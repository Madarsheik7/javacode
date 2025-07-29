package com.tpms.global.daoimpl;

import java.util.Collections;
import java.util.List;
// import java.util.concurrent.TimeUnit;

// import com.google.common.base.Stopwatch;
import com.tpms.global.model.TransactionOverview;

// import org.apache.commons.lang3.StringUtils;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.dao.DataAccessException;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
// import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
// import org.springframework.stereotype.Service;
// import org.springframework.util.CollectionUtils;

// import com.tpms.global.config.LoadJpaQueries;
import com.tpms.global.constant.GlobalTransaction;
import com.tpms.global.dao.GlobalTransactionDao;
import com.tpms.global.model.HistoryOverviewRequest;
import com.tpms.global.model.SearchTransaction;
import com.tpms.global.model.Tcodes;
import com.tpms.global.model.TransactionData;

// @Service
public class GlobalTransactionHistoryDaoImpl implements GlobalTransactionDao {

    // private static final Logger logger = LoggerFactory.getLogger(GlobalTransactionHistoryDaoImpl.class);
    // private final NamedParameterJdbcTemplate namedJdbcTemplate;
    // public GlobalTransactionHistoryDaoImpl(NamedParameterJdbcTemplate namedJdbcTemplate) {
    //     this.namedJdbcTemplate = namedJdbcTemplate;
    // }

    private static final String GROUP_STRING = " group by LANE_TX_ID, accountNo, agencyName, "
            + "DEVICE_NO, PLATE_NUMBER, PLATE_STATE, txType, entryTimeStamp, postedDate, entryPlazaId, PLAN_NAME, "
            + "TX_DATE, TX_EXTERN_REF_NO, TX_TIMESTAMP, PlazaId, laneId, actual_class,"
            + "posted_fare_amount, ocrConfidence, matchType, SAS_TOKEN , agencyShortName, atpFileId,"
            + "entryLaneId, externFileId, expectedRevenueAmount, ocrConf, outFileName, plateCountry, "
            + "plazaAgencyId,reviewedClass, txSubType, updateTs, violTxStatus, violType, amountPaid, ecsLevel, noticeNo, "
            + "status, firstMailDate, mailDate, noticeFeeAmount, noticeTollAmount, vehicleSpeed, imageReviewedDate, violationSeq, imageReviewer, isClosed, ictxDeviceNo "
            + " ORDER BY ";

    @Override
    public List<TransactionData> findTransactionHistory(SearchTransaction searchTransaction) {
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
        return java.util.Collections.singletonList(data);
    }

    private void endWhereClasue(StringBuilder queryBuilder) {
        queryBuilder.append(" )");
        
    }

    private String buildOrderType(SearchTransaction searchTransaction) {
        //bug 84324
        if(searchTransaction.getSortType().equals("postedDate")) {
            //return ", ttd.POSTED_DATE";
            return "POSTED_DATE DESC";
        }
        if(searchTransaction.getSortType().equals("agencyName")) {
            //return ", va.STMT_DESCRIPTION";
            return "STMT_DESCRIPTION";
        }
        if(searchTransaction.getSortType().equals("plateNumber")) {
            //return ", ttd.PLATE_NUMBER";
            return "PLATE_NUMBER";
        }
        if(searchTransaction.getSortType().equals("entryPlazaId")) {
            //return ", tep.extern_plaza_id";
            return "extern_plaza_id";
        }
        if(searchTransaction.getSortType().equals("deviceNo")) {
            //return ", ttd.DEVICE_NO";
            return "DEVICE_NO DESC";
        }
        if(searchTransaction.getSortType().equals("txstartDate")) {
            //return ", ttd.TX_DATE";
            return "TX_DATE DESC";
        }
        //return ", ttd.TX_DATE";
        return "TX_DATE DESC";
    }

    // private void addDateRangeCondition(StringBuilder queryBuilder, MapSqlParameterSource paramSource, String paramName,
    //         String condition, String txstartDate, String txendDate, String postedDate) {
    //     if (StringUtils.isNotBlank(txstartDate) && StringUtils.isNotBlank(txendDate)) {
    //         String startDatePlaceholder = ":" + paramName + "_START";
    //         String endDatePlaceholder = ":" + paramName + "_END";
    //         String conditionFragment = null;
    //         if(paramName.equals("TX_DATE")) {
    //             conditionFragment = " AND " + condition+ " BETWEEN TO_DATE(" + startDatePlaceholder
    //             + ", 'DD-MON-YYYY') AND (TO_DATE(" + endDatePlaceholder + ", 'DD-MON-YYYY')+1)  AND " + postedDate+" >= TO_DATE(" + startDatePlaceholder + ", 'DD-MON-YYYY')-10";
    //         }else {
    //             conditionFragment = " AND " + condition + " BETWEEN TO_DATE(" + startDatePlaceholder
    //             + ", 'DD-MON-YYYY') AND (TO_DATE(" + endDatePlaceholder + ", 'DD-MON-YYYY')+1)";
    //         }

    //         queryBuilder.append(
    //                 paramSource.getValues().isEmpty() ? conditionFragment.replaceFirst("AND", "") : conditionFragment);

    //         paramSource.addValue(paramName + "_START", txstartDate);
    //         paramSource.addValue(paramName + "_END", txendDate);
    //     }

    // }

    @Override
    public List<TransactionOverview> getTransOverviewByLaneTxID(HistoryOverviewRequest historyOverviewRequest) {
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
        return java.util.Collections.singletonList(overview);
    }

    // Commented out methods that reference missing JDBC classes
    // private void addConditionAndParameter(StringBuilder queryBuilder, MapSqlParameterSource paramSource,
    //         String paramName, String condition, String value) {
    //     if (StringUtils.isNotBlank(value)) {
    //         String placeholder = ":" + paramName;
    //         String conditionFragment = " AND " + condition + " = " + placeholder;
    //         queryBuilder.append(
    //                 paramSource.getValues().isEmpty() ? conditionFragment.replaceFirst("AND", "") : conditionFragment);
    //         paramSource.addValue(paramName, value);
    //     }
    // }

    // private void addConditionAndParameter(StringBuilder queryBuilder, MapSqlParameterSource paramSource,
    //         String paramName, String condition, Integer value) {
    //     if (value != null) {
    //         String placeholder = ":" + paramName;
    //         String conditionFragment = " AND " + condition + " = " + placeholder;
    //         queryBuilder.append(
    //                 paramSource.getValues().isEmpty() ? conditionFragment.replaceFirst("AND", "") : conditionFragment);
    //         paramSource.addValue(paramName, value);
    //     }
    // }

    @Override
    public String getplateType(String state, String codeId) {
        // Return a hardcoded plate type
        return "Standard";
    }
}
