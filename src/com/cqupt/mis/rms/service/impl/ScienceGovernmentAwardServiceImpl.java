package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceGovAwardPerson;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.service.ScienceGovernmentAwardService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class ScienceGovernmentAwardServiceImpl implements
		ScienceGovernmentAwardService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
	@Override
	public ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson> findScienceGovernmentAwardByAwardId(
			String awardId) {
		// TODO Auto-generated method stub
		ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson> scienceGovernmentAward = new ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>();
		List<ScienceGovAwardPerson> scienceGovAwardPersons = this.searchDao.SearchObjectsByFactor("ScienceGovAwardPerson", "scienceGovernmentAward.awardId", awardId);
		scienceGovernmentAward.setModelList(scienceGovAwardPersons);
		scienceGovernmentAward.setModel((ScienceGovernmentAward)this.searchDao.SearchUniqueObjectsByFactor("ScienceGovernmentAward", "awardId", awardId));
		return scienceGovernmentAward;
	}

	@Override
	public List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> findAllScienceGovernmentAward(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> scienceGovernmentAwards = new ArrayList<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>>();
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<ScienceGovernmentAward> scienceGovAwards = searchDao.SearchObjectsByFactor("ScienceGovernmentAward", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(ScienceGovernmentAward scienceGovAward:scienceGovAwards){
					scienceGovernmentAwards.add(this.findScienceGovernmentAwardByAwardId(scienceGovAward.getAwardId()));
				}
			}
		return scienceGovernmentAwards;
	}

	@Override
	public List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> searchScienceGovernmentAwardByStringFactor(
			List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> scienceGovernmentAwards,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> scienceGovernmentAward = new ArrayList<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>>();
		int num = 0;
		if(factorName.equals("awardId")){
			num = 1;
		}else if(factorName.equals("collegesIn")){
			num = 2;
		}else if(factorName.equals("projectName")){
			num = 3;
		}else if(factorName.equals("awardingGrades")){
			num = 4;
		}else if(factorName.equals("completeUnit")){
			num = 5;
		}else if(factorName.equals("submitUser")){
			num = 6;
		}else if(factorName.equals("approvedUser")){
			num = 7;
		}else if(factorName.equals("status")){
			num = 8;
		}else if(factorName.equals("author")){
			num = 9;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<scienceGovernmentAwards.size();i++){
			switch(num)
			{
			case 1:{
				if(scienceGovernmentAwards.get(i).getModel().getAwardId().indexOf(factorValue)!=-1){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			case 2:{
				if(scienceGovernmentAwards.get(i).getModel().getCollegesIn().indexOf(factorValue)!=-1){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			case 3:{
				if(scienceGovernmentAwards.get(i).getModel().getProjectName().indexOf(factorValue)!=-1){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			case 4:{
				if(scienceGovernmentAwards.get(i).getModel().getAwardingGrades().indexOf(factorValue)!=-1){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			case 5:{
				if(scienceGovernmentAwards.get(i).getModel().getCompleteUnit().indexOf(factorValue)!=-1){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			case 6:{
				if(scienceGovernmentAwards.get(i).getModel().getSubmitUser()!=null){
					if(scienceGovernmentAwards.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
					}
				}
				break;
			}
			case 7:{
				if(scienceGovernmentAwards.get(i).getModel().getApprovedUser()!=null){
					if(scienceGovernmentAwards.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
					}
				}
				break;
			}
			case 8:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(scienceGovernmentAwards.get(i).getModel().getStatus()==status){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			case 9:{
				for(int j=0;j<scienceGovernmentAwards.get(i).getModelList().size();j++){
					if(scienceGovernmentAwards.get(i).getModelList().get(j).getMemberName().indexOf(factorValue)!=-1){
						scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
						break;
					}
				}
				break;
			}
			default :break;
			}
		}
		return scienceGovernmentAward;
	}

	@Override
	public List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> searchScienceGovernmentAwardByNumFactor(
			List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> scienceGovernmentAwards,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> scienceGovernmentAward = new ArrayList<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>>();
		int num = 0;
		if(factorName.equals("unitAward")){
			num = 1;
		}else if(factorName.equals("personAward")){
			num = 2;
		}else if(factorName.equals("totalAward")){
			num = 3;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<scienceGovernmentAwards.size();i++){
			switch(num)
			{
			case 1:{
				if((scienceGovernmentAwards.get(i).getModel().getUnitAward()>minNum||scienceGovernmentAwards.get(i).getModel().getUnitAward()==minNum)
						&&(scienceGovernmentAwards.get(i).getModel().getUnitAward()<maxNum||scienceGovernmentAwards.get(i).getModel().getUnitAward()==maxNum)){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			case 2:{
				if((scienceGovernmentAwards.get(i).getModel().getPersonAward()>minNum||scienceGovernmentAwards.get(i).getModel().getPersonAward()==minNum)
						&&(scienceGovernmentAwards.get(i).getModel().getPersonAward()<maxNum||scienceGovernmentAwards.get(i).getModel().getPersonAward()==maxNum)){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			case 3:{
				if((scienceGovernmentAwards.get(i).getModel().getTotalAward()>minNum||scienceGovernmentAwards.get(i).getModel().getTotalAward()==minNum)
						&&(scienceGovernmentAwards.get(i).getModel().getTotalAward()<maxNum||scienceGovernmentAwards.get(i).getModel().getTotalAward()==maxNum)){
					scienceGovernmentAward.add(scienceGovernmentAwards.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return scienceGovernmentAward;
	}

}
