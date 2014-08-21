package com.cqupt.mis.rms.model;

import java.util.Date;

public class HumanitiesResearchReward {
	private String researchRewardId;
	private String researchRewardName;
	private String rewardClassify;
	private String rewardGrades;
	private String issueUnit;
	private Date approveTime;
	private String approveNumber;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getResearchRewardId() {
		return researchRewardId;
	}

	public void setResearchRewardId(String researchRewardId) {
		this.researchRewardId = researchRewardId;
	}

	public String getResearchRewardName() {
		return researchRewardName;
	}

	public void setResearchRewardName(String researchRewardName) {
		this.researchRewardName = researchRewardName;
	}

	public String getRewardClassify() {
		return rewardClassify;
	}

	public void setRewardClassify(String rewardClassify) {
		this.rewardClassify = rewardClassify;
	}

	public String getRewardGrades() {
		return rewardGrades;
	}

	public void setRewardGrades(String rewardGrades) {
		this.rewardGrades = rewardGrades;
	}

	public String getIssueUnit() {
		return issueUnit;
	}

	public void setIssueUnit(String issueUnit) {
		this.issueUnit = issueUnit;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public String getApproveNumber() {
		return approveNumber;
	}

	public void setApproveNumber(String approveNumber) {
		this.approveNumber = approveNumber;
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
