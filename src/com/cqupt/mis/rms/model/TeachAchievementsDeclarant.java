package com.cqupt.mis.rms.model;

public class TeachAchievementsDeclarant {
	
	private int id;
	private TeachAchievementsCQ  teachAchievementsCQ;
	private String declarantId;
	private String declarantName;
	private int orders;
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TeachAchievementsCQ getTeachAchievementsCQ() {
		return teachAchievementsCQ;
	}
	public void setTeachAchievementsCQ(TeachAchievementsCQ teachAchievementsCQ) {
		this.teachAchievementsCQ = teachAchievementsCQ;
	}
	public String getDeclarantId() {
		return declarantId;
	}
	public void setDeclarantId(String declarantId) {
		this.declarantId = declarantId;
	}
	public String getDeclarantName() {
		return declarantName;
	}
	public void setDeclarantName(String declarantName) {
		this.declarantName = declarantName;
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
