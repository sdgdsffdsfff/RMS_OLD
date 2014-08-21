package com.cqupt.mis.rms.service;

import com.cqupt.mis.rms.utils.ExcelTemplate;


/**
 * <p>Title:下载从数据库导出的Excel文件的服务层接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
public interface DownLoadExcelInfoService {

	
	/**
	 * 通过相应的条件得到相应教学成果信息类课程建设的信息
	 * @return Object 返回教学成果信息类课程建设对应的excel
	 * */
	public Object getExcelCourseContributeNewInfo();	

	/**
	 * 通过相应的条件得到相应教学成果信息类专业建设的信息
	 * @return Object 返回教学成果信息类专业建设对应的excel
	 * */
	public Object getExcelMajorContributeNewInfo();	

	/**
	 * 通过相应的条件得到相应教学成果信息类学生获奖的信息
	 * @return Object 返回教学成果信息类学生获奖对应的excel
	 * */
	public Object getExcelStudentAwardsNewInfo();	

	/**
	 * 通过相应的条件得到相应教学成果信息类教材立项的信息
	 * @return Object 返回教学成果信息类教材立项对应的excel
	 * */
	public Object getExcelTeachingMaterialSetNewInfo();	

	
	/**
	 * 通过相应的条件得到相应新的教学成果信息类教学成果的信息
	 * @return Object 返回教学成果信息类教学成果对应的excel
	 * */
	public Object getExcelTeachAchievementsNewInfo();	

	
	/**
	 * 通过相应的条件得到相应教学成果信息类教学成果的信息
	 * @return Object 返回教学成果信息类教学成果对应的excel
	 * */
	public Object getExcelTeachAchievementsCQInfo();	
		
	
	
	/**
	 * 通过相应的条件得到相应教学成果信息类课程建设的信息
	 * @return Object 返回教学成果信息类课程建设对应的excel
	 * */
	public Object getExcelCourseContributeInfo();	

	/**
	 * 通过相应的条件得到相应教学成果信息类专业建设的信息
	 * @return Object 返回教学成果信息类专业建设对应的excel
	 * */
	public Object getExcelMajorContributeInfo();	

	/**
	 * 通过相应的条件得到相应教学成果信息类学生获奖的信息
	 * @return Object 返回教学成果信息类学生获奖对应的excel
	 * */
	public Object getExcelStudentAwardsInfo();	

	/**
	 * 通过相应的条件得到相应教学成果信息类教材立项的信息
	 * @return Object 返回教学成果信息类教材立项对应的excel
	 * */
	public Object getExcelTeachingMaterialSetInfo();	

	/**
	 * 通过相应的条件得到相应教学成果信息类教学成果的信息
	 * @return Object 返回教学成果信息类教学成果对应的excel
	 * */
	public Object getExcelTeachAchievementsInfo();	

	/**
	 * 通过相应的条件得到相应人文社科类学术会议的信息
	 * @return Object 返回人文社科类学术会议对应的excel
	 * */
	public Object getExcelHumanitiesAcademicMeetingInfo();	

	/**
	 * 通过相应的条件得到相应人文社科类著作的信息
	 * @return Object 返回人文社科类著作对应的excel
	 * */
	public Object getExcelHumanitiesBookInfo();	

	/**
	 * 通过相应的条件得到相应人文社科类交流论文的信息
	 * @return Object 返回人文社科类交流论文对应的excel
	 * */
	public Object getExcelHumanitiesExchangePaperInfo();	

	/**
	 * 通过相应的条件得到相应人文社科类论文的信息
	 * @return Object 返回人文社科类论文对应的excel
	 * */
	public Object getExcelHumanitiesPaperInfo();	

	/**
	 * 通过相应的条件得到相应人文社科类项目基本信息的信息
	 * @return Object 返回人文社科类项目基本信息对应的excel
	 * */
	public Object getExcelHumanitiesProjectInfo();	

	/**
	 * 通过相应的条件得到相应人文社科类科研获奖的信息
	 * @return Object 返回人文社科类科研获奖对应的excel
	 * */
	public Object getExcelHumanitiesResearchRewardInfo();	

	/**
	 * 通过相应的条件得到相应理工科研类著作的信息
	 * @return Object 返回理工科研类著作对应的excel
	 * */
	public Object getExcelScienceBookInfo();	

	/**
	 * 通过相应的条件得到相应理工科研类政府科技奖励的信息
	 * @return Object 返回理工科研类政府科技奖励对应的excel
	 * */
	public Object getExcelScienceGovernmentAwardInfo();	

	/**
	 * 通过相应的条件得到相应理工科研类知识产权情况的信息
	 * @return Object 返回理工科研类知识产权情况对应的excel
	 * */
	public Object getExcelScienceIpRightsInfo();	

	/**
	 * 通过相应的条件得到相应理工科研类活动机构的信息
	 * @return Object 返回理工科研类活动机构对应的excel
	 * */
	public Object getExcelScienceOrganizationInfo();	

	/**
	 * 通过相应的条件得到相应理工科研类论文的信息
	 * @return Object 返回理工科研类论文对应的excel
	 * */
	public Object getExcelSciencePaperInfo();	

	/**
	 * 通过相应的条件得到理工科研类技术转让情况的信息
	 * @return Object 返回理工科研类技术转让情况对应的excel
	 * */
	public Object getExcelScienceTechTransferInfo();	

	/**
	 * 通过相应的条件得到相应理工科研类科技项目的信息
	 * @return Object 返回理工科研类科技项目对应的excel
	 * */
	public Object getExcelScienceTechProjectInfo();	

	/**
	 * 通过相应的条件得到相应理工科研类技术转让情况的信息
	 * @return Object 返回理工科研类技术转让情况对应的excel
	 * */
	public Object getExcelScienceTechExchangeInfo();


	
}
