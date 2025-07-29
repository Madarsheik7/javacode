package com.tpms.global.model;

import java.time.OffsetDateTime;

public class TransactionOverview {

    private String dmvPlateType;
    private String account;
    private String eventTimeStamp;
    private String eventType;
    private String eventTypeDesc;
    private String laneTxId;
    private String plateNumber;
    private String plateState;
    private String plateCountry;
    private String reviewedClass;
    private String txStatus;
    private String txStatusDesc;
    private String reviewedvehicletype;
    private String dateImageReviewed;
    private Integer imageReviewer;
    public Integer getImageReviewer() {
		return imageReviewer;
	}

	public void setImageReviewer(Integer imageReviewer) {
		this.imageReviewer = imageReviewer;
	}

	public String getDmvPlateType() {
        return dmvPlateType;
    }

    public void setDmvPlateType(String dmvPlateType) {
        this.dmvPlateType = dmvPlateType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEventTimeStamp() {
        return eventTimeStamp;
    }

    public void setEventTimeStamp(String eventTimeStamp) {
        this.eventTimeStamp = eventTimeStamp;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeDesc() {
        return eventTypeDesc;
    }

    public void setEventTypeDesc(String eventTypeDesc) {
        this.eventTypeDesc = eventTypeDesc;
    }

    public String getLaneTxId() {
        return laneTxId;
    }

    public void setLaneTxId(String laneTxId) {
        this.laneTxId = laneTxId;
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

    public String getPlateCountry() {
        return plateCountry;
    }

    public void setPlateCountry(String plateCountry) {
        this.plateCountry = plateCountry;
    }

    public String getReviewedClass() {
        return reviewedClass;
    }

    public void setReviewedClass(String reviewedClass) {
        this.reviewedClass = reviewedClass;
    }

    public String getTxStatus() {
        return txStatus;
    }

    public void setTxStatus(String txStatus) {
        this.txStatus = txStatus;
    }

    public String getTxStatusDesc() {
        return txStatusDesc;
    }

    public void setTxStatusDesc(String txStatusDesc) {
        this.txStatusDesc = txStatusDesc;
    }

    public String getReviewedvehicletype() {
        return reviewedvehicletype;
    }

    public void setReviewedvehicletype(String reviewedvehicletype) {
        this.reviewedvehicletype = reviewedvehicletype;
    }

    public String getDateImageReviewed() {
        return dateImageReviewed;
    }

    public void setDateImageReviewed(String dateImageReviewed) {
        this.dateImageReviewed = dateImageReviewed;
    }
}