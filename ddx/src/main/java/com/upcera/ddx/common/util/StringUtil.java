/**   
 * @Title: StringUtil.java 
 * @Package com.upcera.ddx.common.util 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-9 下午02:41:44 
 * @version V1.0   
 */ 
package com.upcera.ddx.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.upcera.ddx.common.GlobalConstants;


/** 
 * @ClassName: StringUtil 
 * @Description: 字符串工具类 
 * @author ERIC
 * @date 2014-6-9 下午02:41:44 
 *  
 */

public final class StringUtil {
	
	private static final int byteMaxhex = 255;
	private static final Pattern regInteger = Pattern.compile("\\d+");
	private static final Pattern isNumber = Pattern
			.compile("-{0,1}[0-9]+[.]{0,1}[0-9]*");
	private static final Pattern isLowcase = Pattern.compile("[a-z]+");
	private static final Pattern isUppercase = Pattern.compile("[A-Z]+");
	private static final char[] charArray = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * 
	 * @Title: isDigit 
	 * @Description: 字符串是否是数字
	 * @author ERIC 
	 * @date 2014-6-9下午02:43:35
	 * @param @param ch
	 * @param @return
	 * @return boolean true:字符是数字 false:字符不是数字
	 */
	public static boolean isDigit(char ch) {
		int temp = ch & byteMaxhex;
		return temp >= 48 && temp <= 57;
	}

	/**
	 * 
	 * @Title: isDigit 
	 * @Description: 字符串是否是数字串 
	 * @author ERIC 
	 * @date 2014-6-9下午02:44:39
	 * @param @param string
	 * @param @return
	 * @return boolean true:数字 false：非数字
	 */
	public static boolean isDigit(String string) {
		boolean bool = false;
		if (!isEmpty(string)) {
			Matcher matcher = regInteger.matcher(string);
			bool = matcher.matches();
		}
		return bool;
	}

	/**
	 * 
	 * @Title: isLowerCase 
	 * @Description: 字符是否是小写
	 * @author ERIC 
	 * @date 2014-6-9下午02:45:28
	 * @param @param ch
	 * @param @return
	 * @return boolean true:小写字符 false:大写字符
	 */
	public static boolean isLowerCase(char ch) {
		int temp = ch & byteMaxhex;
		return temp >= 97 && temp <= 122;
	}

	/**
	 * 
	 * @Title: isLowerCase 
	 * @Description: 字符串是否是小写字符
	 * @author ERIC 
	 * @date 2014-6-9下午02:46:11
	 * @param @param string
	 * @param @return
	 * @return boolean true:字符串为小写字符串 false:字符串为大写字符串
	 */
	public static boolean isLowerCase(String string) {
		Matcher matcher = isLowcase.matcher(string);
		return matcher.matches();
	}

	/**
	 * 
	 * @Title: isUpperCase 
	 * @Description: 字符是否是大写字符
	 * @author ERIC 
	 * @date 2014-6-9下午02:46:49
	 * @param @param ch
	 * @param @return
	 * @return boolean true:大写字符 false:小写字符
	 */
	public static boolean isUpperCase(char ch) {
		int temp = ch & byteMaxhex;
		return temp >= 65 && temp <= 90;
	}

	/**
	 * 
	 * @Title: isUpperCase 
	 * @Description: 字符串是否是大写字符串
	 * @author ERIC 
	 * @date 2014-6-9下午02:47:26
	 * @param @param string
	 * @param @return
	 * @return boolean true:字符串为大写字符串 false:小写字符串
	 */
	public static boolean isUpperCase(String string) {
		Matcher matcher = isUppercase.matcher(string);
		return matcher.matches();
	}

	/**
	 * 
	 * @Title: toUnsignedString 
	 * @Description: 转换为无符号字符串
	 * @author ERIC 
	 * @date 2014-6-9下午02:48:25
	 * @param @param i
	 * @param @param shift
	 * @param @return
	 * @return String
	 */
	private static String toUnsignedString(long i, int shift) {
		char[] chs = new char[64];
		int charPosition = 64;
		int radix = 1 << shift;
		int value = radix - 1;
		do {
			chs[--charPosition] = charArray[(int) (i & value)];
			i >>>= shift;
		} while (i > 0);
		return new String(chs, charPosition, 64 - charPosition);
	}

	/**
	 * 
	 * @Title: toHexString 
	 * @Description: int值转换为十六进制
	 * @author ERIC 
	 * @date 2014-6-9下午02:48:44
	 * @param @param i
	 * @param @return
	 * @return String
	 */
	public static String toHexString(int i) {
		return toUnsignedString(i, 4);
	}

	/**
	 * 
	 * @Title: toHexString 
	 * @Description: long值转换为十六进制
	 * @author ERIC 
	 * @date 2014-6-9下午02:49:29
	 * @param @param i
	 * @param @return
	 * @return String 十六进制字符串
	 */
	public static String toHexString(long i) {
		return toUnsignedString(i, 4);
	}

	/**
	 * 
	 * @Title: toOctalString 
	 * @Description: int值转换为八进制
	 * @author ERIC 
	 * @date 2014-6-9下午02:50:03
	 * @param @param i
	 * @param @return
	 * @return String 八进制字符串
	 */
	public static String toOctalString(int i) {
		return toUnsignedString(i, 3);
	}

	/**
	 * 
	 * @Title: toOctalString 
	 * @Description: long值转换为八进制
	 * @author ERIC 
	 * @date 2014-6-9下午02:50:36
	 * @param @param i
	 * @param @return
	 * @return String 八进制字符串
	 */
	public static String toOctalString(long i) {
		return toUnsignedString(i, 3);
	}

	/**
	 * 
	 * @Title: toBinaryString 
	 * @Description: int值转换为二进制
	 * @author ERIC 
	 * @date 2014-6-9下午02:51:09
	 * @param @param i
	 * @param @return
	 * @return String 二进制字符串
	 */
	public static String toBinaryString(int i) {
		return toUnsignedString(i, 1);
	}

	/**
	 * 
	 * @Title: toBinaryString 
	 * @Description: long值转换为二进制
	 * @author ERIC 
	 * @date 2014-6-9下午02:51:42
	 * @param @param i
	 * @param @return
	 * @return String 二进制字符串
	 */
	public static String toBinaryString(long i) {
		return toUnsignedString(i, 1);
	}

	/**
	 * 
	 * @Title: isNull 
	 * @Description: 判断对象是否为Null
	 * @author ERIC 
	 * @date 2014-6-9下午02:52:09
	 * @param @param obj
	 * @param @return
	 * @return boolean
	 */
	public static boolean isNull(Object obj) {
		return null == obj;
	}

	/**
	 * 
	 * @Title: isEmpty 
	 * @Description: 判断对象是否为空或空字符串
	 * @author ERIC 
	 * @date 2014-6-9下午02:53:12
	 * @param @param obj
	 * @param @return
	 * @return boolean true:空	false:非空
	 */
	public static boolean isEmpty(Object obj) {
		boolean bool = true;
		if (null != obj) {
			if (obj instanceof String) {
				if (!"".equals(obj.toString().trim())) {
					bool = false;
				}
			} else {
				bool = false;
			}
		}
		return bool;
	}

	/**
	 * 
	 * @Title: getUniqueId 
	 * @Description: 产生唯一ID
	 * @author ERIC 
	 * @date 2014-6-9下午02:54:17
	 * @param @param param
	 * @param @return
	 * @return String
	 */
	public static String getUniqueId(String param) {
		if (null != param) {
			param = param + System.currentTimeMillis();
		}
		return param;
	}

	/**
	 * 
	 * @Title: excNullToString 
	 * @Description: 处理Null或空字符串
	 * @author ERIC 
	 * @date 2014-6-9下午02:54:45
	 * @param @param string
	 * @param @return
	 * @return String
	 */
	public static String excNullToString(String string) {
		return excNullToString(string, GlobalConstants.EMPTY_STRING);
	}

	/**
	 * 
	 * @Title: excNullToString 
	 * @Description: 处理Null或空字符串
	 * @author ERIC 
	 * @date 2014-6-9下午02:55:22
	 * @param @param string
	 * @param @param added
	 * @param @return
	 * @return String
	 */
	public static String excNullToString(String string, String added) {
		if (isNull(string)) {
			string = added;
		}
		return string;
	}

	/**
	 * 
	 * @Title: excNullToObject 
	 * @Description: 处理Null或空对象
	 * @author ERIC 
	 * @date 2014-6-9下午02:55:41
	 * @param @param obj
	 * @param @return
	 * @return Object
	 */
	public static Object excNullToObject(Object obj) {
		return excNullToObject(obj, new Object());
	}

	/**
	 * 
	 * @Title: excNullToObject 
	 * @Description: 处理Null或空对象
	 * @author ERIC 
	 * @date 2014-6-9下午02:56:50
	 * @param @param obj
	 * @param @param added
	 * @param @return
	 * @return Object
	 */
	public static Object excNullToObject(Object obj, Object added) {
		if (isNull(obj)) {
			obj = added;
		}
		return obj;
	}

	/**
	 * 
	 * @Title: stringToInt 
	 * @Description: 将字符串转换成整数类型，如果为空则转换成0
	 * @author ERIC 
	 * @date 2014-6-9下午02:57:08
	 * @param @param string
	 * @param @return
	 * @return int
	 */
	public static Integer stringToInt(String string) {
		return stringToInt(string, GlobalConstants.NUM_0);
	}
	
	/**
	 * 
	 * @Title: stringToInteger
	 * @Description: 将字符串转换成整数类型，如果为空则转换成null
	 * @author ERIC 
	 * @date 2014-6-9下午02:57:08
	 * @param @param string
	 * @param @return
	 * @return int
	 */
	public static Integer stringToInteger(String string) {
		Integer result = null;
		try {
			result = Integer.parseInt(string);
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 
	 * @Title: stringToInt 
	 * @Description: 将字符串转换成整数类型，如果为空则转换成指定值
	 * @author ERIC 
	 * @date 2014-6-9下午02:57:32
	 * @param @param string
	 * @param @param added
	 * @param @return
	 * @return int
	 */
	public static Integer stringToInt(String string, int added) {
		int result = 0;
		try {
			result = Integer.parseInt(string);
		} catch (Exception e) {
			result = added;
			// log.info("Parameter string is empty or is digital type, default to int。");
		}
		return result;
	}

	/**
	 * 
	 * @Title: stringToLong 
	 * @Description: 将字符串转换成Long类型，如果为空则转换成0
	 * @author ERIC 
	 * @date 2014-6-9下午02:58:24
	 * @param @param string
	 * @param @return
	 * @return long
	 */
	public static Long stringToLong(String string) {
		return stringToLong(string, GlobalConstants.NUM_0);
	}
	
	/**
	 * 
	 * @Title: stringToLong2
	 * @Description: 将字符串转换成Long类型，如果为空则转换成null
	 * @author ERIC 
	 * @date 2014-6-9下午02:58:24
	 * @param @param string
	 * @param @return
	 * @return long
	 */
	public static Long stringToLong2(String string) {
		Long result = null;
		try {
			result = Long.parseLong(string);
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 
	 * @Title: stringToLong 
	 * @Description: 将字符串转换成Long类型，如果为空则转换成指定值
	 * @author ERIC 
	 * @date 2014-6-9下午03:00:22
	 * @param @param string
	 * @param @param added
	 * @param @return
	 * @return long
	 */
	public static Long stringToLong(String string, long added) {
		long result = 0;
		try {
			result = Long.parseLong(string);
		} catch (Exception e) {
			result = added;
			// log.info("Parameter string is empty or is digital type, default to long。");
		}
		return result;
	}

	/**
	 * 
	 * @Title: stringToFloat 
	 * @Description: 将字符串转换成float类型
	 * @author ERIC 
	 * @date 2014-6-9下午03:01:41
	 * @param @param string
	 * @param @return
	 * @return float
	 */
	public static float stringToFloat(String string) {
		return stringToFloat(string, 0.0f);
	}

	/**
	 * 
	 * @Title: stringToFloat 
	 * @Description: 将字符串转换成float类型,如果为空则转为指定的值
	 * @author ERIC 
	 * @date 2014-6-9下午03:01:58
	 * @param @param string
	 * @param @param added
	 * @param @return
	 * @return float
	 */
	public static float stringToFloat(String string, float added) {
		float result = 0.0f;
		try {
			result = Float.parseFloat(string);
		} catch (Exception e) {
			result = added;
			// log.info("Parameter string is empty or is digital type, default to float。");
		}
		return result;
	}

	/**
	 * 
	 * @Title: stringToDouble 
	 * @Description: 将字符串转换成double类型,如果为空则转为指定的值
	 * @author ERIC 
	 * @date 2014-6-9下午03:02:16
	 * @param @param string
	 * @param @return
	 * @return double
	 */
	public static double stringToDouble(String string) {
		return stringToDouble(string, 0.0d);
	}

	/**
	 * 
	 * @Title: stringToDouble 
	 * @Description: 将字符串转换成double类型,如果为空则转为指定的值
	 * @author ERIC 
	 * @date 2014-6-9下午03:02:32
	 * @param @param string
	 * @param @param added
	 * @param @return
	 * @return double
	 */
	public static double stringToDouble(String string, double added) {
		double result = 0.0d;
		try {
			result = Double.parseDouble(string);
		} catch (Exception e) {
			result = added;
			// log.info("Parameter string is empty or is digital type, default to double。");
		}
		return result;
	}

	/**
	 * 
	 * @Title: isNumbers 
	 * @Description: 判断是否为数值类型（整数、小数、负数）
	 * @author ERIC 
	 * @date 2014-6-9下午03:02:53
	 * @param @param string
	 * @param @return
	 * @return boolean
	 */
	public static boolean isNumbers(String string) {
		boolean bool = false;
		try {
			Matcher matcher = isNumber.matcher(string);
			bool = matcher.matches();
		} catch (Exception e) {
//			log.error("参数字符串为空！", e);
		}
		return bool;
	}

	/**
	 * 
	 * @Title: stringUncode 
	 * @Description: 将Unicode编码转换为正常字符
	 * @author ERIC 
	 * @date 2014-6-9下午03:03:13
	 * @param @param param
	 * @param @return
	 * @return String
	 */
	public static String stringUncode(String param) {
		if (param != null && !param.trim().equals("")) {
			try {
				param = URLDecoder.decode(param, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return param;
	}

	/**
	 * 
	 * @Title: stringEncode 
	 * @Description: 将字符转换为Unicode编码
	 * @author ERIC 
	 * @date 2014-6-9下午03:03:40
	 * @param @param param
	 * @param @return
	 * @return String
	 */
	public static String stringEncode(String param) {
		if (param != null && !param.trim().equals("")) {
			try {
				param = URLEncoder.encode(param, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return param;
	}

	/**
	 * 
	 * @Title: parseBoolean 
	 * @Description: 将Object对象转换为boolean 判断是否为空，为空在则返回false
	 * @author ERIC 
	 * @date 2014-6-9下午03:04:06
	 * @param @param str
	 * @param @return
	 * @return boolean
	 */
	public static boolean parseBoolean(String str) {
		boolean bool = false;
		if (str != null && !"".equals(str.trim())) {
			bool = Boolean.parseBoolean(str);
		}
		return bool;
	}

	/**
	 * 
	 * @Title: parseBoolean 
	 * @Description: 将Object对象转换为boolean 判断是否为空，为空在则返回false
	 * @author ERIC 
	 * @date 2014-6-9下午03:04:28
	 * @param @param obj
	 * @param @return
	 * @return boolean
	 */
	public static boolean parseBoolean(Object obj) {
		boolean bool = false;
		if (obj != null) {
			bool = parseBoolean(obj.toString());
		}
		return bool;
	}

	/**
	 * 
	 * @Title: toUtf8 
	 * @Description: 将参数转换为UTF-8编码 <根据不同浏览器处理方式不一样>
	 * @author ERIC 
	 * @date 2014-6-9下午03:05:16
	 * @param @param param
	 * @param @return
	 * @return String
	 */
	public static String toUtf8(String param) {
		try {
			param = new String(param.getBytes("UTF-8"), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return param;
	}

	/**
	 * 
	 * @Title: toGbk 
	 * @Description: 将参数转换为GBK编码 <根据不同浏览器处理方式不一样>
	 * @author ERIC 
	 * @date 2014-6-9下午03:06:17
	 * @param @param param
	 * @param @return
	 * @return String
	 */
	public static String toGbk(String param) {
		try {
			param = new String(param.getBytes("GBK"), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return param;
	}

	/**
	 * 
	 * @Title: reversal 
	 * @Description: 将字符串字母全部反转
	 * @author ERIC 
	 * @date 2014-6-9下午03:07:12
	 * @param @param param
	 * @param @return
	 * @return String
	 */
	public static String reversal(String param) {
		if (param != null && param.length() > 1) {
			StringBuffer sb = new StringBuffer();
			String[] str = param.split("");
			for (int i = (str.length - 1); i >= 0; i--) {
				sb.append(str[i]);
			}
			param = sb.toString();
		}
		return param;
	}

	/**
	 * 
	 * @Title: replaceEnter 
	 * @Description: 将字符串中包含的回车换行符\n 替换成"< b r >"
	 * @author ERIC 
	 * @date 2014-6-9下午03:07:56
	 * @param @param content
	 * @param @return
	 * @return String
	 */
	public static String replaceEnter(String content) {
		if (content != null) {
			content = content.replaceAll("\n", "<BR>");
		}
		return content;
	}

	/**
	 * 
	 * @Title: replaceBr 
	 * @Description: 将字符串中包含的"< b r >" 替换成回车换行符\n
	 * @author ERIC 
	 * @date 2014-6-9下午03:08:19
	 * @param @param content
	 * @param @return
	 * @return String
	 */
	public static String replaceBr(String content) {
		if (content != null) {
			content = content.replaceAll("<BR>", "\n");
			content = content.replaceAll("<br>", "\n");
		}
		return content;
	}

	/**
	 * 
	 * @Title: firstCharToUpperCase 
	 * @Description: 将字符串首字母转为大写字母
	 * @author ERIC 
	 * @date 2014-6-9下午03:08:43
	 * @param @param content
	 * @param @return
	 * @return String
	 */
	public static String firstCharToUpperCase(String content) {
		if (!isEmpty(content)) {
			String tou = content.substring(0, 1);
			String wei = content.substring(1);
			content = tou.toUpperCase() + wei;
		}
		return content;
	}

	/**
	 * 
	 * @Title: firstCharToLowerCase 
	 * @Description: 将字符串首字母转为小写字母
	 * @author ERIC 
	 * @date 2014-6-9下午03:09:27
	 * @param @param content
	 * @param @return
	 * @return String
	 */
	public static String firstCharToLowerCase(String content) {
		if (!isEmpty(content)) {
			String tou = content.substring(0, 1);
			String wei = content.substring(1);
			content = tou.toLowerCase() + wei;
		}
		return content;
	}

	/**
	 * 
	 * @Title: hex2byte 
	 * @Description: 反格式化byte
	 * @author ERIC 
	 * @date 2014-6-9下午03:10:29
	 * @param @param s
	 * @param @return
	 * @return byte[]
	 */
	public static byte[] hex2byte(String s) {
		byte[] src = s.toLowerCase().getBytes();
		byte[] ret = new byte[src.length / 2];
		for (int i = 0; i < src.length; i += 2) {
			byte hi = src[i];
			byte low = src[i + 1];
			hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a')
					: hi - '0');
			low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a')
					: low - '0');
			ret[i / 2] = (byte) (hi << 4 | low);
		}
		return ret;
	}

	/**
	 * 
	 * @Title: byte2hex 
	 * @Description: 格式化byte
	 * @author ERIC 
	 * @date 2014-6-9下午03:10:50
	 * @param @param b
	 * @param @return
	 * @return String
	 */
	public static String byte2hex(byte[] b) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] out = new char[b.length * 2];
		for (int i = 0; i < b.length; i++) {
			byte c = b[i];
			out[i * 2] = Digit[(c >>> 4) & 0X0F];
			out[i * 2 + 1] = Digit[c & 0X0F];
		}
		return new String(out);
	}
	
	/**
	 * @Description:把数组转换为一个用逗号分隔的字符串 ，以便于用in+String 查询
	 */
	public static String converToString(String[] ig) {
		String str = "";
		if (ig != null && ig.length > 0) {
			for (int i = 0; i < ig.length; i++) {
				str += ig[i] + ",";
			}
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}

	/**
	 * @Description:把list转换为一个用逗号分隔的字符串
	 */
	public static String listToString(List list) {
		StringBuilder sb = new StringBuilder();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1) {
					sb.append(list.get(i) + ",");
				} else {
					sb.append(list.get(i));
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * @Title: main 
	 * @Description: 主函数
	 * @author ERIC 
	 * @date 2014-6-9下午03:11:02
	 * @param @param args
	 * @return void
	 */
	public static void main(String[] args) {
		System.out.println(reversal("sadda"));
	}


}
