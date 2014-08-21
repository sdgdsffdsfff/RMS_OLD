package com.cqupt.mis.rms.action.school;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.service.TeachingMaterialSetService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchSchoolTeachingMaterialSetAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private TeachingMaterialSetService oldteachingMaterialSetService;
	public TeachingMaterialSetService getOldteachingMaterialSetService() {
		return oldteachingMaterialSetService;
	}

	public void setOldteachingMaterialSetService(
			TeachingMaterialSetService oldteachingMaterialSetService) {
		this.oldteachingMaterialSetService = oldteachingMaterialSetService;
	}

	private List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> teachingMaterialSets;
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
		this.teachingMaterialSets = oldteachingMaterialSetService.findAllTeachingMaterialSet(cquptUsers);
	}
	
	public String execute(){
		this.getAllTeachingMaterialSet();
		teachingMaterialSets = oldteachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				teachingMaterialSets = oldteachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				teachingMaterialSets = oldteachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				teachingMaterialSets = oldteachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				teachingMaterialSets = oldteachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, stringName4, stringValue4);
			}
		}
		System.out.println(cquptColleges.size());
		ActionContext.getContext().put("cquptColleges", cquptColleges);
		System.out.println(teachingMaterialSets.size());
		ActionContext.getContext().put("teachingMaterialSets", teachingMaterialSets);
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

	public void setTeachingMaterialSets(
			List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> teachingMaterialSets) {
		this.teachingMaterialSets = teachingMaterialSets;
	}
}
