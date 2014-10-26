package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.StudentAwardsData;

/**
 * 学生获奖信息Data类的比较器
 * @author Bern
 *
 */
public class StudentAwardsDataComparator implements Comparator<StudentAwardsData> {

	@Override
	public int compare(StudentAwardsData o1, StudentAwardsData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}
	
}
