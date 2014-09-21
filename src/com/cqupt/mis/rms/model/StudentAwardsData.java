package com.cqupt.mis.rms.model;

import java.io.Serializable;

/*
 * 可动态添加数据库字段的类
 * 字段值类
 * @author fengdi
 * 2014.9.20
 */

public class StudentAwardsData implements Serializable {
	private StudentAwardsRecord awards;		//记录
	private StudentAwardsField field;		//字段
	private String value;		//字段的值
	
	
	public StudentAwardsRecord getAwards() {
		return awards;
	}
	public void setAwards(StudentAwardsRecord awards) {
		this.awards = awards;
	}
	public StudentAwardsField getField() {
		return field;
	}
	public void setField(StudentAwardsField field) {
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
		StudentAwardsData other = (StudentAwardsData) obj;
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
