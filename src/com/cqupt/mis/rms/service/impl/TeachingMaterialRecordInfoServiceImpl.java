package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialData;
import com.cqupt.mis.rms.model.TeachingMaterialRecord;
import com.cqupt.mis.rms.model.TeachingRecordEditor;
import com.cqupt.mis.rms.service.TeachingMaterialRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找教材立项信息的Service实现
 * @author Bern
 *
 */
public class TeachingMaterialRecordInfoServiceImpl implements TeachingMaterialRecordInfoService{
	//注入Dao层
	private SearchDao searchDao;
	
	@Override
	public ModelInfo<TeachingMaterialRecord, TeachingRecordEditor> findTeachingMaterialRecordInfoByAwardsId(
			String recordId) {
		ModelInfo<TeachingMaterialRecord, TeachingRecordEditor> teachingMaterialRecordInfo = new ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>();
		//查找recordId相应的教材立项的作者集合
		List<TeachingRecordEditor> teachingRecordEditors = this.searchDao.SearchObjectsByFactor("TeachingRecordEditor", "teachingMaterialRecord.id", recordId);
		//查找recordId相应的教材立项记录集合,并设置到模型中
		teachingMaterialRecordInfo.setModel((TeachingMaterialRecord)this.searchDao.SearchUniqueObjectsByFactor("TeachingMaterialRecord", "id", recordId));
		teachingMaterialRecordInfo.setModelList(teachingRecordEditors);
		return teachingMaterialRecordInfo;
	}

	@Override
	public List<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>> findAllTeachingMaterialRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>> teachingMaterialRecordInfos = new ArrayList<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>>();
		List<String> awardsIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的教材立项记录Id集合
		 */
		awardsIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<TeachingRecordEditor> teachingRecordEditors = searchDao.SearchObjectsByFactor("TeachingRecordEditor", "editorId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<teachingRecordEditors.size(); j++) {
				boolean b = false;
				for (int z=0; z<awardsIds.size(); z++) {
					if (awardsIds.get(z).equals(teachingRecordEditors.get(j).getTeachingMaterialRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					awardsIds.add(teachingRecordEditors.get(j).getTeachingMaterialRecord().getId());
				}
			}
		}
		
		/*
		 * 通过已查找的记录id来查找相应的教材立项信息记录
		 */
		for(int i=1; i<awardsIds.size(); i++){
			teachingMaterialRecordInfos.add(this.findTeachingMaterialRecordInfoByAwardsId(awardsIds.get(i)));
		}
		return teachingMaterialRecordInfos;
	}

	@Override
	public List<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>> searchTeachingMaterialRecordInfoByStringFactor(
			List<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>> teachingMaterialRecordInfos,
			String factorName, String factorValue) {
		List<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>> returnTeachingMaterialRecordInfos = new ArrayList<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>>();
		int num = 0;
		//判断查找的是哪个字段
		if("recordId".equals(factorName)) {
			num = 1;
		} else if ("recordName".equals(factorName)) {
			num = 2;
		} else if("status".equals(factorName)) {	
			num = 3;
		} else if("submitUser".equals(factorName)) {
			num = 4;
		} else if("approvedUser".equals(factorName)) {
			num = 5;
		} else {		//动态字段
			num = 6;
		}
		
		for(int i=0; i<teachingMaterialRecordInfos.size(); i++){
			switch(num)
			{
			case 1:{
				if(teachingMaterialRecordInfos.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnTeachingMaterialRecordInfos.add(teachingMaterialRecordInfos.get(i));
				}
				break;
			}
			case 2:{
				if(teachingMaterialRecordInfos.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnTeachingMaterialRecordInfos.add(teachingMaterialRecordInfos.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(teachingMaterialRecordInfos.get(i).getModel().getStatus() == status){
					returnTeachingMaterialRecordInfos.add(teachingMaterialRecordInfos.get(i));
				}
				break;
			}
			case 4:{
				if(teachingMaterialRecordInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnTeachingMaterialRecordInfos.add(teachingMaterialRecordInfos.get(i));
				}
				break;
			}
			case 5:{
				if(teachingMaterialRecordInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnTeachingMaterialRecordInfos.add(teachingMaterialRecordInfos.get(i));
				}
				break;
			}
			case 6:{
				Set<TeachingMaterialData> fields = teachingMaterialRecordInfos.get(i).getModel().getFields();
				for(TeachingMaterialData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnTeachingMaterialRecordInfos.add(teachingMaterialRecordInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnTeachingMaterialRecordInfos;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
}
