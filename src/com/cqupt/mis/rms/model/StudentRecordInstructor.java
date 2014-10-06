package com.cqupt.mis.rms.model;

/**
 * 学生获奖信息对应的指导教师类
 * @author Bern
 *
 */
public class StudentRecordInstructor {
	
	private int id;		//逻辑主键
	private StudentAwardsRecord studentAwardsRecord;		//学生获奖记录
	private String instructorId;		//指导教师Id
	private String memberName;		//指导教师姓名
	private String remarks;		//备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentAwardsRecord getStudentAwardsRecord() {
		return studentAwardsRecord;
	}
	public void setStudentAwardsRecord(StudentAwardsRecord studentAwardsRecord) {
		this.studentAwardsRecord = studentAwardsRecord;
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
