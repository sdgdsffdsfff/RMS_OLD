package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.TeachingMaterialSetNewService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeTeachingMaterialSetNewAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private TeachingMaterialSetNewService teachingMaterialSetNewService;
	private List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> teachingMaterialSetsNewInfos;
	
	private String roleId;
	
	private String stringName1;
	private String stringValue1;
	
	private String stringName2;
	private String stringValue2;
	
	private String stringName3;
	private String stringValue3;
	
	private String stringName4;
	private String stringValue4;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void getAllTeachingMaterialSetNew(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.teachingMaterialSetsNewInfos = teachingMaterialSetNewService.findAllTeachingMaterialSet(cquptUsers);
	}
	
	public String execute(){
		this.getAllTeachingMaterialSetNew();
		teachingMaterialSetsNewInfos = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNewInfos, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				teachingMaterialSetsNewInfos = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNewInfos, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				teachingMaterialSetsNewInfos = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNewInfos, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				teachingMaterialSetsNewInfos = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNewInfos, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				teachingMaterialSetsNewInfos = teachingMaterialSetNewService.searchTeachingMaterialSetByStringFactor(teachingMaterialSetsNewInfos, stringName4, stringValue4);
			}
		}
		
		ActionContext.getContext().put("teachingMaterialSetsNewInfos", teachingMaterialSetsNewInfos);
		type="search";

		if(stringName1!=null){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<teachingMaterialSetsNewInfos.size();i++){
			builder.append(teachingMaterialSetsNewInfos.get(i).getModel().getTeachingMaterialId())
			.append(":{teachingMaterialId:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getTeachingMaterialId())
			.append("\",setClass:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getSetClass())
			.append("\",setTime:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getSetTime())
			.append("\",numberProject:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getNumberProject())
			.append("\",teachingMaterialName:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getTeachingMaterialName())
			.append("\",resultsPostedStatus:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getResultsPostedStatus())
			.append("\",submitUser:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getApprovedUser().getUserName())
			.append("\",status:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getStatus())
			.append("\",wordsNumbers:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getWordsNumbers()+"")
			.append("\",remarks:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getRemarks())
			.append("\",collegeAward:\"").append(teachingMaterialSetsNewInfos.get(i).getModel().getCollegeAward())

			.append("\"}");
			if(i+1<teachingMaterialSetsNewInfos.size()){
				builder.append(",");
			}
		}
		builder.append("}");
		
		try {
			response.getWriter().println(builder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			return null;
		}else{
			return "SUCCESS";
		}
	}

	public void setSearchCQUPTUserService(
			SearchCQUPTUserService searchCQUPTUserService) {
		this.searchCQUPTUserService = searchCQUPTUserService;
	}

	public void setteachingMaterialSetNewService(
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

	public void setTeachingMaterialSets(
			List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> teachingMaterialSets) {
		this.teachingMaterialSetsNewInfos = teachingMaterialSets;
	}
}
