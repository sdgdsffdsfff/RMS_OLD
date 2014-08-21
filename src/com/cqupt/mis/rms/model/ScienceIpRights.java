package com.cqupt.mis.rms.model;

import java.util.Date;

public class ScienceIpRights {
	private String rightsId;
	private String collegesIn;
	private String patentName;
	private String patentType;
	private String applicationNumber;
	private String patentStatus;
	private Date filingDate;
	private Date announcementDate;
	private float incentivePayments;
	private String remarks;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getRightsId() {
		return rightsId;
	}

	public void setRightsId(String rightsId) {
		this.rightsId = rightsId;
	}

	public String getCollegesIn() {
		return collegesIn;
	}

	public void setCollegesIn(String collegesIn) {
		this.collegesIn = collegesIn;
	}

	public String getPatentName() {
		return patentName;
	}

	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}

	public String getPatentType() {
		return patentType;
	}

	public void setPatentType(String patentType) {
		this.patentType = patentType;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getPatentStatus() {
		return patentStatus;
	}

	public void setPatentStatus(String patentStatus) {
		this.patentStatus = patentStatus;
	}

	public Date getFilingDate() {
		return filingDate;
	}

	public void setFilingDate(Date filingDate) {
		this.filingDate = filingDate;
	}

	public Date getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	public float getIncentivePayments() {
		return incentivePayments;
	}

	public void setIncentivePayments(float incentivePayments) {
		this.incentivePayments = incentivePayments;
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
