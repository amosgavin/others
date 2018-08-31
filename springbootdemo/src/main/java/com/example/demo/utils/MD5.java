package com.example.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static String digest(String inbuf) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(inbuf.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
//			buf.toString();// 32位
//			buf.toString().substring(8, 24));// 16位
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		String text = "20080711000000000000000424221111112010-01-20";
		System.out.println(digest(text));
	}
}
