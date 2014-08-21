package com.cqupt.mis.rms.action.school;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.TeachingMaterialSetNewService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchSchoolTeachingMaterialSetNewAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private TeachingMaterialSetNewService teachingMaterialSetNewService;
	private List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> teachingMaterialSetsNew;
	private List<CQUPTCollege> cquptColleges;
	private String collegeId;
	private String roleId;
	
	private String stringName1;
	private String stringValue1;
	
	private String stringName2;
	private String stringValue2;
	
	private String stringName3;
	private String stringValue3;
	
	private String stringName4;
	private String stringValue4;
	
	public void getAllTeachingMaterialSet(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		cquptColleges = searchCQUPTUserService.findManageCQUPTCollegeByRoleId(role);
		if(collegeId==null||collegeId.equals("all")){
		}else{
			cquptUsers = searchCQUPTUserService.searchCollegeUserByCollegeId(cquptUsers, collegeId);
		}
		this.teachingMaterialSetsNew = teachingMaterialSetNewService.findAllTeachingMaterialSet(cquptUsers);
	}
	
	public String execute(){
		this.getAllTeachingMaterialSet();
		teachingMaterialSetsNew = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNew, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				teachingMaterialSetsNew = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNew, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				teachingMaterialSetsNew = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNew, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				teachingMaterialSetsNew = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNew, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				teachingMaterialSetsNew = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNew, stringName4, stringValue4);
			}
		}
		ActionContext.getContext().put("cquptColleges", cquptColleges);
		ActionContext.getContext().put("teachingMaterialSetsNew", teachingMaterialSetsNew);
		return "SUCCESS";
	}

	public void setCquptColleges(List<CQUPTCollege> cquptColleges) {
		this.cquptColleges = cquptColleges;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public void setSearchCQUPTUserService(
			SearchCQUPTUserService searchCQUPTUserService) {
		this.searchCQUPTUserService = searchCQUPTUserService;
	}

	public void setTeachingMaterialSetNewService(
			TeachingMaterialSetNewService teachingMaterialSetNewService) {
		this.teachingMaterialSetNewService = teachingMaterialSetNewService;
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

	public void setStringName3(String stringName3) {
		this.stringName3 = stringName3;
	}

	public void setStringValue3(String stringValue3) {
		this.stringValue3 = stringValue3;
	}

	public void setStringName4(String stringName4) {
		this.stringName4 = stringName4;
	}

	public void setStringValue4(String stringValue4) {
		this.stringValue4 = stringValue4;
	}

	public void setTeachingMaterialSetsNew(
			List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> teachingMaterialSetsNew) {
		this.teachingMaterialSetsNew = teachingMaterialSetsNew;
	}
}
