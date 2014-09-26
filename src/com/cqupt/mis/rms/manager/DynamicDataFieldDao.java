package com.cqupt.mis.rms.manager;

import java.util.List;

public interface DynamicDataFieldDao {
	/**
	 * 添加字段
	 * @param obj
	 * @return
	 */
	public boolean addField(Object obj);
		
	/**
	 * 删除字段
	 * @param obj
	 * @return
	 */
	public boolean deleteField(Object obj);
		
	/**
	 * 修改字段
	 * @param obj
	 * @return
	 */
	public boolean updateField(Object obj);
		
	/**
	 * 查找所有字段
	 * @param className
	 * @return
	 */
	public List<Object> findAllFields(String className);
}
