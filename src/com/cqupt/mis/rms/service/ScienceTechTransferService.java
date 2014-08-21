package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceTechTransfer;
import com.cqupt.mis.rms.model.ScienceTransferLeader;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface ScienceTechTransferService {
	//根据转让ID查找指定技术转让信息
	public ModelInfo<ScienceTechTransfer, ScienceTransferLeader> findScienceTechTransferByTransferId(String transferId);
	//根据用户集合查找与该用户群体相关的技术转让信息。
	public List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> findAllScienceTechTransfer(List<CQUPTUser> CQUPTUsers);
	
	//从指定ScienceTechTransfer集合中筛检出符合条件的ScienceTechTransfer集合
	//筛选字段为字符串类型
	public List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> searchScienceTechTransferByStringFactor(List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfers,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> searchScienceTechTransferByNumFactor(List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfers,String factorName,float minNum,float maxNum);
	//筛选字段为时间类型
	public List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> searchScienceTechTransferByDateFactor(List<ModelInfo<ScienceTechTransfer, ScienceTransferLeader>> scienceTechTransfers,String factorName,Date begin,Date end);

}
