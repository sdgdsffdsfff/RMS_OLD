package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.TeachingMaterialData;

/**
 * 教材立项信息Data类的比较器
 * @author Bern
 *
 */
public class TeachingMaterialDataComparator implements Comparator<TeachingMaterialData> {

	@Override
	public int compare(TeachingMaterialData o1, TeachingMaterialData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}

}
