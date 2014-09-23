package com.cqupt.mis.rms.action.system.user;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.model.DynamicField;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.opensymphony.xwork2.ActionSupport;

public class DynamicDataFieldManagerAction extends ActionSupport {
	//注入动态数据库字段Dao接口
	private DynamicDataFieldDao dynamicDataFieldDao;
	
	private int classNum;
	private String fieldName;
	private String fieldDes;
	
	//添加字段
	public String addField() {
		boolean result = false;		
		Object obj = getInitedObject();
		if(obj == null) {
			return "error";
		}
		result = dynamicDataFieldDao.addField(obj);
		
		if(result) {
			return SUCCESS;
		} else {
			return "error";
		}
	}
	
	//删除字段
	public String delete() {
		//TODO
		return "";
	}
	
	//修改字段
	public String modify() {
		return "";
	}
	
	//根据classNum初始化一个相应类型的对象
	private Object getInitedObject() {
		if(classNum == 1) {
			return null;	
		} else if (classNum == 2) {
			return null;
		} else if (classNum == 3) {
			return null;
		} else if(classNum == 4) {
			
			return null;
		} else if(classNum == 5) {
			DynamicField dynamicField = new StudentAwardsField();
//			StudentAwardsField stuaAwardsField = new StudentAwardsField();
//			stuaAwardsField.setName(fieldName);
//			stuaAwardsField.setDescription(fieldDes);
//			stuaAwardsField.setIsDelete(0);
			dynamicField.setName(fieldName);
			dynamicField.setDescription(fieldDes);
			dynamicField.setIsDelete(0);
			return dynamicField;
		}
		return null;
	}
	
	
	private String getClassName() {
		
		return "";
				
	}
	
	public DynamicDataFieldDao getDynamicDataFieldDao() {
		return dynamicDataFieldDao;
	}
	public void setDynamicDataFieldDao(DynamicDataFieldDao dynamicDataFieldDao) {
		this.dynamicDataFieldDao = dynamicDataFieldDao;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldDes() {
		return fieldDes;
	}
	public void setFieldDes(String fieldDes) {
		this.fieldDes = fieldDes;
	}

}
