package com.cqupt.mis.rms.action.school;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.service.ScienceOrganizationService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchSchoolScienceOrganizationAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private ScienceOrganizationService scienceOrganizationService;
	private List<ScienceOrganization> scienceOrganizations;
	private List<CQUPTCollege> cquptColleges;
	private String collegeId;
	private String roleId;
	
	private String stringName1;
	private String stringValue1;
	
	private String stringName2;
	private String stringValue2;
	
	private String floatName1;
	private float minFloatValue1;
	private float maxFloatValue1;
	
	private String floatName2;
	private float minFloatValue2;
	private float maxFloatValue2;
	
	private String floatName3;
	private float minFloatValue3;
	private float maxFloatValue3;
	
	
	public void getAllScienceOrganizations(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		cquptColleges = searchCQUPTUserService.findManageCQUPTCollegeByRoleId(role);
		if(collegeId==null||collegeId.equals("all")){
		}else{
			cquptUsers = searchCQUPTUserService.searchCollegeUserByCollegeId(cquptUsers, collegeId);
		}
		this.scienceOrganizations = scienceOrganizationService.findAllScienceOrganization(cquptUsers);
	}
	
	public String execute(){
		this.getAllScienceOrganizations();
		scienceOrganizations = scienceOrganizationService.searchScienceOrganizationByStringFactor(scienceOrganizations, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				scienceOrganizations = scienceOrganizationService.searchScienceOrganizationByStringFactor(scienceOrganizations, stringName1, stringValue1);
			}
		}
		
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				scienceOrganizations = scienceOrganizationService.searchScienceOrganizationByStringFactor(scienceOrganizations, stringName2, stringValue2);
			}
		}
		
		
		if(floatName1==null||floatName1.equals("请选择")){
		}else{
			if(minFloatValue1==0&&maxFloatValue1==0){
			}else{
				scienceOrganizations = scienceOrganizationService.searchScienceOrganizationByNumFactor(scienceOrganizations, floatName1, minFloatValue1, maxFloatValue1);
			}
		}
		
		if(floatName2==null||floatName2.equals("请选择")){
		}else{
			if(minFloatValue2==0&&maxFloatValue2==0){
			}else{
				scienceOrganizations = scienceOrganizationService.searchScienceOrganizationByNumFactor(scienceOrganizations, floatName2, minFloatValue2, maxFloatValue2);
			}
		}
		
		if(floatName3==null||floatName3.equals("请选择")){
		}else{
			if(minFloatValue3==0&&maxFloatValue3==0){
			}else{
				scienceOrganizations = scienceOrganizationService.searchScienceOrganizationByNumFactor(scienceOrganizations, floatName3, minFloatValue3, maxFloatValue3);
			}
		}
		
		ActionContext.getContext().put("scienceOrganizations", scienceOrganizations);
		ActionContext.getContext().put("cquptColleges", cquptColleges);
		return "SUCCESS";
	}

	public void setSearchCQUPTUserService(
			SearchCQUPTUserService searchCQUPTUserService) {
		this.searchCQUPTUserService = searchCQUPTUserService;
	}

	public void setScienceOrganizationService(
			ScienceOrganizationService scienceOrganizationService) {
		this.scienceOrganizationService = scienceOrganizationService;
	}

	public void setScienceOrganizations(
			List<ScienceOrganization> scienceOrganizations) {
		this.scienceOrganizations = scienceOrganizations;
	}

	public void setCquptColleges(List<CQUPTCollege> cquptColleges) {
		this.cquptColleges = cquptColleges;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setStringName1(String stringName1) {
		this.stringName1 = stringName1;
	}

	public void setStringValue1(String stringValue1) {
		this.stringValue1 = stringValue1;
	}

	public void setStringName2(String stringName2) {
		this.stringName2 = stringName2;
	}

	public void setStringValue2(String stringValue2) {
		this.stringValue2 = stringValue2;
	}

	public void setFloatName1(String floatName1) {
		this.floatName1 = floatName1;
	}

	public void setMinFloatValue1(float minFloatValue1) {
		this.minFloatValue1 = minFloatValue1;
	}

	public void setMaxFloatValue1(float maxFloatValue1) {
		this.maxFloatValue1 = maxFloatValue1;
	}

	public void setFloatName2(String floatName2) {
		this.floatName2 = floatName2;
	}

	public void setMinFloatValue2(float minFloatValue2) {
		this.minFloatValue2 = minFloatValue2;
	}

	public void setMaxFloatValue2(float maxFloatValue2) {
		this.maxFloatValue2 = maxFloatValue2;
	}

	public void setFloatName3(String floatName3) {
		this.floatName3 = floatName3;
	}

	public void setMinFloatValue3(float minFloatValue3) {
		this.minFloatValue3 = minFloatValue3;
	}

	public void setMaxFloatValue3(float maxFloatValue3) {
		this.maxFloatValue3 = maxFloatValue3;
	}
}
