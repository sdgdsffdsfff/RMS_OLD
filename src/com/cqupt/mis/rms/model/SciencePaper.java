package com.cqupt.mis.rms.model;

public class SciencePaper {
	private String paperId;
	private String department;
	private String paperName;
	private String subjectsIn;
	private String postPublication;
	private String includeSituation;
	private String publishedTime;
	private String titleNumber;
	private String awardingGrades;
	private float totalPrize;
	private float deductionsDistPosts;
	private float actualAward;
	private String papersUnits;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;
	private String remarks;

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getSubjectsIn() {
		return subjectsIn;
	}

	public void setSubjectsIn(String subjectsIn) {
		this.subjectsIn = subjectsIn;
	}

	public String getAwardingGrades() {
		return awardingGrades;
	}

	public void setAwardingGrades(String awardingGrades) {
		this.awardingGrades = awardingGrades;
	}

	public float getTotalPrize() {
		return totalPrize;
	}

	public void setTotalPrize(float totalPrize) {
		this.totalPrize = totalPrize;
	}

	public float getDeductionsDistPosts() {
		return deductionsDistPosts;
	}

	public void setDeductionsDistPosts(float deductionsDistPosts) {
		this.deductionsDistPosts = deductionsDistPosts;
	}

	public float getActualAward() {
		return actualAward;
	}

	public void setActualAward(float actualAward) {
		this.actualAward = actualAward;
	}

	public String getPapersUnits() {
		return papersUnits;
	}

	public void setPapersUnits(String papersUnits) {
		this.papersUnits = papersUnits;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPostPublication() {
		return postPublication;
	}

	public void setPostPublication(String postPublication) {
		this.postPublication = postPublication;
	}

	public String getIncludeSituation() {
		return includeSituation;
	}

	public void setIncludeSituation(String includeSituation) {
		this.includeSituation = includeSituation;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getTitleNumber() {
		return titleNumber;
	}

	public void setTitleNumber(String titleNumber) {
		this.titleNumber = titleNumber;
	}

}
