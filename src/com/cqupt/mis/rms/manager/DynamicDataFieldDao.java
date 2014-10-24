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
	
	/**
	 * 根据类名查找其所对应的字段总数
	 * @param className
	 * @return 字段总数
	 */
	public int countField(String className);
	
	/**
	 * 将order字段重新排序
	 * @param className	字段类名
	 * @param beginOrder 起始排序值
	 * @param endOrder	结束的排序值
	 * @param add 修改介于beginOrder和endOrder值之间的字段。如果为true，每个加1；如果为false，每个减1
	 * @return
	 */
	public boolean updateOrder(String className, int beginorder, int endOrder, boolean add);
}
