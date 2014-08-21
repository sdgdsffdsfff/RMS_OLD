package com.cqupt.mis.rms.model;

public class HumanitiesAcademicMeetingPerson {
	private int id;
	private HumanitiesAcademicMeeting humanitiesAcademicMeeting;
	private String meetingPersonId;
	private String meetingPersonName;
	private int orders;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HumanitiesAcademicMeeting getHumanitiesAcademicMeeting() {
		return humanitiesAcademicMeeting;
	}

	public void setHumanitiesAcademicMeeting(
			HumanitiesAcademicMeeting humanitiesAcademicMeeting) {
		this.humanitiesAcademicMeeting = humanitiesAcademicMeeting;
	}

	public String getMeetingPersonId() {
		return meetingPersonId;
	}

	public void setMeetingPersonId(String meetingPersonId) {
		this.meetingPersonId = meetingPersonId;
	}

	public String getMeetingPersonName() {
		return meetingPersonName;
	}

	public void setMeetingPersonName(String meetingPersonName) {
		this.meetingPersonName = meetingPersonName;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
