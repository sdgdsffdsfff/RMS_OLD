package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.GetInfoToExcelDao;
import com.cqupt.mis.rms.utils.TypeConvert;

public class GetInfoToExcelDaoImpl extends BaseHibernateDaoSupport implements GetInfoToExcelDao{

	@Override
	public List<Object> getInfo(String modelName) {
		// TODO Auto-generated method stub
		String hql = "from "+modelName+" model";
		@SuppressWarnings("unchecked")
		List<Object> lists = getSession().createQuery(hql).list();
		return lists;
	}

	@Override
	public List<Object> getInfoByFactor(String modelName, String factorName,
			String factorValue) {
		// TODO Auto-generated method stub
		String hql ="";
		if(factorName.equals("status")){
			int factorValueInt = Integer.parseInt(factorValue);
			hql	= "from "+modelName+" model where model."+factorName+" ="+factorValueInt+"";
		}
		else{
			hql = "from "+modelName+" model where model."+factorName+" ='"+factorValue+"'";
		}

		@SuppressWarnings("unchecked")
		
		List<Object> lists = getSession().createQuery(hql).list();
		return lists;
	}

	@Override
	public Object getUserInfoByFactor(String modelName,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		
		String hql = "from "+modelName+" model where model.courseContribute."+factorName+" ='"+factorValue+"'";

		
		Object userInfo = (Object) getSession().createQuery(hql).setParameter(0, factorValue).uniqueResult();
		return userInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getInfoByFactors(String modelName, String factorName,
			String factorValues) {
		// TODO Auto-generated method stub
		
		String[] factor = TypeConvert.StringToStringArrayByComma(factorValues);
		String Values = TypeConvert.objectArrayStringToString(factor);
		String hql = "from "+modelName+" model where model."+factorName+" in("+Values+")";
		List<Object> lists = getSession().createQuery(hql).list();		
	
		return lists;
	}

	
}
