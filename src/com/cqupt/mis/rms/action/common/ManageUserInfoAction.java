/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.common;


import java.util.List;

import com.cqupt.mis.rms.manager.ModifyUserInfoDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.Positions;
import com.cqupt.mis.rms.model.Titles;
import com.cqupt.mis.rms.service.ModifyUserInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:管理用户信息Action</p>
*<p>Description:根据用户Id取得用户的个人信息</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ManageUserInfoAction extends ActionSupport {
	//注入接口
	private ModifyUserInfoService modifyUserInfoService;
	private ModifyUserInfoDao modifyUserInfoDao;
	
	private CQUPTUser cquptUser;
	private Titles titles;
	private Positions positions;
	
	private String timeTitlesBegin;
	private String timeTitlesEnd;
	private String titlesName;
	
	private String timePositionBegin;
	private String timePositionEnd;
	private String positionName;
	
	
	public CQUPTUser getCquptUser() {
		return cquptUser;
	}

	public void setCquptUser(CQUPTUser cquptUser) {
		this.cquptUser = cquptUser;
	}
	
	public void setModifyUserInfoService(ModifyUserInfoService modifyUserInfoService) {
		this.modifyUserInfoService = modifyUserInfoService;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

	public void setPositions(Positions positions) {
		this.positions = positions;
	}
	
	public void setModifyUserInfoDao(ModifyUserInfoDao modifyUserInfoDao) {
		this.modifyUserInfoDao = modifyUserInfoDao;
	}

	public String execute() throws Exception {
		//取得存放在session中的userId
		try {
			String userId = (String)ActionContext.getContext().getSession().get("userId");
			cquptUser = modifyUserInfoService.findUserInfoByUserId(userId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String manageTitles() {
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		CQUPTUser user = new CQUPTUser();
		user.setUserId(userId);
		titles.setUser(user);
		titles.setTitlesName(titlesName);
		titles.setTimeTitlesBegin(TypeConvert.stringOrNullToDate(timeTitlesBegin));
		titles.setTimeTitlesEnd(TypeConvert.stringOrNullToDate(timeTitlesEnd));
		boolean result = modifyUserInfoService.updateTitlesOrPositions(titles);
		Confirm confirm = new Confirm();
		if(result){
			confirm.setIsSuccess("right");
			confirm.setMessage("个人职称信息添加成功");
			confirm.setUrl("viewTitles.action");
			confirm.setRetName("个人职称信息管理页面");
		}else{
			confirm.setIsSuccess("error");
			confirm.setMessage("个人职称信息添加失败");
			confirm.setUrl("viewTitles.action");
			confirm.setRetName("个人职称信息管理页面");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}
	
	public String managePositions() {
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		CQUPTUser user = new CQUPTUser();
		user.setUserId(userId);
		positions.setUser(user);
		positions.setPositionName(positionName);
		positions.setTimePositionBegin(TypeConvert.stringOrNullToDate(timePositionBegin));
		positions.setTimePositionEnd(TypeConvert.stringOrNullToDate(timePositionEnd));
		boolean result = modifyUserInfoService.updateTitlesOrPositions(positions);
		Confirm confirm = new Confirm();
		if(result){
			confirm.setIsSuccess("right");
			confirm.setMessage("个人职务信息添加成功");
			confirm.setUrl("viewPositions.action");
			confirm.setRetName("个人职务信息管理页面");
		}else{
			confirm.setIsSuccess("error");
			confirm.setMessage("个人职务信息添加失败");
			confirm.setUrl("viewPositions.action");
			confirm.setRetName("个人职务信息管理页面");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}

	public String viewTitles(){
		try {
			String userId = (String)ActionContext.getContext().getSession().get("userId");
			List<Titles> titlesList = modifyUserInfoDao.findTitlesByUserId(userId);
			ActionContext.getContext().put("titlesList", titlesList);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String viewPositions(){
		try {
			String userId = (String)ActionContext.getContext().getSession().get("userId");
			List<Positions> positionsList = modifyUserInfoDao.findPositionsByUserId(userId);
			ActionContext.getContext().put("positionsList", positionsList);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public void setTimeTitlesBegin(String timeTitlesBegin) {
		this.timeTitlesBegin = timeTitlesBegin;
	}

	public void setTimeTitlesEnd(String timeTitlesEnd) {
		this.timeTitlesEnd = timeTitlesEnd;
	}

	public void setTimePositionBegin(String timePositionBegin) {
		this.timePositionBegin = timePositionBegin;
	}

	public void setTimePositionEnd(String timePositionEnd) {
		this.timePositionEnd = timePositionEnd;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public void setTitlesName(String titlesName) {
		this.titlesName = titlesName;
	}
	


}
