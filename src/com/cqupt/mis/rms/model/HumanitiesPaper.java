package com.cqupt.mis.rms.model;

public class HumanitiesPaper {
	private String paperId;
	private String paperName;
	private String publishedTime;
	private String postPublication;
	private String publishedGrades;
	private String searchStation;
	private String belongProject;
	private String subjectsClassify;
	private String achievementQuote;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getPostPublication() {
		return postPublication;
	}

	public void setPostPublication(String postPublication) {
		this.postPublication = postPublication;
	}

	public String getPublishedGrades() {
		return publishedGrades;
	}

	public void setPublishedGrades(String publishedGrades) {
		this.publishedGrades = publishedGrades;
	}

	public String getSearchStation() {
		return searchStation;
	}

	public void setSearchStation(String searchStation) {
		this.searchStation = searchStation;
	}

	public String getBelongProject() {
		return belongProject;
	}

	public void setBelongProject(String belongProject) {
		this.belongProject = belongProject;
	}

	public String getSubjectsClassify() {
		return subjectsClassify;
	}

	public void setSubjectsClassify(String subjectsClassify) {
		this.subjectsClassify = subjectsClassify;
	}

	public String getAchievementQuote() {
		return achievementQuote;
	}

	public void setAchievementQuote(String achievementQuote) {
		this.achievementQuote = achievementQuote;
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
