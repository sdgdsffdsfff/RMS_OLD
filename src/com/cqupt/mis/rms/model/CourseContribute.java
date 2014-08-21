package com.cqupt.mis.rms.model;

import java.util.Date;

import com.cqupt.mis.rms.model.CQUPTUser;

public class CourseContribute {
	private String courseId;
	private String classContribute;
	private String typeContribute;
	private String timeContribute;
	private String courseName;
	private Date checkTime;
	private Date endTime;
	private Float collegeAward;
	private String remarks;
	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;
	private int status;
	private String returnReason;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	public Float getCollegeAward() {
		return collegeAward;
	}
	public void setCollegeAward(Float collegeAward) {
		this.collegeAward = collegeAward;
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
