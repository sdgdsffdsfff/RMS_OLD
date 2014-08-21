package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachersAwards;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.TeachAchievementsService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeTeachAchievementsAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private TeachAchievementsService teachAchievementsService;
	private List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfos;
	
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
		this.teachAchievementsInfos = teachAchievementsService.findAllTeachAchievementsInfo(cquptUsers);
	}
	
	public String execute(){
		this.getAllTeachAchievementsInfo();
		this.teachAchievementsInfos = teachAchievementsService.searchTeachAchievementsInfoByStringFactor(teachAchievementsInfos, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				teachAchievementsInfos = teachAchievementsService.searchTeachAchievementsInfoByStringFactor(teachAchievementsInfos, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				teachAchievementsInfos = teachAchievementsService.searchTeachAchievementsInfoByStringFactor(teachAchievementsInfos, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				teachAchievementsInfos = teachAchievementsService.searchTeachAchievementsInfoByStringFactor(teachAchievementsInfos, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				teachAchievementsInfos = teachAchievementsService.searchTeachAchievementsInfoByStringFactor(teachAchievementsInfos, stringName4, stringValue4);
			}
		}
		if(floatName1==null||floatName1.equals("请选择")){
		}else{
			if(minFloatValue1==0&&maxFloatValue1==0){
			}else{
				teachAchievementsInfos = teachAchievementsService.searchTeachAchievementsInfoByNumFactor(teachAchievementsInfos, floatName1, minFloatValue1, maxFloatValue1);
			}
		}
		
		System.out.println(teachAchievementsInfos.size());
		ActionContext.getContext().put("teachAchievementsInfos", teachAchievementsInfos);
		type="search";


		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<teachAchievementsInfos.size();i++){
			builder.append(teachAchievementsInfos.get(i).getModel().getAchievementsId())
			.append(":{achievementsId:\"").append(teachAchievementsInfos.get(i).getModel().getAchievementsId())
			.append("\",classAchievements:\"").append(teachAchievementsInfos.get(i).getModel().getClassAchievements())
			.append("\",projectName:\"").append(teachAchievementsInfos.get(i).getModel().getProjectName())
			.append("\",levelAchievements:\"").append(teachAchievementsInfos.get(i).getModel().getLevelAchievements())
			.append("\",timeAchievements:\"").append(teachAchievementsInfos.get(i).getModel().getTimeAchievements())
			.append("\",collegeAward:\"").append(teachAchievementsInfos.get(i).getModel().getCollegeAward())
			.append("\",submitUser:\"").append(teachAchievementsInfos.get(i).getModel().getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(teachAchievementsInfos.get(i).getModel().getApprovedUser().getUserName())
			.append("\",status:\"").append(teachAchievementsInfos.get(i).getModel().getStatus())
			.append("\"}");
			if(i+1<teachAchievementsInfos.size()){
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

	public void setTeachAchievementsService(
			TeachAchievementsService teachAchievementsService) {
		this.teachAchievementsService = teachAchievementsService;
	}

	public void setTeachAchievementsInfos(
			List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfos) {
		this.teachAchievementsInfos = teachAchievementsInfos;
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
