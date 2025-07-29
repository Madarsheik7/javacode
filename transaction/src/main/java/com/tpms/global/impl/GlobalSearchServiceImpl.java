package com.tpms.global.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.tpms.global.model.TransactionOverview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tpms.global.model.HistoryOverviewRequest;
import com.tpms.global.model.SearchTransaction;
import com.tpms.global.model.TransactionData;
import com.tpms.global.service.GlobalSearchService;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {

    private static final Logger logger = LoggerFactory.getLogger(GlobalSearchServiceImpl.class);

    @Override
    public List<TransactionData> findTransactionHistory(SearchTransaction searchTransaction) throws SQLException {
        logger.info("findTransactionHistory called with searchTransaction: {}", searchTransaction);
        
        // Return a hardcoded list of TransactionData with only essential fields
        TransactionData data = new TransactionData();
        data.setLaneTxId(12345L);
        data.setAccountNo("ACC123");
        data.setImageUrl("http://example.com/image1.jpg");
        data.setAgencyName("Sample Agency");
        data.setDeviceNo("DEV001");
        data.setPlateNumber("ABC1234");
        data.setPlateState("CA");
        data.setTxType("TOLL");
        data.setTxTimestamp("2024-06-01T12:00:00Z");
        data.setPostedDate("01-JUN-24");
        data.setStatus("PAID");
        data.setSasToken("token123");
        
        List<TransactionData> result = Collections.singletonList(data);
        logger.info("Returning simplified transaction data: {}", result);
        return result;
    }

    @Override
    public List<TransactionOverview> getTransOverviewByLaneTxID(HistoryOverviewRequest historyOverviewRequest) {
        logger.info("getTransOverviewByLaneTxID called with request: {}", historyOverviewRequest);
        
        // Return a hardcoded list of TransactionOverview
        TransactionOverview overview = new TransactionOverview();
        overview.setDmvPlateType("Standard");
        overview.setAccount("ACC123");
        overview.setEventTimeStamp("2024-06-01T12:00:00Z");
        overview.setEventType("ENTRY");
        overview.setEventTypeDesc("Entry Event");
        overview.setLaneTxId("12345");
        overview.setPlateNumber("ABC1234");
        overview.setPlateState("CA");
        overview.setPlateCountry("USA");
        overview.setReviewedClass("2");
        overview.setTxStatus("PAID");
        overview.setTxStatusDesc("Paid Status");
        overview.setReviewedvehicletype("Car");
        overview.setDateImageReviewed("01-JUN-24");
        overview.setImageReviewer(101);
        
        List<TransactionOverview> result = Collections.singletonList(overview);
        logger.info("Returning hardcoded overview data: {}", result);
        return result;
    }
}
