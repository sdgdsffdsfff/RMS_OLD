package com.cqupt.mis.rms.model;

import java.util.Date;

public class HumanitiesProject {
	private String projectId;
	private String projectName;
	private String projectNumber;
	private String projectOrigin;
	private Date timeApproved;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectOrigin() {
		return projectOrigin;
	}

	public void setProjectOrigin(String projectOrigin) {
		this.projectOrigin = projectOrigin;
	}

	public Date getTimeApproved() {
		return timeApproved;
	}

	public void setTimeApproved(Date timeApproved) {
		this.timeApproved = timeApproved;
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
