package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.TeachingMaterialSetService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeTeachingMaterialSetAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private TeachingMaterialSetService teachingMaterialSetService;
	private List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> teachingMaterialSets;
	
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
	public void getAllTeachingMaterialSet(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.teachingMaterialSets = teachingMaterialSetService.findAllTeachingMaterialSet(cquptUsers);
	}
	
	public String execute(){
		this.getAllTeachingMaterialSet();
		teachingMaterialSets = teachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				teachingMaterialSets = teachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				teachingMaterialSets = teachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				teachingMaterialSets = teachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				teachingMaterialSets = teachingMaterialSetService.searchTeachingMaterialSetByStringFactor(teachingMaterialSets, stringName4, stringValue4);
			}
		}
		
		System.out.println(teachingMaterialSets.size());
		ActionContext.getContext().put("teachingMaterialSets", teachingMaterialSets);
		type="search";


		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<teachingMaterialSets.size();i++){
			builder.append(teachingMaterialSets.get(i).getModel().getTeachingMaterialId())
			.append(":{teachingMaterialId:\"").append(teachingMaterialSets.get(i).getModel().getTeachingMaterialId())
			.append("\",setClass:\"").append(teachingMaterialSets.get(i).getModel().getSetClass())
			.append("\",setTime:\"").append(teachingMaterialSets.get(i).getModel().getSetTime())
			.append("\",numberProject:\"").append(teachingMaterialSets.get(i).getModel().getNumberProject())
			.append("\",teachingMaterialName:\"").append(teachingMaterialSets.get(i).getModel().getTeachingMaterialName())
			.append("\",resultsPostedStatus:\"").append(teachingMaterialSets.get(i).getModel().getResultsPostedStatus())
			.append("\",submitUser:\"").append(teachingMaterialSets.get(i).getModel().getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(teachingMaterialSets.get(i).getModel().getApprovedUser().getUserName())
			.append("\",status:\"").append(teachingMaterialSets.get(i).getModel().getStatus())
			.append("\"}");
			if(i+1<teachingMaterialSets.size()){
				builder.append(",");
			}
		}
		builder.append("}");
		System.out.println(builder);
		
		try {
			response.getWriter().println(builder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(stringName1!=null){
			return null;
		}else{
			return "SUCCESS";
		}
	}

	public void setSearchCQUPTUserService(
			SearchCQUPTUserService searchCQUPTUserService) {
		this.searchCQUPTUserService = searchCQUPTUserService;
	}

	public void setTeachingMaterialSetService(
			TeachingMaterialSetService teachingMaterialSetService) {
		this.teachingMaterialSetService = teachingMaterialSetService;
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
