package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.StudentInstructorNew;
import com.cqupt.mis.rms.service.StudentAwardsNewInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class StudentAwardsNewInfoServiceImpl implements StudentAwardsNewInfoService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<StudentAwardsNew, StudentInstructorNew> findStudentAwardsInfoByAwardsId(
			String awardsId) {
		// TODO Auto-generated method stub
		ModelInfo<StudentAwardsNew, StudentInstructorNew> studentAwardsInfo = new ModelInfo<StudentAwardsNew, StudentInstructorNew>();
		List<StudentInstructorNew> studentInstructors = this.searchDao.SearchObjectsByFactor("StudentInstructorNew", "studentAwardsNew.awardsId", awardsId);
		studentAwardsInfo.setModel((StudentAwardsNew)this.searchDao.SearchUniqueObjectsByFactor("StudentAwardsNew", "awardsId", awardsId));
		studentAwardsInfo.setModelList(studentInstructors);
		return studentAwardsInfo;
	}

	@Override
	public List<ModelInfo<StudentAwardsNew, StudentInstructorNew>> findAllStudentAwardsInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<StudentAwardsNew, StudentInstructorNew>> studentAwardsInfos = new ArrayList<ModelInfo<StudentAwardsNew, StudentInstructorNew>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<StudentAwardsNew> studentAwards = searchDao.SearchObjectsByFactor("StudentAwardsNew", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(StudentAwardsNew studentAward:studentAwards){
					studentAwardsInfos.add(this.findStudentAwardsInfoByAwardsId(studentAward.getAwardsId()));
				}
			}
		return studentAwardsInfos;
	}

	@Override
	public List<ModelInfo<StudentAwardsNew, StudentInstructorNew>> searchStudentAwardsInfoByStringFactor(
			List<ModelInfo<StudentAwardsNew, StudentInstructorNew>> studentAwardsInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<StudentAwardsNew, StudentInstructorNew>> studentAwardsInfo = new ArrayList<ModelInfo<StudentAwardsNew, StudentInstructorNew>>();
		int num = 0;
		if(factorName.equals("awardsId")){
			num = 1;
		}else if(factorName.equals("rewardTime")){
			num = 2;
		}else if(factorName.equals("rewardStudents")){
			num = 3;
		}else if(factorName.equals("rewardName")){
			num = 4;
		}else if(factorName.equals("rewardLevel")){
			num = 5;
		}else if(factorName.equals("collegeAward")){
			num = 6;
		}else if(factorName.equals("submitUser")){
			num = 7;
		}else if(factorName.equals("approvedUser")){
			num = 8;
		}else if(factorName.equals("status")){
			num = 9;
		}else if(factorName.equals("teacher")){
			num = 10;
		}else if(factorName.equals("rewardUnit")){
			num = 11;
		}else if(factorName.equals("firstStudents")){
			num = 12;
		}else if(factorName.equals("remarks")){
			num = 13;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<studentAwardsInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(studentAwardsInfos.get(i).getModel().getAwardsId().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 2:{
				if(studentAwardsInfos.get(i).getModel().getRewardTime().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 3:{
				if(studentAwardsInfos.get(i).getModel().getRewardStudents().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 4:{
				if(studentAwardsInfos.get(i).getModel().getRewardName().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 5:{
				if(studentAwardsInfos.get(i).getModel().getRewardLevel().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 6:{
				if(studentAwardsInfos.get(i).getModel().getCollegeAward().toString().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 7:{
				if(studentAwardsInfos.get(i).getModel().getSubmitUser()!=null){
					if(studentAwardsInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						studentAwardsInfo.add(studentAwardsInfos.get(i));
					}
				}
				break;
			}
			case 8:{
				if(studentAwardsInfos.get(i).getModel().getApprovedUser()!=null){
					if(studentAwardsInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						studentAwardsInfo.add(studentAwardsInfos.get(i));
					}
				}
				break;
			}
			case 9:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(studentAwardsInfos.get(i).getModel().getStatus()==status){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 11:{
				if(studentAwardsInfos.get(i).getModel().getRewardUnit().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 12:{
				if(studentAwardsInfos.get(i).getModel().getFirstStudents().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 13:{
				if(studentAwardsInfos.get(i).getModel().getRemarks().indexOf(factorValue)!=-1){
					studentAwardsInfo.add(studentAwardsInfos.get(i));
				}
				break;
			}
			case 10:{
				for(int j=0;j<studentAwardsInfos.get(i).getModelList().size();j++){
					if(studentAwardsInfos.get(i).getModelList().get(j).getMemberName().indexOf(factorValue)!=-1){
						studentAwardsInfo.add(studentAwardsInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return studentAwardsInfo;
	}

}
