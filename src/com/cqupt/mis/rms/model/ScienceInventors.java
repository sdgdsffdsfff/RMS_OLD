package com.cqupt.mis.rms.model;

public class ScienceInventors {
	private int id;
	private ScienceIpRights scienceIpRights;
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

	public ScienceIpRights getScienceIpRights() {
		return scienceIpRights;
	}

	public void setScienceIpRights(ScienceIpRights scienceIpRights) {
		this.scienceIpRights = scienceIpRights;
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
