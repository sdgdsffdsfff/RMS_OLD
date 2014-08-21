package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.service.ScienceOrganizationService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeScienceOrganizationAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private ScienceOrganizationService scienceOrganizationService;
	private List<ScienceOrganization> scienceOrganizations;
	
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
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void getAllScienceOrganizations(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
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
		type="search";
		
		if(stringName1!=null){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<scienceOrganizations.size();i++){
			builder.append(scienceOrganizations.get(i).getOrganizationId())
			.append(":{organizationId:\"").append(scienceOrganizations.get(i).getOrganizationId())
			.append("\",organizationName:\"").append(scienceOrganizations.get(i).getOrganizationName())
			.append("\",organizationType:\"").append(scienceOrganizations.get(i).getOrganizationType())
			.append("\",organizationCategory:\"").append(scienceOrganizations.get(i).getOrganizationCategory())
			.append("\",sortSubject:\"").append(scienceOrganizations.get(i).getSortSubject())
			.append("\",modusComposition:\"").append(scienceOrganizations.get(i).getModusComposition())
			.append("\",totalEmployees:\"").append(scienceOrganizations.get(i).getTotalEmployees())
			.append("\",doctorEmployees:\"").append(scienceOrganizations.get(i).getDoctorEmployees())
			.append("\",masterEmployees:\"").append(scienceOrganizations.get(i).getMasterEmployees())
			.append("\",internalExpenditures:\"").append(scienceOrganizations.get(i).getInternalExpenditures())
			.append("\",rdExpenditures:\"").append(scienceOrganizations.get(i).getRdExpenditures())
			.append("\",numIssueAssume:\"").append(scienceOrganizations.get(i).getNumIssueAssume())
			.append("\",submitUser:\"").append(scienceOrganizations.get(i).getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(scienceOrganizations.get(i).getApprovedUser().getUserName())
			.append("\",status:\"").append(scienceOrganizations.get(i).getStatus())
			.append("\"}");
			if(i+1<scienceOrganizations.size()){
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

	public void setScienceOrganizationService(
			ScienceOrganizationService scienceOrganizationService) {
		this.scienceOrganizationService = scienceOrganizationService;
	}

	public void setScienceOrganizations(
			List<ScienceOrganization> scienceOrganizations) {
		this.scienceOrganizations = scienceOrganizations;
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
