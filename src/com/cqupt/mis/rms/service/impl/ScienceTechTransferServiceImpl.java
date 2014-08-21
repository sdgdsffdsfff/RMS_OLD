package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceTechTransfer;
import com.cqupt.mis.rms.model.ScienceTransferLeader;
import com.cqupt.mis.rms.service.ScienceTechTransferService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class ScienceTechTransferServiceImpl implements
		ScienceTechTransferService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<ScienceTechTransfer, ScienceTransferLeader> findScienceTechTransferByTransferId(
			String transferId) {
		// TODO Auto-generated method stub
		ModelInfo<ScienceTechTransfer, ScienceTransferLeader> scienceTechTransferInfo =
				new ModelInfo<ScienceTechTransfer, ScienceTransferLeader>();
		List<ScienceTransferLeader> scienceTransferLeaders = this.searchDao.SearchObjectsByFactor("ScienceTransferLeader", "scienceTechTransfer.transferId", transferId);
		scienceTechTransferInfo.setModel((ScienceTechTransfer)this.searchDao.SearchUniqueObjectsByFactor("ScienceTechTransfer", "transferId", transferId));
		scienceTechTransferInfo.setModelList(scienceTransferLeaders);
		return scienceTechTransferInfo;
	}

	@Override
	public List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> findAllScienceTechTransfer(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfers = new ArrayList<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>>();
		for (int i = 0; i < CQUPTUsers.size(); i++) {
			List<ScienceTechTransfer> scienceTransfers = searchDao.SearchObjectsByFactor("ScienceTechTransfer", "submitUser.userId", CQUPTUsers.get(i).getUserId());
			for(ScienceTechTransfer scienceTransfer:scienceTransfers){
				scienceTechTransfers.add(this.findScienceTechTransferByTransferId(scienceTransfer.getTransferId()));
			}
		}
		return scienceTechTransfers;
	}

	@Override
	public List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> searchScienceTechTransferByStringFactor(
			List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfers, String factorName,
			String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfer = new ArrayList<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>>();
		int num = 0;
		if(factorName.equals("transferId")){
			num = 1;
		}else if(factorName.equals("collegeIn")){
			num = 2;
		}else if(factorName.equals("techName")){
			num = 3;
		}else if(factorName.equals("projectLeader")){
			num = 4;
		}else if(factorName.equals("transfereeUnit")){
			num = 5;
		}else if(factorName.equals("unitProperties")){
			num = 6;
		}else if(factorName.equals("transformationWay")){
			num = 7;
		}else if(factorName.equals("submitUser")){
			num = 8;
		}else if(factorName.equals("approvedUser")){
			num = 9;
		}else if(factorName.equals("status")){
			num = 10;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<scienceTechTransfers.size();i++){
			switch(num)
			{
			case 1:{
				if(scienceTechTransfers.get(i).getModel().getTransferId().indexOf(factorValue)!=-1){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			case 2:{
				if(scienceTechTransfers.get(i).getModel().getCollegeIn().indexOf(factorValue)!=-1){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			case 3:{
				if(scienceTechTransfers.get(i).getModel().getTechName().indexOf(factorValue)!=-1){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			case 4:{
				for(int j=0;j<scienceTechTransfers.get(i).getModelList().size();j++){
					if(scienceTechTransfers.get(i).getModelList().get(j).getLeaderName().indexOf(factorValue)!=-1){
						scienceTechTransfer.add(scienceTechTransfers.get(i));
						break;
					}
				}
				
				break;
			}
			case 5:{
				if(scienceTechTransfers.get(i).getModel().getTransfereeUnit().indexOf(factorValue)!=-1){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			case 6:{
				if(scienceTechTransfers.get(i).getModel().getUnitProperties().indexOf(factorValue)!=-1){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			case 7:{
				if(scienceTechTransfers.get(i).getModel().getTransformationWay().indexOf(factorValue)!=-1){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			case 8:{
				if(scienceTechTransfers.get(i).getModel().getSubmitUser()!=null){
					if(scienceTechTransfers.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						scienceTechTransfer.add(scienceTechTransfers.get(i));
					}
				}
				break;
			}
			case 9:{
				if(scienceTechTransfers.get(i).getModel().getApprovedUser()!=null){
					if(scienceTechTransfers.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						scienceTechTransfer.add(scienceTechTransfers.get(i));
					}
				}
				break;
			}
			case 10:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(scienceTechTransfers.get(i).getModel().getStatus()==status){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return scienceTechTransfer;
	}

	@Override
	public List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> searchScienceTechTransferByNumFactor(
			List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfers, String factorName,
			float minNum, float maxNum) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfer = new ArrayList<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>>();
		int num = 0;
		if(factorName.equals("contractAmount")){
			num = 1;
		}else if(factorName.equals("realIncome")){
			num = 2;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<scienceTechTransfers.size();i++){
			switch(num)
			{
			case 1:{
				if((scienceTechTransfers.get(i).getModel().getContractAmount()>minNum||scienceTechTransfers.get(i).getModel().getContractAmount()==minNum)
						&&(scienceTechTransfers.get(i).getModel().getContractAmount()<maxNum||scienceTechTransfers.get(i).getModel().getContractAmount()==maxNum)){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			case 2:{
				if((scienceTechTransfers.get(i).getModel().getRealIncome()>minNum||scienceTechTransfers.get(i).getModel().getRealIncome()==minNum)
						&&(scienceTechTransfers.get(i).getModel().getRealIncome()<maxNum||scienceTechTransfers.get(i).getModel().getRealIncome()==maxNum)){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			default:break; 
			}
		}
		return scienceTechTransfer;
	}

	@Override
	public List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> searchScienceTechTransferByDateFactor(
			List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfers, String factorName,
			Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfer = new ArrayList<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>>();
		int num = 0;
		if(factorName.equals("startTime")){
			num = 1;
		}else if(factorName.equals("endTime")){
			num = 2;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<scienceTechTransfers.size();i++){
			switch(num)
			{
			case 1:{
				if(scienceTechTransfers.get(i).getModel().getStartTime().after(begin)&&scienceTechTransfers.get(i).getModel().getStartTime().before(end)){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			case 2:{
				if(scienceTechTransfers.get(i).getModel().getEndTime().after(begin)&&scienceTechTransfers.get(i).getModel().getEndTime().before(end)){
					scienceTechTransfer.add(scienceTechTransfers.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return scienceTechTransfer;
	}
}
