package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.TeachersAwardsData;

/**
 * 教学成果奖信息Data类的比较器
 * @author Bern
 *
 */
public class TeachAchievementsDataComparator implements Comparator<TeachersAwardsData>{

	@Override
	public int compare(TeachersAwardsData o1, TeachersAwardsData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}
	
}
