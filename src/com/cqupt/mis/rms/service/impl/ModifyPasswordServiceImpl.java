/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/

package com.cqupt.mis.rms.service.impl;

import com.cqupt.mis.rms.manager.ModifyPasswordDao;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.service.ModifyPasswordService;
import com.cqupt.mis.rms.utils.EncryptUtils;

/**
*<p>Title:管理用户修改密码的服务层实现类</p>
*<p>Description: 处理用户修改密码的业务逻辑</p>
*@author LvHai
*@version 1.0
*/
public class ModifyPasswordServiceImpl implements ModifyPasswordService {
	//注入管理用户修改密码的接口
	private ModifyPasswordDao modifyPasswordDao;
	
	public void setModifyPasswordDao(ModifyPasswordDao modifyPasswordDao) {
		this.modifyPasswordDao = modifyPasswordDao;
	}

	@Override
	public boolean updateUserPassword(String userId, String oldPassword,
			String newPassword) {
		oldPassword = EncryptUtils.setUPassEncrypt(oldPassword);
		newPassword = EncryptUtils.setUPassEncrypt(newPassword);
		try {
			UserLogin userLogin = modifyPasswordDao.findUserAndPassword(userId, oldPassword);
			if(userLogin != null){
				userLogin.setUserId(userId);
				userLogin.setUserPwd(newPassword);
				modifyPasswordDao.updateUserLoginInfo(userLogin);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
