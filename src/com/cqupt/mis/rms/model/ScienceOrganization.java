package com.cqupt.mis.rms.model;

public class ScienceOrganization {
	private String organizationId;
	private String organizationName;
	private String organizationType;
	private String organizationCategory;
	private String sortSubject;
	private String modusComposition;
	private int totalEmployees;
	private int doctorEmployees;
	private int masterEmployees;
	private int totalIts;
	private int advancedIts;
	private int middleIts;
	private int juniorIts;
	private int otherIts;
	private int numGraduates;
	private float internalExpenditures;
	private float rdExpenditures;
	private int numIssueAssume;
	private float assetsFixed;
	private float assetsEquipment;
	private float assetsImport;
	private String industryService;

	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;

	private int status;
	private String returnReason;

	
	
	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getOrganizationCategory() {
		return organizationCategory;
	}

	public void setOrganizationCategory(String organizationCategory) {
		this.organizationCategory = organizationCategory;
	}

	public String getSortSubject() {
		return sortSubject;
	}

	public void setSortSubject(String sortSubject) {
		this.sortSubject = sortSubject;
	}

	public String getModusComposition() {
		return modusComposition;
	}

	public void setModusComposition(String modusComposition) {
		this.modusComposition = modusComposition;
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public int getDoctorEmployees() {
		return doctorEmployees;
	}

	public void setDoctorEmployees(int doctorEmployees) {
		this.doctorEmployees = doctorEmployees;
	}

	public int getMasterEmployees() {
		return masterEmployees;
	}

	public void setMasterEmployees(int masterEmployees) {
		this.masterEmployees = masterEmployees;
	}

	public int getTotalIts() {
		return totalIts;
	}

	public void setTotalIts(int totalIts) {
		this.totalIts = totalIts;
	}

	public int getAdvancedIts() {
		return advancedIts;
	}

	public void setAdvancedIts(int advancedIts) {
		this.advancedIts = advancedIts;
	}

	public int getMiddleIts() {
		return middleIts;
	}

	public void setMiddleIts(int middleIts) {
		this.middleIts = middleIts;
	}

	public int getJuniorIts() {
		return juniorIts;
	}

	public void setJuniorIts(int juniorIts) {
		this.juniorIts = juniorIts;
	}

	public int getOtherIts() {
		return otherIts;
	}

	public void setOtherIts(int otherIts) {
		this.otherIts = otherIts;
	}

	public int getNumGraduates() {
		return numGraduates;
	}

	public void setNumGraduates(int numGraduates) {
		this.numGraduates = numGraduates;
	}

	public float getInternalExpenditures() {
		return internalExpenditures;
	}

	public void setInternalExpenditures(float internalExpenditures) {
		this.internalExpenditures = internalExpenditures;
	}

	public float getRdExpenditures() {
		return rdExpenditures;
	}

	public void setRdExpenditures(float rdExpenditures) {
		this.rdExpenditures = rdExpenditures;
	}

	public int getNumIssueAssume() {
		return numIssueAssume;
	}

	public void setNumIssueAssume(int numIssueAssume) {
		this.numIssueAssume = numIssueAssume;
	}

	public float getAssetsFixed() {
		return assetsFixed;
	}

	public void setAssetsFixed(float assetsFixed) {
		this.assetsFixed = assetsFixed;
	}

	public float getAssetsEquipment() {
		return assetsEquipment;
	}

	public void setAssetsEquipment(float assetsEquipment) {
		this.assetsEquipment = assetsEquipment;
	}

	public float getAssetsImport() {
		return assetsImport;
	}

	public void setAssetsImport(float assetsImport) {
		this.assetsImport = assetsImport;
	}

	public String getIndustryService() {
		return industryService;
	}

	public void setIndustryService(String industryService) {
		this.industryService = industryService;
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

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

}
