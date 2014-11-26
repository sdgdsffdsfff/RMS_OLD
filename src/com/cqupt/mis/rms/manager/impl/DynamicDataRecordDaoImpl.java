package com.cqupt.mis.rms.manager.impl;

import java.io.File;
import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.manager.DynamicDataRecordDao;
import com.cqupt.mis.rms.model.Proofs;

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
	public boolean updateRecord(Object obj) {
		boolean result = false;
		try {
			this.getHibernateTemplate().update(obj);
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public <T> List<T> findAllRecords(String className) {
		// TODO 暂不可用，有问题
		try {
			String hql = "select distinct record from "+className+" record join record.fields data where data.field.isDelete=0";
			return getSession().createQuery(hql).list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object findRecordByClassNameAndId(String className, String recordId) {
		Object obj = null;
		try {
			String hql = "from "+className+" record where record.id = ?";
			obj = getSession().createQuery(hql).setParameter(0, recordId).uniqueResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public int findStatusByRecordId(String recordId, String modelName) {
		int status = -1;
		try {
			String hql = "select record.status from "+modelName+" record where record.id = ?";
			status = (Integer) getSession().createQuery(hql).setParameter(0, recordId).uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Proofs> findProofByRecordId(String recordId) {
		List<Proofs> proofs = null;
		try {
			String hql = "from Proofs proofs where proofs.infoApprovedId = ?";
			proofs = this.getSession().createQuery(hql).setParameter(0, recordId).list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return proofs;
	}

	@Override
	public boolean deleteProofByRecordId(String recordId) {
		int result = -1;
		try {
			String hql = "delete from Proofs proofs where proofs.infoApprovedId = ?";
			result = this.getSession().createQuery(hql).setParameter(0, recordId).executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteFile(String fileName, String filePath) {
		String path = filePath + "\\" + fileName;
		File file = new File(path);
		if(file.isFile() && file.exists()){
			file.delete();
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteInfoByRecordId(String recordId, String modelName) {
		int result = -1;
		try {
			String hql = "delete from "+modelName+" record where record.id = ?";
			result = this.getSession().createQuery(hql).setParameter(0, recordId).executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteFieldDataByRecordId(String recordId, String modelName, String modelFactor) {
		int result = -1;
		try {
			String hql = "delete from "+modelName+" data where data."+modelFactor+".id = ?";
			result = this.getSession().createQuery(hql).setParameter(0, recordId).executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteMemberInfoByRecordId(String recordId,
			String memberModelName, String memberFactor) {
		
		int result = -1;
		try {
			String hql = "delete from "+memberModelName+" modelName where modelName."+memberFactor+".id = ?";
			result = getSession().createQuery(hql).setParameter(0, recordId).executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
