package com.tpms.global.model;

public class TransactionData {
	private Long laneTxId;
	private String accountNo;
	private String imageUrl;
	private String agencyName;
	private String deviceNo;
	private String plateNumber;
	private String plateState;
	private String txType;
	private String txTimestamp;
	private String postedDate;
	private String status;
	private String sasToken;

	public TransactionData() {
	}

	public TransactionData(Long laneTxId, String accountNo, String imageUrl, String agencyName, String deviceNo,
			String plateNumber, String plateState, String txType, String txTimestamp, String postedDate, 
			String status, String sasToken) {
		this.laneTxId = laneTxId;
		this.accountNo = accountNo;
		this.imageUrl = imageUrl;
		this.agencyName = agencyName;
		this.deviceNo = deviceNo;
		this.plateNumber = plateNumber;
		this.plateState = plateState;
		this.txType = txType;
		this.txTimestamp = txTimestamp;
		this.postedDate = postedDate;
		this.status = status;
		this.sasToken = sasToken;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
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

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
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

	public String getSasToken() {
		return sasToken;
	}

	public void setSasToken(String sasToken) {
		this.sasToken = sasToken;
	}

	@Override
	public String toString() {
		return "TransactionData [laneTxId=" + laneTxId + ", accountNo=" + accountNo + ", plateNumber=" + plateNumber
				+ ", agencyName=" + agencyName + ", deviceNo=" + deviceNo + ", plateState=" + plateState + ", txType="
				+ txType + ", status=" + status + "]";
	}
}
