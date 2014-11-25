/**   
 * @Title: MD5Encrypt.java 
 * @Package com.upcera.ddx.common.security 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-9 下午04:44:18 
 * @version V1.0   
 */ 
package com.upcera.ddx.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/** 
 * @ClassName: MD5Encrypt 
 * @Description: MD5加/解密工具类
 * @author ERIC
 * @date 2014-6-9 下午04:44:18 
 *  
 */

public class MD5Encrypt {

	private static MD5Encrypt md5 = new MD5Encrypt();

	/**
	 * 
	 * <p>Title: MD5Encrypt</p> 
	 * <p>Description: 默认的空构造器</p>
	 */
	private MD5Encrypt() {

	}

	/**
	 * 
	 * @Title: getInstance 
	 * @Description: 获取MD5工具类实例
	 * @author ERIC 
	 * @date 2014-6-9下午04:56:29
	 * @param @return
	 * @return MD5Encrypt
	 */
	public static MD5Encrypt getInstance() {
		return md5;
	}

	/**
	 * 
	 * @Title: encrypt 
	 * @Description: MD5解密不了
	 * @author ERIC 
	 * @date 2014-6-9下午04:57:13
	 * @param @param sourceStr
	 * @param @return
	 * @return String
	 */
	public String encrypt(String sourceStr) {
		MessageDigest md;
		String encryptString = "";
		byte[] bytes = null;
		try {
			md = MessageDigest.getInstance("MD5");
			bytes = md.digest(sourceStr.getBytes());
			encryptString = new String(bytes, "UTF-8");
		} catch (Exception e) {
			encryptString = sourceStr;
		}
		return encryptString;
	}

	/**
	 * 
	 * @Title: md5 
	 * @Description:  MD5加密
	 * @author ERIC 
	 * @date 2014-6-9下午04:57:52
	 * @param @param plainText 需要加密的字符串
	 * @param @param number 加密位16,32
	 * @param @return
	 * @return String 已加密字符串
	 */
	public String md5(String plainText, int number) {
		String result = plainText;
		if (plainText != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(plainText.getBytes());
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
				if (number == 16) {// 16位的加密
					result = buf.toString().substring(8, 24);
				} else if (number == 32) {// 32位的加密
					result = buf.toString();
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(MD5Encrypt.getInstance().md5("a123456", 32));
	}
	
}
