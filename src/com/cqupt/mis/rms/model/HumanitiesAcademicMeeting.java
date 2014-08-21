package com.cqupt.mis.rms.model;

import java.util.Date;

public class HumanitiesAcademicMeeting {
	private String academicMeetingId;
	private String academicMeetingName;
	private String hostUnit;
	private String meetingClassify;
	private Date holdingTime;
	private String meetingLocation;
	private String participantsNumber;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	public String getAcademicMeetingId() {
		return academicMeetingId;
	}

	public void setAcademicMeetingId(String academicMeetingId) {
		this.academicMeetingId = academicMeetingId;
	}

	public String getAcademicMeetingName() {
		return academicMeetingName;
	}

	public void setAcademicMeetingName(String academicMeetingName) {
		this.academicMeetingName = academicMeetingName;
	}

	public String getHostUnit() {
		return hostUnit;
	}

	public void setHostUnit(String hostUnit) {
		this.hostUnit = hostUnit;
	}

	public String getMeetingClassify() {
		return meetingClassify;
	}

	public void setMeetingClassify(String meetingClassify) {
		this.meetingClassify = meetingClassify;
	}

	public Date getHoldingTime() {
		return holdingTime;
	}

	public void setHoldingTime(Date holdingTime) {
		this.holdingTime = holdingTime;
	}

	public String getMeetingLocation() {
		return meetingLocation;
	}

	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}

	public String getParticipantsNumber() {
		return participantsNumber;
	}

	public void setParticipantsNumber(String participantsNumber) {
		this.participantsNumber = participantsNumber;
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
