package com.cqupt.mis.rms.model;

import java.util.Date;

public class ScienceTechProject {
	private String projectId;
	private String projectName;
	private Date timeProjectApproved;
	private float totalFundContract;
	private String sortSubject;
	private String sortActivity;
	private String originProject;
	private String formOrganization;
	private String formCooperation;
	private String organReliedProject;
	private String industryService;
	private String unitProject;

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

	public Date getTimeProjectApproved() {
		return timeProjectApproved;
	}

	public void setTimeProjectApproved(Date timeProjectApproved) {
		this.timeProjectApproved = timeProjectApproved;
	}

	public float getTotalFundContract() {
		return totalFundContract;
	}

	public void setTotalFundContract(float totalFundContract) {
		this.totalFundContract = totalFundContract;
	}

	public String getSortSubject() {
		return sortSubject;
	}

	public void setSortSubject(String sortSubject) {
		this.sortSubject = sortSubject;
	}

	public String getSortActivity() {
		return sortActivity;
	}

	public void setSortActivity(String sortActivity) {
		this.sortActivity = sortActivity;
	}

	public String getOriginProject() {
		return originProject;
	}

	public void setOriginProject(String originProject) {
		this.originProject = originProject;
	}

	public String getFormOrganization() {
		return formOrganization;
	}

	public void setFormOrganization(String formOrganization) {
		this.formOrganization = formOrganization;
	}

	public String getFormCooperation() {
		return formCooperation;
	}

	public void setFormCooperation(String formCooperation) {
		this.formCooperation = formCooperation;
	}

	public String getOrganReliedProject() {
		return organReliedProject;
	}

	public void setOrganReliedProject(String organReliedProject) {
		this.organReliedProject = organReliedProject;
	}

	public String getIndustryService() {
		return industryService;
	}

	public void setIndustryService(String industryService) {
		this.industryService = industryService;
	}

	public String getUnitProject() {
		return unitProject;
	}

	public void setUnitProject(String unitProject) {
		this.unitProject = unitProject;
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
