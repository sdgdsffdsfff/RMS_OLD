package com.cqupt.mis.rms.model;

public class HumanitiesResearchRewardPerson {
	private int id;
	private HumanitiesResearchReward humanitiesResearchReward;
	private String rewardPersonId;
	private String rewardPersonName;
	private int orders;
	private String task;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HumanitiesResearchReward getHumanitiesResearchReward() {
		return humanitiesResearchReward;
	}

	public void setHumanitiesResearchReward(
			HumanitiesResearchReward humanitiesResearchReward) {
		this.humanitiesResearchReward = humanitiesResearchReward;
	}

	public String getRewardPersonId() {
		return rewardPersonId;
	}

	public void setRewardPersonId(String rewardPersonId) {
		this.rewardPersonId = rewardPersonId;
	}

	public String getRewardPersonName() {
		return rewardPersonName;
	}

	public void setRewardPersonName(String rewardPersonName) {
		this.rewardPersonName = rewardPersonName;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
