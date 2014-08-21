/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
/*import com.cqupt.mis.rms.service.DownLoadExcelInfobyFactorService;
import com.cqupt.mis.rms.service.ExcelToDBService;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.service.impl.ExcelToDBCourseContributeServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBHumanitiesAcademicMeetingServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBHumanitiesBookServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBHumanitiesExchangePaperServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBHumanitiesPaperServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBHumanitiesProjectServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBHumanitiesResearchRewardServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBMajorContributeServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBScienceBookServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBScienceGovernmentAwardServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBScienceIpRightsServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBScienceOrganizationServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBSciencePaperServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBScienceTechExchangeServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBScienceTechProjectServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBScienceTechTransferServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBStudentAwardsServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBTeachAchievementsServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBTeachingMaterialSetServiceImpl;
import com.cqupt.mis.rms.service.impl.SubmitInfoAndProofsServiceImpl;
import com.cqupt.mis.rms.utils.ExcelTemplate;*/
/*
import com.cqupt.mis.rms.service.ExcelToDBService;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.service.impl.ExcelToDBAchServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBHumServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBTecServiceImpl;
import com.cqupt.mis.rms.service.impl.SubmitInfoAndProofsServiceImpl;
*/

import com.cqupt.mis.rms.service.ExcelToDBService;
import com.cqupt.mis.rms.service.impl.ExcelToDBNewAchServiceImpl;
import com.cqupt.mis.rms.service.impl.ExcelToDBTecServiceImpl;

/**
*<p>Title:测试管理用户登录信息类</p>
*<p>Description: 测试系统接口运行是否存在错误，必须保存所有测试代码。</p>
*@author HHY
*@version 1.0
*/
@SuppressWarnings("deprecation")
public class ExcelTest extends AbstractDependencyInjectionSpringContextTests {

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
	public void testHHY() throws Exception {
		/*DownLoadExcelInfobyFactorService downLoadExcelInfobyFactorService = (DownLoadExcelInfobyFactorService)applicationContext.getBean("downLoadExcelInfobyFactorService");
		
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
	 * 
	 * 
*/
		
		//ExcelToDBService excelToDBService1=(ExcelToDBAchServiceImpl)applicationContext.getBean("excelToDBAchServiceImpl");
		//ExcelToDBService excelToDBService2=(ExcelToDBHumServiceImpl)applicationContext.getBean("excelToDBHumServiceImpl");
		//ExcelToDBService excelToDBService3=(ExcelToDBTecServiceImpl)applicationContext.getBean("excelToDBTecServiceImpl");

	   
	/*	SubmitInfoAndProofsService submitInfoAndProofsService = (SubmitInfoAndProofsServiceImpl)applicationContext.getBean("submitInfoAndProofsService");
*/
	}
}
