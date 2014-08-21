package com.cqupt.mis.rms.test.lvhai;


import com.cqupt.mis.rms.manager.ModifyPasswordDao;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.utils.AbstractTest;

public class ModifyPasswordDaoImplTest extends AbstractTest {
	private ModifyPasswordDao modifyPasswordDao;


	public void setModifyPasswordDao(ModifyPasswordDao modifyPasswordDao) {
		this.modifyPasswordDao = modifyPasswordDao;
	}

	@Override
	public void init() {
		modifyPasswordDao = (ModifyPasswordDao)this.configYourManager("modifyPasswordDao");
	}

	public void testFindUserAndPassword(){
		this.init();
		try {
			UserLogin u = modifyPasswordDao.findUserAndPassword("654321", "76A68763D367BAFD");
			if(u != null){
				System.out.println(u.getUserId());
				System.out.println(u.getUserPwd());
			}
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUpdateUserLoginInfo(){
		this.init();
		try {
			UserLogin userLogin = new UserLogin();
			userLogin.setUserId("654321");
			userLogin.setUserPwd("76A68763D367BAFD");
			modifyPasswordDao.updateUserLoginInfo(userLogin);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		ModifyPasswordDaoImplTest m = new ModifyPasswordDaoImplTest();
		m.testFindUserAndPassword();
		m.testUpdateUserLoginInfo();
	}
}
