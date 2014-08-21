package com.cqupt.mis.rms.test.lvhai;


import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.service.ModifyUserInfoService;
import com.cqupt.mis.rms.utils.AbstractTest;

public class ModifyUserInfoServiceImplTest extends AbstractTest {
	private ModifyUserInfoService modifyUserInfoService;


	public void setModifyUserInfoService(ModifyUserInfoService modifyUserInfoService) {
		this.modifyUserInfoService = modifyUserInfoService;
	}

	@Override
	public void init() {
		modifyUserInfoService = (ModifyUserInfoService)this.configYourManager("modifyUserInfoService");
	}

	public void testFindUserInfoByUserId(){
		this.init();
		try {
			CQUPTUser u = modifyUserInfoService.findUserInfoByUserId("123456");
			System.out.println(u.getDepartment());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUpdateUserInfo(){
		this.init();
		try {
			CQUPTUser u = modifyUserInfoService.findUserInfoByUserId("123456");
			u.setLastAcademic("测试1");
			modifyUserInfoService.modifyUserInfo(u);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		ModifyUserInfoServiceImplTest m = new ModifyUserInfoServiceImplTest();
		m.testFindUserInfoByUserId();
		//m.testUpdateUserInfo();
	}
}
