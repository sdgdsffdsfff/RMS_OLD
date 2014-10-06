package com.cqupt.mis.rms.action.system.user;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.DynamicDataFieldUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理删除动态字段的Action
 * @author Bern
 *
 */
public class DeleteDynamicDataFieldAction extends ActionSupport {
	//注入动态数据库字段Dao接口
	private DynamicDataFieldDao dynamicDataFieldDao;
			
	private int classNum;
	private int fieldId;
	
	/**
	 * 删除字段（假删除，仅仅将isDelete字段值改为1）
	 */
	public String execute() {
		boolean result = false;
		String className = DynamicDataFieldUtils.getClassNameByClassNum(classNum);
		if(className == null) {
			return "error";
		}
		result = dynamicDataFieldDao.deleteField(className, fieldId);
		Confirm confirm = new Confirm();
		if(result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("删除字段成功");
			confirm.setUrl("findDynamicDataField.action?classNum="+classNum);
			confirm.setRetName("动态字段管理页面");
			ActionContext.getContext().put("confirm", confirm);
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("删除字段失败");
			confirm.setUrl("findDynamicDataField.action?classNum="+classNum);
			confirm.setRetName("动态字段管理页面");
			ActionContext.getContext().put("confirm", confirm);
		}
		return SUCCESS;
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

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	
}
