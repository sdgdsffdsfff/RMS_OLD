package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.OtherTeachingAwardsData;

/**
 * 其他教学奖励信息Data类的比较器
 * @author Bern
 *
 */
public class OtherTeachingAwardsDataComparator implements Comparator<OtherTeachingAwardsData> {

	@Override
	public int compare(OtherTeachingAwardsData o1, OtherTeachingAwardsData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}

}
