package com.tpms.global.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpms.global.model.HistoryOverviewRequest;
import com.tpms.global.model.SearchTransaction;
import com.tpms.global.model.TPMSGateway;
import com.tpms.global.model.TransactionData;
import com.tpms.global.model.TransactionOverview;
import com.tpms.global.model.TransactionResponse;
import com.tpms.global.service.GlobalSearchService;
import com.tpms.global.utility.CorrelationIdUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class GlobalTransactionController {
	
	private final GlobalSearchService globalSearchService;

	public GlobalTransactionController(GlobalSearchService globalSearchService) {
		this.globalSearchService = globalSearchService;
	}

	private static final Logger logger = LoggerFactory.getLogger(GlobalTransactionController.class);

	@PostMapping("/history-transaction")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@ApiOperation(value = " Global Transaction History service. ")

	public TPMSGateway<?> getTransaction(@RequestBody SearchTransaction searchTransaction) {
		try {
			String correlationIdNode = null;
			String correlationId = CorrelationIdUtil.generateCorrelationId(correlationIdNode, searchTransaction.getLaneTxId());
			CorrelationIdUtil.setCorrelationId(correlationId);
			MDC.put("correlationId", correlationId);
			
			logger.info("Search transaction received: {}", searchTransaction);
			
			// Always return hardcoded data regardless of search criteria
			List<TransactionData> transactionList = globalSearchService.findTransactionHistory(searchTransaction);
			logger.info("Transaction list size: {}", transactionList != null ? transactionList.size() : "null");
			
			List<TransactionResponse> responseList = new ArrayList<>();
			if (transactionList != null && !transactionList.isEmpty()) {
				transactionList.forEach(tranx -> {
					responseList.add(buildResponse(tranx));
				});
				logger.info("Response list size: {}", responseList.size());
				return new TPMSGateway<>(true, HttpStatus.OK, responseList);
			} else {
				logger.warn("Transaction list is null or empty");
			}
		} catch (Exception e) {
			logger.error("Error in History-Transaction API: {}", e.getMessage(), e);
		}
		return new TPMSGateway<>(HttpStatus.OK, null, "no Transactions Found");
	}

	private TransactionResponse buildResponse(TransactionData tranx) {
		TransactionResponse response = new TransactionResponse();
		response.setLaneTxId(tranx.getLaneTxId());
		response.setAccountNo(tranx.getAccountNo());
		response.setPlateNumber(tranx.getPlateNumber());
		response.setAgencyName(tranx.getAgencyName());
		response.setDeviceNo(tranx.getDeviceNo());
		response.setPlateState(tranx.getPlateState());
		response.setTxType(tranx.getTxType());
		// Fix the substring issue by checking length
		if (tranx.getTxTimestamp() != null && tranx.getTxTimestamp().length() >= 22) {
			response.setTxTimestamp(tranx.getTxTimestamp().substring(0, 22));
		} else {
			response.setTxTimestamp(tranx.getTxTimestamp());
		}
		response.setPostedDate(tranx.getPostedDate());
		response.setStatus(tranx.getStatus());
		
		// Handle image URLs with tokens
		if (StringUtils.isNotBlank(tranx.getImageUrl())) {
			response.setImageUrl(Arrays.asList(StringUtils.split(tranx.getImageUrl(), ",")));
		}
		if(StringUtils.isNotBlank(tranx.getSasToken()) && StringUtils.isNotBlank(tranx.getImageUrl())) {
			List<String> tokenList = new ArrayList<String>();
			response.getImageUrl().forEach(url -> tokenList.add(url+"?"+tranx.getSasToken()));
			response.setImageUrl(tokenList);
		}
		return response;
	}



	@GetMapping("/get_transaction_overview")
	public TPMSGateway<?> getTransactionOverview(@RequestParam(required = false) String laneTxId,
			@RequestParam(required = false) String page, @RequestParam(required = false) String size) {
		try {
			if (org.apache.commons.lang3.StringUtils.isNotBlank(laneTxId)) {
				HistoryOverviewRequest historyOverviewRequest = new HistoryOverviewRequest();
				historyOverviewRequest.setLaneTxId(laneTxId);
				historyOverviewRequest.setSize(org.apache.commons.lang3.StringUtils.isBlank(size) ? 10 : Integer.valueOf(size));
				historyOverviewRequest.setPage(org.apache.commons.lang3.StringUtils.isNotBlank(page) ? Integer.valueOf(page) : 0);
				List<TransactionOverview> transactionOverview = globalSearchService.getTransOverviewByLaneTxID(historyOverviewRequest);
				// Return the full list directly, no paging
				return new TPMSGateway<>(true, HttpStatus.OK, transactionOverview);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return new TPMSGateway<>(HttpStatus.OK, null, "Not found..");
	}

	public String convertDate(String postedDate) {
		if (postedDate != null && !postedDate.isBlank()) {
			try {
				// Handle the format "01-JUN-24" that's already in the correct format
				if (postedDate.contains("-")) {
					return postedDate;
				}
				// Handle other formats if needed
				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDate parsedDate = LocalDate.parse(postedDate, inputFormatter);
				DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
				return parsedDate.format(outputFormatter);
			} catch (Exception e) {
				logger.warn("Error converting date: {}", postedDate, e);
				return postedDate; // Return original if conversion fails
			}
		} else {
			return null;
		}
	}
	
	public String eventConvertDate(String eventTime) {
		if (!eventTime.isBlank()) {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate parsedDate = LocalDate.parse(eventTime.substring(0, 10), inputFormatter);

			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			return parsedDate.format(outputFormatter) + eventTime.substring(10);
		} else {
			return null;
		}

	}

	@GetMapping("/global-transaction-history-healthCheck")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class) })
	@ApiOperation(value = "Service status check, returns a string response if Global Transaction History service is running. ")

	public String healthCheck() {
		logger.debug("Global Transaction History health check get URL triggered");
		return "Global Transaction History service is running..";
	}

}
