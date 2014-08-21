/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;


/**
*<p>Title:测试类</p>
*<p>Description: 测试系统接口运行是否存在错误，必须保存所有测试代码。</p>
*@author LvHai
*@version 1.0
*/
@SuppressWarnings("deprecation")
public class TestExample extends AbstractDependencyInjectionSpringContextTests {

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
	*测试提交理科论文信息的底层接口
	*@return void
	*/
	@Test
	public void testSubmitSciencePaperDao() throws Exception {
		
	}
}
