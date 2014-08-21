package com.cqupt.mis.rms.model;

public class ScienceTechAttendPerson {
	private int id;
	private ScienceTechExchange scienceTechExchange;
	private String attendId;
	private String memberName;
	private int orders;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ScienceTechExchange getScienceTechExchange() {
		return scienceTechExchange;
	}

	public void setScienceTechExchange(ScienceTechExchange scienceTechExchange) {
		this.scienceTechExchange = scienceTechExchange;
	}

	public String getAttendId() {
		return attendId;
	}

	public void setAttendId(String attendId) {
		this.attendId = attendId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
