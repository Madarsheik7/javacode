package com.tpms.global.dao;

import java.sql.SQLException;
import java.util.List;

import com.tpms.global.model.HistoryOverviewRequest;
import com.tpms.global.model.SearchTransaction;
import com.tpms.global.model.TransactionData;
import com.tpms.global.model.TransactionOverview;

public interface GlobalTransactionDao {

	public List<TransactionData> findTransactionHistory(SearchTransaction searchTransaction)throws SQLException;
	public List<TransactionOverview> getTransOverviewByLaneTxID(HistoryOverviewRequest historyOverviewRequest);
	public String getplateType(String state, String codeId);
}
