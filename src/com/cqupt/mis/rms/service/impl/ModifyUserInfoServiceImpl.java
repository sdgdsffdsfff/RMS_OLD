package com.cqupt.mis.rms.service.impl;

import com.cqupt.mis.rms.manager.ModifyUserInfoDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.service.ModifyUserInfoService;

public class ModifyUserInfoServiceImpl implements ModifyUserInfoService {
	//注入底层接口
	private ModifyUserInfoDao modifyUserInfoDao;
	
	public void setModifyUserInfoDao(ModifyUserInfoDao modifyUserInfoDao) {
		this.modifyUserInfoDao = modifyUserInfoDao;
	}


	@Override
	public boolean modifyUserInfo(CQUPTUser cquptUser) {
		// TODO Auto-generated method stub
		try {
			if(cquptUser != null){
				modifyUserInfoDao.updateUserInfo(cquptUser);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}


	@Override
	public CQUPTUser findUserInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		return modifyUserInfoDao.findUserInfoByUserId(userId);
	}


	@Override
	public boolean updateTitlesOrPositions(Object object) {
		// TODO Auto-generated method stub
		try {
			if(object != null){
				modifyUserInfoDao.addTitlesOrPositions(object);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
