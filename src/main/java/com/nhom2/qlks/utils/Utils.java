package com.nhom2.qlks.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.nhom2.qlks.hibernate.pojo.User;

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
	
	public String checkRegister(User user) {
		String err_msg = null;
		
		if (user.getHoTen().length() == 0) {
			return err_msg = "Thiếu họ tên";
		}
		
		if (user.getGioiTinh() == null) {
			return err_msg = "Thiếu giới tính";
		}
		
		if (user.getCmnd().length() == 0) {
			return err_msg = "Thiếu số chứng mình nhân dân";
		}
		
		if (user.getEmail().length() == 0) {
			return err_msg = "Thiếu địa chỉ email";
		}
		
		if (user.getSdt().length() == 0) {
			return err_msg = "Thiếu số điện thoại";
		}
		
		if (user.getTenDangNhap().length() == 0) {
			return err_msg = "Thiếu tên username";
		}
		
		if (user.getMatKhau().length() == 0) {
			return err_msg = "Thiếu password";
		}
		
		return err_msg;
	}
}
