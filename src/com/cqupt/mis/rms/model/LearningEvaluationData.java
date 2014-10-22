package com.cqupt.mis.rms.model;

import java.io.Serializable;

/**
 * 可动态添加数据库字段的类
 * 学评教的字段值类
 * @author Bern
 * 2014.10.21
 */
public class LearningEvaluationData implements Serializable {
	private LearningEvaluationRecord record;		//记录
	private LearningEvaluationField field;		//字段
	private String value;		//字段的值
	
	public LearningEvaluationRecord getRecord() {
		return record;
	}
	public void setRecord(LearningEvaluationRecord record) {
		this.record = record;
	}
	public LearningEvaluationField getField() {
		return field;
	}
	public void setField(LearningEvaluationField field) {
		this.field = field;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((field == null) ? 0 : field.hashCode());
		return result;
	}
	
	/*
	 * 重写equals方法，判断相等的条件为：若field的id相同，则视为相等
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(getClass() != obj.getClass())
			return false;
		LearningEvaluationData other = (LearningEvaluationData) obj;
		if(this.field == null)
			return false;
		if(other.field == null)
			return false;
		if(this.field.getId() == other.field.getId()) {
			return true;
		} else {
			return false;
		}
		
	}
}
