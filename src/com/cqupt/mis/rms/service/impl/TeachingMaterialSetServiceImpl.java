package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.service.TeachingMaterialSetService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class TeachingMaterialSetServiceImpl implements
		TeachingMaterialSetService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<TeachingMaterialSet, TeachingMaterialEditor> findTeachingMaterialSetByTeachingMaterialId(
			String teachingMaterialId) {
		// TODO Auto-generated method stub
		ModelInfo<TeachingMaterialSet, TeachingMaterialEditor> teachingMaterialSetInfo = new ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>();
		List<TeachingMaterialEditor> teachingMaterialEditors = this.searchDao.SearchObjectsByFactor("TeachingMaterialEditor", "teachingMaterialSet.teachingMaterialId", teachingMaterialId);
		teachingMaterialSetInfo.setModel((TeachingMaterialSet)this.searchDao.SearchUniqueObjectsByFactor("TeachingMaterialSet", "teachingMaterialId", teachingMaterialId));
		teachingMaterialSetInfo.setModelList(teachingMaterialEditors);
		return teachingMaterialSetInfo;
	}

	@Override
	public List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> findAllTeachingMaterialSet(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		
		List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> teachingMaterialSetInfos = new ArrayList<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>>();
		List<String> teachingMaterialIds = new ArrayList<String>();
		
		teachingMaterialIds.add("null");
			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<TeachingMaterialEditor> teachingMaterialEditors = searchDao.SearchObjectsByFactor("TeachingMaterialEditor", "editorId", CQUPTUsers.get(i).getUserId());
				
				for (int j = 0; j < teachingMaterialEditors.size(); j++) {
					boolean b = false;
					for (int z = 0; z < teachingMaterialIds.size(); z++) {
						if (teachingMaterialIds.get(z).equals(teachingMaterialEditors.get(j).getTeachingMaterialSet().getTeachingMaterialId())) {
							b = true;
						}	
					}
					if (b == false) {
						teachingMaterialIds.add(teachingMaterialEditors.get(j).getTeachingMaterialSet().getTeachingMaterialId());
					}
				}
			}
			for(int i=1;i<teachingMaterialIds.size();i++){
				teachingMaterialSetInfos.add(this.findTeachingMaterialSetByTeachingMaterialId(teachingMaterialIds.get(i)));
			}
		return teachingMaterialSetInfos;
		
	}

	@Override
	public List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> searchTeachingMaterialSetByStringFactor(
			List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> teachingMaterialSets, String factorName,
			String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> teachingMaterialSet = new ArrayList<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>>();
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
			default :break;
			}
		}
		return teachingMaterialSet;
	}

}
