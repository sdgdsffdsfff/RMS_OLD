package com.cqupt.mis.rms.model;

public class ScienceGovernmentAward {
	private String awardId;
	private String collegesIn;
	private String projectName;
	private String awardingGrades;
	private String completeUnit;
	private float unitAward;
	private float personAward;
	private float totalAward;
	private String remarks;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getAwardId() {
		return awardId;
	}

	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}

	public String getCollegesIn() {
		return collegesIn;
	}

	public void setCollegesIn(String collegesIn) {
		this.collegesIn = collegesIn;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getAwardingGrades() {
		return awardingGrades;
	}

	public void setAwardingGrades(String awardingGrades) {
		this.awardingGrades = awardingGrades;
	}

	public String getCompleteUnit() {
		return completeUnit;
	}

	public void setCompleteUnit(String completeUnit) {
		this.completeUnit = completeUnit;
	}

	public float getUnitAward() {
		return unitAward;
	}

	public void setUnitAward(float unitAward) {
		this.unitAward = unitAward;
	}

	public float getPersonAward() {
		return personAward;
	}

	public void setPersonAward(float personAward) {
		this.personAward = personAward;
	}

	public float getTotalAward() {
		return totalAward;
	}

	public void setTotalAward(float totalAward) {
		this.totalAward = totalAward;
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
