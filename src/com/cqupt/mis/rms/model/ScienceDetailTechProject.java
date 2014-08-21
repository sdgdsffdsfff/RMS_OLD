package com.cqupt.mis.rms.model;

import java.util.Date;

public class ScienceDetailTechProject {
	private String deatilProjectId;
	private ScienceTechProject scienceTechProject;
	private Date updateTime;
	private float inputThisYear;
	private float expenditureThisYear;
	private int totalStaff;
	private int advancedStaff;
	private int middleStaff;
	private int juniorStaff;
	private int otherStaff;
	private int graduateJoin;
	private String projectStatus;

	public String getDeatilProjectId() {
		return deatilProjectId;
	}

	public void setDeatilProjectId(String deatilProjectId) {
		this.deatilProjectId = deatilProjectId;
	}

	public ScienceTechProject getScienceTechProject() {
		return scienceTechProject;
	}

	public void setScienceTechProject(ScienceTechProject scienceTechProject) {
		this.scienceTechProject = scienceTechProject;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public float getInputThisYear() {
		return inputThisYear;
	}

	public void setInputThisYear(float inputThisYear) {
		this.inputThisYear = inputThisYear;
	}

	public float getExpenditureThisYear() {
		return expenditureThisYear;
	}

	public void setExpenditureThisYear(float expenditureThisYear) {
		this.expenditureThisYear = expenditureThisYear;
	}

	public int getTotalStaff() {
		return totalStaff;
	}

	public void setTotalStaff(int totalStaff) {
		this.totalStaff = totalStaff;
	}

	public int getAdvancedStaff() {
		return advancedStaff;
	}

	public void setAdvancedStaff(int advancedStaff) {
		this.advancedStaff = advancedStaff;
	}

	public int getMiddleStaff() {
		return middleStaff;
	}

	public void setMiddleStaff(int middleStaff) {
		this.middleStaff = middleStaff;
	}

	public int getJuniorStaff() {
		return juniorStaff;
	}

	public void setJuniorStaff(int juniorStaff) {
		this.juniorStaff = juniorStaff;
	}

	public int getOtherStaff() {
		return otherStaff;
	}

	public void setOtherStaff(int otherStaff) {
		this.otherStaff = otherStaff;
	}

	public int getGraduateJoin() {
		return graduateJoin;
	}

	public void setGraduateJoin(int graduateJoin) {
		this.graduateJoin = graduateJoin;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

}
