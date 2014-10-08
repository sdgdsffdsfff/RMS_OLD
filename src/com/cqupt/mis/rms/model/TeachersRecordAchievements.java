package com.cqupt.mis.rms.model;

public class TeachersRecordAchievements {

	private int id;  //逻辑主键
	private TeachersAwardsRecord teachersAwardsRecord;  //教师获奖记录
	private String awardId;       // 获奖老师Id
	private String memberName;    //获奖老师姓名
	private int orders;           //获奖老师次序
	private String remarks;       //备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public TeachersAwardsRecord getTeachersAwardsRecord() {
		return teachersAwardsRecord;
	}

	public void setTeachersAwardsRecord(TeachersAwardsRecord teachersAwardsRecord) {
		this.teachersAwardsRecord = teachersAwardsRecord;
	}


	public String getAwardId() {
		return awardId;
	}

	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
