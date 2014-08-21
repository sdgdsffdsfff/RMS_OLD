package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.MajorContributeMemberNew;
import com.cqupt.mis.rms.service.MajorContributeNewService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class MajorContributeNewServiceImpl implements MajorContributeNewService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<MajorContributeNew, MajorContributeMemberNew> findMajorContributeInfoByMajorId(
			String majorId) {
		// TODO Auto-generated method stub
		ModelInfo<MajorContributeNew, MajorContributeMemberNew> majorContributeInfo = new ModelInfo<MajorContributeNew, MajorContributeMemberNew>();
		List<MajorContributeMemberNew> majorContributeMembers = this.searchDao.SearchObjectsByFactor("MajorContributeMemberNew", "majorContributeNew.majorId", majorId);
		majorContributeInfo.setModel((MajorContributeNew)this.searchDao.SearchUniqueObjectsByFactor("MajorContributeNew", "majorId", majorId));
		majorContributeInfo.setModelList(majorContributeMembers);
		return majorContributeInfo;
	}

	@Override
	public List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> findAllMajorContributeInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfos = new ArrayList<ModelInfo<MajorContributeNew, MajorContributeMemberNew>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<MajorContributeNew> majorContributes = searchDao.SearchObjectsByFactor("MajorContributeNew", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(MajorContributeNew majorContribute:majorContributes){
					majorContributeInfos.add(this.findMajorContributeInfoByMajorId(majorContribute.getMajorId()));
				}
			}
		return majorContributeInfos;
	}

	@Override
	public List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> searchMajorContributeInfoByStringFactor(
			List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfo = new ArrayList<ModelInfo<MajorContributeNew, MajorContributeMemberNew>>();
		int num = 0;
		if(factorName.equals("majorId")){
			num = 1;
		}else if(factorName.equals("classContribute")){
			num = 2;
		}else if(factorName.equals("typeContribute")){
			num = 3;
		}else if(factorName.equals("timeContribute")){
			num = 4;
		}else if(factorName.equals("majorName")){
			num = 5;
		}else if(factorName.equals("submitUser")){
			num = 6;
		}else if(factorName.equals("approvedUser")){
			num = 7;
		}else if(factorName.equals("status")){
			num = 8;
		}else if(factorName.equals("member")){
			num = 9;
		}else if(factorName.equals("projectSource")){
			num = 10;
		}else if(factorName.equals("reportedAmounts")){
			num = 11;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0 ;i<majorContributeInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(majorContributeInfos.get(i).getModel().getMajorId().indexOf(factorValue)!=-1){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			case 2:{
				if(majorContributeInfos.get(i).getModel().getClassContribute().indexOf(factorValue)!=-1){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			case 3:{
				if(majorContributeInfos.get(i).getModel().getTypeContribute().indexOf(factorValue)!=-1){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			case 4:{
				if(majorContributeInfos.get(i).getModel().getTimeContribute().indexOf(factorValue)!=-1){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			case 5:{
				if(majorContributeInfos.get(i).getModel().getMajorName().indexOf(factorValue)!=-1){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			case 6:{
				if(majorContributeInfos.get(i).getModel().getSubmitUser()!=null){
					if(majorContributeInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						majorContributeInfo.add(majorContributeInfos.get(i));
					}
				}
				break;
			}
			case 7:{
				if(majorContributeInfos.get(i).getModel().getApprovedUser()!=null){
					if(majorContributeInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						majorContributeInfo.add(majorContributeInfos.get(i));
					}
				}
				break;
			}
			case 8:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(majorContributeInfos.get(i).getModel().getStatus()==status){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			case 9:{
				for(int j=0;j<majorContributeInfos.get(i).getModelList().size();j++){
					if(majorContributeInfos.get(i).getModelList().get(j).getMemberName().indexOf(factorValue)!=-1){
						majorContributeInfo.add(majorContributeInfos.get(i));
						break;
					}
				}
				break;
			}
			case 10:{
				if(majorContributeInfos.get(i).getModel().getProjectSource().indexOf(factorValue)!=-1){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			case 11:{
				if(majorContributeInfos.get(i).getModel().getReportedAmounts().toString().indexOf(factorValue)!=-1){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return majorContributeInfo;
	}

	@Override
	public List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> searchMajorContributeInfoByNumFactor(
			List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfo = new ArrayList<ModelInfo<MajorContributeNew, MajorContributeMemberNew>>();
		int num = 0;
		if(factorName.equals("rewardCollege")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0 ;i<majorContributeInfos.size();i++){
			switch(num)
			{
			case 1:{
				if((majorContributeInfos.get(i).getModel().getRewardCollege()>minNum||majorContributeInfos.get(i).getModel().getRewardCollege()==minNum)
						&&(majorContributeInfos.get(i).getModel().getRewardCollege()<maxNum||majorContributeInfos.get(i).getModel().getRewardCollege()==maxNum)){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return majorContributeInfo;
	}

	@Override
	public List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> searchMajorContributeInfoByDateFactor(
			List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfo = new ArrayList<ModelInfo<MajorContributeNew, MajorContributeMemberNew>>();
		int num = 0;
		if(factorName.equals("checkTime")){
			num = 1;
		}else if(factorName.equals("endTime")){
			num = 2;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0 ;i<majorContributeInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(majorContributeInfos.get(i).getModel().getCheckTime().after(begin)&&majorContributeInfos.get(i).getModel().getCheckTime().before(end)){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			case 2:{
				if(majorContributeInfos.get(i).getModel().getEndTime().after(begin)&&majorContributeInfos.get(i).getModel().getEndTime().before(end)){
					majorContributeInfo.add(majorContributeInfos.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return majorContributeInfo;
	}

}
