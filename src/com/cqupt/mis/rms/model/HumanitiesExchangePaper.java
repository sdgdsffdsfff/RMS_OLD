package com.cqupt.mis.rms.model;

import java.util.Date;

public class HumanitiesExchangePaper {
	private String exchangePaperId;
	private String exchangePaperName;
	private String searchStation;
	private String subjectsClassify;
	private Date publishedTime;
	private String hostConferenceName;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getExchangePaperId() {
		return exchangePaperId;
	}

	public void setExchangePaperId(String exchangePaperId) {
		this.exchangePaperId = exchangePaperId;
	}

	public String getExchangePaperName() {
		return exchangePaperName;
	}

	public void setExchangePaperName(String exchangePaperName) {
		this.exchangePaperName = exchangePaperName;
	}

	public String getSearchStation() {
		return searchStation;
	}

	public void setSearchStation(String searchStation) {
		this.searchStation = searchStation;
	}

	public String getSubjectsClassify() {
		return subjectsClassify;
	}

	public void setSubjectsClassify(String subjectsClassify) {
		this.subjectsClassify = subjectsClassify;
	}

	public Date getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(Date publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getHostConferenceName() {
		return hostConferenceName;
	}

	public void setHostConferenceName(String hostConferenceName) {
		this.hostConferenceName = hostConferenceName;
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
