package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.manager.DynamicDataRecordDao;

public class DynamicDataRecordDaoImpl extends BaseHibernateDaoSupport implements DynamicDataRecordDao {

	@Override
	public boolean addRecord(Object obj) {
		boolean result = false;
		try {
			this.getHibernateTemplate().save(obj);
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteRecord(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecord(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> findAllRecords(String className) {
		// TODO Auto-generated method stub
		return null;
	}


}
