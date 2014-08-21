package com.cqupt.mis.rms.model;

import com.cqupt.mis.rms.model.CQUPTUser;

public class TeachAchievements {
	private String achievementsId;
	private String classAchievements;
	private String projectName;
	private String levelAchievements;
	private String timeAchievements;
	private Float collegeAward;
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
	public String getTimeAchievements() {
		return timeAchievements;
	}
	public void setTimeAchievements(String timeAchievements) {
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
	
}
