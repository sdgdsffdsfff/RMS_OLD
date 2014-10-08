package com.cqupt.mis.rms.action.teacher;

import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.service.DynamicDataFieldService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户录入动态字段类信息之前的Action</p>
*<p>Description:接收输入请求，取出动态的数据库字段，返回后展示在输入页面</p>
*@author Bern
*@version 2.0
**/
public class InputDynamicDataRecordAction extends ActionSupport {
	//注入服务层接口
	private SearchDao searchDao;
	
	/**
	 * 录入学生获奖信息前的加载 
	 */
	public String inputStudentAwardsRecord() {
		List<Object> fields = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.StudentAwardsField", "isDelete", 0);		
		ActionContext.getContext().put("allFields", fields);
		return SUCCESS;
	}
	
	/**
	 * 录入教学成果奖前的加载
	 */
	public String inputTeacherAwardsRecord() {
		List<Object> fields = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.TeachersAwardsField", "isDelete", 0);		
		ActionContext.getContext().put("allFields", fields);
		return SUCCESS;
	}
	
	/**
	 * 录入专业建设信息前的加载 
	 */
	public String inputMajorContributeRecord() {
		List<Object> fields = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.MajorContributeField", "isDelete", 0);		
		ActionContext.getContext().put("allFields", fields);
		return SUCCESS;
	}
	
	/**
	 * 录入教材立项信息前的加载 
	 */
	public String inputTeachingMaterialRecord() {
		List<Object> fields = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.TeachingMaterialField", "isDelete", 0);		
		ActionContext.getContext().put("allFields", fields);
		return SUCCESS;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

}