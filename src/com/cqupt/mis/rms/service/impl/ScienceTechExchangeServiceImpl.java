package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceTechAttendPerson;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.service.ScienceTechExchangeService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class ScienceTechExchangeServiceImpl implements
		ScienceTechExchangeService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<ScienceTechExchange, ScienceTechAttendPerson> findScienceTechExchangeByTechExchangeId(
			String techExchangeId) {
		// TODO Auto-generated method stub
		ModelInfo<ScienceTechExchange, ScienceTechAttendPerson> scienceTechExchangeInfos = new ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>();
		List<ScienceTechAttendPerson> scienceTechAttendPersons = this.searchDao.SearchObjectsByFactor("ScienceTechAttendPerson", "scienceTechExchange.techExchangeId", techExchangeId);
		scienceTechExchangeInfos.setModelList(scienceTechAttendPersons);
		scienceTechExchangeInfos.setModel((ScienceTechExchange)this.searchDao.SearchUniqueObjectsByFactor("ScienceTechExchange", "techExchangeId", techExchangeId));
		return scienceTechExchangeInfos;
	}

	@Override
	public List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> findAllScienceTechExchange(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchangeInfos = new ArrayList<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<ScienceTechExchange> scienceTechAttends = searchDao.SearchObjectsByFactor("ScienceTechExchange", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(ScienceTechExchange scienceTechAttend:scienceTechAttends){
					scienceTechExchangeInfos.add(this.findScienceTechExchangeByTechExchangeId(scienceTechAttend.getTechExchangeId()));
				}
			}
		return scienceTechExchangeInfos;
	}

	@Override
	public List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> searchScienceTechExchangeByStringFactor(
			List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchanges,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchangeInfos = new ArrayList<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>>();
		int num = 0;
		if(factorName.equals("techExchangeId")){
			num = 1;
		}else if(factorName.equals("collegesIn")){
			num = 2;
		}else if(factorName.equals("exchangeType")){
			num = 3;
		}else if(factorName.equals("exchangeHost")){
			num = 4;
		}else if(factorName.equals("submitUser")){
			num = 5;
		}else if(factorName.equals("approvedUser")){
			num = 6;
		}else if(factorName.equals("status")){
			num = 7;
		}else if(factorName.equals("person")){
			num = 8;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<scienceTechExchanges.size();i++){
			switch(num)
			{
			case 1:{
				if(scienceTechExchanges.get(i).getModel().getTechExchangeId().indexOf(factorValue)!=-1){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 2:{
				if(scienceTechExchanges.get(i).getModel().getCollegesIn().indexOf(factorValue)!=-1){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 3:{
				if(scienceTechExchanges.get(i).getModel().getExchangeType().indexOf(factorValue)!=-1){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 4:{
				if(scienceTechExchanges.get(i).getModel().getExchangeHost().indexOf(factorValue)!=-1){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 5:{
				if(scienceTechExchanges.get(i).getModel().getSubmitUser()!=null){
					if(scienceTechExchanges.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
					}
				}
				break;
			}
			case 6:{
				if(scienceTechExchanges.get(i).getModel().getApprovedUser()!=null){
					if(scienceTechExchanges.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
					}
				}
				break;
			}
			case 7:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(scienceTechExchanges.get(i).getModel().getStatus()==status){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 8:{
				for(int j=0;j<scienceTechExchanges.get(i).getModelList().size();j++){
					if(scienceTechExchanges.get(i).getModelList().get(j).getMemberName().indexOf(factorValue)!=-1){
						scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
					}
				}
				break;
			}
			default:break;
			}
		}
		return scienceTechExchangeInfos;
	}

	@Override
	public List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> searchScienceTechExchangeByNumFactor(
			List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchanges,
			String factorName, float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchangeInfos = new ArrayList<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>>();
		int num = 0;
		if(factorName.equals("sendNumber")){
			num = 1;
		}else if(factorName.equals("receiveNumber")){
			num = 2;
		}else if(factorName.equals("attendNumber")){
			num = 3;
		}else if(factorName.equals("papersNumber")){
			num = 4;
		}else if(factorName.equals("specialInvitedNumber")){
			num = 5;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<scienceTechExchanges.size();i++){
			switch(num)
			{
			case 1:{
				if((scienceTechExchanges.get(i).getModel().getSendNumber()>minNum||scienceTechExchanges.get(i).getModel().getSendNumber()==minNum)
						&&(scienceTechExchanges.get(i).getModel().getSendNumber()<maxNum||scienceTechExchanges.get(i).getModel().getSendNumber()==maxNum)){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 2:{
				if((scienceTechExchanges.get(i).getModel().getReceiveNumber()>minNum||scienceTechExchanges.get(i).getModel().getReceiveNumber()==minNum)
						&&(scienceTechExchanges.get(i).getModel().getReceiveNumber()<maxNum||scienceTechExchanges.get(i).getModel().getReceiveNumber()==maxNum)){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 3:{
				if((scienceTechExchanges.get(i).getModel().getAttendNumber()>minNum||scienceTechExchanges.get(i).getModel().getAttendNumber()==minNum)
						&&(scienceTechExchanges.get(i).getModel().getAttendNumber()<maxNum||scienceTechExchanges.get(i).getModel().getAttendNumber()==maxNum)){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 4:{
				if((scienceTechExchanges.get(i).getModel().getPapersNumber()>minNum||scienceTechExchanges.get(i).getModel().getPapersNumber()==minNum)
						&&(scienceTechExchanges.get(i).getModel().getPapersNumber()<maxNum||scienceTechExchanges.get(i).getModel().getPapersNumber()==maxNum)){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			case 5:{
				if((scienceTechExchanges.get(i).getModel().getSpecialInvitedNumber()>minNum||scienceTechExchanges.get(i).getModel().getSpecialInvitedNumber()==minNum)
						&&(scienceTechExchanges.get(i).getModel().getSpecialInvitedNumber()<maxNum||scienceTechExchanges.get(i).getModel().getSpecialInvitedNumber()==maxNum)){
					scienceTechExchangeInfos.add(scienceTechExchanges.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return scienceTechExchangeInfos;
	}

}
