/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.cqupt.mis.rms.manager.GetCollegeInfoDao;


/**
*<p>Title:测试管理用户登录信息类</p>
*<p>Description: 测试系统接口运行是否存在错误，必须保存所有测试代码。</p>
*@author HHY
*@version 1.0
*/
@SuppressWarnings("deprecation")
public class GetCollegeInfoDaoImplTest extends AbstractDependencyInjectionSpringContextTests {

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
		GetCollegeInfoDao getCollegeInfoDao = (GetCollegeInfoDao)applicationContext.getBean("getCollegeInfoDao");
		Object o1 = getCollegeInfoDao.getInfo("ScienceTechProject");
		System.out.println(o1);
		
		Integer o3 = getCollegeInfoDao.updateInfoById("1", "ScienceTechProject", "1", "projectId","1");
		System.out.println(o3);
		Object o2 = getCollegeInfoDao.getInfoByFactor("1", "ScienceTechProject", "projectId");
		System.out.println(o2);
	//	Integer o4 = getCollegeInfoDao.updateRejectInfoById("1", "ScienceTechProject", "1", "projectId","1","no");

	}
}
