package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceTechAttendPerson;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.service.ScienceTechExchangeService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;

public class SearchCollegeScienceTechExchangeAction {
	private SearchCQUPTUserService searchCQUPTUserService;
	private ScienceTechExchangeService scienceTechExchangeService;
	private List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchange;
	
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
	
	private String floatName2;
	private float minFloatValue2;
	private float maxFloatValue2;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void getAllScienceTechExchange(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.scienceTechExchange = scienceTechExchangeService.findAllScienceTechExchange(cquptUsers);
	}
	
	public String execute(){
		this.getAllScienceTechExchange();
		scienceTechExchange = this.scienceTechExchangeService.searchScienceTechExchangeByStringFactor(scienceTechExchange, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				scienceTechExchange = scienceTechExchangeService.searchScienceTechExchangeByStringFactor(scienceTechExchange, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				scienceTechExchange = scienceTechExchangeService.searchScienceTechExchangeByStringFactor(scienceTechExchange, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				scienceTechExchange = scienceTechExchangeService.searchScienceTechExchangeByStringFactor(scienceTechExchange, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				scienceTechExchange = scienceTechExchangeService.searchScienceTechExchangeByStringFactor(scienceTechExchange, stringName4, stringValue4);
			}
		}
		
		if(floatName1==null||floatName1.equals("请选择")){
		}else{
			if(minFloatValue1==0&&maxFloatValue1==0){
			}else{
				scienceTechExchange = scienceTechExchangeService.searchScienceTechExchangeByNumFactor(scienceTechExchange, floatName1, minFloatValue1, maxFloatValue1);
			}
		}
		if(floatName2==null||floatName2.equals("请选择")){
		}else{
			if(minFloatValue2==0&&maxFloatValue2==0){
			}else{
				scienceTechExchange = scienceTechExchangeService.searchScienceTechExchangeByNumFactor(scienceTechExchange, floatName2, minFloatValue2, maxFloatValue2);
			}
		}
		ActionContext.getContext().put("scienceTechExchange", scienceTechExchange);
		type="search";

		if(stringName1!=null){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<scienceTechExchange.size();i++){
			builder.append(scienceTechExchange.get(i).getModel().getTechExchangeId())
			.append(":{techExchangeId:\"").append(scienceTechExchange.get(i).getModel().getTechExchangeId())
			.append("\",collegesIn:\"").append(scienceTechExchange.get(i).getModel().getCollegesIn())
			.append("\",exchangeType:\"").append(scienceTechExchange.get(i).getModel().getExchangeType())
			.append("\",sendNumber:\"").append(scienceTechExchange.get(i).getModel().getSendNumber())
			.append("\",receiveNumber:\"").append(scienceTechExchange.get(i).getModel().getReceiveNumber())
			.append("\",attendNumber:\"").append(scienceTechExchange.get(i).getModel().getAttendNumber())
			.append("\",papersNumber:\"").append(scienceTechExchange.get(i).getModel().getPapersNumber())
			.append("\",specialInvitedNumber:\"").append(scienceTechExchange.get(i).getModel().getSpecialInvitedNumber())
			.append("\",exchangeHost:\"").append(scienceTechExchange.get(i).getModel().getExchangeHost())
			.append("\",submitUser:\"").append(scienceTechExchange.get(i).getModel().getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(scienceTechExchange.get(i).getModel().getApprovedUser().getUserName())
			.append("\",status:\"").append(scienceTechExchange.get(i).getModel().getStatus())
			.append("\"}");
			if(i+1<scienceTechExchange.size()){
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

	public void setScienceTechExchangeService(
			ScienceTechExchangeService scienceTechExchangeService) {
		this.scienceTechExchangeService = scienceTechExchangeService;
	}

	public void setScienceTechExchange(
			List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchange) {
		this.scienceTechExchange = scienceTechExchange;
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
