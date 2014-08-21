package com.cqupt.mis.rms.test;

import com.cqupt.mis.rms.utils.EncryptUtils;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String uPass = EncryptUtils.setUPassEncrypt("admin");
		System.out.println(uPass);
	}

}
