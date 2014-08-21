package com.cqupt.mis.rms.model;

public class ScienceTechExchange {
	private String techExchangeId;
	private String collegesIn;
	private String exchangeType;
	private int sendNumber;
	private int receiveNumber;
	private int attendNumber;
	private int papersNumber;
	private int specialInvitedNumber;
	private String exchangeHost;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getTechExchangeId() {
		return techExchangeId;
	}

	public void setTechExchangeId(String techExchangeId) {
		this.techExchangeId = techExchangeId;
	}

	public String getCollegesIn() {
		return collegesIn;
	}

	public void setCollegesIn(String collegesIn) {
		this.collegesIn = collegesIn;
	}

	public String getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	public int getSendNumber() {
		return sendNumber;
	}

	public void setSendNumber(int sendNumber) {
		this.sendNumber = sendNumber;
	}

	public int getReceiveNumber() {
		return receiveNumber;
	}

	public void setReceiveNumber(int receiveNumber) {
		this.receiveNumber = receiveNumber;
	}

	public int getAttendNumber() {
		return attendNumber;
	}

	public void setAttendNumber(int attendNumber) {
		this.attendNumber = attendNumber;
	}

	public int getPapersNumber() {
		return papersNumber;
	}

	public void setPapersNumber(int papersNumber) {
		this.papersNumber = papersNumber;
	}

	public int getSpecialInvitedNumber() {
		return specialInvitedNumber;
	}

	public void setSpecialInvitedNumber(int specialInvitedNumber) {
		this.specialInvitedNumber = specialInvitedNumber;
	}

	public String getExchangeHost() {
		return exchangeHost;
	}

	public void setExchangeHost(String exchangeHost) {
		this.exchangeHost = exchangeHost;
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
