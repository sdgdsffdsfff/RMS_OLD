package com.cqupt.mis.rms.model;

import java.io.Serializable;

public class TeachersAwardsData implements Serializable {
	

	private TeachersAwardsRecord awards;		//记录
	private TeachersAwardsField field;		//字段
	private String value;		//字段的值

	public TeachersAwardsRecord getAwards() {
		return awards;
	}
	public void setAwards(TeachersAwardsRecord awards) {
		this.awards = awards;
	}
	public TeachersAwardsField getField() {
		return field;
	}
	public void setField(TeachersAwardsField field) {
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
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		TeachersAwardsData other = (TeachersAwardsData) obj;
		if (this.field == null)
			return false;
		if (other.field == null)
			return false;
		if (this.field.getId() == other.field.getId()) {
			return true;
		} else {
			return false;
		}

	}
}
	