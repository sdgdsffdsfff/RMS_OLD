package com.cqupt.mis.rms.model;

import java.util.Date;

import com.cqupt.mis.rms.model.CQUPTUser;

public class MajorContribute {
	private String majorId;
	private String classContribute;
	private String typeContribute;
	private String timeContribute;
	private String majorName;
	private Date checkTime;
	private Date endTime;
	private Float rewardCollege;
	private String remarks;
	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;
	private int status;
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
