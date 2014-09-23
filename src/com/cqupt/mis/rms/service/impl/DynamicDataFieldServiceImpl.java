package com.cqupt.mis.rms.service.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.service.DynamicDataFieldService;

public class DynamicDataFieldServiceImpl implements DynamicDataFieldService {
	//注入数据访问层接口
	DynamicDataFieldDao dynamicDataFieldDao;
	
	@Override
	public boolean addField(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteField(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateField(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> findAllFields(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	public DynamicDataFieldDao getDynamicDataFieldDao() {
		return dynamicDataFieldDao;
	}

	public void setDynamicDataFieldDao(DynamicDataFieldDao dynamicDataFieldDao) {
		this.dynamicDataFieldDao = dynamicDataFieldDao;
	}
	
	

}
