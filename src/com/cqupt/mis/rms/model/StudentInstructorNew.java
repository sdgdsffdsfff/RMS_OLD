package com.cqupt.mis.rms.model;

public class StudentInstructorNew {

	private int id;
	private StudentAwardsNew studentAwardsNew;
	

	private String instructorId;
	private String memberName;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StudentAwardsNew getStudentAwardsNew() {
		return studentAwardsNew;
	}

	public void setStudentAwardsNew(StudentAwardsNew studentAwardsNew) {
		this.studentAwardsNew = studentAwardsNew;
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
