package com.cqupt.mis.rms.action.school;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceBookAuthor;
import com.cqupt.mis.rms.service.ScienceBookService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchSchoolScienceBookInfoAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private ScienceBookService scienceBookService;
	private List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfo;
	private List<CQUPTCollege> cquptColleges;
	private String roleId;
	private String collegeId;
	
	private String stringName1;
	private String stringValue1;
	
	private String stringName2;
	private String stringValue2;
	
	private String stringName3;
	private String stringValue3;
	
	private String stringName4;
	private String stringValue4;
	
	
	private String floatName1;
	private float minFloatValue1;
	private float maxFloatValue1;
	
	private String floatName2;
	private float minFloatValue2;
	private float maxFloatValue2;
	
	public void getAllScienceBookInfo(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		cquptColleges = searchCQUPTUserService.findManageCQUPTCollegeByRoleId(role);
		if(collegeId==null||collegeId.equals("all")){
		}else{
			cquptUsers = searchCQUPTUserService.searchCollegeUserByCollegeId(cquptUsers, collegeId);
		}
		this.scienceBookInfo = scienceBookService.findAllScienceBookInfo(cquptUsers);
	}
	
	public String execute(){
		this.getAllScienceBookInfo();
		scienceBookInfo = scienceBookService.searchScienceBookInfoByStringFactor(scienceBookInfo, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
			scienceBookInfo = scienceBookService.searchScienceBookInfoByStringFactor(scienceBookInfo, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
			scienceBookInfo = scienceBookService.searchScienceBookInfoByStringFactor(scienceBookInfo, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
			scienceBookInfo = scienceBookService.searchScienceBookInfoByStringFactor(scienceBookInfo, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
			scienceBookInfo = scienceBookService.searchScienceBookInfoByStringFactor(scienceBookInfo, stringName4, stringValue4);
			}
		}
		
		if(floatName1==null||floatName1.equals("请选择")){
		}else{
			if(minFloatValue1==0&&maxFloatValue1==0){
			}else{
				scienceBookInfo = scienceBookService.searchScienceBookInfoByNumFactor(scienceBookInfo, floatName1, minFloatValue1, maxFloatValue1);
			}
		}
		if(floatName2==null||floatName2.equals("请选择")){
		}else{
			if(minFloatValue2==0&&maxFloatValue2==0){
			}else{
				scienceBookInfo = scienceBookService.searchScienceBookInfoByNumFactor(scienceBookInfo, floatName2, minFloatValue2, maxFloatValue2);
			}
		}
		
		ActionContext.getContext().put("cquptColleges", cquptColleges);
		ActionContext.getContext().put("scienceBookInfo", scienceBookInfo);
		return "SUCCESS";
	}

	public void setSearchCQUPTUserService(
			SearchCQUPTUserService searchCQUPTUserService) {
		this.searchCQUPTUserService = searchCQUPTUserService;
	}

	public void setScienceBookService(ScienceBookService scienceBookService) {
		this.scienceBookService = scienceBookService;
	}

	public void setScienceBookInfo(
			List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfo) {
		this.scienceBookInfo = scienceBookInfo;
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
}
