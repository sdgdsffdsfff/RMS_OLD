package com.cqupt.mis.rms.model;

import java.util.Date;

public class MajorContributeNew {
	private String majorId;
	private String classContribute;//项目级别
	private String typeContribute;//项目类别
	private String timeContribute;//立项时间
	private String majorName;//项目名称
	private Date checkTime;//申报时间
	private Date endTime;//结项时间
	private Float rewardCollege;//奖励金额
	private String remarks;//备注
	private String projectSource;//项目来源
	private Float reportedAmounts;//申报金额
	
	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;
	private Integer status;
	private String returnReason;
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String getClassContribute() {
		return classContribute;
	}
	public void setClassContribute(String classContribute) {
		this.classContribute = classContribute;
	}
	public String getTypeContribute() {
		return typeContribute;
	}
	public void setTypeContribute(String typeContribute) {
		this.typeContribute = typeContribute;
	}
	public String getTimeContribute() {
		return timeContribute;
	}
	public void setTimeContribute(String timeContribute) {
		this.timeContribute = timeContribute;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Float getRewardCollege() {
		return rewardCollege;
	}
	public void setRewardCollege(Float rewardCollege) {
		this.rewardCollege = rewardCollege;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public String getProjectSource() {
		return projectSource;
	}
	public void setProjectSource(String projectSource) {
		this.projectSource = projectSource;
	}
	public Float getReportedAmounts() {
		return reportedAmounts;
	}
	public void setReportedAmounts(Float reportedAmounts) {
		this.reportedAmounts = reportedAmounts;
	}
}
