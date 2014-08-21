package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesPaperAuthor;
import com.cqupt.mis.rms.service.HumanitiesPaperService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class HumanitiesPaperServiceImpl implements HumanitiesPaperService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor> findHumanitiesPaperInfoByPaperId(
			String paperId) {
		// TODO Auto-generated method stub
		ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor> humanitiesPaperInfo = new ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>();
		List<HumanitiesPaperAuthor> humanitiesPaperAuthors = this.searchDao.SearchObjectsByFactor("HumanitiesPaperAuthor", "humanitiesPaper.paperId", paperId);
		humanitiesPaperInfo.setModelList(humanitiesPaperAuthors);
		humanitiesPaperInfo.setModel((HumanitiesPaper)this.searchDao.SearchUniqueObjectsByFactor("HumanitiesPaper", "paperId", paperId));
		return humanitiesPaperInfo;
	}

	@Override
	public List<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>> findAllHumanitiesPaperInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>> humanitiesPaperInfos = new ArrayList<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>>();
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<HumanitiesPaper> HumanitiesPapers = searchDao.SearchObjectsByFactor("HumanitiesPaper", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(HumanitiesPaper HumanitiesPaper:HumanitiesPapers){
					humanitiesPaperInfos.add(this.findHumanitiesPaperInfoByPaperId(HumanitiesPaper.getPaperId()));
				}
			}
		return humanitiesPaperInfos;
	}

	@Override
	public List<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>> searchHumanitiesPaperInfoByStringFactor(
			List<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>> humanitiesPaperInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>> humanitiesPaperInfo = new ArrayList<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>>();
		int num = 0;
		if(factorName.equals("paperId")){
			num = 1;
		}else if(factorName.equals("paperName")){
			num = 2;
		}else if(factorName.equals("publishedTime")){
			num = 3;
		}else if(factorName.equals("postPublication")){
			num = 4;
		}else if(factorName.equals("publishedGrades")){
			num = 5;
		}else if(factorName.equals("searchStation")){
			num = 6;
		}else if(factorName.equals("belongProject")){
			num = 7;
		}else if(factorName.equals("subjectsClassify")){
			num = 8;
		}else if(factorName.equals("achievementQuote")){
			num = 9;
		}else if(factorName.equals("submitUser")){
			num = 10;
		}else if(factorName.equals("approvedUser")){
			num = 11;
		}else if(factorName.equals("status")){
			num = 12;
		}else if(factorName.equals("author")){
			num = 13;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<humanitiesPaperInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(humanitiesPaperInfos.get(i).getModel().getPaperId().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 2:{
				if(humanitiesPaperInfos.get(i).getModel().getPaperName().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 3:{
				if(humanitiesPaperInfos.get(i).getModel().getPublishedTime().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 4:{
				if(humanitiesPaperInfos.get(i).getModel().getPostPublication().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 5:{
				if(humanitiesPaperInfos.get(i).getModel().getPublishedGrades().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 6:{
				if(humanitiesPaperInfos.get(i).getModel().getSearchStation().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 7:{
				if(humanitiesPaperInfos.get(i).getModel().getBelongProject().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 8:{
				if(humanitiesPaperInfos.get(i).getModel().getSubjectsClassify().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 9:{
				if(humanitiesPaperInfos.get(i).getModel().getAchievementQuote().indexOf(factorValue)!=-1){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 10:{
				if(humanitiesPaperInfos.get(i).getModel().getSubmitUser()!=null){
					if(humanitiesPaperInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
					}
				}
				break;
			}
			case 11:{
				if(humanitiesPaperInfos.get(i).getModel().getApprovedUser()!=null){
					if(humanitiesPaperInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
					}
				}
				break;
			}
			case 12:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(humanitiesPaperInfos.get(i).getModel().getStatus()==status){
					humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
				}
				break;
			}
			case 13:{
				for(int j=0;j<humanitiesPaperInfos.get(i).getModelList().size();j++){
					if(humanitiesPaperInfos.get(i).getModelList().get(j).getAuthorName().indexOf(factorValue)!=-1){
						humanitiesPaperInfo.add(humanitiesPaperInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesPaperInfo;
	}
}
