package com.cqupt.mis.rms.model;


public class TeachAchievementsCQ {

	private String achievementsId;
	private String classAchievements;//负责人（学生）
	private String gradeAchievements;//结题时间
	private String projectName;//项目名称
    private String timeAchievements;//立项时间
	private String certificationUnit;//团队成员
	private String reportedAmounts;//项目编号
	private Float verifyAmounts;//奖励金额
	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;
	private int status;
	private String remarks;//备注
	
	private String returnReason;
	private String projectType;//类型
	private String standbyField1;
	public String getAchievementsId() {
		return achievementsId;
	}
	public void setAchievementsId(String achievementsId) {
		this.achievementsId = achievementsId;
	}
	public String getClassAchievements() {
		return classAchievements;
	}
	public void setClassAchievements(String classAchievements) {
		this.classAchievements = classAchievements;
	}
	public String getGradeAchievements() {
		return gradeAchievements;
	}
	public void setGradeAchievements(String gradeAchievements) {
		this.gradeAchievements = gradeAchievements;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTimeAchievements() {
		return timeAchievements;
	}
	public void setTimeAchievements(String timeAchievements) {
		this.timeAchievements = timeAchievements;
	}
	public String getCertificationUnit() {
		return certificationUnit;
	}
	public void setCertificationUnit(String certificationUnit) {
		this.certificationUnit = certificationUnit;
	}
	public String getReportedAmounts() {
		return reportedAmounts;
	}
	public void setReportedAmounts(String reportedAmounts) {
		this.reportedAmounts = reportedAmounts;
	}
	public Float getVerifyAmounts() {
		return verifyAmounts;
	}
	public void setVerifyAmounts(Float verifyAmounts) {
		this.verifyAmounts = verifyAmounts;
	}
	public CQUPTUser getSubmitUser() {
		return submitUser;
	}
	public void setSubmitUser(CQUPTUser submitUser) {
		this.submitUser = submitUser;
	}
	public CQUPTUser getApprovedUser() {
		return approvedUser;
	}
	public void setApprovedUser(CQUPTUser approvedUser) {
		this.approvedUser = approvedUser;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public String getStandbyField1() {
		return standbyField1;
	}
	public void setStandbyField1(String standbyField1) {
		this.standbyField1 = standbyField1;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
}
