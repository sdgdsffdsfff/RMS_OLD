package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.TeachingMaterialSetNewService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class TeachingMaterialSetNewServiceImpl implements
		TeachingMaterialSetNewService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew> findTeachingMaterialSetByTeachingMaterialId(
			String teachingMaterialId) {
		// TODO Auto-generated method stub
		ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew> teachingMaterialSetInfo = new ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>();
		List<TeachingMaterialEditorNew> teachingMaterialEditors = this.searchDao.SearchObjectsByFactor("TeachingMaterialEditorNew", "teachingMaterialSetNew.teachingMaterialId", teachingMaterialId);
		teachingMaterialSetInfo.setModel((TeachingMaterialSetNew)this.searchDao.SearchUniqueObjectsByFactor("TeachingMaterialSetNew", "teachingMaterialId", teachingMaterialId));
		teachingMaterialSetInfo.setModelList(teachingMaterialEditors);
		return teachingMaterialSetInfo;
	}

	@Override
	public List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> findAllTeachingMaterialSet(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		
		List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> teachingMaterialSetInfos = new ArrayList<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<TeachingMaterialSetNew> teachingMaterialSets = searchDao.SearchObjectsByFactor("TeachingMaterialSetNew", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(TeachingMaterialSetNew teachingMaterialSet:teachingMaterialSets){
					teachingMaterialSetInfos.add(this.findTeachingMaterialSetByTeachingMaterialId(teachingMaterialSet.getTeachingMaterialId()));
				}
			}
			
		return teachingMaterialSetInfos;
		
	}

	@Override
	public List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> searchTeachingMaterialSetByStringFactor(
			List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> teachingMaterialSets, String factorName,
			String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>> teachingMaterialSet = new ArrayList<ModelInfo<TeachingMaterialSetNew, TeachingMaterialEditorNew>>();
		int num = 0;
		if(factorName.equals("teachingMaterialId")){
			num = 1;
		}else if(factorName.equals("setClass")){
			num = 2;
		}else if(factorName.equals("setTime")){
			num = 3;
		}else if(factorName.equals("numberProject")){
			num = 4;
		}else if(factorName.equals("teachingMaterialName")){
			num = 5;
		}else if(factorName.equals("editorName")){
			num = 6;
		}else if(factorName.equals("resultsPostedStatus")){
			num = 7;
		}else if(factorName.equals("submitUser")){
			num = 8;
		}else if(factorName.equals("approvedUser")){
			num = 9;
		}else if(factorName.equals("status")){
			num = 10;
		}else if(factorName.equals("wordsNumbers")){
			num = 11;
		}else if(factorName.equals("remarks")){
			num = 12;
		}else if(factorName.equals("collegeAward")){
			num = 13;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<teachingMaterialSets.size();i++){
			switch(num)
			{
			case 1:{
				if(teachingMaterialSets.get(i).getModel().getTeachingMaterialId().indexOf(factorValue)!=-1){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			
			case 2:{
				if(teachingMaterialSets.get(i).getModel().getSetClass().indexOf(factorValue)!=-1){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			
			case 3:{
				if(teachingMaterialSets.get(i).getModel().getSetTime().indexOf(factorValue)!=-1){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			
			case 4:{
				if(teachingMaterialSets.get(i).getModel().getNumberProject().indexOf(factorValue)!=-1){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			
			case 5:{
				if(teachingMaterialSets.get(i).getModel().getTeachingMaterialName().indexOf(factorValue)!=-1){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			
			case 6:{
				for(int j=0;j<teachingMaterialSets.get(i).getModelList().size();j++){
					if(teachingMaterialSets.get(i).getModelList().get(j).getEditorName().indexOf(factorValue)!=-1){
						teachingMaterialSet.add(teachingMaterialSets.get(i));
						break;
					}
				}
				break;
			}
			
			case 7:{
				if(teachingMaterialSets.get(i).getModel().getResultsPostedStatus().indexOf(factorValue)!=-1){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			
			case 8:{
				if(teachingMaterialSets.get(i).getModel().getSubmitUser()!=null){
					if(teachingMaterialSets.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						teachingMaterialSet.add(teachingMaterialSets.get(i));
					}
				}
				break;
			}
			
			case 9:{
				if(teachingMaterialSets.get(i).getModel().getApprovedUser()!=null){
					if(teachingMaterialSets.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						teachingMaterialSet.add(teachingMaterialSets.get(i));
					}
				}
				break;
			}
			
			case 10:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(teachingMaterialSets.get(i).getModel().getStatus()==status){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			case 11:{
				int wordsNumbers = java.lang.Integer.parseInt(factorValue);
				if(teachingMaterialSets.get(i).getModel().getWordsNumbers()==wordsNumbers){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			case 12:{
				if(teachingMaterialSets.get(i).getModel().getRemarks().indexOf(factorValue)!=-1){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			case 13:{
				float collegeAward = java.lang.Float.parseFloat(factorValue);
				if(teachingMaterialSets.get(i).getModel().getCollegeAward()==collegeAward){
					teachingMaterialSet.add(teachingMaterialSets.get(i));
				}
				break;
			}
			default :break;
			}
		}
		return teachingMaterialSet;
	}

}
