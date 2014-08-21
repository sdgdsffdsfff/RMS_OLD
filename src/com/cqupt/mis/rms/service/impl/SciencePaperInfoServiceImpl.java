package com.cqupt.mis.rms.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.service.SciencePaperInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class SciencePaperInfoServiceImpl implements SciencePaperInfoService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@Override
	public ModelInfo<SciencePaper, SciencePaperAuthor> findSciencePaperInfoByPaperId(String paperId) {
		// TODO Auto-generated method stub
		ModelInfo<SciencePaper, SciencePaperAuthor> modelInfo = new ModelInfo<SciencePaper, SciencePaperAuthor>();
		modelInfo.setModel((SciencePaper)searchDao.SearchUniqueObjectsByFactor("SciencePaper", "paperId", paperId));
		List<SciencePaperAuthor> sciencePaperAuthor = searchDao.SearchObjectsByFactor("SciencePaperAuthor", "sciencePaper.paperId", paperId);
		modelInfo.setModelList(sciencePaperAuthor);
 		return modelInfo;
	}

	@Override
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperFactor(
			String paperFactorName, String paperFactorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos = new ArrayList<ModelInfo<SciencePaper, SciencePaperAuthor>>();
		List<SciencePaper> sciencePapers = searchDao.SearchObjectsLikeFactor("SciencePaper", paperFactorName, paperFactorValue);
		for(int i=0;i<sciencePapers.size();i++){
			sciencePaperInfos.add(this.findSciencePaperInfoByPaperId(sciencePapers.get(i).getPaperId()));
		}
		return sciencePaperInfos;
	}

	@Override
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByAuthorId(
			String authorId) {
		// TODO Auto-generated method stub
		List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos = new ArrayList<ModelInfo<SciencePaper, SciencePaperAuthor>>();
		List<SciencePaperAuthor> sciencePaperAuthors = searchDao.SearchObjectsByFactor("SciencePaperAuthor", "authorId", authorId);
		for(int i=0;i<sciencePaperAuthors.size();i++){
			boolean b = false;
			for(int j=0;j<sciencePaperInfos.size();j++){
				if(sciencePaperAuthors.get(i).getSciencePaper().getPaperId().equals(sciencePaperInfos.get(j).getModel().getPaperId())){
					b = true;
				}
			}
			if(b==false){
				sciencePaperInfos.add(this.findSciencePaperInfoByPaperId(sciencePaperAuthors.get(i).getSciencePaper().getPaperId()));
			}
		}
		return sciencePaperInfos;
	}


	
	@Override
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findAllSciencePaperInfo(List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos = new ArrayList<ModelInfo<SciencePaper, SciencePaperAuthor>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<SciencePaper> sciencePapers = searchDao.SearchObjectsByFactor("SciencePaper", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(SciencePaper sciencePaper:sciencePapers){
					sciencePaperInfos.add(this.findSciencePaperInfoByPaperId(sciencePaper.getPaperId()));
				}
			}
		return sciencePaperInfos;
	}
	
	
	@Override
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findHerselfSciencePaperInfo(String userId) {
		// TODO Auto-generated method stub
		List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos = new ArrayList<ModelInfo<SciencePaper, SciencePaperAuthor>>();
		List<SciencePaperAuthor> sciencePaperAuthors = this.searchDao.SearchObjectsByFactor("SciencePaperAuthor", "authorId", userId);
		for(int i=0;i<sciencePaperAuthors.size();i++){
			sciencePaperInfos.add(this.findSciencePaperInfoByPaperId(sciencePaperAuthors.get(i).getSciencePaper().getPaperId()));
		}
		return sciencePaperInfos;
	}
	

	@Override
	public SciencePaperAuthor findSciencePaperFirstAuthorByPaperId(
			String paperId) {
		// TODO Auto-generated method stub
		SciencePaperAuthor sciencePaperAuthor = new SciencePaperAuthor();
		List<SciencePaperAuthor> sciencePaperAuthors = this.searchDao.SearchObjectsByFactor("SciencePaperAuthor", "sciencePaper.paperId", paperId);
		for(int i=0;i<sciencePaperAuthors.size();i++){
			if(sciencePaperAuthors.get(i).getOrders()==1){
				sciencePaperAuthor = sciencePaperAuthors.get(i);
			}
		}
		return sciencePaperAuthor;
	}

	@Override
	public List<SciencePaperAuthor> findSciencePaperOtherAuthorByPaperId(
			String paperId) {
		// TODO Auto-generated method stub
		List<SciencePaperAuthor> sciencePaperAuthor = new ArrayList<SciencePaperAuthor>();
		List<SciencePaperAuthor> sciencePaperAuthors = this.searchDao.SearchObjectsByFactor("SciencePaperAuthor", "sciencePaper.paperId", paperId);
		for(int i=0;i<sciencePaperAuthors.size();i++){
			for(int j=0;j<sciencePaperAuthors.size();j++){
				if(sciencePaperAuthors.get(j).getOrders()==i+1){
					sciencePaperAuthor.add(sciencePaperAuthors.get(j));
				}
			}
		}
		sciencePaperAuthor.remove(0);
		return sciencePaperAuthor;
	}


	@Override
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperStringFactor(
			List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos,
			String paperFactorName, String paperFactorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfo = new ArrayList<ModelInfo<SciencePaper, SciencePaperAuthor>>();
		
		int num = 0;
		if(paperFactorName.equals("paperId")){
			num = 1;
		}else if(paperFactorName.equals("paperName")){
			num = 2;
		}else if(paperFactorName.equals("subjectsIn")){
			num = 3;
		}else if(paperFactorName.equals("postPublication")){
			num = 4;
		}else if(paperFactorName.equals("includeSituation")){
			num = 5;
		}else if(paperFactorName.equals("publishedTime")){
			num = 6;
		}else if(paperFactorName.equals("titleNumber")){
			num = 7;
		}else if(paperFactorName.equals("awardingGrades")){
			num = 8;
		}else if(paperFactorName.equals("papersUnits")){
			num = 9;
		}else if(paperFactorName.equals("status")){
			num = 10;
		}else if(paperFactorName.equals("submitUser")){
			num = 11;
		}else if(paperFactorName.equals("approvedUser")){
			num = 12;
		}else if(paperFactorName.equals("author")){
			num = 13;
		}else{
			System.out.println("输入的paperFactorName值有误！您输入的paperFactorName值："+paperFactorName);
		}
		
		
		for(int i=0;i<sciencePaperInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(sciencePaperInfos.get(i).getModel().getPaperId().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 2:{
				if(sciencePaperInfos.get(i).getModel().getPaperName().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 3:{
				if(sciencePaperInfos.get(i).getModel().getSubjectsIn().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 4:{
				if(sciencePaperInfos.get(i).getModel().getPostPublication().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 5:{
				if(sciencePaperInfos.get(i).getModel().getIncludeSituation().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 6:{
				if(sciencePaperInfos.get(i).getModel().getPublishedTime().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 7:{
				if(sciencePaperInfos.get(i).getModel().getTitleNumber().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 8:{
				if(sciencePaperInfos.get(i).getModel().getAwardingGrades().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 9:{
				if(sciencePaperInfos.get(i).getModel().getPapersUnits().indexOf(paperFactorValue)!=-1){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 10:{
				int status = java.lang.Integer.parseInt(paperFactorValue);
				if(sciencePaperInfos.get(i).getModel().getStatus()==status){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 11:{
				if(sciencePaperInfos.get(i).getModel().getSubmitUser()!=null){
					if(sciencePaperInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(paperFactorValue)!=-1){
						sciencePaperInfo.add(sciencePaperInfos.get(i));
					}
				}
				break;
			}
			
			case 12:{
				if(sciencePaperInfos.get(i).getModel().getApprovedUser()!=null){
					if(sciencePaperInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(paperFactorValue)!=-1){
						sciencePaperInfo.add(sciencePaperInfos.get(i));
					}
				}
				break;
			}
			
			case 13:{
				for(int j=0;j<sciencePaperInfos.get(i).getModelList().size();j++){
					if(sciencePaperInfos.get(i).getModelList().get(j).getMemberName().indexOf(paperFactorValue)!=-1){
						sciencePaperInfo.add(sciencePaperInfos.get(i));
						break;
					}
				}
				break;
			}
			
			 default:break;
			}
		}
		
		
		return sciencePaperInfo;
	}

	@Override
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperNumberFactor(
			List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos,
			String paperFactorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfo = new ArrayList<ModelInfo<SciencePaper, SciencePaperAuthor>>();
		
		int num = 0;
		if(paperFactorName.equals("totalPrize")){
			num = 1;
		}else if(paperFactorName.equals("deductionsDistPosts")){
			num = 2;
		}else if(paperFactorName.equals("actualAward")){
			num = 3;
		}else{
			System.out.println("输入的paperFactorName值有误！您输入的paperFactorName值："+paperFactorName);
		}
		
		for(int i=0;i<sciencePaperInfos.size();i++){
			switch(num){
			case 1:{
				if((sciencePaperInfos.get(i).getModel().getTotalPrize()>minNum||sciencePaperInfos.get(i).getModel().getTotalPrize()==minNum)
						&&(sciencePaperInfos.get(i).getModel().getTotalPrize()<maxNum||sciencePaperInfos.get(i).getModel().getTotalPrize()==maxNum)){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 2:{
				if((sciencePaperInfos.get(i).getModel().getDeductionsDistPosts()>minNum||sciencePaperInfos.get(i).getModel().getDeductionsDistPosts()==minNum)
						&&(sciencePaperInfos.get(i).getModel().getDeductionsDistPosts()<maxNum||sciencePaperInfos.get(i).getModel().getDeductionsDistPosts()==maxNum)){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			case 3:{
				if((sciencePaperInfos.get(i).getModel().getActualAward()>minNum||sciencePaperInfos.get(i).getModel().getActualAward()==minNum)
						&&(sciencePaperInfos.get(i).getModel().getActualAward()<maxNum||sciencePaperInfos.get(i).getModel().getActualAward()==maxNum)){
					sciencePaperInfo.add(sciencePaperInfos.get(i));
				}
				break;
			}
			
			default:break;
			}
		}		
		
		return sciencePaperInfo;
	}

//	@Override
//	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findManageSciencePaperInfo(
//			int roleId) {
//		// TODO Auto-generated method stub
//		List<RoleCollege> roleColleges = this.searchDao.SearchObjectsByFactor("RoleCollege", "roleInfo.roleId", roleId);
//		List<CQUPTUser> cquptUsers = new ArrayList<CQUPTUser>();
//		for(int i=0;i<roleColleges.size();i++){
//			List<CQUPTUser> cquptUser = this.searchDao.SearchObjectsByFactor("CQUPTUser", "cquptCollege.collegeId", roleColleges.get(i).getCollegeInfo().getCollegeId());
//			for(int j=0;j<cquptUser.size();j++){
//				cquptUsers.add(cquptUser.get(j));
//			}
//		}
//		return this.findAllSciencePaperInfo(cquptUsers);
//	}

//	@Override
//	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperAuthorStringFactor(
//			List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos,
//			String paperFactorName, String paperFactorValue) {
//		// TODO Auto-generated method stub
//		List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfo = new ArrayList<ModelInfo<SciencePaper, SciencePaperAuthor>>();
//		
//		int num = 0;
//		if(paperFactorName.equals("author")){
//			num = 1;
//		}else{
//			System.out.println("输入的paperFactorName值有误！您输入的paperFactorName值："+paperFactorName);
//		}
//		
//		for(int i=0;i<sciencePaperInfos.size();i++){
//			for(int j=0;j<sciencePaperInfos.get(i).getModelList().size();j++){
//				switch(num){
//				case 1:{
//						String authorId = sciencePaperInfos.get(i).getModelList().get(j).getAuthorId();
//						CQUPTUser CQUPTUser = this.searchDao.SearchUniqueObjectsByFactor("CQUPTUser", "userId", authorId);
//						if(CQUPTUser!=null){
//							if(CQUPTUser.getUserName().indexOf(paperFactorValue)!=-1){
//								sciencePaperInfo.add(sciencePaperInfos.get(i));
//							}
//						}
//					
//					break;
//				}
//				default:break;
//				}
//			}
//		}
//		
//		
//		
//		return sciencePaperInfo;
//	}

	


//	@Override
//	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperDateFactor(
//			List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos,
//			String paperFactorName, Date begin, Date end) {
//		// TODO Auto-generated method stub
//		List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfo = new ArrayList<ModelInfo<SciencePaper, SciencePaperAuthor>>();
//		int num = 0;
//		if(paperFactorName.equals("time")){
//			num = 1;
//		}else{
//			System.out.println("输入的paperFactorName值有误！您输入的paperFactorName值："+paperFactorName);
//		}
//		
//		for(int i=0;i<sciencePaperInfos.size();i++){
//			ScienceTechProject scienceTechProject = new ScienceTechProject();
//			switch(num){
//			case 1:{
//				if(scienceTechProject.getTimeProjectApproved().after(begin)&&scienceTechProject.getTimeProjectApproved().before(end)){
//					sciencePaperInfo.add(sciencePaperInfos.get(i));
//				}
//			}
//			default :break;
//			}
//		}
//		
//		return null;
//	}

}
