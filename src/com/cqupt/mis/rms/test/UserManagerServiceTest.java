/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.cqupt.mis.rms.service.CollegeManagerService;


/**
*<p>Title:测试管理用户登录信息类</p>
*<p>Description: 测试系统接口运行是否存在错误，必须保存所有测试代码。</p>
*@author HHY
*@version 1.0
*/
@SuppressWarnings("deprecation")
public class UserManagerServiceTest extends AbstractDependencyInjectionSpringContextTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Override
	protected String[] getConfigLocations() {
		String[] config = new String[] {"classpath:config/applicationContext-*.xml"};
		return config;
	}
	
	/**
	*测试管理用户登录信息的接口
	*@return void
	*/
	@Test
	public void testGetCollegeInfoDao() throws Exception {
		CollegeManagerService collegeManagerService = (CollegeManagerService)
		applicationContext.getBean("collegeManagerService");
		collegeManagerService.getInfoByFactor("1", "ScienceTechProject", "projectId");
		collegeManagerService.getInfo("ScienceTechProject");
		collegeManagerService.updateInfoById("1", "ScienceTechProject", "1", "projectId","1");
		collegeManagerService.updateRejectInfoById("1", "ScienceTechProject", "1", "projectId","1","no");
	}
}
