package com.tpms.global.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResponse {

	private Long laneTxId;
	private String accountNo;
	private String plateNumber;
	private List<String> imageUrl;
	private String agencyName;
	private String deviceNo;
	private String plateState;
	private String txType;
	private String txTimestamp;
	private String postedDate;
	private String status;

	public TransactionResponse() {
	}

	public TransactionResponse(Long laneTxId, String accountNo, String plateNumber, List<String> imageUrl, 
			String agencyName, String deviceNo, String plateState, String txType, String txTimestamp, 
			String postedDate, String status) {
		this.laneTxId = laneTxId;
		this.accountNo = accountNo;
		this.plateNumber = plateNumber;
		this.imageUrl = imageUrl;
		this.agencyName = agencyName;
		this.deviceNo = deviceNo;
		this.plateState = plateState;
		this.txType = txType;
		this.txTimestamp = txTimestamp;
		this.postedDate = postedDate;
		this.status = status;
	}

	public Long getLaneTxId() {
		return laneTxId;
	}

	public void setLaneTxId(Long laneTxId) {
		this.laneTxId = laneTxId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public List<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getPlateState() {
		return plateState;
	}

	public void setPlateState(String plateState) {
		this.plateState = plateState;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public String getTxTimestamp() {
		return txTimestamp;
	}

	public void setTxTimestamp(String txTimestamp) {
		this.txTimestamp = txTimestamp;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
