package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.MajorContribute;
import com.cqupt.mis.rms.model.MajorContributeMember;
import com.cqupt.mis.rms.service.MajorContributeService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class MajorContributeServiceImpl implements MajorContributeService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<MajorContribute, MajorContributeMember> findMajorContributeInfoByMajorId(
			String majorId) {
		// TODO Auto-generated method stub
		ModelInfo<MajorContribute, MajorContributeMember> majorContributeInfo = new ModelInfo<MajorContribute, MajorContributeMember>();
		List<MajorContributeMember> majorContributeMembers = this.searchDao.SearchObjectsByFactor("MajorContributeMember", "majorContribute.majorId", majorId);
		majorContributeInfo.setModel((MajorContribute)this.searchDao.SearchUniqueObjectsByFactor("MajorContribute", "majorId", majorId));
		majorContributeInfo.setModelList(majorContributeMembers);
		return majorContributeInfo;
	}

	@Override
	public List<ModelInfo<MajorContribute, MajorContributeMember>> findAllMajorContributeInfo(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<MajorContribute, MajorContributeMember>> majorContributeInfos = new ArrayList<ModelInfo<MajorContribute, MajorContributeMember>>();
		List<String> majorIds = new ArrayList<String>();
		
		majorIds.add("null");
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<MajorContributeMember> majorContributeMembers = searchDao.SearchObjectsByFactor("MajorContributeMember", "memberId", CQUPTUsers.get(i).getUserId());
				
				for (int j = 0; j < majorContributeMembers.size(); j++) {
					boolean b = false;
					for (int z = 0; z < majorIds.size(); z++) {
						if (majorIds.get(z).equals(majorContributeMembers.get(j).getMajorContribute().getMajorId())) {
							b = true;
						}	
					}
					if (b == false) {
						majorIds.add(majorContributeMembers.get(j).getMajorContribute().getMajorId());
					}
				}
			}
			for(int i=1;i<majorIds.size();i++){
				majorContributeInfos.add(this.findMajorContributeInfoByMajorId(majorIds.get(i)));
			}
		return majorContributeInfos;
	}

	@Override
	public List<ModelInfo<MajorContribute, MajorContributeMember>> searchMajorContributeInfoByStringFactor(
			List<ModelInfo<MajorContribute, MajorContributeMember>> majorContributeInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<MajorContribute, MajorContributeMember>> majorContributeInfo = new ArrayList<ModelInfo<MajorContribute, MajorContributeMember>>();
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
			default:break;
			}
		}
		return majorContributeInfo;
	}

	@Override
	public List<ModelInfo<MajorContribute, MajorContributeMember>> searchMajorContributeInfoByNumFactor(
			List<ModelInfo<MajorContribute, MajorContributeMember>> majorContributeInfos,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<MajorContribute, MajorContributeMember>> majorContributeInfo = new ArrayList<ModelInfo<MajorContribute, MajorContributeMember>>();
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
	public List<ModelInfo<MajorContribute, MajorContributeMember>> searchMajorContributeInfoByDateFactor(
			List<ModelInfo<MajorContribute, MajorContributeMember>> majorContributeInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<MajorContribute, MajorContributeMember>> majorContributeInfo = new ArrayList<ModelInfo<MajorContribute, MajorContributeMember>>();
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
