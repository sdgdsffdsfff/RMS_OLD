package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachAchievementsDeclarant;
import com.cqupt.mis.rms.service.TeachAchievementsCQService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class TeachAchievementsCQServiceImpl implements TeachAchievementsCQService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant> findTeachAchievementsCQInfoByAchievementsId(
			String achievementsId) {
		// TODO Auto-generated method stub
		ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant> teachAchievementsNewInfo = new ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>();
		List<TeachAchievementsDeclarant> teachAchievementsDeclarant = this.searchDao.SearchObjectsByFactor("TeachAchievementsDeclarant", "teachAchievementsCQ.achievementsId", achievementsId);
		teachAchievementsNewInfo.setModel((TeachAchievementsCQ)this.searchDao.SearchUniqueObjectsByFactor("TeachAchievementsCQ", "achievementsId", achievementsId));
		teachAchievementsNewInfo.setModelList(teachAchievementsDeclarant);
		return teachAchievementsNewInfo;
	}

	@Override
	public List<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>> findAllTeachAchievementsCQInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>> teachAchievementsNewInfos = new ArrayList<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<TeachAchievementsCQ> teachAchievementsCQ = searchDao.SearchObjectsByFactor("TeachAchievementsCQ", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(TeachAchievementsCQ teachAchievementCQ:teachAchievementsCQ){
					teachAchievementsNewInfos.add(this.findTeachAchievementsCQInfoByAchievementsId(teachAchievementCQ.getAchievementsId()));
				}
			}
		return teachAchievementsNewInfos;
	}

	@Override
	public List<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>> 
		searchTeachAchievementsCQInfoByStringFactor(List<ModelInfo<TeachAchievementsCQ, 
				TeachAchievementsDeclarant>> teachAchievementsCQInfos,String factorName,
				String factorValue){
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>> teachAchievementsCQInfo = new ArrayList<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>>();
		int num = 0;
		if(factorName.equals("achievementsId")){
			num = 1;
		}else if(factorName.equals("classAchievements")){
			num = 2;
		}else if(factorName.equals("projectName")){
			num = 3;
		}else if(factorName.equals("gradeAchievements")){
			num = 4;
		}else if(factorName.equals("timeAchievements")){
			num = 5;
		}else if(factorName.equals("submitUser")){
			num = 6;
		}else if(factorName.equals("approvedUser")){
			num = 7;
		}else if(factorName.equals("status")){
			num = 8;
		}else if(factorName.equals("declarantName")){
			num = 9;
		}else if(factorName.equals("projectType")){
			num = 10;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0 ;i<teachAchievementsCQInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(teachAchievementsCQInfos.get(i).getModel().getAchievementsId().indexOf(factorValue)!=-1){
					teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
				}
				break;
			}
			case 2:{
				if(teachAchievementsCQInfos.get(i).getModel().getClassAchievements().indexOf(factorValue)!=-1){
					teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
				}
				break;
			}
			case 3:{
				if(teachAchievementsCQInfos.get(i).getModel().getProjectName().indexOf(factorValue)!=-1){
					teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
				}
				break;
			}
			case 4:{
				if(teachAchievementsCQInfos.get(i).getModel().getGradeAchievements().indexOf(factorValue)!=-1){
					teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
				}
				break;
			}
			case 5:{
				if(teachAchievementsCQInfos.get(i).getModel().getTimeAchievements().indexOf(factorValue)!=-1){
					teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
				}
				break;
			}
			case 6:{
				if(teachAchievementsCQInfos.get(i).getModel().getSubmitUser()!=null){
					if(teachAchievementsCQInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
					}
				}
				break;
			}
			case 7:{
				if(teachAchievementsCQInfos.get(i).getModel().getApprovedUser()!=null){
					if(teachAchievementsCQInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
					}
				}
				break;
			}
			case 8:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(teachAchievementsCQInfos.get(i).getModel().getStatus()==status){
					teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
				}
				break;
			}
			case 9:{
				for(int j=0;j<teachAchievementsCQInfos.get(i).getModelList().size();j++){
					if(teachAchievementsCQInfos.get(i).getModelList().get(j).getDeclarantName().indexOf(factorValue)!=-1){
						teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
						break;
					}
				}
				break;
			}
			case 10:{
				if(teachAchievementsCQInfos.get(i).getModel().getProjectType().indexOf(factorValue)!=-1){
					teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return teachAchievementsCQInfo;
	}

	@Override
	public List<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>> searchTeachAchievementsCQInfoByNumFactor(
			List<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>> teachAchievementsCQInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>> teachAchievementsCQInfo = new ArrayList<ModelInfo<TeachAchievementsCQ, TeachAchievementsDeclarant>>();
		int num = 0;
		if(factorName.equals("verifyAmounts")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0 ;i<teachAchievementsCQInfos.size();i++){
			switch(num)
			{
			case 1:{
				if((teachAchievementsCQInfos.get(i).getModel().getVerifyAmounts()>minNum||teachAchievementsCQInfos.get(i).getModel().getVerifyAmounts()==minNum)
						&&(teachAchievementsCQInfos.get(i).getModel().getVerifyAmounts()<maxNum||teachAchievementsCQInfos.get(i).getModel().getVerifyAmounts()==maxNum)){
					teachAchievementsCQInfo.add(teachAchievementsCQInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return teachAchievementsCQInfo;
	}

}
