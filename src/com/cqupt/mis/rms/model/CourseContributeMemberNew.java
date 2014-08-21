package com.cqupt.mis.rms.model;

public class CourseContributeMemberNew {

	private int id;
	private CourseContributeNew courseContributeNew;
	

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

	public CourseContributeNew getCourseContributeNew() {
		return courseContributeNew;
	}

	public void setCourseContributeNew(CourseContributeNew courseContributeNew) {
		this.courseContributeNew = courseContributeNew;
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
