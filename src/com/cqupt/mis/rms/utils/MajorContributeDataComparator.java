package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.MajorContributeData;

/**
 * 专业建设信息Data类的比较器
 * @author Bern
 *
 */
public class MajorContributeDataComparator implements Comparator<MajorContributeData> {
	
	@Override
	public int compare(MajorContributeData o1, MajorContributeData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}
}
