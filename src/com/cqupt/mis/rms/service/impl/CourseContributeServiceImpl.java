package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.CourseContribute;
import com.cqupt.mis.rms.model.CourseContributeMember;
import com.cqupt.mis.rms.service.CourseContributeService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class CourseContributeServiceImpl implements CourseContributeService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<CourseContribute, CourseContributeMember> findCourseContributeInfoByCourseId(
			String courseId) {
		// TODO Auto-generated method stub
		ModelInfo<CourseContribute, CourseContributeMember> courseContributeInfo = new ModelInfo<CourseContribute, CourseContributeMember>();
		List<CourseContributeMember> courseContributeMembers = this.searchDao.SearchObjectsByFactor("CourseContributeMember", "courseContribute.courseId", courseId);
		courseContributeInfo.setModel((CourseContribute)this.searchDao.SearchUniqueObjectsByFactor("CourseContribute", "courseId", courseId));
		courseContributeInfo.setModelList(courseContributeMembers);
		return courseContributeInfo;
	}

	@Override
	public List<ModelInfo<CourseContribute, CourseContributeMember>> findAllCourseContributeInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<CourseContribute, CourseContributeMember>> courseContributeInfos = new ArrayList<ModelInfo<CourseContribute, CourseContributeMember>>();
		List<String> courseIds = new ArrayList<String>();
		
		courseIds.add("null");
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<CourseContributeMember> courseContributeMembers = searchDao.SearchObjectsByFactor("CourseContributeMember", "memberId", CQUPTUsers.get(i).getUserId());
				
				for (int j = 0; j < courseContributeMembers.size(); j++) {
					boolean b = false;
					for (int z = 0; z < courseIds.size(); z++) {
						if (courseIds.get(z).equals(courseContributeMembers.get(j).getCourseContribute().getCourseId())) {
							b = true;
						}	
					}
					if (b == false) {
						courseIds.add(courseContributeMembers.get(j).getCourseContribute().getCourseId());
					}
				}
			}
			for(int i=1;i<courseIds.size();i++){
				courseContributeInfos.add(this.findCourseContributeInfoByCourseId(courseIds.get(i)));
			}
		return courseContributeInfos;
	}

	@Override
	public List<ModelInfo<CourseContribute, CourseContributeMember>> searchCourseContributeInfoByStringFactor(
			List<ModelInfo<CourseContribute, CourseContributeMember>> courseContributeInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<CourseContribute, CourseContributeMember>> courseContributeInfo = new ArrayList<ModelInfo<CourseContribute, CourseContributeMember>>();
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
	public List<ModelInfo<CourseContribute, CourseContributeMember>> searchCourseContributeInfoByNumFactor(
			List<ModelInfo<CourseContribute, CourseContributeMember>> courseContributeInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<CourseContribute, CourseContributeMember>> CourseContributeInfo = new ArrayList<ModelInfo<CourseContribute, CourseContributeMember>>();
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
	public List<ModelInfo<CourseContribute, CourseContributeMember>> searchCourseContributeInfoByDateFactor(
			List<ModelInfo<CourseContribute, CourseContributeMember>> courseContributeInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<CourseContribute, CourseContributeMember>> CourseContributeInfo = new ArrayList<ModelInfo<CourseContribute, CourseContributeMember>>();
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
