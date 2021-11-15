package com.nhom2.qlks.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Utils {
	public String strToMD5(String str) {
		String hashtext = null;
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(str.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashtext = bigInt.toString(16);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return hashtext;
	}
}
