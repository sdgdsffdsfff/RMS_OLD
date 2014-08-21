package com.cqupt.mis.rms.model;

public class StudentAwardsNew {
	private String awardsId;
	private String rewardTime;//获奖时间
	private String rewardStudents;//学生团队成员
	private String rewardName;//赛事名称
	private String rewardLevel;//获奖级别
	private Float collegeAward;//奖励金额
	private String rewardUnit;//颁奖单位
	private String firstStudents;//排名第一的学生姓名
	private String remarks;//备注
	
	
	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;
	private int status;
	private String returnReason;
	public String getAwardsId() {
		return awardsId;
	}
	public void setAwardsId(String awardsId) {
		this.awardsId = awardsId;
	}
	public String getRewardTime() {
		return rewardTime;
	}
	public void setRewardTime(String rewardTime) {
		this.rewardTime = rewardTime;
	}
	public String getRewardStudents() {
		return rewardStudents;
	}
	public void setRewardStudents(String rewardStudents) {
		this.rewardStudents = rewardStudents;
	}
	public String getRewardName() {
		return rewardName;
	}
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	public String getRewardLevel() {
		return rewardLevel;
	}
	public void setRewardLevel(String rewardLevel) {
		this.rewardLevel = rewardLevel;
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
	public String getRewardUnit() {
		return rewardUnit;
	}
	public void setRewardUnit(String rewardUnit) {
		this.rewardUnit = rewardUnit;
	}
	public String getFirstStudents() {
		return firstStudents;
	}
	public void setFirstStudents(String firstStudents) {
		this.firstStudents = firstStudents;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
