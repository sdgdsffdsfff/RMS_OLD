package com.cqupt.mis.rms.model;

public class ScienceGovAwardPerson {
	private int id;
	private ScienceGovernmentAward scienceGovernmentAward;
	private String authorId;
	private String memberName;
	private int orders;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ScienceGovernmentAward getScienceGovernmentAward() {
		return scienceGovernmentAward;
	}

	public void setScienceGovernmentAward(
			ScienceGovernmentAward scienceGovernmentAward) {
		this.scienceGovernmentAward = scienceGovernmentAward;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
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
