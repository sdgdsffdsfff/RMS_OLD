package com.cqupt.mis.rms.service;

import java.util.List;

/**
 * 处理教学类信息的Service
 * @author Bern
 *
 */
public interface ViewTeachingInfoService {
	public List<Object> findAllInfoByUserIdAndClassName(String submitUserId,
			String ClassName);
}
