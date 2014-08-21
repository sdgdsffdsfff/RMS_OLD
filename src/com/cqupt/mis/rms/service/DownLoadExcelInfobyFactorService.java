package com.cqupt.mis.rms.service;






/**
 * <p>Title:下载从数据库导出的Excel文件的服务层接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
public interface DownLoadExcelInfobyFactorService {

	
	/**
	 * 通过相应的条件得到相应人文社科类学术会议的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回人文社科类学术会议对应的excel
	 * */
	public Object getExcelHumanitiesAcademicMeetingInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应人文社科类著作的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回人文社科类著作对应的excel
	 * */
	public Object getExcelHumanitiesBookInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应人文社科类交流论文的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回人文社科类交流论文对应的excel
	 * */
	public Object getExcelHumanitiesExchangePaperInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应人文社科类论文的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回人文社科类论文对应的excel
	 * */
	public Object getExcelHumanitiesPaperInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应人文社科类项目基本信息的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回人文社科类项目基本信息对应的excel
	 * */
	public Object getExcelHumanitiesProjectInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应人文社科类科研获奖的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回人文社科类科研获奖对应的excel
	 * */
	public Object getExcelHumanitiesResearchRewardInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应理工科研类著作的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回理工科研类著作对应的excel
	 * */
	public Object getExcelScienceBookInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应理工科研类政府科技奖励的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回理工科研类政府科技奖励对应的excel
	 * */
	public Object getExcelScienceGovernmentAwardInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应理工科研类知识产权情况的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回理工科研类知识产权情况对应的excel
	 * */
	public Object getExcelScienceIpRightsInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应理工科研类活动机构的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回理工科研类活动机构对应的excel
	 * */
	public Object getExcelScienceOrganizationInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应理工科研类论文的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回理工科研类论文对应的excel
	 * */
	public Object getExcelSciencePaperInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到理工科研类技术转让情况的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回理工科研类技术转让情况对应的excel
	 * */
	public Object getExcelScienceTechTransferInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应理工科研类科技项目的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回理工科研类科技项目对应的excel
	 * */
	public Object getExcelScienceTechProjectInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应理工科研类技术转让情况的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回理工科研类技术转让情况对应的excel
	 * */
	public Object getExcelScienceTechExchangeInfo(String factorName,String factorValues,String userId);	

	
	/**
	 * 通过相应的条件得到相应新的教学成果信息类教学成果的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回教学成果信息类教学成果对应的excel
	 * */
	public Object getExcelTeachAchievementsNewInfo(String factorName,String factorValues,String userId);	

	
	
	/**
	 * 通过相应的条件得到相应教学成果信息类课程建设的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回教学成果信息类课程建设对应的excel
	 * */
	public Object getExcelCourseContributeNewInfo(String factorName,String factorValues,String userId);	

	
	/**
	 * 通过相应的条件得到相应教学成果信息类学生获奖的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回教学成果信息类学生获奖对应的excel
	 * */
	public Object getExcelStudentAwardsNewInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应教学成果信息类教材立项的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回教学成果信息类教材立项对应的excel
	 * */
	public Object getExcelTeachingMaterialSetNewInfo(String factorName,String factorValues,String userId);	

	/**
	 * 通过相应的条件得到相应教学成果信息类教学成果的信息
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回教学成果信息类教学成果对应的excel
	 * */
	public Object getExcelTeachAchievementsCQInfo(String factorName,String factorValues,String userId);

	public Object getExcelMajorContributeNewInfo(String factorName,String factorValues, String userId);


	public Object getExcelCourseContributeInfo(String factorName,
			String factorValues, String userId);

	public Object getExcelMajorContributeInfo(String factorName,
			String factorValues, String userId);

	public Object getExcelStudentAwardsInfo(String factorName,
			String factorValues, String userId);

	public Object getExcelTeachingMaterialSetInfo(String factorName,
			String factorValues, String userId);

	public Object getExcelTeachAchievementsInfo(String factorName,
			String factorValues, String userId);

	
	
	
	
}
