package com.cqupt.mis.rms.service;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.model.Sheet;

public interface DownLoadExcelInfoByModelService {

	/**
	 * 通过相应的条件得到相应教学成果信息类课程建设的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回教学成果信息类课程建设对应的excel
	 * */
	public Object getExcelCourseContributeInfo(ArrayList<Sheet> lists1,
			ArrayList<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应教学成果信息类专业建设的信息
     * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合  
	 * @return Object 返回教学成果信息类专业建设对应的excel
	 * */
	public Object getExcelMajorContributeInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应教学成果信息类学生获奖的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回教学成果信息类学生获奖对应的excel
	 * */
	public Object getExcelStudentAwardsInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应教学成果信息类教材立项的信息
	 * @param lists1 需要的信息的字段集合
	 * @return Object 返回教学成果信息类教材立项对应的excel
	 * */
	public Object getExcelTeachingMaterialSetInfo(ArrayList<Sheet> lists1,int m);	

	/**
	 * 通过相应的条件得到相应教学成果信息类教学成果的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回教学成果信息类教学成果对应的excel
	 * */
	public Object getExcelTeachAchievementsInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应人文社科类学术会议的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回人文社科类学术会议对应的excel
	 * */
	public Object getExcelHumanitiesAcademicMeetingInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应人文社科类著作的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回人文社科类著作对应的excel
	 * */
	public Object getExcelHumanitiesBookInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应人文社科类交流论文的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回人文社科类交流论文对应的excel
	 * */
	public Object getExcelHumanitiesExchangePaperInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应人文社科类论文的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回人文社科类论文对应的excel
	 * */
	public Object getExcelHumanitiesPaperInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应人文社科类项目基本信息的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @param lists3 需要的信息的字段集合
	 * @return Object 返回人文社科类项目基本信息对应的excel
	 * */
	public Object getExcelHumanitiesProjectInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,List<Sheet> lists3,int m);	

	/**
	 * 通过相应的条件得到相应人文社科类科研获奖的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回人文社科类科研获奖对应的excel
	 * */
	public Object getExcelHumanitiesResearchRewardInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应理工科研类著作的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回理工科研类著作对应的excel
	 * */
	public Object getExcelScienceBookInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应理工科研类政府科技奖励的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回理工科研类政府科技奖励对应的excel
	 * */
	public Object getExcelScienceGovernmentAwardInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应理工科研类知识产权情况的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回理工科研类知识产权情况对应的excel
	 * */
	public Object getExcelScienceIpRightsInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到相应理工科研类活动机构的信息
	 * @param lists1 需要的信息的字段集合
	 * @return Object 返回理工科研类活动机构对应的excel
	 * */
	public Object getExcelScienceOrganizationInfo(ArrayList<Sheet> lists1,int m);	

	/**
	 * 通过相应的条件得到相应理工科研类论文的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回理工科研类论文对应的excel
	 * */
	public Object getExcelSciencePaperInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

	/**
	 * 通过相应的条件得到理工科研类技术转让情况的信息
	 * @param lists1 需要的信息的字段集合
	 * @return Object 返回理工科研类技术转让情况对应的excel
	 * */
	public Object getExcelScienceTechTransferInfo(ArrayList<Sheet> lists1,int m);	

	/**
	 * 通过相应的条件得到相应理工科研类科技项目的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @param lists3 需要的信息的字段集合
	 * @return Object 返回理工科研类科技项目对应的excel
	 * */
	public Object getExcelScienceTechProjectInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,
			List<Sheet> lists3,int m);	

	/**
	 * 通过相应的条件得到相应理工科研类技术转让情况的信息
	 * @param lists1 需要的信息的字段集合
	 * @param lists2 需要的信息的字段集合
	 * @return Object 返回理工科研类技术转让情况对应的excel
	 * */
	public Object getExcelScienceTechExchangeInfo(ArrayList<Sheet> lists1,
			List<Sheet> lists2,int m);	

}
