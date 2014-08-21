package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.service.ScienceOrganizationService;

public class ScienceOrganizationServiceImpl implements
		ScienceOrganizationService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@Override
	public ScienceOrganization findScienceOrganizationById(String id) {
		// TODO Auto-generated method stub
		return this.searchDao.SearchUniqueObjectsByFactor("ScienceOrganization", "organizationId", id);
	}

	@Override
	public List<ScienceOrganization> findScienceOrganizationByFactor(
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		return this.searchDao.SearchObjectsLikeFactor("ScienceOrganization", factorName, factorValue);
	}

	@Override
	public List<ScienceOrganization> findAllScienceOrganization(
			List<CQUPTUser> CQUPTUsers) { 
		// TODO Auto-generated method stub
		List<ScienceOrganization> scienceOrganizations = new ArrayList<ScienceOrganization>();
		for(int i=0;i<CQUPTUsers.size();i++){
			List<ScienceOrganization> scienceOrganization = this.searchDao.SearchObjectsByFactor("ScienceOrganization", "submitUser.userId", CQUPTUsers.get(i).getUserId());
			for(int j=0;j<scienceOrganization.size();j++){
				scienceOrganizations.add(scienceOrganization.get(j));
			}
		}
		return scienceOrganizations;
	}

	@Override
	public List<ScienceOrganization> findherselfScienceOrganization(
			String userId) {
		// TODO Auto-generated method stub
		List<ScienceOrganization> scienceOrganization = this.searchDao.SearchObjectsByFactor("ScienceOrganization", "submitUser.userId", userId);
		return scienceOrganization;
	}

	@Override
	public List<ScienceOrganization> searchScienceOrganizationByStringFactor(
			List<ScienceOrganization> scienceOrganizations, String factorName,
			String factorValue) {
		// TODO Auto-generated method stub
		List<ScienceOrganization> scienceOrganization = new ArrayList<ScienceOrganization>();
		int num = 0;
		if(factorName.equals("organizationId")){
			num = 1;
		}else if(factorName.equals("organizationName")){
			num = 2;
		}else if(factorName.equals("organizationType")){
			num = 3;
		}else if(factorName.equals("organizationCategory")){
			num = 4;
		}else if(factorName.equals("sortSubject")){
			num = 5;
		}else if(factorName.equals("modusComposition")){
			num = 6;
		}else if(factorName.equals("industryService")){
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
		
		
		for(int i=0;i<scienceOrganizations.size();i++){
			switch(num)
			{
			case 1:{
				if(scienceOrganizations.get(i).getOrganizationId().indexOf(factorValue)!=-1){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 2:{
				if(scienceOrganizations.get(i).getOrganizationName().indexOf(factorValue)!=-1){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 3:{
				if(scienceOrganizations.get(i).getOrganizationType().indexOf(factorValue)!=-1){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 4:{
				if(scienceOrganizations.get(i).getOrganizationCategory().indexOf(factorValue)!=-1){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 5:{
				if(scienceOrganizations.get(i).getSortSubject().indexOf(factorValue)!=-1){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 6:{
				if(scienceOrganizations.get(i).getModusComposition().indexOf(factorValue)!=-1){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 7:{
				if(scienceOrganizations.get(i).getIndustryService().indexOf(factorValue)!=-1){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 8:{
				if(scienceOrganizations.get(i).getSubmitUser()!=null){
					if(scienceOrganizations.get(i).getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						scienceOrganization.add(scienceOrganizations.get(i));
					}
				}
				break;
			}
			
			case 9:{
				if(scienceOrganizations.get(i).getApprovedUser()!=null){
					if(scienceOrganizations.get(i).getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						scienceOrganization.add(scienceOrganizations.get(i));
					}
				}
				break;
			}
			
			case 10:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(scienceOrganizations.get(i).getStatus()==status){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			default :break;
			}
		}
		return scienceOrganization;
	}

	@Override
	public List<ScienceOrganization> searchScienceOrganizationByNumFactor(
			List<ScienceOrganization> scienceOrganizations, String factorName,
			float minFactorValue, float maxFactorValue) {
		// TODO Auto-generated method stub
		List<ScienceOrganization> scienceOrganization = new ArrayList<ScienceOrganization>();
		int num = 0;
		if(factorName.equals("totalEmployees")){
			num = 1;
		}else if(factorName.equals("doctorEmployees")){
			num = 2;
		}else if(factorName.equals("masterEmployees")){
			num = 3;
		}else if(factorName.equals("totalIts")){
			num = 4;
		}else if(factorName.equals("advancedIts")){
			num = 5;
		}else if(factorName.equals("middleIts")){
			num = 6;
		}else if(factorName.equals("juniorIts")){
			num = 7;
		}else if(factorName.equals("otherIts")){
			num = 8;
		}else if(factorName.equals("numGraduates")){
			num = 9;
		}else if(factorName.equals("internalExpenditures")){
			num = 10;
		}else if(factorName.equals("rdExpenditures")){
			num = 11;
		}else if(factorName.equals("numIssueAssume")){
			num = 12;
		}else if(factorName.equals("assetsFixed")){
			num = 13;
		}else if(factorName.equals("assetsEquipment")){
			num = 14;
		}else if(factorName.equals("assetsImport")){
			num = 15;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		
		for(int i=0;i<scienceOrganizations.size();i++){
			switch(num)
			{
			case 1:{
				if((scienceOrganizations.get(i).getTotalEmployees()>minFactorValue||scienceOrganizations.get(i).getTotalEmployees()==minFactorValue)
						&&(scienceOrganizations.get(i).getTotalEmployees()<maxFactorValue||scienceOrganizations.get(i).getTotalEmployees()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 2:{
				if((scienceOrganizations.get(i).getDoctorEmployees()>minFactorValue||scienceOrganizations.get(i).getDoctorEmployees()==minFactorValue)
						&&(scienceOrganizations.get(i).getDoctorEmployees()<maxFactorValue||scienceOrganizations.get(i).getDoctorEmployees()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 3:{
				if((scienceOrganizations.get(i).getMasterEmployees()>minFactorValue||scienceOrganizations.get(i).getMasterEmployees()==minFactorValue)
						&&(scienceOrganizations.get(i).getMasterEmployees()<maxFactorValue||scienceOrganizations.get(i).getMasterEmployees()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 4:{
				if((scienceOrganizations.get(i).getTotalIts()>minFactorValue||scienceOrganizations.get(i).getTotalIts()==minFactorValue)
						&&(scienceOrganizations.get(i).getTotalIts()<maxFactorValue||scienceOrganizations.get(i).getTotalIts()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 5:{
				if((scienceOrganizations.get(i).getAdvancedIts()>minFactorValue||scienceOrganizations.get(i).getAdvancedIts()==minFactorValue)
						&&(scienceOrganizations.get(i).getAdvancedIts()<maxFactorValue||scienceOrganizations.get(i).getAdvancedIts()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 6:{
				if((scienceOrganizations.get(i).getMiddleIts()>minFactorValue||scienceOrganizations.get(i).getMiddleIts()==minFactorValue)
						&&(scienceOrganizations.get(i).getMiddleIts()<maxFactorValue||scienceOrganizations.get(i).getMiddleIts()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 7:{
				if((scienceOrganizations.get(i).getJuniorIts()>minFactorValue||scienceOrganizations.get(i).getJuniorIts()==minFactorValue)
						&&(scienceOrganizations.get(i).getJuniorIts()<maxFactorValue||scienceOrganizations.get(i).getJuniorIts()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 8:{
				if((scienceOrganizations.get(i).getOtherIts()>minFactorValue||scienceOrganizations.get(i).getOtherIts()==minFactorValue)
						&&(scienceOrganizations.get(i).getOtherIts()<maxFactorValue||scienceOrganizations.get(i).getOtherIts()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 9:{
				if((scienceOrganizations.get(i).getNumGraduates()>minFactorValue||scienceOrganizations.get(i).getNumGraduates()==minFactorValue)
						&&(scienceOrganizations.get(i).getNumGraduates()<maxFactorValue||scienceOrganizations.get(i).getNumGraduates()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 10:{
				if((scienceOrganizations.get(i).getInternalExpenditures()>minFactorValue||scienceOrganizations.get(i).getInternalExpenditures()==minFactorValue)
						&&(scienceOrganizations.get(i).getInternalExpenditures()<maxFactorValue||scienceOrganizations.get(i).getInternalExpenditures()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 11:{
				if((scienceOrganizations.get(i).getRdExpenditures()>minFactorValue||scienceOrganizations.get(i).getRdExpenditures()==minFactorValue)
						&&(scienceOrganizations.get(i).getRdExpenditures()<maxFactorValue||scienceOrganizations.get(i).getRdExpenditures()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 12:{
				if((scienceOrganizations.get(i).getNumIssueAssume()>minFactorValue||scienceOrganizations.get(i).getNumIssueAssume()==minFactorValue)
						&&(scienceOrganizations.get(i).getNumIssueAssume()<maxFactorValue||scienceOrganizations.get(i).getNumIssueAssume()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 13:{
				if((scienceOrganizations.get(i).getAssetsFixed()>minFactorValue||scienceOrganizations.get(i).getAssetsFixed()==minFactorValue)
						&&(scienceOrganizations.get(i).getAssetsFixed()<maxFactorValue||scienceOrganizations.get(i).getAssetsFixed()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 14:{
				if((scienceOrganizations.get(i).getAssetsEquipment()>minFactorValue||scienceOrganizations.get(i).getAssetsEquipment()==minFactorValue)
						&&(scienceOrganizations.get(i).getAssetsEquipment()<maxFactorValue||scienceOrganizations.get(i).getAssetsEquipment()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			case 15:{
				if((scienceOrganizations.get(i).getAssetsImport()>minFactorValue||scienceOrganizations.get(i).getAssetsImport()==minFactorValue)
						&&(scienceOrganizations.get(i).getAssetsImport()<maxFactorValue||scienceOrganizations.get(i).getAssetsImport()==maxFactorValue)){
					scienceOrganization.add(scienceOrganizations.get(i));
				}
				break;
			}
			
			default:break;
			}
		}
		return scienceOrganization;
	}

}
