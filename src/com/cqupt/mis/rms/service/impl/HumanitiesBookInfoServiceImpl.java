package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.service.HumanitiesBookInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class HumanitiesBookInfoServiceImpl implements HumanitiesBookInfoService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<HumanitiesBook, HumanitiesBookAuthor> findHumanitiesBookInfoByBookId(
			String bookId) {
		// TODO Auto-generated method stub
		ModelInfo<HumanitiesBook, HumanitiesBookAuthor> HumanitiesPaperInfo = new ModelInfo<HumanitiesBook, HumanitiesBookAuthor>();
		List<HumanitiesBookAuthor> humanitiesBookAuthors = this.searchDao.SearchObjectsByFactor("HumanitiesBookAuthor", "humanitiesBook.bookId", bookId);
		HumanitiesPaperInfo.setModelList(humanitiesBookAuthors);
		HumanitiesPaperInfo.setModel((HumanitiesBook)this.searchDao.SearchUniqueObjectsByFactor("HumanitiesBook", "bookId", bookId));
		return HumanitiesPaperInfo;
	}
	@Override
	public List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> findAllHumanitiesBookInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos = new ArrayList<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<HumanitiesBook> humanitiesBooks = searchDao.SearchObjectsByFactor("HumanitiesBook", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(HumanitiesBook humanitiesBook:humanitiesBooks){
					humanitiesBookInfos.add(this.findHumanitiesBookInfoByBookId(humanitiesBook.getBookId()));
				}
			}
		return humanitiesBookInfos;
	}
	@Override
	public List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> searchHumanitiesBookInfoByStringFactor(
			List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfo = new ArrayList<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>>();
		int num = 0;
		if(factorName.equals("bookId")){
			num = 1;
		}else if(factorName.equals("bookName")){
			num = 2;
		}else if(factorName.equals("grades")){
			num = 3;
		}else if(factorName.equals("publisher")){
			num = 4;
		}else if(factorName.equals("ISBN")){
			num = 5;
		}else if(factorName.equals("belongProject")){
			num = 6;
		}else if(factorName.equals("subjectsClassify")){
			num = 7;
		}else if(factorName.equals("achievementQuote")){
			num = 8;
		}else if(factorName.equals("submitUser")){
			num = 9;
		}else if(factorName.equals("approvedUser")){
			num = 10;
		}else if(factorName.equals("status")){
			num = 11;
		}else if(factorName.equals("author")){
			num = 12;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<humanitiesBookInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(humanitiesBookInfos.get(i).getModel().getBookId().indexOf(factorValue)!=-1){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 2:{
				if(humanitiesBookInfos.get(i).getModel().getBookName().indexOf(factorValue)!=-1){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 3:{
				if(humanitiesBookInfos.get(i).getModel().getGrades().indexOf(factorValue)!=-1){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 4:{
				if(humanitiesBookInfos.get(i).getModel().getPublisher().indexOf(factorValue)!=-1){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 5:{
				if(humanitiesBookInfos.get(i).getModel().getISBN().indexOf(factorValue)!=-1){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 6:{
				if(humanitiesBookInfos.get(i).getModel().getBelongProject().indexOf(factorValue)!=-1){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 7:{
				if(humanitiesBookInfos.get(i).getModel().getSubjectsClassify().indexOf(factorValue)!=-1){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 8:{
				if(humanitiesBookInfos.get(i).getModel().getAchievementQuote().indexOf(factorValue)!=-1){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 9:{
				if(humanitiesBookInfos.get(i).getModel().getSubmitUser()!=null){
					if(humanitiesBookInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesBookInfo.add(humanitiesBookInfos.get(i));
					}
				}
				break;
			}
			case 10:{
				if(humanitiesBookInfos.get(i).getModel().getApprovedUser()!=null){
					if(humanitiesBookInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesBookInfo.add(humanitiesBookInfos.get(i));
					}
				}
				break;
			}
			case 11:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(humanitiesBookInfos.get(i).getModel().getStatus()==status){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			case 12:{
				for(int j=0;j<humanitiesBookInfos.get(i).getModelList().size();j++){
					if(humanitiesBookInfos.get(i).getModelList().get(j).getAuthorName().indexOf(factorValue)!=-1){
						humanitiesBookInfo.add(humanitiesBookInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesBookInfo;
	}
	@Override
	public List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> searchHumanitiesBookInfoByNumFactor(
			List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfo = new ArrayList<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>>();
		int num = 0;
		if(factorName.equals("wordcount")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<humanitiesBookInfos.size();i++){
			switch(num)
			{
			case 1:{
				if((humanitiesBookInfos.get(i).getModel().getWordcount()>minNum||humanitiesBookInfos.get(i).getModel().getWordcount()==minNum)
						&&(humanitiesBookInfos.get(i).getModel().getWordcount()<maxNum||humanitiesBookInfos.get(i).getModel().getWordcount()==maxNum)){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesBookInfo;
	}
	@Override
	public List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> searchHumanitiesBookInfoByDateFactor(
			List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfo = new ArrayList<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>>();
		int num = 0;
		if(factorName.equals("publishedTime")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<humanitiesBookInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(humanitiesBookInfos.get(i).getModel().getPublishedTime().after(begin)&&humanitiesBookInfos.get(i).getModel().getPublishedTime().before(end)){
					humanitiesBookInfo.add(humanitiesBookInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesBookInfo;
	}
}
