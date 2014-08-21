package com.cqupt.mis.rms.model;

public class ScienceBook {
	private String bookId;
	private String unitAuthor;
	private String publicationName;
	private String publicationType;
	private String publisher;
	private String ISBN;
	private String awardingGrades;
	private String publishedTime;
	private float totalPrize;
	private float deductionsDistPosts;
	private float actualAward;
	private String remarks;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getUnitAuthor() {
		return unitAuthor;
	}

	public void setUnitAuthor(String unitAuthor) {
		this.unitAuthor = unitAuthor;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAwardingGrades() {
		return awardingGrades;
	}

	public void setAwardingGrades(String awardingGrades) {
		this.awardingGrades = awardingGrades;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
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
