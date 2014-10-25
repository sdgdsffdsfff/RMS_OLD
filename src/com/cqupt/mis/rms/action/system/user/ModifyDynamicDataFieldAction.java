package com.cqupt.mis.rms.action.system.user;

import sun.awt.image.PixelConverter.Bgrx;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.model.EducationalReformField;
import com.cqupt.mis.rms.model.ExcellentTrainerField;
import com.cqupt.mis.rms.model.LearningEvaluationField;
import com.cqupt.mis.rms.model.MajorContributeField;
import com.cqupt.mis.rms.model.OtherTeachingAwardsField;
import com.cqupt.mis.rms.model.QualityProjectField;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.cqupt.mis.rms.model.TeachersAwardsField;
import com.cqupt.mis.rms.model.TeachingMaterialField;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.DynamicDataFieldUtils;
import com.opensymphony.xwork2.Action;
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
	private int oldOrder;
	private int newOrder;
	
	/**
	 * 根据类名和字段id查找相应的字段
	 */
	public String findFieldByClassNameAndId() {
		String className = DynamicDataFieldUtils.getClassNameByClassNum(classNum);
		String infoName = DynamicDataFieldUtils.getInfoNameByClassNum(classNum);
		if(className == null) {
			return "error";
		}
		int count = dynamicDataFieldDao.countField(className);
		Object obj = dynamicDataFieldDao.findFieldByClassNameAndId(className, fieldId);
		if(obj == null) {
			return "error";
		}
		ActionContext.getContext().put("field", obj);
		ActionContext.getContext().put("classNum", classNum);
		ActionContext.getContext().put("infoName", infoName);
		ActionContext.getContext().put("count", count);
		return SUCCESS;
	}
	
	/**
	 * 修改字段
	 */
	public String modify() {
		boolean result = false;
		String className = DynamicDataFieldUtils.getClassNameByClassNum(classNum);
		if(oldOrder > newOrder) {
			dynamicDataFieldDao.updateOrder(className, newOrder, oldOrder, true);
		} else if(oldOrder < newOrder) {
			dynamicDataFieldDao.updateOrder(className, oldOrder, newOrder, false);
		}
		
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
		if(classNum == 1) {		//专业建设/教改项目信息的动态字段类
			MajorContributeField majorContributeField = new MajorContributeField();
			majorContributeField.setId(fieldId);
			majorContributeField.setName(fieldName);
			majorContributeField.setDescription(fieldDes);
			majorContributeField.setOrder(newOrder);
			majorContributeField.setIsDelete(0);
			return majorContributeField;
		} else if (classNum == 2) {		//优秀培训师信息的动态字段类
			ExcellentTrainerField excellentTrainerField = new ExcellentTrainerField();
			excellentTrainerField.setId(fieldId);
			excellentTrainerField.setName(fieldName);
			excellentTrainerField.setDescription(fieldDes);
			excellentTrainerField.setOrder(newOrder);
			excellentTrainerField.setIsDelete(0);
			return excellentTrainerField;
		} else if (classNum == 3) {		//教学成果奖信息的动态字段类
			TeachersAwardsField teachersAwardsField = new TeachersAwardsField();
			teachersAwardsField.setId(fieldId);
			teachersAwardsField.setName(fieldName);
			teachersAwardsField.setDescription(fieldDes);
			teachersAwardsField.setOrder(newOrder);
			teachersAwardsField.setIsDelete(0);
			return teachersAwardsField;
		} else if(classNum == 4) {		//教材立项信息的动态字段类
			TeachingMaterialField teachingMaterialField = new TeachingMaterialField();
			teachingMaterialField.setId(fieldId);
			teachingMaterialField.setName(fieldName);
			teachingMaterialField.setDescription(fieldDes);
			teachingMaterialField.setOrder(newOrder);
			teachingMaterialField.setIsDelete(0);
			return teachingMaterialField;
		} else if(classNum == 5) {		//学生获奖信息的动态字段类
			StudentAwardsField studentAwardsField = new StudentAwardsField();
			studentAwardsField.setId(fieldId);
			studentAwardsField.setName(fieldName);
			studentAwardsField.setDescription(fieldDes);
			studentAwardsField.setOrder(newOrder);
			studentAwardsField.setIsDelete(0);
			return studentAwardsField;
		} else if(classNum == 6) {		//质量工程的动态字段类
			QualityProjectField qualityProjectField = new QualityProjectField();
			qualityProjectField.setId(fieldId);
			qualityProjectField.setName(fieldName);
			qualityProjectField.setDescription(fieldDes);
			qualityProjectField.setOrder(newOrder);
			qualityProjectField.setIsDelete(0);
			return qualityProjectField;
		} else if(classNum == 7) {		//学评教的动态字段类
			LearningEvaluationField learningEvaluationField = new LearningEvaluationField();
			learningEvaluationField.setId(fieldId);
			learningEvaluationField.setName(fieldName);
			learningEvaluationField.setDescription(fieldDes);
			learningEvaluationField.setOrder(newOrder);
			learningEvaluationField.setIsDelete(0);
			return learningEvaluationField;
		} else if(classNum == 8) {		//教改结题信息的动态字段类
			EducationalReformField educationalReformField = new EducationalReformField();
			educationalReformField.setId(fieldId);
			educationalReformField.setName(fieldName);
			educationalReformField.setDescription(fieldDes);
			educationalReformField.setOrder(newOrder);
			educationalReformField.setIsDelete(0);
			return educationalReformField;
		} else if(classNum == 9) {		//其他教学奖励信息的动态字段类
			OtherTeachingAwardsField otherTeachingAwardsField = new OtherTeachingAwardsField();
			otherTeachingAwardsField.setId(fieldId);
			otherTeachingAwardsField.setName(fieldName);
			otherTeachingAwardsField.setDescription(fieldDes);
			otherTeachingAwardsField.setOrder(newOrder);
			otherTeachingAwardsField.setIsDelete(0);
			return otherTeachingAwardsField;
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

	public int getOldOrder() {
		return oldOrder;
	}

	public void setOldOrder(int oldOrder) {
		this.oldOrder = oldOrder;
	}

	public int getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(int newOrder) {
		this.newOrder = newOrder;
	}

}
