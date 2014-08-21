package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachersAwardsNew;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.TeachAchievementsNewService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeTeachAchievementsNewAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private TeachAchievementsNewService teachAchievementsNewService;
	private List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> teachAchievementsNewInfos;
	
	private String roleId;
	
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
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void getAllTeachAchievementsInfo(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.teachAchievementsNewInfos = teachAchievementsNewService.findAllTeachAchievementsInfo(cquptUsers);
	}
	
	public String execute(){
		this.getAllTeachAchievementsInfo();
		this.teachAchievementsNewInfos = teachAchievementsNewService.searchTeachAchievementsInfoByStringFactor(teachAchievementsNewInfos, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				teachAchievementsNewInfos = teachAchievementsNewService.searchTeachAchievementsInfoByStringFactor(teachAchievementsNewInfos, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				teachAchievementsNewInfos = teachAchievementsNewService.searchTeachAchievementsInfoByStringFactor(teachAchievementsNewInfos, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				teachAchievementsNewInfos = teachAchievementsNewService.searchTeachAchievementsInfoByStringFactor(teachAchievementsNewInfos, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				teachAchievementsNewInfos = teachAchievementsNewService.searchTeachAchievementsInfoByStringFactor(teachAchievementsNewInfos, stringName4, stringValue4);
			}
		}
		if(floatName1==null||floatName1.equals("请选择")){
		}else{
			if(minFloatValue1==0&&maxFloatValue1==0){
			}else{
				teachAchievementsNewInfos = teachAchievementsNewService.searchTeachAchievementsInfoByNumFactor(teachAchievementsNewInfos, floatName1, minFloatValue1, maxFloatValue1);
			}
		}
		
		ActionContext.getContext().put("teachAchievementsNewInfos", teachAchievementsNewInfos);
		type="search";

		if(stringName1!=null){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<teachAchievementsNewInfos.size();i++){
			
			String classAchievements = "";
			if(teachAchievementsNewInfos.get(i).getModel().getClassAchievements()!=null){
				classAchievements = teachAchievementsNewInfos.get(i).getModel().getClassAchievements();
			}
			
			String TimeAchievements = "";
			if(teachAchievementsNewInfos.get(i).getModel().getTimeAchievements()!=null){
				TimeAchievements = teachAchievementsNewInfos.get(i).getModel().getTimeAchievements().toString();
			}
			
			Float CollegeAward = 0.0f;
			if(teachAchievementsNewInfos.get(i).getModel().getCollegeAward()!=null){
				CollegeAward = teachAchievementsNewInfos.get(i).getModel().getCollegeAward();
			}
			
			String ApprovedUser = "";
			if(teachAchievementsNewInfos.get(i).getModel().getApprovedUser().getUserName()!=null){
				ApprovedUser = teachAchievementsNewInfos.get(i).getModel().getApprovedUser().getUserName();
			}
			
			
			builder.append(teachAchievementsNewInfos.get(i).getModel().getAchievementsId())
			.append(":{achievementsId:\"").append(teachAchievementsNewInfos.get(i).getModel().getAchievementsId())
			.append("\",classAchievements:\"").append(classAchievements)
			.append("\",projectName:\"").append(teachAchievementsNewInfos.get(i).getModel().getProjectName())
			.append("\",levelAchievements:\"").append(teachAchievementsNewInfos.get(i).getModel().getLevelAchievements())
			.append("\",timeAchievements:\"").append(TimeAchievements)
			.append("\",collegeAward:\"").append(CollegeAward)
			.append("\",submitUser:\"").append(teachAchievementsNewInfos.get(i).getModel().getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(ApprovedUser)
			.append("\",status:\"").append(teachAchievementsNewInfos.get(i).getModel().getStatus())
			.append("\"}");
			if(i+1<teachAchievementsNewInfos.size()){
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

	public void setteachAchievementsNewService(
			TeachAchievementsNewService teachAchievementsNewService) {
		this.teachAchievementsNewService = teachAchievementsNewService;
	}

	public void setteachAchievementsNewInfos(
			List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> teachAchievementsNewInfos) {
		this.teachAchievementsNewInfos = teachAchievementsNewInfos;
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
}
