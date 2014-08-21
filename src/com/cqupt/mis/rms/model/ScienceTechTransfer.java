package com.cqupt.mis.rms.model;

import java.util.Date;

public class ScienceTechTransfer {
	private String transferId;
	private String collegeIn;
	private String techName;
	private String transfereeUnit;
	private String unitProperties;
	private float contractAmount;
	private float realIncome;
	private String transformationWay;
	private Date startTime;
	private Date endTime;
	private String remarks;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getCollegeIn() {
		return collegeIn;
	}

	public void setCollegeIn(String collegeIn) {
		this.collegeIn = collegeIn;
	}
	
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getTransfereeUnit() {
		return transfereeUnit;
	}

	public void setTransfereeUnit(String transfereeUnit) {
		this.transfereeUnit = transfereeUnit;
	}

	public String getUnitProperties() {
		return unitProperties;
	}

	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}

	public float getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(float contractAmount) {
		this.contractAmount = contractAmount;
	}

	public float getRealIncome() {
		return realIncome;
	}

	public void setRealIncome(float realIncome) {
		this.realIncome = realIncome;
	}

	public String getTransformationWay() {
		return transformationWay;
	}

	public void setTransformationWay(String transformationWay) {
		this.transformationWay = transformationWay;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public CQUPTUser getSubmitUser() {
		return submitUser;
	}

	public void setSubmitUser(CQUPTUser submitUser) {
		this.submitUser = submitUser;
	}

	public CQUPTUser getApprovedUser() {
		return approvedUser;
	}

	public void setApprovedUser(CQUPTUser approvedUser) {
		this.approvedUser = approvedUser;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

}
