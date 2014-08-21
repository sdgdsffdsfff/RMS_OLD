package com.cqupt.mis.rms.model;

import java.util.Date;

public class HumanitiesProjectDetail {
	private int id;
	private HumanitiesProject humanitiesProject;
	private Date updateTime;
	private String projectStatus;
	private float money;
	private String timePerPerson;

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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getTimePerPerson() {
		return timePerPerson;
	}

	public void setTimePerPerson(String timePerPerson) {
		this.timePerPerson = timePerPerson;
	}
}
