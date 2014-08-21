package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachAchievementsDeclarant;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.TeachAchievementsCQService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeTeachAchievementsCQAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private TeachAchievementsCQService teachAchievementsCQService;
	
	public TeachAchievementsCQService getTeachAchievementsCQService() {
		return teachAchievementsCQService;
	}

	public void setTeachAchievementsCQService(
			TeachAchievementsCQService teachAchievementsCQService) {
		this.teachAchievementsCQService = teachAchievementsCQService;
	}

	private List<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>> teachAchievementsCQInfos;
	
	
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
	public void getAllTeachAchievementsNewInfo(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.teachAchievementsCQInfos = teachAchievementsCQService.findAllTeachAchievementsCQInfo(cquptUsers);
	}
	
	public String execute(){
		this.getAllTeachAchievementsNewInfo();
		this.teachAchievementsCQInfos = teachAchievementsCQService.searchTeachAchievementsCQInfoByStringFactor(teachAchievementsCQInfos, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				teachAchievementsCQInfos = teachAchievementsCQService.searchTeachAchievementsCQInfoByStringFactor(teachAchievementsCQInfos, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				teachAchievementsCQInfos = teachAchievementsCQService.searchTeachAchievementsCQInfoByStringFactor(teachAchievementsCQInfos, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				teachAchievementsCQInfos = teachAchievementsCQService.searchTeachAchievementsCQInfoByStringFactor(teachAchievementsCQInfos, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				teachAchievementsCQInfos = teachAchievementsCQService.searchTeachAchievementsCQInfoByStringFactor(teachAchievementsCQInfos, stringName4, stringValue4);
			}
		}
		if(floatName1==null||floatName1.equals("请选择")){
		}else{
			if(minFloatValue1==0&&maxFloatValue1==0){
			}else{
				teachAchievementsCQInfos = teachAchievementsCQService.searchTeachAchievementsCQInfoByNumFactor(teachAchievementsCQInfos, floatName1, minFloatValue1, maxFloatValue1);
			}
		}
		
		ActionContext.getContext().put("teachAchievementsCQInfos", teachAchievementsCQInfos);
		type="search";

		if(stringName1!=null){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<teachAchievementsCQInfos.size();i++){
			String AchievementsId = "";
			if(teachAchievementsCQInfos.get(i).getModel().getAchievementsId()!=null){
				AchievementsId = teachAchievementsCQInfos.get(i).getModel().getAchievementsId();
			}
			
			String ClassAchievements = "";
			if(teachAchievementsCQInfos.get(i).getModel().getClassAchievements()!=null){
				ClassAchievements = teachAchievementsCQInfos.get(i).getModel().getClassAchievements();
			}
			
			String ProjectName = "";
			if(teachAchievementsCQInfos.get(i).getModel().getProjectName()!=null){
				ProjectName = teachAchievementsCQInfos.get(i).getModel().getProjectName();
			}
			
			String GradeAchievements = "";
			if(teachAchievementsCQInfos.get(i).getModel().getGradeAchievements()!=null){
				GradeAchievements = teachAchievementsCQInfos.get(i).getModel().getGradeAchievements();
			}
			
			String TimeAchievements = "";
			if(teachAchievementsCQInfos.get(i).getModel().getTimeAchievements()!=null){
				TimeAchievements = teachAchievementsCQInfos.get(i).getModel().getTimeAchievements();
			}
			
			Float VerifyAmounts = 0.0f;
			if(teachAchievementsCQInfos.get(i).getModel().getVerifyAmounts()!=null){
				VerifyAmounts = teachAchievementsCQInfos.get(i).getModel().getVerifyAmounts();
			}
			
			Float ReportedAmounts = 0.0f;
			if(teachAchievementsCQInfos.get(i).getModel().getReportedAmounts()!=null){
				ReportedAmounts = Float.parseFloat(teachAchievementsCQInfos.get(i).getModel().getReportedAmounts());
			}
			
			String SubmitUser = "";
			if(teachAchievementsCQInfos.get(i).getModel().getSubmitUser().getUserName()!=null){
				SubmitUser = teachAchievementsCQInfos.get(i).getModel().getSubmitUser().getUserName();
			}
			
			String ApprovedUser = "";
			if(teachAchievementsCQInfos.get(i).getModel().getApprovedUser().getUserName()!=null){
				ApprovedUser = teachAchievementsCQInfos.get(i).getModel().getApprovedUser().getUserName();
			}
			
			
			builder.append(AchievementsId)
			.append(":{achievementsId:\"").append(AchievementsId)
			.append("\",classAchievements:\"").append(ClassAchievements)
			.append("\",projectName:\"").append(ProjectName)
			.append("\",gradeAchievements:\"").append(GradeAchievements)
			.append("\",timeAchievements:\"").append(TimeAchievements)
			.append("\",verifyAmounts:\"").append(VerifyAmounts)
			.append("\",reportedAmounts:\"").append(ReportedAmounts)
			.append("\",submitUser:\"").append(SubmitUser)
			.append("\",approvedUser:\"").append(ApprovedUser)
			.append("\",status:\"").append(teachAchievementsCQInfos.get(i).getModel().getStatus())
			.append("\"}");
			if(i+1<teachAchievementsCQInfos.size()){
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

	public TeachAchievementsCQService getTeachAchievementsNewService() {
		return teachAchievementsCQService;
	}

	public void setTeachAchievementsNewService(
			TeachAchievementsCQService teachAchievementsNewService) {
		this.teachAchievementsCQService = teachAchievementsNewService;
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
