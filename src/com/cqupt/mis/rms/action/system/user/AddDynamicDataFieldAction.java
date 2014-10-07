package com.cqupt.mis.rms.action.system.user;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.MajorContributeField;
import com.cqupt.mis.rms.model.MajorContributeRecord;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.cqupt.mis.rms.model.TeachingMaterialField;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 处理添加动态字段类的Action
 * @author Bern
 */
public class AddDynamicDataFieldAction extends ActionSupport {
	//注入动态数据库字段Dao接口
	private DynamicDataFieldDao dynamicDataFieldDao;
		
	private SearchDao searchDao;
	
	private int classNum;
	private String fieldName;
	private String fieldDes;
	
	/*
	 * 添加字段
	 */
	public String execute() {
		boolean result;
		Object obj = getInitedObject();
		if(obj == null) {
			return "error";
		}
		result = dynamicDataFieldDao.addField(obj);
		Confirm confirm = new Confirm();
		if(result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("添加字段成功");
			confirm.setUrl("pages/system/managedynamicdatafield.jsp");
			confirm.setRetName("动态字段管理页面");
			ActionContext.getContext().put("confirm", confirm);
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("添加字段失败");
			confirm.setUrl("pages/system/managedynamicdatafield.jsp");
			confirm.setRetName("动态字段管理页面");
			ActionContext.getContext().put("confirm", confirm);
		}
		return SUCCESS;
	}
	
	/*
	 * 根据classNum初始化一个相应类型的对象
	 * 如果增加了一个动态字段表，在此方法中添加if判断，并初始化相应的类
	 */
	private Object getInitedObject() {
		if(classNum == 1) {		//专业建设/教改项目信息
			MajorContributeField majorContributeField = new MajorContributeField();
			majorContributeField.setName(fieldName);
			majorContributeField.setDescription(fieldDes);
			majorContributeField.setIsDelete(0);
			return majorContributeField;
		} else if (classNum == 2) {
			return null;
		} else if (classNum == 3) {
			return null;
		} else if(classNum == 4) {		//教材立项信息
			TeachingMaterialField teachingMaterialField = new TeachingMaterialField();
			teachingMaterialField.setName(fieldName);
			teachingMaterialField.setDescription(fieldDes);
			teachingMaterialField.setIsDelete(0);
			return teachingMaterialField;
		} else if(classNum == 5) {		//学生获奖信息的动态字段类
			StudentAwardsField stuaAwardsField = new StudentAwardsField();
			stuaAwardsField.setName(fieldName);
			stuaAwardsField.setDescription(fieldDes);
			stuaAwardsField.setIsDelete(0);
			return stuaAwardsField;
		}
		return null;
	}

	public DynamicDataFieldDao getDynamicDataFieldDao() {
		return dynamicDataFieldDao;
	}

	public void setDynamicDataFieldDao(DynamicDataFieldDao dynamicDataFieldDao) {
		this.dynamicDataFieldDao = dynamicDataFieldDao;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
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
