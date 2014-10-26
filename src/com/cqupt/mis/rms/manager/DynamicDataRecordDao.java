package com.cqupt.mis.rms.manager;

import java.util.List;

public interface DynamicDataRecordDao {
	/**
	 * 添加记录
	 * @param obj
	 * @return
	 */
	public boolean addRecord(Object obj);
		
	/**
	 * 删除记录
	 * @param obj
	 * @return
	 */
	public boolean deleteRecord(Object obj);
		
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
}
