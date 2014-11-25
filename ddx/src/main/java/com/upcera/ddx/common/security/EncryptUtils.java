/**   
 * @Title: EncryptUtils.java 
 * @Package com.upcera.ddx.common.security 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-9 下午04:44:06 
 * @version V1.0   
 */ 
package com.upcera.ddx.common.security;

import java.security.MessageDigest;

import com.upcera.ddx.common.util.StringUtil;

/** 
 * @ClassName: EncryptUtils 
 * @Description: 加密工具类
 * @author ERIC
 * @date 2014-6-9 下午04:44:06 
 *  
 */

public class EncryptUtils {
	
	/**
	 * 
	 * <p>Title: EncryptUtils</p> 
	 * <p>Description: 默认构造器</p>
	 */
	private EncryptUtils() {

	}

	/**
	 * 
	 * @Title: md5 
	 * @Description: 使用md5加密
	 * @author ERIC 
	 * @date 2014-6-9下午04:51:34
	 * @param @param sourceStr 待加密的字符串
	 * @param @return
	 * @return String 加密后的字符串
	 */
	public static String md5(String sourceStr) {
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
	 * @Title: toHexString 
	 * @Description: 将源字符串转换为十六进制数字的字符串
	 * @author ERIC 
	 * @date 2014-6-9下午04:53:18
	 * @param @param sourceStr
	 * @param @return
	 * @return String
	 */
	public static String toHexString(String sourceStr) {
		if (StringUtil.isEmpty(sourceStr)) {
			return sourceStr;
		}
		StringBuffer strBuff = new StringBuffer("");
		for (char ch : sourceStr.toCharArray()) {
			strBuff.append(StringUtil.toHexString(ch));
		}
		return strBuff.toString();
	}

}
