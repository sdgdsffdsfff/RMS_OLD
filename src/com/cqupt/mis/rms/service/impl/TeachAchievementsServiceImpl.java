package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachersAwards;
import com.cqupt.mis.rms.service.TeachAchievementsService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class TeachAchievementsServiceImpl implements TeachAchievementsService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<TeachAchievements, TeachersAwards> findTeachAchievementsInfoByAchievementsId(
			String achievementsId) {
		// TODO Auto-generated method stub
		ModelInfo<TeachAchievements, TeachersAwards> teachAchievementsInfo = new ModelInfo<TeachAchievements, TeachersAwards>();
		List<TeachersAwards> teachersAwards = this.searchDao.SearchObjectsByFactor("TeachersAwards", "teachAchievements.achievementsId", achievementsId);
		teachAchievementsInfo.setModel((TeachAchievements)this.searchDao.SearchUniqueObjectsByFactor("TeachAchievements", "achievementsId", achievementsId));
		teachAchievementsInfo.setModelList(teachersAwards);
		return teachAchievementsInfo;
	}

	@Override
	public List<ModelInfo<TeachAchievements, TeachersAwards>> findAllTeachAchievementsInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfos = new ArrayList<ModelInfo<TeachAchievements, TeachersAwards>>();
		List<String> achievementsIds = new ArrayList<String>();
		
		achievementsIds.add("null");
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<TeachersAwards> teachersAwards = searchDao.SearchObjectsByFactor("TeachersAwards", "awardId", CQUPTUsers.get(i).getUserId());
				
				for (int j = 0; j < teachersAwards.size(); j++) {
					boolean b = false;
					for (int z = 0; z < achievementsIds.size(); z++) {
						if (achievementsIds.get(z).equals(teachersAwards.get(j).getTeachAchievements().getAchievementsId())) {
							b = true;
						}	
					}
					if (b == false) {
						achievementsIds.add(teachersAwards.get(j).getTeachAchievements().getAchievementsId());
					}
				}
			}
			for(int i=1;i<achievementsIds.size();i++){
				teachAchievementsInfos.add(this.findTeachAchievementsInfoByAchievementsId(achievementsIds.get(i)));
			}
		return teachAchievementsInfos;
	}

	@Override
	public List<ModelInfo<TeachAchievements, TeachersAwards>> searchTeachAchievementsInfoByStringFactor(
			List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfo = new ArrayList<ModelInfo<TeachAchievements, TeachersAwards>>();
		int num = 0;
		if(factorName.equals("achievementsId")){
			num = 1;
		}else if(factorName.equals("classAchievements")){
			num = 2;
		}else if(factorName.equals("projectName")){
			num = 3;
		}else if(factorName.equals("levelAchievements")){
			num = 4;
		}else if(factorName.equals("timeAchievements")){
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
		for(int i=0 ;i<teachAchievementsInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(teachAchievementsInfos.get(i).getModel().getAchievementsId().indexOf(factorValue)!=-1){
					teachAchievementsInfo.add(teachAchievementsInfos.get(i));
				}
				break;
			}
			case 2:{
				if(teachAchievementsInfos.get(i).getModel().getClassAchievements().indexOf(factorValue)!=-1){
					teachAchievementsInfo.add(teachAchievementsInfos.get(i));
				}
				break;
			}
			case 3:{
				if(teachAchievementsInfos.get(i).getModel().getProjectName().indexOf(factorValue)!=-1){
					teachAchievementsInfo.add(teachAchievementsInfos.get(i));
				}
				break;
			}
			case 4:{
				if(teachAchievementsInfos.get(i).getModel().getLevelAchievements().indexOf(factorValue)!=-1){
					teachAchievementsInfo.add(teachAchievementsInfos.get(i));
				}
				break;
			}
			case 5:{
				if(teachAchievementsInfos.get(i).getModel().getTimeAchievements().indexOf(factorValue)!=-1){
					teachAchievementsInfo.add(teachAchievementsInfos.get(i));
				}
				break;
			}
			case 6:{
				if(teachAchievementsInfos.get(i).getModel().getSubmitUser()!=null){
					if(teachAchievementsInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						teachAchievementsInfo.add(teachAchievementsInfos.get(i));
					}
				}
				break;
			}
			case 7:{
				if(teachAchievementsInfos.get(i).getModel().getApprovedUser()!=null){
					if(teachAchievementsInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						teachAchievementsInfo.add(teachAchievementsInfos.get(i));
					}
				}
				break;
			}
			case 8:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(teachAchievementsInfos.get(i).getModel().getStatus()==status){
					teachAchievementsInfo.add(teachAchievementsInfos.get(i));
				}
				break;
			}
			case 9:{
				for(int j=0;j<teachAchievementsInfos.get(i).getModelList().size();j++){
					if(teachAchievementsInfos.get(i).getModelList().get(j).getMemberName().indexOf(factorValue)!=-1){
						teachAchievementsInfo.add(teachAchievementsInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return teachAchievementsInfo;
	}

	@Override
	public List<ModelInfo<TeachAchievements, TeachersAwards>> searchTeachAchievementsInfoByNumFactor(
			List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfo = new ArrayList<ModelInfo<TeachAchievements, TeachersAwards>>();
		int num = 0;
		if(factorName.equals("collegeAward")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0 ;i<teachAchievementsInfos.size();i++){
			switch(num)
			{
			case 1:{
				if((teachAchievementsInfos.get(i).getModel().getCollegeAward()>minNum||teachAchievementsInfos.get(i).getModel().getCollegeAward()==minNum)
						&&(teachAchievementsInfos.get(i).getModel().getCollegeAward()<maxNum||teachAchievementsInfos.get(i).getModel().getCollegeAward()==maxNum)){
					teachAchievementsInfo.add(teachAchievementsInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return teachAchievementsInfo;
	}

}
