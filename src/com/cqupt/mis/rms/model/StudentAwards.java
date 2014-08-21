package com.cqupt.mis.rms.model;

import com.cqupt.mis.rms.model.CQUPTUser;

public class StudentAwards {
	private String awardsId;
	private String rewardTime;
	private String rewardStudents;
	private String rewardName;
	private String rewardLevel;
	private String collegeAward;
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
	public String getCollegeAward() {
		return collegeAward;
	}
	public void setCollegeAward(String collegeAward) {
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
