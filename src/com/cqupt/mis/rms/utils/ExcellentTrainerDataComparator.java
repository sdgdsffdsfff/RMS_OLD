package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.ExcellentTrainerData;

/**
 * 优秀培训师获奖信息Data类的比较器
 * @author Bern
 *
 */
public class ExcellentTrainerDataComparator implements Comparator<ExcellentTrainerData> {

	@Override
	public int compare(ExcellentTrainerData o1, ExcellentTrainerData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}
	
}
