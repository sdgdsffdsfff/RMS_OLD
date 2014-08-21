package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachersAwardsNew;
import com.cqupt.mis.rms.service.TeachAchievementsNewService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class TeachAchievementsNewServiceImpl implements TeachAchievementsNewService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<TeachAchievementsNew, TeachersAwardsNew> findTeachAchievementsInfoByAchievementsId(
			String achievementsId) {
		// TODO Auto-generated method stub
		ModelInfo<TeachAchievementsNew, TeachersAwardsNew> teachAchievementsInfo = new ModelInfo<TeachAchievementsNew, TeachersAwardsNew>();
		List<TeachersAwardsNew> teachersAwards = this.searchDao.SearchObjectsByFactor("TeachersAwardsNew", "teachAchievementsNew.achievementsId", achievementsId);
		teachAchievementsInfo.setModel((TeachAchievementsNew)this.searchDao.SearchUniqueObjectsByFactor("TeachAchievementsNew", "achievementsId", achievementsId));
		teachAchievementsInfo.setModelList(teachersAwards);
		return teachAchievementsInfo;
	}

	@Override
	public List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> findAllTeachAchievementsInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> teachAchievementsInfos = new ArrayList<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<TeachAchievementsNew> teachAchievements = searchDao.SearchObjectsByFactor("TeachAchievementsNew", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(TeachAchievementsNew teachAchievement:teachAchievements){
					teachAchievementsInfos.add(this.findTeachAchievementsInfoByAchievementsId(teachAchievement.getAchievementsId()));
				}
			}
		return teachAchievementsInfos;
	}

	@Override
	public List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> searchTeachAchievementsInfoByStringFactor(
			List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> teachAchievementsInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> teachAchievementsInfo = new ArrayList<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>>();
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
		}else if(factorName.equals("projectName")){
			num = 10;
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
				if(teachAchievementsInfos.get(i).getModel().getTimeAchievements().toString().indexOf(factorValue)!=-1){
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
			}case 10:{
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
	public List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> searchTeachAchievementsInfoByNumFactor(
			List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> teachAchievementsInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>> teachAchievementsInfo = new ArrayList<ModelInfo<TeachAchievementsNew, TeachersAwardsNew>>();
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
