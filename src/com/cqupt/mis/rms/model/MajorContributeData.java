package com.cqupt.mis.rms.model;

import java.io.Serializable;

/*
 * 可动态添加数据库字段的类
 * 字段值类
 * @author fengdi
 * 2014.10.7
 */
public class MajorContributeData implements Serializable {
	private MajorContributeRecord record;		//记录
	private MajorContributeField field;		//字段
	private String value;		//字段的值
	
	
	public MajorContributeRecord getRecord() {
		return record;
	}
	public void setRecord(MajorContributeRecord record) {
		this.record = record;
	}
	public MajorContributeField getField() {
		return field;
	}
	public void setField(MajorContributeField field) {
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
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		return result;
	}
	
	/*
	 * 重写equals方法，判断相等的条件为：若field的id相同，则视为相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MajorContributeData other = (MajorContributeData) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (field.getId() != other.getField().getId())
			return false;
		return true;
	}
	
	
}
