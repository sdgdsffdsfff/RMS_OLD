package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceInventors;
import com.cqupt.mis.rms.model.ScienceIpRights;
import com.cqupt.mis.rms.service.ScienceIpRightsService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class ScienceIpRightsServiceImpl implements ScienceIpRightsService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<ScienceIpRights, ScienceInventors> findScienceIpRightsInfoByRightsId(
			String rightsId) {
		// TODO Auto-generated method stub
		ModelInfo<ScienceIpRights, ScienceInventors> scienceIpRights = new ModelInfo<ScienceIpRights, ScienceInventors>();
		List<ScienceInventors> scienceInventors = this.searchDao.SearchObjectsByFactor("ScienceInventors", "scienceIpRights.rightsId", rightsId);
		scienceIpRights.setModelList(scienceInventors);
		scienceIpRights.setModel((ScienceIpRights)this.searchDao.SearchUniqueObjectsByFactor("ScienceIpRights", "rightsId", rightsId));
		return scienceIpRights;
	}

	@Override
	public List<ModelInfo<ScienceIpRights, ScienceInventors>> findAllScienceIpRightsInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfos = new ArrayList<ModelInfo<ScienceIpRights, ScienceInventors>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<ScienceIpRights> scienceIpRights = searchDao.SearchObjectsByFactor("ScienceIpRights", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(ScienceIpRights scienceIpRight:scienceIpRights){
					scienceIpRightsInfos.add(this.findScienceIpRightsInfoByRightsId(scienceIpRight.getRightsId()));
				}
			}
		return scienceIpRightsInfos;
	}

	@Override
	public List<ModelInfo<ScienceIpRights, ScienceInventors>> searchScienceIpRightsInfoByStringFactor(
			List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfo = new ArrayList<ModelInfo<ScienceIpRights, ScienceInventors>>();
		int num = 0;
		if(factorName.equals("rightsId")){
			num = 1;
		}else if(factorName.equals("collegesIn")){
			num = 2;
		}else if(factorName.equals("patentName")){
			num = 3;
		}else if(factorName.equals("patentType")){
			num = 4;
		}else if(factorName.equals("applicationNumber")){
			num = 5;
		}else if(factorName.equals("patentStatus")){
			num = 6;
		}else if(factorName.equals("submitUser")){
			num = 7;
		}else if(factorName.equals("approvedUser")){
			num = 8;
		}else if(factorName.equals("status")){
			num = 9;
		}else if(factorName.equals("author")){
			num = 10;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<scienceIpRightsInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(scienceIpRightsInfos.get(i).getModel().getRightsId().indexOf(factorValue)!=-1){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			case 2:{
				if(scienceIpRightsInfos.get(i).getModel().getCollegesIn().indexOf(factorValue)!=-1){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			case 3:{
				if(scienceIpRightsInfos.get(i).getModel().getPatentName().indexOf(factorValue)!=-1){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			case 4:{
				if(scienceIpRightsInfos.get(i).getModel().getPatentType().indexOf(factorValue)!=-1){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			case 5:{
				if(scienceIpRightsInfos.get(i).getModel().getApplicationNumber().indexOf(factorValue)!=-1){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			case 6:{
				if(scienceIpRightsInfos.get(i).getModel().getPatentStatus().indexOf(factorValue)!=-1){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			case 7:{
				if(scienceIpRightsInfos.get(i).getModel().getSubmitUser()!=null){
					if(scienceIpRightsInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
					}
				}
				break;
			}
			case 8:{
				if(scienceIpRightsInfos.get(i).getModel().getApprovedUser()!=null){
					if(scienceIpRightsInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
					}
				}
				break;
			}
			case 9:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(scienceIpRightsInfos.get(i).getModel().getStatus()==status){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			case 10:{
				for(int j=0;j<scienceIpRightsInfos.get(i).getModelList().size();j++){
					if(scienceIpRightsInfos.get(i).getModelList().get(j).getMemberName().indexOf(factorValue)!=-1){
						scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
						break;
					}
				}
				break;
			}
			default :break;
			}
			
		}
		return scienceIpRightsInfo;
	}

	@Override
	public List<ModelInfo<ScienceIpRights, ScienceInventors>> searchScienceIpRightsInfoByNumFactor(
			List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfo = new ArrayList<ModelInfo<ScienceIpRights, ScienceInventors>>();
		int num = 0;
		if(factorName.equals("incentivePayments")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<scienceIpRightsInfos.size();i++){
			switch(num)
			{
			case 1:{
				if((scienceIpRightsInfos.get(i).getModel().getIncentivePayments()>minNum||scienceIpRightsInfos.get(i).getModel().getIncentivePayments()==minNum)
						&&(scienceIpRightsInfos.get(i).getModel().getIncentivePayments()<maxNum||scienceIpRightsInfos.get(i).getModel().getIncentivePayments()==maxNum)){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return scienceIpRightsInfo;
	}
	@Override
	public List<ModelInfo<ScienceIpRights, ScienceInventors>> searchScienceIpRightsInfoByDateFactor(
			List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfo = new ArrayList<ModelInfo<ScienceIpRights, ScienceInventors>>();
		int num = 0;
		if(factorName.equals("filingDate")){
			num = 1;
		}else if(factorName.equals("announcementDate")){
			num = 2;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<scienceIpRightsInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(scienceIpRightsInfos.get(i).getModel().getFilingDate().before(end)&&scienceIpRightsInfos.get(i).getModel().getFilingDate().after(begin)){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			case 2:{
				if(scienceIpRightsInfos.get(i).getModel().getAnnouncementDate().before(end)&&scienceIpRightsInfos.get(i).getModel().getAnnouncementDate().after(begin)){
					scienceIpRightsInfo.add(scienceIpRightsInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return scienceIpRightsInfo;
	}
}
