package com.cqupt.mis.rms.manager;

import java.util.List;

/**
 * 处理查找教学类信息的接口
 * @author Bern
 * 2014.09.28
 */
public interface SearchTeachingInfoDao {
	/**
	 * 根据类名和提交者ID查找相应的信息
	 */
	public List<Object> findAllInfoByUserIdAndClassName(String submitUserId,
			String ClassName);
	
}
