package com.tpms.global.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchTransaction extends PageInfo {

	private String laneTxId;
	private String externalRefId;
	private String txstartDate;
	private String txendDate;
	private String accountNo;
	private String postedstartDate;
	private String postedendDate;
	private String plazaAgencyId;
	private String etcAccountId;
	private String deviceNo;
	private String plateNumber;
	private String plateState;
	private String entryPlazaId;
	private String laneId;
	private String plazaId;
	private String agencyName;
	private String sortType;
	//added
	private Integer imageReviewer;
	private String noticeNo;
	private String ictxDeviceNo;


	public String getLaneTxId() {
		return laneTxId;
	}

	public void setLaneTxId(String laneTxId) {
		this.laneTxId = laneTxId;
	}

	public String getExternalRefId() {
		return externalRefId;
	}

	public void setExternalRefId(String externalRefId) {
		this.externalRefId = externalRefId;
	}

	public String getTxstartDate() {
		return txstartDate;
	}

	public void setTxstartDate(String txstartDate) {
		this.txstartDate = txstartDate;
	}

	public String getTxendDate() {
		return txendDate;
	}

	public void setTxendDate(String txendDate) {
		this.txendDate = txendDate;
	}

	public String getPostedstartDate() {
		return postedstartDate;
	}

	public void setPostedstartDate(String postedstartDate) {
		this.postedstartDate = postedstartDate;
	}

	public String getPostedendDate() {
		return postedendDate;
	}

	public void setPostedendDate(String postedendDate) {
		this.postedendDate = postedendDate;
	}

	public String getPlazaAgencyId() {
		return plazaAgencyId;
	}

	public void setPlazaAgencyId(String plazaAgencyId) {
		this.plazaAgencyId = plazaAgencyId;
	}

	public String getEtcAccountId() {
		return etcAccountId;
	}

	public void setEtcAccountId(String etcAccountId) {
		this.etcAccountId = etcAccountId;
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

	public String getEntryPlazaId() {
		return entryPlazaId;
	}

	public void setEntryPlazaId(String entryPlazaId) {
		this.entryPlazaId = entryPlazaId;
	}

	public String getLaneId() {
		return laneId;
	}

	public void setLaneId(String laneId) {
		this.laneId = laneId;
	}

	public String getPlazaId() {
		return plazaId;
	}

	public void setPlazaId(String plazaId) {
		this.plazaId = plazaId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	
	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public Integer getImageReviewer() {
		return imageReviewer;
	}

	public void setImageReviewer(Integer imageReviewer) {
		this.imageReviewer = imageReviewer;
	}

	public String getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	

	public String getIctxDeviceNo() {
		return ictxDeviceNo;
	}

	public void setIctxDeviceNo(String ictxDeviceNo) {
		this.ictxDeviceNo = ictxDeviceNo;
	}

	@Override
	public String toString() {
		return "SearchTransaction [laneTxId=" + laneTxId + ", externalRefId=" + externalRefId + ", txstartDate="
				+ txstartDate + ", txendDate=" + txendDate + ", postedstartDate=" + postedstartDate + ", postedendDate="
				+ postedendDate + ", plazaAgencyId=" + plazaAgencyId + ", etcAccountId=" + etcAccountId + ", deviceNo="
				+ deviceNo + ", plateNumber=" + plateNumber + ", plateState=" + plateState + ", entryPlazaId="
				+ entryPlazaId + ", laneId=" + laneId + ", plazaId=" + plazaId + ", accountNo=" + accountNo
				+ ", agencyName=" + agencyName + "]";
	}

}
