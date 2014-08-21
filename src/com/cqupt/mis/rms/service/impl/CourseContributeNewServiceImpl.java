package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.CourseContributeMemberNew;
import com.cqupt.mis.rms.service.CourseContributeNewService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class CourseContributeNewServiceImpl implements CourseContributeNewService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<CourseContributeNew, CourseContributeMemberNew> findCourseContributeInfoByCourseId(
			String courseId) {
		// TODO Auto-generated method stub
		ModelInfo<CourseContributeNew, CourseContributeMemberNew> courseContributeInfoNew = new ModelInfo<CourseContributeNew, CourseContributeMemberNew>();
		List<CourseContributeMemberNew> courseContributeMembers = this.searchDao.SearchObjectsByFactor("CourseContributeMemberNew", "courseContributeNew.courseId", courseId);
		courseContributeInfoNew.setModel((CourseContributeNew)this.searchDao.SearchUniqueObjectsByFactor("CourseContributeNew", "courseId", courseId));
		courseContributeInfoNew.setModelList(courseContributeMembers);
		return courseContributeInfoNew;
	}

	@Override
	public List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> findAllCourseContributeInfo(
			List<CQUPTUser> CQUPTUsers) { 
		// TODO Auto-generated method stub
		List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> courseContributeInfosNew = new ArrayList<ModelInfo<CourseContributeNew, CourseContributeMemberNew>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<CourseContributeNew> courseContributesNew = searchDao.SearchObjectsByFactor("CourseContributeNew", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(CourseContributeNew courseContribute:courseContributesNew){
					courseContributeInfosNew.add(this.findCourseContributeInfoByCourseId(courseContribute.getCourseId()));
				}
			}
		return courseContributeInfosNew;
	}

	@Override
	public List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> searchCourseContributeInfoByStringFactor(
			List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> courseContributeInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> courseContributeInfo = new ArrayList<ModelInfo<CourseContributeNew, CourseContributeMemberNew>>();
		int num = 0;
		if(factorName.equals("courseId")){
			num = 1;
		}else if(factorName.equals("classContribute")){
			num = 2;
		}else if(factorName.equals("typeContribute")){
			num = 3;
		}else if(factorName.equals("timeContribute")){
			num = 4;
		}else if(factorName.equals("courseName")){
			num = 5;
		}else if(factorName.equals("submitUser")){
			num = 6;
		}else if(factorName.equals("approvedUser")){
			num = 7;
		}else if(factorName.equals("status")){
			num = 8;
		}else if(factorName.equals("member")){
			num = 9;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0 ;i<courseContributeInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(courseContributeInfos.get(i).getModel().getCourseId().indexOf(factorValue)!=-1){
					courseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			case 2:{
				if(courseContributeInfos.get(i).getModel().getClassContribute().indexOf(factorValue)!=-1){
					courseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			case 3:{
				if(courseContributeInfos.get(i).getModel().getTypeContribute().indexOf(factorValue)!=-1){
					courseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			case 4:{
				if(courseContributeInfos.get(i).getModel().getTimeContribute().indexOf(factorValue)!=-1){
					courseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			case 5:{
				if(courseContributeInfos.get(i).getModel().getCourseName().indexOf(factorValue)!=-1){
					courseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			case 6:{
				if(courseContributeInfos.get(i).getModel().getSubmitUser()!=null){
					if(courseContributeInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						courseContributeInfo.add(courseContributeInfos.get(i));
					}
				}
				break;
			}
			case 7:{
				if(courseContributeInfos.get(i).getModel().getApprovedUser()!=null){
					if(courseContributeInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						courseContributeInfo.add(courseContributeInfos.get(i));
					}
				}
				break;
			}
			case 8:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(courseContributeInfos.get(i).getModel().getStatus()==status){
					courseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			case 9:{
				for(int j=0;j<courseContributeInfos.get(i).getModelList().size();j++){
					if(courseContributeInfos.get(i).getModelList().get(j).getMemberName().indexOf(factorValue)!=-1){
						courseContributeInfo.add(courseContributeInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return courseContributeInfo;
	}

	@Override
	public List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> searchCourseContributeInfoByNumFactor(
			List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> courseContributeInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> CourseContributeInfo = new ArrayList<ModelInfo<CourseContributeNew, CourseContributeMemberNew>>();
		int num = 0;
		if(factorName.equals("collegeAward")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0 ;i<courseContributeInfos.size();i++){
			switch(num)
			{
			case 1:{
				if((courseContributeInfos.get(i).getModel().getCollegeAward()>minNum||courseContributeInfos.get(i).getModel().getCollegeAward()==minNum)
						&&(courseContributeInfos.get(i).getModel().getCollegeAward()<maxNum||courseContributeInfos.get(i).getModel().getCollegeAward()==maxNum)){
					CourseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return CourseContributeInfo;
	}

	@Override
	public List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> searchCourseContributeInfoByDateFactor(
			List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> courseContributeInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<CourseContributeNew, CourseContributeMemberNew>> CourseContributeInfo = new ArrayList<ModelInfo<CourseContributeNew, CourseContributeMemberNew>>();
		int num = 0;
		if(factorName.equals("checkTime")){
			num = 1;
		}else if(factorName.equals("endTime")){
			num = 2;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0 ;i<courseContributeInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(courseContributeInfos.get(i).getModel().getCheckTime().after(begin)&&courseContributeInfos.get(i).getModel().getCheckTime().before(end)){
					CourseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			case 2:{
				if(courseContributeInfos.get(i).getModel().getEndTime().after(begin)&&courseContributeInfos.get(i).getModel().getEndTime().before(end)){
					CourseContributeInfo.add(courseContributeInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return CourseContributeInfo;
	}

}
