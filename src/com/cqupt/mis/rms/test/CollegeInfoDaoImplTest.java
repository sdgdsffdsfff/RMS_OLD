package com.cqupt.mis.rms.test;

import com.cqupt.mis.rms.manager.CollegeInfoDao;
import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.utils.AbstractTest;

public class CollegeInfoDaoImplTest extends AbstractTest {
	private CollegeInfoDao collegeInfoDao;
	@Override
	public void init() {
		collegeInfoDao = (CollegeInfoDao)this.configYourManager("collegeInfoDao");
	}
	
	public void testAddCollegeInfo(){
		init();
		CQUPTCollege collegeInfo = new CQUPTCollege();
		collegeInfo.setCollegeId("06");
		collegeInfo.setCollegeName("体育学院");
		try {
			collegeInfoDao.addCollegeInfo(collegeInfo);
			System.out.println("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindCQUPTCollegeByCollegeId(){
		init();
		try {
			CQUPTCollege collegeInfo = collegeInfoDao.findCQUPTCollegeByCollegeId("01");
			System.out.println("学院名称是：" +collegeInfo.getCollegeName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUpdateCollegeInfoByEntity(){
		init();
		try {
			CQUPTCollege collegeInfo = collegeInfoDao.findCQUPTCollegeByCollegeId("06");
			collegeInfo.setCollegeName("软件技术学院");
			collegeInfoDao.updateCollegeInfoByEntity(collegeInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
