package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceBookAuthor;
import com.cqupt.mis.rms.service.ScienceBookService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class ScienceBookServiceImpl implements ScienceBookService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@Override
	public ModelInfo<ScienceBook, ScienceBookAuthor> findScienceBookInfoByBookId(
			String bookId) {
		// TODO Auto-generated method stub
		ModelInfo<ScienceBook, ScienceBookAuthor> scienceBookInfo = new ModelInfo<ScienceBook, ScienceBookAuthor>();
		scienceBookInfo.setModel((ScienceBook)this.searchDao.SearchUniqueObjectsByFactor("ScienceBook", "bookId", bookId));
		List<ScienceBookAuthor> scienceBookAuthors = new ArrayList<ScienceBookAuthor>();
		scienceBookAuthors = this.searchDao.SearchObjectsByFactor("ScienceBookAuthor", "scienceBook.bookId", bookId);
		scienceBookInfo.setModelList(scienceBookAuthors);
		return scienceBookInfo;
	}

	@Override
	public List<ModelInfo<ScienceBook, ScienceBookAuthor>> findScienceBookInfoByAuthorId(
			String authorId) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfos = new ArrayList<ModelInfo<ScienceBook, ScienceBookAuthor>>();
		List<ScienceBookAuthor> scienceBookAuthors = searchDao.SearchObjectsByFactor("ScienceBookAuthor", "authorId", authorId);
		for(int i=0;i<scienceBookAuthors.size();i++){
			boolean b = false;
			for(int j=0;j<scienceBookInfos.size();j++){
				if(scienceBookAuthors.get(i).getScienceBook().getBookId().equals(scienceBookInfos.get(j).getModel().getBookId())){
					b = true;
				}
			}
			if(b==false){
				scienceBookInfos.add(this.findScienceBookInfoByBookId(scienceBookAuthors.get(i).getScienceBook().getBookId()));
			}
		}
		return scienceBookInfos;
	}

	@Override
	public List<ModelInfo<ScienceBook, ScienceBookAuthor>> findAllScienceBookInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfos = new ArrayList<ModelInfo<ScienceBook, ScienceBookAuthor>>();
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<ScienceBook> scienceBooks = searchDao.SearchObjectsByFactor("ScienceBook", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(ScienceBook scienceBook:scienceBooks){
					scienceBookInfos.add(this.findScienceBookInfoByBookId(scienceBook.getBookId()));
				}
			}
		return scienceBookInfos;
	}

	@Override
	public List<ModelInfo<ScienceBook, ScienceBookAuthor>> searchScienceBookInfoByStringFactor(
			List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfo = new ArrayList<ModelInfo<ScienceBook, ScienceBookAuthor>>();
		
		int num = 0;
		if(factorName.equals("bookId")){
			num = 1;
		}else if(factorName.equals("unitAuthor")){
			num = 2;
		}else if(factorName.equals("publicationName")){
			num = 3;
		}else if(factorName.equals("publicationType")){
			num = 4;
		}else if(factorName.equals("publisher")){
			num = 5;
		}else if(factorName.equals("ISBN")){
			num = 6;
		}else if(factorName.equals("awardingGrades")){
			num = 7;
		}else if(factorName.equals("publishedTime")){
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
		
		for(int i=0;i<scienceBookInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(scienceBookInfos.get(i).getModel().getBookId().indexOf(factorValue)!=-1){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 2:{
				if(scienceBookInfos.get(i).getModel().getUnitAuthor().indexOf(factorValue)!=-1){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 3:{
				if(scienceBookInfos.get(i).getModel().getPublicationName().indexOf(factorValue)!=-1){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 4:{
				if(scienceBookInfos.get(i).getModel().getPublicationType().indexOf(factorValue)!=-1){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 5:{
				if(scienceBookInfos.get(i).getModel().getPublisher().indexOf(factorValue)!=-1){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 6:{
				if(scienceBookInfos.get(i).getModel().getISBN().indexOf(factorValue)!=-1){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 7:{
				if(scienceBookInfos.get(i).getModel().getAwardingGrades().indexOf(factorValue)!=-1){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 8:{
				if(scienceBookInfos.get(i).getModel().getPublishedTime().indexOf(factorValue)!=-1){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 9:{
				if(scienceBookInfos.get(i).getModel().getSubmitUser()!=null){
					if(scienceBookInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						scienceBookInfo.add(scienceBookInfos.get(i));
					}
				}
				break;
			}
			case 10:{
				if(scienceBookInfos.get(i).getModel().getApprovedUser()!=null){
					if(scienceBookInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						scienceBookInfo.add(scienceBookInfos.get(i));
					}
				}
				break;
			}
			case 11:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(scienceBookInfos.get(i).getModel().getStatus()==status){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 12:{
				for(int j=0;j<scienceBookInfos.get(i).getModelList().size();j++){
					if(scienceBookInfos.get(i).getModelList().get(j).getMemberName().indexOf(factorValue)!=-1){
						scienceBookInfo.add(scienceBookInfos.get(i));
						break;
					}
				}
				break;
			}
			
			default:break;
			}
		}
		return scienceBookInfo;
	}

	@Override
	public List<ModelInfo<ScienceBook, ScienceBookAuthor>> searchScienceBookInfoByNumFactor(
			List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfo = new ArrayList<ModelInfo<ScienceBook, ScienceBookAuthor>>();
		
		int num = 0;
		if(factorName.equals("totalPrize")){
			num = 1;
		}else if(factorName.equals("deductionsDistPosts")){
			num = 2;
		}else if(factorName.equals("actualAward")){
			num = 3;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<scienceBookInfos.size();i++){
			switch(num)
			{
			case 1:{
				if((scienceBookInfos.get(i).getModel().getTotalPrize()>minNum||scienceBookInfos.get(i).getModel().getTotalPrize()==minNum)
						&&(scienceBookInfos.get(i).getModel().getTotalPrize()<maxNum||scienceBookInfos.get(i).getModel().getTotalPrize()==maxNum)){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 2:{
				if((scienceBookInfos.get(i).getModel().getDeductionsDistPosts()>minNum||scienceBookInfos.get(i).getModel().getDeductionsDistPosts()==minNum)
						&&(scienceBookInfos.get(i).getModel().getDeductionsDistPosts()<maxNum||scienceBookInfos.get(i).getModel().getDeductionsDistPosts()==maxNum)){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			case 3:{
				if((scienceBookInfos.get(i).getModel().getActualAward()>minNum||scienceBookInfos.get(i).getModel().getActualAward()==minNum)
						&&(scienceBookInfos.get(i).getModel().getActualAward()<maxNum||scienceBookInfos.get(i).getModel().getActualAward()==maxNum)){
					scienceBookInfo.add(scienceBookInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return scienceBookInfo;
	}
}
