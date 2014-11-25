package com.upcera.ddx.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.upcera.ddx.common.target.Excel;
import com.upcera.ddx.common.util.StringUtil;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.common.util.ToolsKit.DateUtil;
/**
 * @desc excel解析与创建抽象类
 * @author king
 * @createDate 2014-7-23 15:14:27
 * 
 */
public abstract class AbstractExcelService<T> {
	
	public static final String FORMAT_TIME = "HH:mm";
	
	public static final String FORMAT_CALENDAR = "yyyy-MM-dd";

	/**
	 * @desc parse excel
	 * @author king
	 * @param file
	 *            文件
	 * @param claszz
	 *            实体类class
	 * @param startLine
	 *            开始解析行号
	 * 
	 * @return List<T>
	 * 
	 * 
	 * @throws Exception
	 * 
	 * @createDate 2013-12-04 18:07:05
	 * 
	 */
	public List<T> paser(File file, Class<T> claszz, int startLine) throws Exception {

		// 2003
		HSSFWorkbook hssfWorkbook = null;
		// 2007
		XSSFWorkbook xssfWorkbook = null;
		List<T> dataList = new ArrayList<T>();
		try {
			hssfWorkbook = new HSSFWorkbook(new FileInputStream(file));
		} catch (Exception e) {
			xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
		}
		if (hssfWorkbook != null) {
			parseBy2003(hssfWorkbook, dataList, file, claszz, startLine);
		} else {
			parseBy2007(xssfWorkbook, dataList, file, claszz, startLine);
		}
		return dataList;
	}

	/**
	 * @project parse excel by version 2007
	 * @author king
	 * @throws Exception
	 * 
	 * @createDate 2013-12-04 18:07:05
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void parseBy2007(XSSFWorkbook xssfWorkbook, List<T> dataList, File file, Class<?> claszz, int startLine)
			throws Exception {
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow == null || rowNum < startLine || isNullRow(xssfRow)) {
					continue;
				}
				Object object = claszz.newInstance();
				List<Method> method = getmethodList("get", claszz.getMethods());
				for (int i = 0; i < method.size(); i++) {
					try {
						if (method.get(i).isAnnotationPresent(Excel.class)) {
							int cell = ToolsKit.TypeConversionUtil.asInteger(parseComment(method.get(i),Excel.class).get("index"));
							String value = getValue(xssfRow.getCell(cell));
							Method setMethod = claszz.getDeclaredMethod("set" + method.get(i).getName().split("get")[1], String.class);
							setMethod.invoke(object, value);
						}
					} catch (Exception e) {
						// Ignore
					}
				}
				dataList.add((T) object);
			}
		}
	}

	/**
	 * @project parse excel by version 2003
	 * @author king
	 * @throws Exception
	 * 
	 * @createDate 2013-12-04 18:07:05
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void parseBy2003(HSSFWorkbook hssfWorkbook, List<T> dataList, File file, Class<?> claszz, int startLine)
			throws Exception {
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet xssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow == null || rowNum < startLine || isNullRow(xssfRow)) {
					continue;
				}
				Object object = claszz.newInstance();
				List<Method> method = getmethodList("get", claszz.getMethods());
				for (int i = 0; i < method.size(); i++) {
					try {
						if (method.get(i).isAnnotationPresent(Excel.class)) {
							Map map = parseComment(method.get(i),Excel.class);
							int cell = ToolsKit.TypeConversionUtil.asInteger(map.get("index"));
							String value = getValue(xssfRow.getCell(cell));
							Method setMethod = claszz.getDeclaredMethod("set" + method.get(i).getName().split("get")[1], String.class);
							setMethod.invoke(object, value);
						}
					} catch (Exception e) {
						// Ignore
					}
				}
				dataList.add((T) object);
			}
		}
	}
	
	private boolean isNullRow(XSSFRow row) {
		boolean isNullRow = true;
		try {
			int lastNum = row.getLastCellNum();
			for (int i = 0; i < lastNum; i++) {
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(getValue(row.getCell(i)))) {
					isNullRow = false;
					break;
				}
			}
		} catch (Exception e) {
			// Ignore
		}
		return isNullRow;
	}

	private boolean isNullRow(HSSFRow row) {
		boolean isNullRow = true;
		try {
			int lastNum = row.getLastCellNum();
			for (int i = 0; i < lastNum; i++) {
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(getValue(row.getCell(i)))) {
					isNullRow = false;
					break;
				}
			}
		} catch (Exception e) {
			// Ignore
		}
		return isNullRow;
	}

	private String getValue(HSSFCell hssfCell) {
		short format = hssfCell.getCellStyle().getDataFormat();
		SimpleDateFormat sdf = null;
		if (format == 14 || format == 31 || format == 57 || format == 58 || format == 176) {
			// 日期
			sdf = new SimpleDateFormat(FORMAT_CALENDAR);
		} else if (format == 20 || format == 32) {
			// 时间
			sdf = new SimpleDateFormat(FORMAT_TIME);
		} else {
			hssfCell.setCellType(Cell.CELL_TYPE_STRING);
			return String.valueOf(hssfCell.getStringCellValue());
		}
		Double value = null;
		try {
			value = hssfCell.getNumericCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hssfCell.setCellType(Cell.CELL_TYPE_STRING);
			return String.valueOf(hssfCell.getStringCellValue());
		}
		Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
		return sdf.format(date);
	}

	private String getValue(XSSFCell xssfCell) {
		short format = xssfCell.getCellStyle().getDataFormat();
		SimpleDateFormat sdf = null;
		if (format == 14 || format == 31 || format == 57 || format == 58 || format == 176) {
			// 日期
			sdf = new SimpleDateFormat(FORMAT_CALENDAR);
		} else if (format == 20 || format == 32) {
			// 时间
			sdf = new SimpleDateFormat(FORMAT_TIME);
		} else {
			xssfCell.setCellType(Cell.CELL_TYPE_STRING);
			return String.valueOf(xssfCell.getStringCellValue());
		}
		Double value = null;
		try {
			value = xssfCell.getNumericCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			xssfCell.setCellType(Cell.CELL_TYPE_STRING);
			return String.valueOf(xssfCell.getStringCellValue());
		}
		Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
		return sdf.format(date);

	}

	/**
	 * @desc create excel by version 2007
	 * @author king
	 * @param valueList
	 *            结果集
	 * @param clazz
	 *            对应的实体class
	 * @param fileName
	 *            文件名
	 * @param saveDirectory
	 *            保存目录
	 * 
	 * @return File
	 * 
	 * @throws Exception
	 * @createDate 2013-12-04 18:07:05
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static File create(List<?> valueList, Class clazz, String fileName, String saveDirectory) throws Exception {
		if ("Map".equals(clazz.getSimpleName())) {
			throw new Exception("Class can't is Map.");
		}
		XSSFWorkbook xssBook = new XSSFWorkbook();
		XSSFSheet sheet = xssBook.createSheet(clazz.getSimpleName());
		List<Method> methodList = getmethodList("get", clazz.getDeclaredMethods());
		for (int i = 0; i < valueList.size(); i++) {
			Object obj = ToolsKit.jsonUitl.toBean(clazz,ToolsKit.jsonUitl.toJson(valueList.get(i)));
			for (int j = 0; j < methodList.size(); j++) {
				Map<String, Object> comment = null;
				int titleIndex = j;
				Integer valueType = 3;
				String timeFormat = FORMAT_TIME;
				String calendarFormat = FORMAT_CALENDAR;
				String title = methodList.get(j).getName().split("get")[1];
				String value = ToolsKit.TypeConversionUtil.asString(methodList.get(j).invoke(obj));
				// parse comment
				if (methodList.get(j).isAnnotationPresent(Excel.class)) {
					comment = parseComment(methodList.get(j),Excel.class);
					title = ToolsKit.TypeConversionUtil.asString(comment.get("title"));
					titleIndex = ToolsKit.TypeConversionUtil.asInteger(comment.get("index"));
					valueType = ToolsKit.TypeConversionUtil.asInteger(comment.get("textType"));
					timeFormat = ToolsKit.TypeConversionUtil.asString(comment.get("timeFormat"));
					calendarFormat = ToolsKit.TypeConversionUtil.asString(comment.get("CalendarFormat"));
					
					// set text
					setText(xssBook, sheet, i, title, titleIndex, value, valueType, timeFormat, calendarFormat);
					// set Style
					if (ToolsKit.EmptyCheckUtil.isNotEmpty(comment)) {
						setStype(comment, xssBook, sheet, i, titleIndex);
					}
				}
			}
		}
		File file = ToolsKit.FileUtil.createFileAsFile(saveDirectory, fileName + "_" + DateUtil.ssss() + ".xlsx");
		OutputStream stream = new FileOutputStream(file);
		xssBook.write(stream);
		stream.close();
		return file;
	}
	
	/**
	 * 
	 * @Title: create 
	 * @Description: create excel by version 2007 on specified fields
	 * @author ERIC 
	 * @date 2014-9-11上午10:30:56
	 * @return File
	 */
	public static File create(List<?> valueList, Class clazz, String fileName, String saveDirectory ,String head) throws Exception {
		if ("Map".equals(clazz.getSimpleName())) {
			throw new Exception("Class can't is Map.");
		}
		XSSFWorkbook xssBook = new XSSFWorkbook();
		XSSFSheet sheet = xssBook.createSheet(clazz.getSimpleName());
		String[][] fields = getColumns(head);
		List<Method> methodList = (List<Method>) getmethodListByFields("get", clazz.getDeclaredMethods(),fields).get("methodList");
		List<String> descList = (List<String>) getmethodListByFields("get", clazz.getDeclaredMethods(),fields).get("descList");
		List<String> indexList = (List<String>) getmethodListByFields("get", clazz.getDeclaredMethods(),fields).get("indexList");
		for (int i = 0; i < valueList.size(); i++) {
			Object obj = ToolsKit.jsonUitl.toBean(clazz,ToolsKit.jsonUitl.toJson(valueList.get(i)));
			for (int j = 0; j < methodList.size(); j++) {
				Map<String, Object> comment = null;
				int titleIndex = j;
				Integer valueType = 3;
				String timeFormat = FORMAT_TIME;
				String calendarFormat = FORMAT_CALENDAR;
				String title = methodList.get(j).getName().split("get")[1];
				String value = ToolsKit.TypeConversionUtil.asString(methodList.get(j).invoke(obj));
				// parse comment
				/*if (methodList.get(j).isAnnotationPresent(Excel.class)) {
					comment = parseComment(methodList.get(j),Excel.class);
					title = ToolsKit.TypeConversionUtil.asString(comment.get("title"));
					titleIndex = ToolsKit.TypeConversionUtil.asInteger(comment.get("index"));
					valueType = ToolsKit.TypeConversionUtil.asInteger(comment.get("textType"));
					timeFormat = ToolsKit.TypeConversionUtil.asString(comment.get("timeFormat"));
					calendarFormat = ToolsKit.TypeConversionUtil.asString(comment.get("CalendarFormat"));
				}*/
				title = descList.get(j);
				titleIndex = ToolsKit.TypeConversionUtil.asInteger(indexList.get(j));
				// set text
				setText(xssBook, sheet, i, title, titleIndex, value, valueType, timeFormat, calendarFormat);
				// set Style
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(comment)) {
					setStype(comment, xssBook, sheet, i, titleIndex);
				}
			}
		}
		File file = ToolsKit.FileUtil.createFileAsFile(saveDirectory, fileName + "_" + DateUtil.ssss() + ".xlsx");
		OutputStream stream = new FileOutputStream(file);
		xssBook.write(stream);
		stream.close();
		return file;
	}

	private static void setText(XSSFWorkbook xssBook, XSSFSheet sheet, int row, String title, int titleIndex,
			String value, Integer valueType,String timeFormat,String calendarFormat) throws Exception {
		if (row == 0) {
			if (sheet.getRow(0) != null) {
				sheet.getRow(0).createCell(titleIndex).setCellValue(title);
			} else {
				sheet.createRow(0).createCell(titleIndex).setCellValue(title);
			}
		}
		XSSFCell cell = null;
		if (sheet.getRow(row + 1) != null) {
			cell = sheet.getRow(row + 1).createCell(titleIndex);
		} else {
			cell = sheet.createRow(row + 1).createCell(titleIndex);
		}
		try {
			switch (valueType) {
			case Excel.calendar:
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(DateUtil.parse(value, calendarFormat));
				cell.setCellValue(calendar);
				break;
			case Excel.time:
				Date date = DateUtil.parse(value, timeFormat);
				cell.setCellValue(date);
				break;
			case Excel.number:
				try {
					cell.setCellValue(ToolsKit.TypeConversionUtil.asInteger(value));
				} catch (Exception e) {
					cell.setCellValue(ToolsKit.TypeConversionUtil.asDouble(value));
				}
				break;
			case Excel.string:
				cell.setCellValue(value);
				break;
			default:
				cell.setCellValue(value);
			}
		} catch (Exception e) {
			cell.setCellValue(value);
		}
	}

	private static void setStype(Map<String, Object> comment, XSSFWorkbook xssBook, XSSFSheet sheet, int row, int titleIndex) {
		short border = ToolsKit.TypeConversionUtil.asShort(comment.get("border"));
		Integer valueType = ToolsKit.TypeConversionUtil.asInteger(comment.get("textType"));
		short backgroundColor = ToolsKit.TypeConversionUtil.asShort(comment.get("backgroundColor"));
		String timeFormat = ToolsKit.TypeConversionUtil.asString(comment.get("timeFormat"));
		String calendarFormat = ToolsKit.TypeConversionUtil.asString(comment.get("CalendarFormat"));
		// head stype
		if (row == 0) {
			XSSFCellStyle headStype = xssBook.createCellStyle();
			setBorder(headStype, border);
			XSSFFont font = xssBook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			headStype.setFont(font);
			sheet.getRow(0).getCell(titleIndex).setCellStyle(headStype);
		}
		// text stype
		XSSFCellStyle textStype = xssBook.createCellStyle();
		setBorder(textStype, border);
		if (backgroundColor != Excel.defaultBackgroundColor) {
			textStype.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			textStype.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			textStype.setFillForegroundColor(backgroundColor);
		}
		XSSFCell cell = sheet.getRow(row + 1).getCell(titleIndex);
		XSSFDataFormat format = xssBook.createDataFormat();
		try {
			switch (valueType) {
			case Excel.calendar:
				textStype.setDataFormat(format.getFormat(calendarFormat));
				break;
			case Excel.time:
				textStype.setDataFormat(format.getFormat(timeFormat));
				break;
			case Excel.number:
				break;
			case Excel.string:
				break;
			}
		} catch (Exception e) {
		}
		cell.setCellStyle(textStype);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseComment(Method method,Class clazz) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Annotation p = method.getAnnotation(clazz);
		Method[] methods = p.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			try {
				map.put(methods[i].getName(), methods[i].invoke(p));
			} catch (Exception e) {
				// Ignore
			}
		}
		return map;
	}

	private static List<Method> getmethodList(String flag, Method[] method) {
		List<Method> methodList = new ArrayList<Method>();
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().indexOf(flag) != -1) {
				methodList.add(method[i]);
			}
		}
		return methodList;
	}
	
	private static void setBorder(XSSFCellStyle stype, short border) {
		stype.setBorderTop(border);
		stype.setBorderBottom(border);
		stype.setBorderLeft(border);
		stype.setBorderRight(border);
		stype.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	}
	

	private static Map<String,Object> getmethodListByFields(String flag, Method[] method, String[][] fields) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Method> methodList = new ArrayList<Method>();
		List<String> descList = new ArrayList<String>();
		List<String> indexList = new ArrayList<String>();
		int k = 0;
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().indexOf(flag) != -1) {
				for(int j = 0;j < fields.length;j++){
					String field = fields[j][0];
					field = StringUtil.firstCharToUpperCase(field);
					if(method[i].getName().substring(3).equals(field)){
						methodList.add(k,method[i]);
						descList.add(k,fields[j][1]);
						indexList.add(k,fields[j][2]);
						k++;
					}
				}
			}
		}
		map.put("methodList",methodList );
		map.put("descList",descList );
		map.put("indexList",indexList );
		return map;
	}
	
	/**
	 * 获取需要带出的列及描述
	 * 
	 * @return String[][], 二维数组[feild][text]
	 */
	public static String[][] getColumns(String columns) {
		String fields[][] = null;
		if (!StringUtil.isEmpty(columns)) {
			columns = StringUtil.stringUncode(columns);
			String[] column = columns.split(",");
			fields = new String[column.length][3];
			String[] field = null;
			for (int i = 0, k = column.length; i < k; i++) {
				field = column[i].split(":");
				if (!StringUtil.isEmpty(column[i])) {
					fields[i] = field;
				}
			}
		}
		return fields;
	}
}
