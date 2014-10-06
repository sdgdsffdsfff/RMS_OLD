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
	public boolean deleteField(String className, int fieldId);
		
	/**
	 * 修改字段
	 * @param obj
	 * @return
	 */
	public boolean updateField(Object obj);
		
	/**
	 * 查找所有字段
	 * @param className
	 * @return List<Object>
	 */
	public List<Object> findAllFields(String className);
	
	/**
	 * 根据类名和字段id查找单个字段
	 * @param className
	 * @return Object
	 */
	public Object findFieldByClassNameAndId(String className, int fieldId);
}
