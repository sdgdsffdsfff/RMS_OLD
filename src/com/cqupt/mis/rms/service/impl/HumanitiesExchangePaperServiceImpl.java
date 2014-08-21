package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.service.HumanitiesExchangePaperService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class HumanitiesExchangePaperServiceImpl implements
		HumanitiesExchangePaperService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor> findHumanitiesExchangePaperInfoByExchangePaperId(
			String exchangePaperId) {
		// TODO Auto-generated method stub
		ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor> humanitiesExchangePaperInfo = new ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>();
		List<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthors = this.searchDao.SearchObjectsByFactor("HumanitiesExchangePaperAuthor", "humanitiesExchangePaper.exchangePaperId", exchangePaperId);
		humanitiesExchangePaperInfo.setModel((HumanitiesExchangePaper)this.searchDao.SearchUniqueObjectsByFactor("HumanitiesExchangePaper", "exchangePaperId", exchangePaperId));
		humanitiesExchangePaperInfo.setModelList(humanitiesExchangePaperAuthors);
		return humanitiesExchangePaperInfo;
	}

	@Override
	public List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> findAllHumanitiesExchangePaperInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfos = new ArrayList<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<HumanitiesExchangePaper> humanitiesExchangePapers = searchDao.SearchObjectsByFactor("HumanitiesExchangePaper", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(HumanitiesExchangePaper humanitiesExchangePaper:humanitiesExchangePapers){
					humanitiesExchangePaperInfos.add(this.findHumanitiesExchangePaperInfoByExchangePaperId(humanitiesExchangePaper.getExchangePaperId()));
				}
			}
		return humanitiesExchangePaperInfos;
	}

	@Override
	public List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> searchHumanitiesExchangePaperInfoByStringFactor(
			List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfo = new ArrayList<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>>();
		int num = 0;
		if(factorName.equals("exchangePaperId")){
			num = 1;
		}else if(factorName.equals("exchangePaperName")){
			num = 2;
		}else if(factorName.equals("searchStation")){
			num = 3;
		}else if(factorName.equals("subjectsClassify")){
			num = 4;
		}else if(factorName.equals("hostConferenceName")){
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
		for(int i=0;i<humanitiesExchangePaperInfos.size();i++){
			switch(num){
			case 1:{
				if(humanitiesExchangePaperInfos.get(i).getModel().getExchangePaperId().indexOf(factorValue)!=-1){
					humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
				}
				break;
			}
			case 2:{
				if(humanitiesExchangePaperInfos.get(i).getModel().getExchangePaperName().indexOf(factorValue)!=-1){
					humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
				}
				break;
			}
			case 3:{
				if(humanitiesExchangePaperInfos.get(i).getModel().getSearchStation().indexOf(factorValue)!=-1){
					humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
				}
				break;
			}
			case 4:{
				if(humanitiesExchangePaperInfos.get(i).getModel().getSubjectsClassify().indexOf(factorValue)!=-1){
					humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
				}
				break;
			}
			case 5:{
				if(humanitiesExchangePaperInfos.get(i).getModel().getHostConferenceName().indexOf(factorValue)!=-1){
					humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
				}
				break;
			}
			case 6:{
				if(humanitiesExchangePaperInfos.get(i).getModel().getSubmitUser()!=null){
					if(humanitiesExchangePaperInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
					}
				}
				break;
			}
			case 7:{
				if(humanitiesExchangePaperInfos.get(i).getModel().getApprovedUser()!=null){
					if(humanitiesExchangePaperInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
					}
				}
				break;
			}
			case 8:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(humanitiesExchangePaperInfos.get(i).getModel().getStatus()==status){
					humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
				}
				break;
			}
			case 9:{
				for(int j=0;j<humanitiesExchangePaperInfos.get(i).getModelList().size();j++){
					if(humanitiesExchangePaperInfos.get(i).getModelList().get(j).getAuthorName().indexOf(factorValue)!=-1){
						humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesExchangePaperInfo;
	}

	@Override
	public List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> searchHumanitiesExchangePaperInfoByDateFactor(
			List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfo = new ArrayList<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>>();
		int num = 0;
		if(factorName.equals("exchangePaperId")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<humanitiesExchangePaperInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(humanitiesExchangePaperInfos.get(i).getModel().getPublishedTime().after(begin)&&humanitiesExchangePaperInfos.get(i).getModel().getPublishedTime().before(end)){
					humanitiesExchangePaperInfo.add(humanitiesExchangePaperInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesExchangePaperInfo;
	}

}
