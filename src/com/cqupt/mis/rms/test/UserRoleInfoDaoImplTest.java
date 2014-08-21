package com.cqupt.mis.rms.test;

import com.cqupt.mis.rms.manager.UserRoleInfoDao;
import com.cqupt.mis.rms.utils.AbstractTest;

public class UserRoleInfoDaoImplTest extends AbstractTest {
	private UserRoleInfoDao userRoleInfoDao;
	
	@Override
	public void init() {
		userRoleInfoDao = (UserRoleInfoDao)this.configYourManager("userRoleInfoDao");
	}

	public void testAddUserRoleInfo() {
		init();
		try {
			int[] RoleIdArr = {1,2,3};
			userRoleInfoDao.addUserRoleInfo("wangmin", RoleIdArr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeleteUserRoleInfoByUserId() {
		init();
		try {
			userRoleInfoDao.deleteUserRoleInfoByUserId("ty");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeleteUserRoleInfoByRoleId() {
		init();
		try {
			userRoleInfoDao.deleteUserRoleInfoByRoleId(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
