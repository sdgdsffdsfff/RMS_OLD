package com.cqupt.mis.rms.action.system.user;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.DynamicDataFieldUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理修改动态字段的Action
 * @author Bern
 *
 */
public class ModifyDynamicDataFieldAction extends ActionSupport {
	//注入服务层接口
	private DynamicDataFieldDao dynamicDataFieldDao;
	
	private int fieldId;
	private int classNum;
	private String fieldName;
	private String fieldDes;
	
	/**
	 * 根据类名和字段id查找相应的字段
	 */
	public String findFieldByClassNameAndId() {
		String className = DynamicDataFieldUtils.getClassNameByClassNum(classNum);
		String infoName = DynamicDataFieldUtils.getInfoNameByClassNum(classNum);
		if(className == null) {
			return "error";
		}
		Object obj = dynamicDataFieldDao.findFieldByClassNameAndId(className, fieldId);
		if(obj == null) {
			return "error";
		}
		ActionContext.getContext().put("field", obj);
		ActionContext.getContext().put("classNum", classNum);
		ActionContext.getContext().put("infoName", infoName);
		return SUCCESS;
	}
	
	/**
	 * 修改字段
	 */
	public String modify() {
		boolean result = false;
		Object obj = getModifyedObject();
		if(obj == null) {
			return "error";
		}
		result = dynamicDataFieldDao.updateField(obj);
		Confirm confirm = new Confirm();
		if(result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("修改字段成功");
			confirm.setUrl("pages/system/managedynamicdatafield.jsp");
			confirm.setRetName("动态字段管理页面");
			ActionContext.getContext().put("confirm", confirm);
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("修改字段失败");
			confirm.setUrl("pages/system/managedynamicdatafield.jsp");
			confirm.setRetName("动态字段管理页面");
			ActionContext.getContext().put("confirm", confirm);
		}
		return SUCCESS;
	}
	
	/**
	 * 根据classNum初始化一个相应类型的对象并将其初始化
	 * 如果增加了一个动态字段表，在此方法中添加if判断，并初始化相应的类
	 */
	private Object getModifyedObject() {
		if(classNum == 1) {
			return null;	
		} else if (classNum == 2) {
			return null;
		} else if (classNum == 3) {
			return null;
		} else if(classNum == 4) {
			return null;
		} else if(classNum == 5) {		//学生获奖信息的动态字段类
			StudentAwardsField studentAwardsField = new StudentAwardsField();
			studentAwardsField.setId(fieldId);
			studentAwardsField.setName(fieldName);
			studentAwardsField.setDescription(fieldDes);
			studentAwardsField.setIsDelete(0);
			return studentAwardsField;
		}
		return null;
	}

	public DynamicDataFieldDao getDynamicDataFieldDao() {
		return dynamicDataFieldDao;
	}

	public void setDynamicDataFieldDao(DynamicDataFieldDao dynamicDataFieldDao) {
		this.dynamicDataFieldDao = dynamicDataFieldDao;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
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
