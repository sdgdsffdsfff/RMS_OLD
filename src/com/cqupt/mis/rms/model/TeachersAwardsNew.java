package com.cqupt.mis.rms.model;

public class TeachersAwardsNew {

	private int id;
	private TeachAchievementsNew teachAchievementsNew;
	

	private String awardId;
	private String memberName;
	private int orders;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TeachAchievementsNew getTeachAchievementsNew() {
		return teachAchievementsNew;
	}

	public void setTeachAchievementsNew(TeachAchievementsNew teachAchievementsNew) {
		this.teachAchievementsNew = teachAchievementsNew;
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
