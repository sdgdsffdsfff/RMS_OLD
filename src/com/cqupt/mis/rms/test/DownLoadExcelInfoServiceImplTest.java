/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import com.cqupt.mis.rms.service.DownLoadExcelInfoService;
import com.cqupt.mis.rms.utils.ExcelTemplate;


/**
*<p>Title:测试管理用户登录信息类</p>
*<p>Description: 测试系统接口运行是否存在错误，必须保存所有测试代码。</p>
*@author HHY
*@version 1.0
*/
@SuppressWarnings("deprecation")
public class DownLoadExcelInfoServiceImplTest extends AbstractDependencyInjectionSpringContextTests {

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
		DownLoadExcelInfoService downLoadExcelInfoService = (DownLoadExcelInfoService)applicationContext.getBean("downLoadExcelInfoService");
		ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelCourseContributeInfo();
		
	//  ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelMajorContributeInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelStudentAwardsInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelTeachingMaterialSetInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelTeachAchievementsInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesAcademicMeetingInfo();
	//  ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesBookInfo();
	//  ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesExchangePaperInfo();
	//  ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesPaperInfo();
	//  ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesResearchRewardInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceBookInfo();
	//  ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceGovernmentAwardInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceIpRightsInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceOrganizationInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelSciencePaperInfo();
	//	ExcelTemplate excelTemplate = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceTechTransferInfo();

		System.out.println(excelTemplate);
	}
}
