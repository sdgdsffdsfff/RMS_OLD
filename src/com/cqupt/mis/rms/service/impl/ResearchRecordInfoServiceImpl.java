package com.cqupt.mis.rms.service.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.DynamicDataRecordDao;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.ResearchRecordInfoService;

public class ResearchRecordInfoServiceImpl implements ResearchRecordInfoService {
	private DynamicDataRecordDao dynamicDataRecordDao;

	@Override
	public boolean deleteResearchInfo(String[] recordIds, String recordModelName, String memberModelName,
			String dynamicDataModelName, String dynamicDataModelFactorName, String memberFactor,
			String fileBasePath) {
		
		try {
			for(int i = 0; i < recordIds.length; i++){
				String recordId = recordIds[i];
				int status = dynamicDataRecordDao.findStatusByRecordId(recordId, recordModelName);
				boolean result = false;
				//判断科研信息的状态，如果为0（保存状态）或3（审批未通过）则可以删除，否则不能删除。
				if(status == 0 ||status ==3){
					List<Proofs> proofs = dynamicDataRecordDao.findProofByRecordId(recordId);
					dynamicDataRecordDao.deleteMemberInfoByRecordId(recordId, memberModelName, memberFactor);
					dynamicDataRecordDao.deleteProofByRecordId(recordId);
					dynamicDataRecordDao.deleteFieldDataByRecordId(recordId, dynamicDataModelName, dynamicDataModelFactorName);
					result = dynamicDataRecordDao.deleteInfoByRecordId(recordId, recordModelName);	//动态记录的信息必须放在最后删除
					
					for(int j = 0; j < proofs.size(); j++){
						Proofs proof = proofs.get(j);
						String fileName = proof.getUploadRealName();
						String filePath = fileBasePath + proof.getProofPath();
						dynamicDataRecordDao.deleteFile(fileName, filePath);
					}
				}
				//记录未删除返回
				if(result == false) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public DynamicDataRecordDao getDynamicDataRecordDao() {
		return dynamicDataRecordDao;
	}

	public void setDynamicDataRecordDao(DynamicDataRecordDao dynamicDataRecordDao) {
		this.dynamicDataRecordDao = dynamicDataRecordDao;
	}

	
}
