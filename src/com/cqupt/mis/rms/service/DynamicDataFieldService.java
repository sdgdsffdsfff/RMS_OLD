package com.cqupt.mis.rms.service;

import java.util.List;

public interface DynamicDataFieldService {
	//添加字段
	public boolean addField(Object obj);
	
	//删除字段
	public boolean deleteField(Object obj);
	
	//修改字段
	public boolean updateField(Object obj);
	
	//查找所有字段
	public List<Object> findAllFields(String className);
}
