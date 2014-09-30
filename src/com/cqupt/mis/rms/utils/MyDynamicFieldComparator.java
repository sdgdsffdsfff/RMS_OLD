package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.StudentAwardsData;

/**
 * 自定义的比较器
 * @author Bern
 *
 */
public class MyDynamicFieldComparator implements Comparator<StudentAwardsData> {

	@Override
	public int compare(StudentAwardsData o1, StudentAwardsData o2) {
		if(o1.getField().getId() > o2.getField().getId()) {
			return 1;
		} else if(o1.getField().getId() == o2.getField().getId()) {
			return 0;
		} else {
			return -1;
		}
	}
}
