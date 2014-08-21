package com.cqupt.mis.rms.test.lvhai;


import com.cqupt.mis.rms.manager.ModifyUserInfoDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.utils.AbstractTest;

public class ModifyUserInfoDaoImplTest extends AbstractTest {
	private ModifyUserInfoDao modifyUserInfoDao;

	public void setModifyUserInfoDao(ModifyUserInfoDao modifyUserInfoDao) {
		this.modifyUserInfoDao = modifyUserInfoDao;
	}

	@Override
	public void init() {
		modifyUserInfoDao = (ModifyUserInfoDao)this.configYourManager("modifyUserInfoDao");
	}

	public void testFindUserInfoByUserId(){
		this.init();
		try {
			CQUPTUser u = modifyUserInfoDao.findUserInfoByUserId("123456");
			System.out.println(u.getDepartment());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUpdateUserInfo(){
		this.init();
		try {
			CQUPTUser u = modifyUserInfoDao.findUserInfoByUserId("123456");
			u.setLastAcademic("测试");
			modifyUserInfoDao.updateUserInfo(u);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		ModifyUserInfoDaoImplTest m = new ModifyUserInfoDaoImplTest();
		//m.testFindUserInfoByUserId();
		m.testUpdateUserInfo();
	}
}
