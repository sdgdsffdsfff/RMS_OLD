package com.cqupt.mis.rms.action.system.user;

import java.util.List;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 处理查找动态字段类的Action
 * @author Bern
 */
public class FindDynamicDataFieldAction extends ActionSupport {
	//注入动态数据库字段Dao接口	
	private SearchDao searchDao;
	
	private int classNum;
	
	/*
	 * 查找所有未删除的字段
	 */
	public String execute() {
		String className = getClassName();
		if(className == null) {
			return "error";
		}
		List<Object> fields = searchDao.SearchObjectsByFactor(className, "isDelete", 0);		
		ActionContext.getContext().put("allFields", fields);
		return SUCCESS;
	}
	
	/*
	 * 根据classNum获取相应类名
	 */
	private String getClassName() {
		String className = null;
		if(classNum == 1) {
			className = "";
		} else if (classNum == 2) {
			className = "";
		} else if (classNum == 3) {
			className = "";
		} else if(classNum == 4) {
			className = "";
		} else if(classNum == 5) {		//学生获奖信息的字段类
			className = "com.cqupt.mis.rms.model.StudentAwardsField";
		}
		return className;		
	}
	
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public SearchDao getSearchDao() {
		return searchDao;
	}
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
}
