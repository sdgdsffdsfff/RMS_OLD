package com.cqupt.mis.rms.test.lvhai;


import com.cqupt.mis.rms.service.ModifyPasswordService;
import com.cqupt.mis.rms.utils.AbstractTest;

public class ModifyPasswordServiceImplTest extends AbstractTest {
	private ModifyPasswordService modifyPasswordService;



	public void setModifyPasswordService(ModifyPasswordService modifyPasswordService) {
		this.modifyPasswordService = modifyPasswordService;
	}

	@Override
	public void init() {
		modifyPasswordService = (ModifyPasswordService)this.configYourManager("modifyPasswordService");
	}

	public void testUpdateUserPassword(){
		this.init();
		try {
			boolean result = modifyPasswordService.updateUserPassword("654321", "123456", "123");
			System.out.println("result="+result);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		ModifyPasswordServiceImplTest m = new ModifyPasswordServiceImplTest();
		m.testUpdateUserPassword();
		
	}
}
