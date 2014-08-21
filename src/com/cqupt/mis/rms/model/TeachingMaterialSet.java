package com.cqupt.mis.rms.model;

import com.cqupt.mis.rms.model.CQUPTUser;

public class TeachingMaterialSet {
	private String teachingMaterialId;
	private String setClass;
	private String setTime;
	private String numberProject;
	private String teachingMaterialName;
	private String resultsPostedStatus;
	private CQUPTUser submitUser;
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
}
