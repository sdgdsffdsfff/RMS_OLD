package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.StudentAwards;
import com.cqupt.mis.rms.model.StudentInstructor;
import com.cqupt.mis.rms.service.StudentAwardsInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class StudentAwardsInfoServiceImpl implements StudentAwardsInfoService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<StudentAwards, StudentInstructor> findStudentAwardsInfoByAwardsId(
			String awardsId) {
		// TODO Auto-generated method stub
		ModelInfo<StudentAwards, StudentInstructor> studentAwardsInfo = new ModelInfo<StudentAwards, StudentInstructor>();
		List<StudentInstructor> studentInstructors = this.searchDao.SearchObjectsByFactor("StudentInstructor", "studentAwards.awardsId", awardsId);
		studentAwardsInfo.setModel((StudentAwards)this.searchDao.SearchUniqueObjectsByFactor("StudentAwards", "awardsId", awardsId));
		studentAwardsInfo.setModelList(studentInstructors);
		return studentAwardsInfo;
	}

	@Override
	public List<ModelInfo<StudentAwards, StudentInstructor>> findAllStudentAwardsInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<StudentAwards, StudentInstructor>> studentAwardsInfos = new ArrayList<ModelInfo<StudentAwards, StudentInstructor>>();
		List<String> awardsIds = new ArrayList<String>();
		
		awardsIds.add("null");
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<StudentInstructor> studentInstructors = searchDao.SearchObjectsByFactor("StudentInstructor", "instructorId", CQUPTUsers.get(i).getUserId());
				
				for (int j = 0; j < studentInstructors.size(); j++) {
					boolean b = false;
					for (int z = 0; z < awardsIds.size(); z++) {
						if (awardsIds.get(z).equals(studentInstructors.get(j).getStudentAwards().getAwardsId())) {
							b = true;
						}	
					}
					if (b == false) {
						awardsIds.add(studentInstructors.get(j).getStudentAwards().getAwardsId());
					}
				}
			}
			for(int i=1;i<awardsIds.size();i++){
				studentAwardsInfos.add(this.findStudentAwardsInfoByAwardsId(awardsIds.get(i)));
			}
		return studentAwardsInfos;
	}

	@Override
	public List<ModelInfo<StudentAwards, StudentInstructor>> searchStudentAwardsInfoByStringFactor(
			List<ModelInfo<StudentAwards, StudentInstructor>> studentAwardsInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<StudentAwards, StudentInstructor>> studentAwardsInfo = new ArrayList<ModelInfo<StudentAwards, StudentInstructor>>();
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
				if(studentAwardsInfos.get(i).getModel().getCollegeAward().indexOf(factorValue)!=-1){
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
