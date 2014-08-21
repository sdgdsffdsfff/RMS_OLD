package com.cqupt.mis.rms.model;

public class MajorContributeMember {

	private int id;
	private MajorContribute majorContribute;
	private String memberId;
	private String memberName;
	private int orders;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MajorContribute getMajorContribute() {
		return majorContribute;
	}

	public void setMajorContribute(MajorContribute majorContribute) {
		this.majorContribute = majorContribute;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
