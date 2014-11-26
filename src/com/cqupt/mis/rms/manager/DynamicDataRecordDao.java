package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.Proofs;

public interface DynamicDataRecordDao {
	/**
	 * 添加记录
	 * @param obj
	 * @return
	 */
	public boolean addRecord(Object obj);
		
	/**
	 * 修改记录
	 * @param obj
	 * @return
	 */
	public boolean updateRecord(Object obj);
		
	/**
	 * 查找所有记录
	 * @param className
	 * @return
	 */
	public <T> List<T> findAllRecords(String className);
	
	/**
	 * 通过类名和记录id查找单条详细记录
	 * @param className
	 * @param recordId
	 */
	public Object findRecordByClassNameAndId(String className, String recordId);
	
	/**
	 * 根据记录id查找记录状态
	 * @param recordId	记录id
	 * @param modelName	记录类名
	 * @return
	 */
	public int findStatusByRecordId(String recordId, String modelName);
	
	/**
	 * 根据记录id查找旁证材料
	 * @param recordId
	 * @return
	 */
	public List<Proofs> findProofByRecordId(String recordId);
	
	/**
	 * 根据记录id删除旁证材料
	 * @param recordId 记录id
	 * @return
	 */
	public boolean deleteProofByRecordId(String recordId);
	
	/**
	 * 根据记录id删除记录
	 * @param recordId 记录id
	 * @param modelName 记录类名
	 * @return
	 */
	public boolean deleteInfoByRecordId(String recordId, String modelName);
	
	/**
	 * 删除旁证材料的文件
	 * @param fileName
	 * @param filePath
	 * @return
	 */
	public boolean deleteFile(String fileName, String filePath);
	
	/**
	 * 根据记录id和动态字段值类名删除动态字段数据
	 * @param recordId 记录id
	 * @param modelName 动态字段值类类名
	 * * @param modelName 动态字段值类记录变量名
	 * @return
	 */
	public boolean deleteFieldDataByRecordId(String recordId, String modelName, String modelFactor);
	
	/**
	 * 根据记录id删除成员信息
	 * @param recordId 记录id
	 * @param memberModelName 成员类类名
	 * @param memberFactor 成员类的record变量名
	 * @return
	 */
	public boolean deleteMemberInfoByRecordId(String recordId, String memberModelName, String memberFactor);
}
