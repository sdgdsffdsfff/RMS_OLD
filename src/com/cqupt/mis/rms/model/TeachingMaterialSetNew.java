package com.cqupt.mis.rms.model;

public class TeachingMaterialSetNew {
	private String teachingMaterialId;
	private String setClass;  //教材等级
	private String setTime;//出版日期
	private String numberProject;//类别
	private String teachingMaterialName;//教材名称
	private String resultsPostedStatus;//出版单位
	private Float wordsNumbers;//字数（千字）
	private String remarks;//备注
	private Float collegeAward;//奖励金额
	
	private CQUPTUser submitUser;//
	private CQUPTUser approvedUser;
	private int status;
	private String returnReason;
	public String getTeachingMaterialId() {
		return teachingMaterialId;
	}
	public void setTeachingMaterialId(String teachingMaterialId) {
		this.teachingMaterialId = teachingMaterialId;
	}
	public String getSetClass() {
		return setClass;
	}
	public void setSetClass(String setClass) {
		this.setClass = setClass;
	}
	public String getSetTime() {
		return setTime;
	}
	public void setSetTime(String setTime) {
		this.setTime = setTime;
	}
	public String getNumberProject() {
		return numberProject;
	}
	public void setNumberProject(String numberProject) {
		this.numberProject = numberProject;
	}
	public String getTeachingMaterialName() {
		return teachingMaterialName;
	}
	public void setTeachingMaterialName(String teachingMaterialName) {
		this.teachingMaterialName = teachingMaterialName;
	}
	public String getResultsPostedStatus() {
		return resultsPostedStatus;
	}
	public void setResultsPostedStatus(String resultsPostedStatus) {
		this.resultsPostedStatus = resultsPostedStatus;
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
	public Float getWordsNumbers() {
		return wordsNumbers;
	}
	public void setWordsNumbers(Float wordsNumbers) {
		this.wordsNumbers = wordsNumbers;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Float getCollegeAward() {
		return collegeAward;
	}
	public void setCollegeAward(Float collegeAward) {
		this.collegeAward = collegeAward;
	}

}
