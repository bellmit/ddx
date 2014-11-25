/**   
 * @Title: DateUtil.java 
 * @Package com.upcera.ddx.common.util 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-9 下午02:38:21 
 * @version V1.0   
 */ 
package com.upcera.ddx.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.upcera.ddx.common.GlobalConstants;


/** 
 * @ClassName: DateUtil 
 * @Description: 日期时间工具类 
 * @author ERIC
 * @date 2014-6-9 下午02:38:21 
 *  
 */

public final class DateUtil {

	/**
	 * SimpleDateFormat日期+时间格式yyyy-MM-dd HH:mm:ss
	 */
	public static  SimpleDateFormat SDF_DATETIME = new SimpleDateFormat(
			GlobalConstants.PATTERN_DATE_TIME);
	/**
	 * SimpleDateFormat日期格式yyyy-MM-dd
	 */
	public static  SimpleDateFormat SDF_DATE = new SimpleDateFormat(
			GlobalConstants.PATTERN_DATE);

	/**
	 * 
	 * @Title: parse 
	 * @Description: 将时间日期字符串转换为Date类型 
	 * @author ERIC 
	 * @date 2014-6-9下午03:13:34
	 * @param @param dateStr
	 * @param @return
	 * @return Date
	 */
	public static Date parse(String dateStr) {
		return parse(dateStr, null);
	}

	/**
	 * 
	 * @Title: parse 
	 * @Description: 将时间日期字符串转换为指定格式的Date类型
	 * @author ERIC 
	 * @date 2014-6-9下午03:14:01
	 * @param @param dateStr
	 * @param @param pattern
	 * @param @return
	 * @return Date
	 */
	public static Date parse(String dateStr, String pattern) {
		Date date = null;
		if (null != dateStr) {
			try {
				if (dateStr.length() < 12) {
					dateStr += " 00:00:00";
				}
				if (pattern != null) {
					SimpleDateFormat sim = new SimpleDateFormat(pattern);
					date = sim.parse(dateStr);
				} else {
					date = SDF_DATETIME.parse(dateStr);
				}
			} catch (ParseException e) {
//				log.error("时间格式转换失败！", e);
			}
		} else {
//			log.error("字符串为空：dateStr=" + dateStr);
		}
		return date;
	}

	/**
	 * 
	 * @Title: format 
	 * @Description: 将Date格式化为正规日期时间字符串
	 * @author ERIC 
	 * @date 2014-6-9下午03:17:47
	 * @param @param date
	 * @param @return
	 * @return String
	 */
	public static String format(Date date) {
		return format(date, null);
	}

	/**
	 * 
	 * @Title: format 
	 * @Description: 将Date格式化为指定格式日期时间字符串
	 * @author ERIC 
	 * @date 2014-6-9下午03:20:08
	 * @param @param date
	 * @param @param pattern
	 * @param @return
	 * @return String
	 */
	public static String format(Date date, String pattern) {
		String dateStr = null;
		if (date != null) {
			try {
				if (pattern != null) {
					SimpleDateFormat sim = new SimpleDateFormat(pattern);
					dateStr = sim.format(date);
				} else {
					dateStr = SDF_DATETIME.format(date);
				}
			} catch (Exception e) {
//				log.error("时间格式化字符串失败！", e);
			}
		} else {
//			log.error("Date参数为空：date=" + date);
		}
		return dateStr;
	}

	/**
	 *  
	 * @Title: parseToTimestamp 
	 * @Description: 将时间字符串转换成指定时间格式的时戳
	 * @author ERIC 
	 * @date 2014-6-9下午03:20:21
	 * @param @param dateStr
	 * @param @param pattern
	 * @param @return
	 * @return Timestamp
	 */
	public static Timestamp parseToTimestamp(String dateStr, String pattern) {
		Timestamp tmp = null;
		// 判断字符串是否为空
		if (StringUtil.isEmpty(dateStr) || StringUtil.isEmpty(pattern)) {
			throw new IllegalArgumentException("The parameter is null.");
		}
		// 构造SimpleDateFormat对象
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			tmp = new Timestamp(sdf.parse(dateStr).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	/**
	 * 
	 * @Title: parseToTimestamp 
	 * @Description: 将时间字符串转换成指定时间格式的时戳
	 * @author ERIC 
	 * @date 2014-6-9下午03:21:07
	 * @param @param dateStr
	 * @param @return
	 * @return Timestamp
	 */
	public static Timestamp parseToTimestamp(String dateStr) {
		return parseToTimestamp(dateStr, GlobalConstants.PATTERN_DATE_TIME);
	}

	/**
	 * 
	 * @Title: getAgeByDate 
	 * @Description: 根据出生日期计算标准年龄
	 * @author ERIC 
	 * @date 2014-6-9下午03:22:07
	 * @param @param birthDate
	 * @param @return
	 * @return int
	 */
	public static int getAgeByDate(Date birthDate) {
		Date day = new Date();
		int age = day.getYear() - birthDate.getYear();
		birthDate.setYear(birthDate.getYear() + age);
		age = birthDate.getTime() - day.getTime() > 0 ? age - 1 : age;
		return age;
	}

	/**
	 * 
	 * @Title: getWeekByDate 
	 * @Description: 计算当前日期在当前年份中是第几周
	 * @author ERIC 
	 * @date 2014-6-9下午03:22:31
	 * @param @return
	 * @return int
	 */
	public static int getWeekByDate() {
		return getWeekByDate(new Date());
	}

	/**
	 * 
	 * @Title: getWeekByDate 
	 * @Description: 计算指定日期在当前年份中是第几周
	 * @author ERIC 
	 * @date 2014-6-9下午03:22:51
	 * @param @param date
	 * @param @return
	 * @return int
	 */
	public static int getWeekByDate(Date date) {
		SimpleDateFormat sim = new SimpleDateFormat("w");
		String wk = sim.format(date);
		return StringUtil.stringToInt(wk, -1);
	}

	/**
	 * 
	 * @Title: getAgeByDateStr 
	 * @Description: 根据出生日期字符串计算标准年龄
	 * @author ERIC 
	 * @date 2014-6-9下午03:23:18
	 * @param @param birthDateStr
	 * @param @return
	 * @return int
	 */
	public static int getAgeByDateStr(String birthDateStr) {
		Date birthDate = parse(birthDateStr, "yyyy-MM-dd");
		return getAgeByDate(birthDate);
	}

	/**
	 * 
	 * @Title: getBeforeOrAfterDateByDayNumber 
	 * @Description: 获取当前日期前后N天日期Date
	 * @author ERIC 
	 * @date 2014-6-9下午03:23:33
	 * @param @param dayNumber
	 * @param @return
	 * @return Date
	 */
	public static Date getBeforeOrAfterDateByDayNumber(int dayNumber) {
		return getBeforeOrAfterDateByDayNumber(new Date(), dayNumber);
	}

	/**
	 * 
	 * @Title: getBeforeOrAfterDateByDayNumber 
	 * @Description: 获取指定日期前后N天日期Date
	 * @author ERIC 
	 * @date 2014-6-9下午03:23:52
	 * @param @param date
	 * @param @param dayNumber
	 * @param @return
	 * @return Date
	 */
	public static Date getBeforeOrAfterDateByDayNumber(Date date, int dayNumber) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, dayNumber);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getBeforeOrAfterDateByMonthNumber 
	 * @Description: 获取当前日期的前后N月的日期Date
	 * @author ERIC 
	 * @date 2014-6-9下午03:24:06
	 * @param @param monthNumber
	 * @param @return
	 * @return Date
	 */
	public static Date getBeforeOrAfterDateByMonthNumber(int monthNumber) {
		return getBeforeOrAfterDateByMonthNumber(new Date(), monthNumber);
	}

	/**
	 * 
	 * @Title: getBeforeOrAfterDateByMonthNumber 
	 * @Description: 获取指定日期前后N月的日期Date
	 * @author ERIC 
	 * @date 2014-6-9下午03:24:31
	 * @param @param date
	 * @param @param monthNumber
	 * @param @return
	 * @return Date
	 */
	public static Date getBeforeOrAfterDateByMonthNumber(Date date,
			int monthNumber) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, monthNumber);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: compareDateOrTime 
	 * @Description: 拿date与当前日期比较大小
	 * @author ERIC 
	 * @date 2014-6-9下午03:24:58
	 * @param @param date
	 * @param @param genre 比较类型 1:< , 2:> , 3: <= , 4: >= , 5: ==
	 * @param @return
	 * @return boolean
	 */
	public static boolean compareDateOrTime(Date date, int genre) {
		return compareDateOrTime(date, new Date(), genre);
	}

	/**
	 * 
	 * @Title: compareDateOrTime 
	 * @Description: 两个日期比较大小
	 * @author ERIC 
	 * @date 2014-6-9下午03:26:15
	 * @param @param date1
	 * @param @param date2
	 * @param @param genre 比较类型 1:< , 2:> , 3: <= , 4: >= , 5: ==
	 * @param @return 
	 * @return boolean
	 */
	public static boolean compareDateOrTime(Date date1, Date date2, int genre) {
		boolean bool = false;
		long times1 = date1.getTime();
		long times2 = date2.getTime();
		if (genre == 1) {
			bool = times1 < times2;
		} else if (genre == 2) {
			bool = times1 > times2;
		} else if (genre == 3) {
			bool = times1 <= times2;
		} else if (genre == 4) {
			bool = times1 >= times2;
		} else if (genre == 5) {
			bool = times1 == times2;
		}
		return bool;
	}

	/**
	 * 
	 * @Title: compareDateOrTime 
	 * @Description: 拿date字符串与当前日期比较大小
	 * @author ERIC 
	 * @date 2014-6-9下午03:28:01
	 * @param @param date
	 * @param @param genre 比较类型 1:< , 2:> , 3: <= , 4: >= , 5: ==
	 * @param @return
	 * @return boolean
	 */
	public static boolean compareDateOrTime(String date, int genre) {
		Date day = new Date();
		if (date != null && date.length() < 12) {
			day = parse(SDF_DATE.format(day));
		}
		return compareDateOrTime(parse(date), day, genre);
	}

	/**
	 * 
	 * @Title: compareDateOrTime 
	 * @Description: 两个日期字符串比较大小 比较类型
	 * @author ERIC 
	 * @date 2014-6-9下午03:28:44
	 * @param @param date1
	 * @param @param date2
	 * @param @param genre  1:< , 2:> , 3: <= , 4: >= , 5: ==
	 * @param @return
	 * @return boolean
	 */
	public static boolean compareDateOrTime(String date1, String date2,
			int genre) {
		return compareDateOrTime(parse(date1), parse(date2), genre);
	}
	
	/**
	 * 
	 * @Title: getLastMonDay 
	 * @Description: 得到当前月最后一天
	 * @author ERIC 
	 * @date 2014-6-9下午03:29:19
	 * @param @return
	 * @return String
	 */
	public static String getLastMonDay(){
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, maxDay);
		return DateUtil.format(cal.getTime(), GlobalConstants.PATTERN_DATE);
	}
	
	/**
	 * 
	 * @Title: addDate 
	 * @Description: 时间相加算法
	 * @author ERIC 
	 * @date 2014-6-9下午03:30:29
	 * @param @param startDate 开始时间
	 * @param @param hours 在开始时间基础上加上的小时数必须为整数
	 * @param @return 返回计算后的时间
	 * @return Date
	 */
	public static Date addDate(Date startDate,int hours){
		Date d2=null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.HOUR_OF_DAY, +hours);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dstr=sdf.format(cal.getTime());
		try {
		d2=sdf.parse(dstr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d2;
	}

	/**
	 * 
	 * @Title: daysBetween 
	 * @Description: 计算两个日期之间相差的天数   
	 * @author ERIC 
	 * @date 2014-6-9下午03:31:42
	 * @param @param date1
	 * @param @param date2
	 * @param @return
	 * @return int
	 */
    public static int daysBetween(Date date1,Date date2){     
        Calendar cal = Calendar.getInstance();     
        cal.setTime(date1);     
        long time1 = cal.getTimeInMillis();                  
        cal.setTime(date2);     
        long time2 = cal.getTimeInMillis();          
        long between_days=(time2-time1)/(1000*3600*24);     
             
       return Integer.parseInt(String.valueOf(between_days));            
    } 
    
    /**
     *     
     * @Title: HoursBetween 
     * @Description: 计算两个日期之间相差的小时
     * @author ERIC 
     * @date 2014-6-9下午03:32:15
     * @param @param date1
     * @param @param date2
     * @param @return
     * @return int
     */
    public static int HoursBetween(Date date1,Date date2){     
        Calendar cal = Calendar.getInstance();     
        cal.setTime(date1);     
        long time1 = cal.getTimeInMillis();                  
        cal.setTime(date2);     
        long time2 = cal.getTimeInMillis();          
        long between_hours=(time2-time1)/(1000*3600);     
             
       return Integer.parseInt(String.valueOf(between_hours));            
    } 
    
	/**
	 * 
	 * @Title: main 
	 * @Description: 主函数
	 * @author ERIC 
	 * @date 2014-6-9下午03:32:51
	 * @param @param args
	 * @return void
	 */
	public static void main(String[] args) {
		System.out.println(compareDateOrTime("2013-04-02", 1));
		Date day = new Date();
		Calendar cc = Calendar.getInstance();
		cc.setTime(day);
		cc.set(Calendar.MONTH, cc.get(Calendar.MONTH) + 8);
		cc.set(Calendar.DATE, 28);
		System.out.println(format(day));
		System.out.println(format(cc.getTime()));
		int i = new Double(Math.ceil(2.001))
		.intValue();
		System.out.println(i);
	}
	
}
