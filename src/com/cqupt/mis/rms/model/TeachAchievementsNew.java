package com.cqupt.mis.rms.model;

import java.util.Date;

public class TeachAchievementsNew {
	private String achievementsId;
	private String classAchievements;//期刊类别
	private String projectName;//论文名称
	private String levelAchievements;//期刊名称
	private Date timeAchievements;//出版日期
	private Float collegeAward;//奖励金额
	private String remarks;//备注
	private Float wordsNumber;//字数(千字)
	private String firstChargeMan;//是否为第一负责人
	private String authorRank;//作者排名
    private String publisher;//出版单位
	
	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;
	private int status;
	private String returnReason;
	public String getAchievementsId() {
		return achievementsId;
	}
	public void setAchievementsId(String achievementsId) {
		this.achievementsId = achievementsId;
	}
	public String getClassAchievements() {
		return classAchievements;
	}
	public void setClassAchievements(String classAchievements) {
		this.classAchievements = classAchievements;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getLevelAchievements() {
		return levelAchievements;
	}
	public void setLevelAchievements(String levelAchievements) {
		this.levelAchievements = levelAchievements;
	}
	public Date getTimeAchievements() {
		return timeAchievements;
	}
	public void setTimeAchievements(Date timeAchievements) {
		this.timeAchievements = timeAchievements;
	}
	public Float getCollegeAward() {
		return collegeAward;
	}
	public void setCollegeAward(Float collegeAward) {
		this.collegeAward = collegeAward;
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
	public Float getWordsNumber() {
		return wordsNumber;
	}
	public void setWordsNumber(Float wordsNumber) {
		this.wordsNumber = wordsNumber;
	}
	public String getFirstChargeMan() {
		return firstChargeMan;
	}
	public void setFirstChargeMan(String firstChargeMan) {
		this.firstChargeMan = firstChargeMan;
	}
	public String getAuthorRank() {
		return authorRank;
	}
	public void setAuthorRank(String authorRank) {
		this.authorRank = authorRank;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
