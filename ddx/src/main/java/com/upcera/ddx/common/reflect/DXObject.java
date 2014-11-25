/**   
 * @Title: DXObject.java 
 * @Package com.upcera.ddx.common.reflect 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-9 下午02:36:38 
 * @version V1.0   
 */ 
package com.upcera.ddx.common.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import com.upcera.ddx.common.util.DateUtil;
import com.upcera.ddx.common.util.StringUtil;


/** 
 * @ClassName: DXObject 
 * @Description: 通过反射获取实体所有属性、属性值等操作工具类 
 * @author ERIC
 * @date 2014-6-9 下午02:36:38 
 *  
 */

public class DXObject {
	/**
	 * 
	 * @Title: main 
	 * @Description: 主函数
	 * @author ERIC 
	 * @date 2014-6-9下午03:34:51
	 * @param @param args
	 * @return void
	 */
	public static void main(String[] args) {

	}
	
	/*public static void populate(Object bean, HttpServletRequest request){
		Class clazz = bean.getClass();
		Method ms[] = clazz.getDeclaredMethods();
		String mname;
		String field;
		String fieldType;
		String value;
		for(Method m : ms){
			mname = m.getName();
			if(!mname.startsWith("set")
					|| ArrayUtils.isEmpty(m.getParameterTypes())){
				continue;
			}
			try{
				field = mname.toLowerCase().charAt(3) + mname.substring(4, mname.length());
				value = request.getParameter(field);
				if(StringUtils.isEmpty(value)){
					continue;
				}
				fieldType = m.getParameterTypes()[0].getName();
				//以下可以确认value为String类型
				if(String.class.getName().equals(fieldType)){
					m.invoke(bean, (String)value);
				}else if(Integer.class.getName().equals(fieldType) && NumberUtils.isDigits((String)value)){
					m.invoke(bean, Integer.valueOf((String)value));
				}else if(Short.class.getName().equals(fieldType) && NumberUtils.isDigits((String)value)){
					m.invoke(bean, Short.valueOf((String)value));
				}else if(Float.class.getName().equals(fieldType) && NumberUtils.isNumber((String)value)){
					m.invoke(bean, Float.valueOf((String)value));
				}else if(Double.class.getName().equals(fieldType) && NumberUtils.isNumber((String)value)){
					m.invoke(bean, Double.valueOf((String)value));
				}else if(Date.class.getName().equals(fieldType)){
					String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"};
					m.invoke(bean, DateUtils.parseDate((String)value,parsePatterns));
				}else{
					m.invoke(bean, value);
				}
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}*/

	/**
	 * 
	 * @Title: excType 
	 * @Description: 判断对象类型，并返回String值
	 * @author ERIC 
	 * @date 2014-6-9下午03:35:11
	 * @param @param obj
	 * @param @return
	 * @return String
	 */
	public static String excType(Object obj) {
		String methodValue = null;
		if (obj instanceof String) {
			methodValue = StringUtil.excNullToString((String) obj, "");
		} else if (obj instanceof Integer) {
			methodValue = String.valueOf(obj);
		} else if (obj instanceof Long) {
			methodValue = String.valueOf(obj);
		} else if (obj instanceof Double) {
			methodValue = String.valueOf(obj);
		} else if (obj instanceof Float) {
			methodValue = String.valueOf(obj);
		} else if (obj instanceof Date) {
			methodValue = DateUtil.format((Date) obj);
		} else if (obj instanceof Timestamp) {
			methodValue = DateUtil.format((Timestamp) obj);
		} else if (obj instanceof Byte) {
			if (obj != null) {
				methodValue = (String) obj.toString();
			}
		}
		return methodValue;
	}

	/**
	 * 
	 * @Title: excType 
	 * @Description: 判断对象类型，并返回String值>
	 * @author ERIC 
	 * @date 2014-6-9下午03:35:28
	 * @param @param obj
	 * @param @param value
	 * @param @return
	 * @return Object
	 */
	public static Object excType(Class obj, String value) {
		String type = obj.getName();
		value = StringUtil.stringUncode(value);
		if (type.equals("java.lang.String")) {
			return value;
		} else if (type.equals("int")) {
			return StringUtil.stringToInt(value);
		} else if (type.equals("java.lang.Integer")) {
			return StringUtil.stringToInteger(value);
		} else if (type.equals("long")) {
			return StringUtil.stringToLong(value);
		} else if (type.equals("java.lang.Long")) {
			return StringUtil.stringToLong2(value);
		} else if (type.equals("float")) {
			return StringUtil.stringToFloat(value, 0.0f);
		} else if (type.equals("double")) {
			return StringUtil.stringToDouble(value, 0.0d);
		} else if (type.equals("java.lang.Double")) {
			return StringUtil.stringToDouble(value, 0.0d);
		} else if (type.equals("java.lang.Float")) {
			return StringUtil.stringToFloat(value, 0.0f);
		} else if (type.equals("byte")) {
			if (value == null) {
				return null;
			}
			return value.getBytes();
		} else if (type.indexOf("[B") != -1) {
			if (value == null) {
				return null;
			}
			return value.getBytes();
		} else if (type.indexOf("java.util.List") != -1) {
			if (value == null) {
				return null;
			}
			return value;
		} else if (type.equals("java.util.Date")) {
			if (value == null || value.trim().equals("")) {
				return null;
			}
			return new Timestamp(DateUtil.parse(value).getTime());
		} else if (type.equals("java.sql.Timestamp")) {
			if (value == null || value.trim().equals("")) {
				return null;
			}
			return DateUtil.parseToTimestamp(value, "yyyy-MM-dd HH:mm:ss");
		} else if (type.equals("java.sql.Blob")) {
			if (value == null) {
				return null;
			}
			byte[] by = value.getBytes();
			try {
				Blob blob = new SerialBlob(by);
				return blob;
			} catch (Exception e) {
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: excTypeBySearch 
	 * @Description: 填充值（针对搜索增加%%）
	 * @author ERIC 
	 * @date 2014-6-9下午03:35:59
	 * @param @param mname
	 * @param @param obj
	 * @param @param value
	 * @param @return
	 * @return Object
	 */
	public static Object excTypeBySearch(String mname, Class obj, String value) {
		String type = obj.getName();
		value = StringUtil.stringUncode(value);
		if (type.equals("java.lang.String")) {
			if (!mname.equals("orderby")) {
				value = value == null ? null : "%" + value + "%";
			}
			return value;
		} else if (type.equals("int")) {
			return StringUtil.stringToInt(value);
		} else if (type.equals("java.lang.Integer")) {
			return StringUtil.stringToInt(value);
		} else if (type.equals("long")) {
			return StringUtil.stringToLong(value);
		} else if (type.equals("java.lang.Long")) {
			return StringUtil.stringToLong(value);
		} else if (type.equals("float")) {
			return StringUtil.stringToFloat(value, 0.0f);
		} else if (type.equals("double")) {
			return StringUtil.stringToDouble(value, 0.0d);
		} else if (type.equals("java.lang.Double")) {
			return StringUtil.stringToDouble(value, 0.0d);
		} else if (type.equals("java.lang.Float")) {
			return StringUtil.stringToFloat(value, 0.0f);
		} else if (type.equals("byte")) {
			if (value == null) {
				return null;
			}
			return value.getBytes();
		} else if (type.indexOf("[B") != -1) {
			if (value == null) {
				return null;
			}
			return value.getBytes();
		} else if (type.indexOf("java.util.List") != -1) {
			if (value == null) {
				return null;
			}
			return value;
		} else if (type.equals("java.util.Date")) {
			if (value == null || value.trim().equals("")) {
				return null;
			}
			return new Timestamp(DateUtil.parse(value).getTime());
		} else if (type.equals("java.sql.Timestamp")) {
			if (value == null || value.trim().equals("")) {
				return null;
			}
			return DateUtil.parseToTimestamp(value, "yyyy-mm-dd hh:mm:ss[.f]");
		} else if (type.equals("java.sql.Blob")) {
			if (value == null) {
				return null;
			}
			byte[] by = value.getBytes();
			try {
				Blob blob = new SerialBlob(by);
				return blob;
			} catch (Exception e) {
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: excTypeTest 
	 * @Description: 判断对象类型，并返回String值
	 * @author ERIC 
	 * @date 2014-6-9下午03:36:34
	 * @param @param obj
	 * @param @return
	 * @return Object
	 */
	public static Object excTypeTest(Class obj) {
		String type = obj.getName();
		String value = "" + (int) (Math.random() * 99 + 1);
		if (type.equals("java.lang.String")) {
			return "测试数据" + value;
		} else if (type.equals("int")) {
			return StringUtil.stringToInt(value);
		} else if (type.equals("float")) {
			return StringUtil.stringToFloat(value, 0.0f);
		} else if (type.equals("double")) {
			return StringUtil.stringToDouble(value, 0.0d);
		} else if (type.equals("java.lang.Double")) {
			return StringUtil.stringToDouble(value, 0.0d);
		} else if (type.equals("java.lang.Float")) {
			return StringUtil.stringToFloat(value, 0.0f);
		} else if (type.equals("java.util.Date")) {
			if (value != null) {
				return new Date();
			}
		} else if (type.equals("java.sql.Timestamp")) {
			if (value != null) {
				return new Timestamp(new Date().getTime());
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: excTypeValue 
	 * @Description: 判断值类型
	 * @author ERIC 
	 * @date 2014-6-9下午03:47:24
	 * @param @param obj
	 * @param @param value
	 * @param @return
	 * @return Object
	 */
	public static Object excTypeValue(Class obj, String value) {
		String type = obj.getName();
		if (type.equals("java.lang.String")) {
			return "测试数据" + value;
		} else if (type.equals("int")) {
			return StringUtil.stringToInt(value);
		} else if (type.equals("float")) {
			return StringUtil.stringToFloat(value, 0.0f);
		} else if (type.equals("double")) {
			return StringUtil.stringToDouble(value, 0.0d);
		} else if (type.equals("java.lang.Double")) {
			return StringUtil.stringToDouble(value, 0.0d);
		} else if (type.equals("java.lang.Float")) {
			return StringUtil.stringToFloat(value, 0.0f);
		} else if (type.equals("java.util.Date")) {
			if (value != null) {
				return new Date();
			}
		} else if (type.equals("java.sql.Timestamp")) {
			if (value != null) {
				return new Timestamp(new Date().getTime());
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: typeClass 
	 * @Description: 判断对象类型，并返回String值
	 * @author ERIC 
	 * @date 2014-6-9下午03:48:20
	 * @param @param obj
	 * @param @return
	 * @return Class
	 */
	public static Class typeClass(String obj) {
		Class cla = null;
		if (obj.equals("java.lang.String")) {
			cla = String.class;
		} else if (obj.equals("int")) {
			cla = int.class;
		} else if (obj.equals("java.lang.Integer")) {
			cla = java.lang.Integer.class;
		}  else if (obj.equals("long")) {
			cla = long.class;
		} else if (obj.equals("java.lang.Long")) {
			cla = java.lang.Long.class;
		} else if (obj.equals("float")) {
			cla = float.class;
		} else if (obj.equals("double")) {
			cla = double.class;
		} else if (obj.equals("java.lang.Double")) {
			cla = Double.class;
		} else if (obj.equals("java.lang.Float")) {
			cla = Float.class;
		} else if (obj.equals("java.util.Date")) {
			cla = Date.class;
		} else if (obj.equals("java.sql.Timestamp")) {
			cla = Timestamp.class;
		} else if (obj.equals("java.sql.Blob")) {
			cla = Blob.class;
		} else if (obj.equals("byte")) {
			cla = byte.class;
		} else if (obj.equals("[B")) {
			cla = byte[].class;
		} else if (obj.equals("java.util.List")) {
			cla = List.class;
		}
		return cla;
	}

	/**
	 * 
	 * @Title: fieldByName 
	 * @Description: 获取所有属性名，并放到String[]中
	 * @author ERIC 
	 * @date 2014-6-9下午03:48:33
	 * @param @param f
	 * @param @return
	 * @return String[]
	 */
	public static String[] fieldByName(Field[] f) {
		String[] name = new String[f.length];
		for (int i = 0; i < f.length; i++) {
			name[i] = f[i].getName();
		}
		return name;
	}

	/**
	 * 
	 * @Title: fieldByValue 
	 * @Description: 获取所有属性值，并放到Object[]中
	 * @author ERIC 
	 * @date 2014-6-9下午03:48:48
	 * @param @param f
	 * @param @param o
	 * @param @return
	 * @return Object[]
	 */
	public static Object[] fieldByValue(Field[] f, Object o) {
		Object[] value = new Object[f.length];
		for (int i = 0; i < f.length; i++) {
			try {
				value[i] = f[i].get(o);
			} catch (Exception e) {
			}
		}
		return value;
	}

	/**
	 * 
	 * @Title: getValue 
	 * @Description: 将对象的属性作为key，属性值作为value 保存到Map中
	 * @author ERIC 
	 * @date 2014-6-9下午03:49:00
	 * @param @param obj
	 * @param @return
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> getValue(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] f = obj.getClass().getDeclaredFields();
		String fname[] = DXObject.fieldByName(f);
		String tou = "", wei = "", getMethod = "";
		for (int i = 0; i < fname.length; i++) {
			tou = fname[i].substring(0, 1);
			wei = fname[i].substring(1);
			getMethod = "get" + tou.toUpperCase() + wei;
			try {
				Method method = obj.getClass().getMethod(getMethod);
				Object vas = method.invoke(obj);
				map.put(fname[i], vas);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	/**
	 * 
	 * @Title: setValue 
	 * @Description: 从request中获取参数并填充对象
	 * @author ERIC 
	 * @date 2014-6-9下午03:49:27
	 * @param @param obj
	 * @param @param request
	 * @return void
	 */
	public static void setValue(Object obj, HttpServletRequest request) {
		String columns = request.getParameter("columns");
		Field[] f = obj.getClass().getDeclaredFields();
		String fname = "";
		String tou = "", wei = "", setMethod = "";
		for (int i = 0; i < f.length; i++) {
			fname = f[i].getName();
			tou = fname.substring(0, 1);
			wei = fname.substring(1);
			setMethod = "set" + tou.toUpperCase() + wei;
			String value = request.getParameter(fname);
			String type = f[i].getType().getName();
			/*if (fname.equals("fromIndex")) {
				if (!StringUtil.isEmpty(columns)) {
					value = "0";
				}
			} else if (fname.equals("toIndex")) {
				if (!StringUtil.isEmpty(columns)) {
					value = "65000";
				}
			}
			if (type.equals("java.lang.String")) {
				value = StringUtil.stringUncode(value);
			}*/
			try {
				Method method = obj.getClass().getMethod(setMethod,
						new Class[] { typeClass(type) });
				method.invoke(obj,
						new Object[] { excType(typeClass(type), value) });
			} catch (Exception e) {
				System.err.println("缺少" + setMethod + "(" + typeClass(type)
						+ " " + value + ")" + "方法！ " + e.getMessage());
			}
		}
	}

	/**
	 * 
	 * @Title: setValueForSearch 
	 * @Description: 从request中获取参数并填充对象(针对模糊搜索 增加 %%)
	 * @author ERIC 
	 * @date 2014-6-9下午03:57:52
	 * @param @param obj
	 * @param @param request
	 * @return void
	 */
	public static void setValueForSearch(Object obj, HttpServletRequest request) {
		String columns = request.getParameter("columns");
		Field[] f = obj.getClass().getDeclaredFields();
		String fname = "";
		String setMethod = "";
		for (int i = 0; i < f.length; i++) {
			fname = f[i].getName();
			setMethod = "set" + StringUtil.firstCharToUpperCase(fname);
			String value = request.getParameter(fname);
			if (fname.equals("fromIndex")) {
				if (!StringUtil.isEmpty(columns)) {
					value = "0";
				}
			} else if (fname.equals("toIndex")) {
				if (!StringUtil.isEmpty(columns)) {
					value = "65000";
				}
			}
			String type = f[i].getType().getName();
			if (type.equals("java.lang.String")) {
				value = StringUtil.stringUncode(value);
			}
			try {
				Method method = obj.getClass().getMethod(setMethod,
						new Class[] { typeClass(type) });
				method.invoke(
						obj,
						new Object[] { excTypeBySearch(fname, typeClass(type),
								value) });
			} catch (Exception e) {
				System.err.println("缺少" + setMethod + "(" + typeClass(type)
						+ " " + value + ")" + "方法！ " + e.getMessage());
			}
		}
	}

	/**
	 * 
	 * @Title: setValueTest 
	 * @Description: 测试用
	 * @author ERIC 
	 * @date 2014-6-9下午03:58:16
	 * @param @param obj
	 * @return void
	 */
	public static void setValueTest(Object obj) {
		Field[] f = obj.getClass().getDeclaredFields();
		String fname = "";
		String tou = "", wei = "", setMethod = "";
		for (int i = 0; i < f.length; i++) {
			fname = f[i].getName();
			tou = fname.substring(0, 1);
			wei = fname.substring(1);
			setMethod = "set" + tou.toUpperCase() + wei;
			String type = f[i].getType().getName();
			try {
				Method method = obj.getClass().getMethod(setMethod,
						new Class[] { typeClass(type) });
				method.invoke(obj,
						new Object[] { excTypeTest(typeClass(type)) });
			} catch (Exception e) {
				System.err.println("缺少" + setMethod + "(" + typeClass(type)
						+ " )" + "方法！ " + e);
			}
		}
	}

	/**
	 * 
	 * @Title: setValueForField 
	 * @Description: 给对象某属性设置值
	 * @author ERIC 
	 * @date 2014-6-9下午03:58:39
	 * @param @param obj
	 * @param @param field
	 * @param @param value
	 * @return void
	 */
	public static void setValueForField(Object obj, String field, String value) {
		Field[] f = obj.getClass().getDeclaredFields();
		String fname = "";
		String setMethod = "";
		for (int i = 0; i < f.length; i++) {
			fname = f[i].getName();
			if (fname.equals(field)) {
				setMethod = "set" + StringUtil.firstCharToUpperCase(field);
				String type = f[i].getType().getName();
				try {
					Method method = obj.getClass().getMethod(setMethod,
							new Class[] { typeClass(type) });
					method.invoke(
							obj,
							new Object[] { excTypeValue(typeClass(type), value) });
				} catch (Exception e) {
					System.err.println("缺少" + setMethod + "(" + typeClass(type)
							+ " )" + "方法！ " + e);
				}
			}
		}
	}
	
}
