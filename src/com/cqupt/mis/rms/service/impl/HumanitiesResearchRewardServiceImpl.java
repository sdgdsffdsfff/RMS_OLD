package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesResearchReward;
import com.cqupt.mis.rms.model.HumanitiesResearchRewardPerson;
import com.cqupt.mis.rms.service.HumanitiesResearchRewardService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class HumanitiesResearchRewardServiceImpl implements
		HumanitiesResearchRewardService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson> findHumanitiesResearchRewardByResearchRewardId(
			String researchRewardId) {
		// TODO Auto-generated method stub
		ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson> humanitiesResearchRewardInfo = new ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>();
		List<HumanitiesResearchRewardPerson> humanitiesResearchRewardPersons = this.searchDao.SearchObjectsByFactor("HumanitiesResearchRewardPerson", "humanitiesResearchReward.researchRewardId", researchRewardId);
		humanitiesResearchRewardInfo.setModel((HumanitiesResearchReward)this.searchDao.SearchUniqueObjectsByFactor("HumanitiesResearchReward", "researchRewardId", researchRewardId));
		humanitiesResearchRewardInfo.setModelList(humanitiesResearchRewardPersons);
		return humanitiesResearchRewardInfo;
	}

	@Override
	public List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> findAllHumanitiesResearchReward(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> humanitiesResearchRewardInfos = new ArrayList<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>>();
		
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<HumanitiesResearchReward> humanitiesResearchRewards = searchDao.SearchObjectsByFactor("HumanitiesResearchReward", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(HumanitiesResearchReward humanitiesResearchReward:humanitiesResearchRewards){
					humanitiesResearchRewardInfos.add(this.findHumanitiesResearchRewardByResearchRewardId(humanitiesResearchReward.getResearchRewardId()));
				}
			}
		return humanitiesResearchRewardInfos;
	}

	@Override
	public List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> searchHumanitiesResearchRewardByStringFactor(
			List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> humanitiesResearchRewards,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> humanitiesResearchReward = new ArrayList<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>>();
		int num = 0;
		if(factorName.equals("researchRewardId")){
			num = 1;
		}else if(factorName.equals("researchRewardName")){
			num = 2;
		}else if(factorName.equals("rewardClassify")){
			num = 3;
		}else if(factorName.equals("rewardGrades")){
			num = 4;
		}else if(factorName.equals("issueUnit")){
			num = 5;
		}else if(factorName.equals("approveNumber")){
			num = 6;
		}else if(factorName.equals("submitUser")){
			num = 7;
		}else if(factorName.equals("approvedUser")){
			num = 8;
		}else if(factorName.equals("status")){
			num = 9;
		}else if(factorName.equals("person")){
			num = 10;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<humanitiesResearchRewards.size();i++){
			switch(num){
			case 1:{
				if(humanitiesResearchRewards.get(i).getModel().getResearchRewardId().indexOf(factorValue)!=-1){
					humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
				}
				break;
			}
			case 2:{
				if(humanitiesResearchRewards.get(i).getModel().getResearchRewardName().indexOf(factorValue)!=-1){
					humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
				}
				break;
			}
			case 3:{
				if(humanitiesResearchRewards.get(i).getModel().getRewardClassify().indexOf(factorValue)!=-1){
					humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
				}
				break;
			}
			case 4:{
				if(humanitiesResearchRewards.get(i).getModel().getRewardGrades().indexOf(factorValue)!=-1){
					humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
				}
				break;
			}
			case 5:{
				if(humanitiesResearchRewards.get(i).getModel().getIssueUnit().indexOf(factorValue)!=-1){
					humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
				}
				break;
			}
			case 6:{
				if(humanitiesResearchRewards.get(i).getModel().getApproveNumber().indexOf(factorValue)!=-1){
					humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
				}
				break;
			}
			case 7:{
				if(humanitiesResearchRewards.get(i).getModel().getSubmitUser()!=null){
					if(humanitiesResearchRewards.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
					}
				}
				break;
			}
			case 8:{
				if(humanitiesResearchRewards.get(i).getModel().getApprovedUser()!=null){
					if(humanitiesResearchRewards.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
					}
				}
				break;
			}
			case 9:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(humanitiesResearchRewards.get(i).getModel().getStatus()==status){
					humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
				}
				break;
			}
			case 10:{
				for(int j=0;j<humanitiesResearchRewards.get(i).getModelList().size();j++){
					if(humanitiesResearchRewards.get(i).getModelList().get(j).getRewardPersonName().indexOf(factorValue)!=-1){
						humanitiesResearchReward.add(humanitiesResearchRewards.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesResearchReward;
	}

	@Override
	public List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> searchHumanitiesResearchRewardByDateFactor(
			List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> humanitiesResearchReward,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> humanitiesResearchRewards = new ArrayList<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>>();
		int num = 0;
		if(factorName.equals("approveTime")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<humanitiesResearchReward.size();i++){
			switch(num)
			{
			case 1:{
				if(humanitiesResearchReward.get(i).getModel().getApproveTime().after(begin)&&humanitiesResearchReward.get(i).getModel().getApproveTime().before(end)){
					humanitiesResearchRewards.add(humanitiesResearchReward.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesResearchRewards;
	}

}
