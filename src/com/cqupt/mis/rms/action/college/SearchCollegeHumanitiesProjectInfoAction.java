package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.service.HumanitiesProjectService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.model.ProjectInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeHumanitiesProjectInfoAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private HumanitiesProjectService humanitiesProjectService;
	private List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo;
	
	private String roleId;
	
	private String stringName1;
	private String stringValue1;
	
	private String stringName2;
	private String stringValue2;
	
	private String stringName3;
	private String stringValue3;
	
	private String stringName4;
	private String stringValue4;
	
	private String dateName;
	private String begin;
	private String end;
		
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
	public void getAllHumanitiesProjectInfo(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.projectInfo = this.humanitiesProjectService.findHumanitiesProjectInfoByUser(cquptUsers);
	}
	
	public String execute(){
		this.getAllHumanitiesProjectInfo();
		
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo2 = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo4 = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo5 = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo6 = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo7 = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();
		projectInfo2 = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, "status", "2");
		projectInfo4 = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, "status", "4");
		projectInfo5 = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, "status", "5");
		projectInfo6 = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, "status", "6");
		projectInfo7 = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, "status", "7");
		
		for(int i=0;i<projectInfo4.size();i++){
			projectInfo2.add(projectInfo4.get(i));
		}
		for(int i=0;i<projectInfo5.size();i++){
			projectInfo2.add(projectInfo5.get(i));
		}
		for(int i=0;i<projectInfo6.size();i++){
			projectInfo2.add(projectInfo6.get(i));
		}
		for(int i=0;i<projectInfo7.size();i++){
			projectInfo2.add(projectInfo7.get(i));
		}
		projectInfo.clear();
		projectInfo = projectInfo2;
		
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				projectInfo = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				projectInfo = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				projectInfo = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				projectInfo = humanitiesProjectService.SearchHumanitiesProjectInfoByStringFactor(projectInfo, stringName4, stringValue4);
			}
		}
		
		if(floatName1==null||floatName1.equals("请选择")){
		}else{
			if(minFloatValue1==0&&maxFloatValue1==0){
			}else{
				projectInfo = humanitiesProjectService.SearchHumanitiesProjectInfoByNumFactor(projectInfo, floatName1, minFloatValue1, maxFloatValue1);
			}
		}
		
		if(dateName==null||dateName.equals("请选择")){
		}else{
			Date beginTime = new Date();
			Date endTime = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if(begin==null||begin.equals("")){
				try {
					beginTime = dateFormat.parse("1950-01-01");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				try {
					beginTime = dateFormat.parse(begin);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(end==null||end.equals("")){				
			}else{
				try {
					endTime = dateFormat.parse(end);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			projectInfo = humanitiesProjectService.SearchHumanitiesProjectInfoByDateFactor(projectInfo, dateName, beginTime, endTime);
		}
		
		ActionContext.getContext().put("projectInfo", projectInfo);
		type="search";

		if(stringName1!=null){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<projectInfo.size();i++){
			builder.append(projectInfo.get(i).getProject().getProjectId())
			.append(":{projectId:\"").append(projectInfo.get(i).getProject().getProjectId())
			.append("\",projectName:\"").append(projectInfo.get(i).getProject().getProjectName())
			.append("\",projectNumber:\"").append(projectInfo.get(i).getProject().getProjectNumber())
			.append("\",projectOrigin:\"").append(projectInfo.get(i).getProject().getProjectOrigin())
			.append("\",timeApproved:\"").append(projectInfo.get(i).getProject().getTimeApproved())
			.append("\",submitUser:\"").append(projectInfo.get(i).getProject().getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(projectInfo.get(i).getProject().getApprovedUser().getUserName())
			.append("\",status:\"").append(projectInfo.get(i).getProject().getStatus())
			.append("\"}");
			if(i+1<projectInfo.size()){
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

	public void setHumanitiesProjectService(
			HumanitiesProjectService humanitiesProjectService) {
		this.humanitiesProjectService = humanitiesProjectService;
	}

	public void setProjectInfo(
			List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo) {
		this.projectInfo = projectInfo;
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

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public void setEnd(String end) {
		this.end = end;
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
