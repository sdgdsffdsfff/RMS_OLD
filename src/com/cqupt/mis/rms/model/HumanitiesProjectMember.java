package com.cqupt.mis.rms.model;

public class HumanitiesProjectMember {
	private int id;
	private HumanitiesProject humanitiesProject;
	private String memberId;
	private String memberName;
	private int orders;
	private String task;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HumanitiesProject getHumanitiesProject() {
		return humanitiesProject;
	}

	public void setHumanitiesProject(HumanitiesProject humanitiesProject) {
		this.humanitiesProject = humanitiesProject;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
