package com.upcera.ddx.common.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @desc excel注解参数定义
 * @author king
 * @date 2014-7-23 14:59:46
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {
	public static final int time = 0;
	public static final int calendar = 1;
	public static final int number = 2;
	public static final int string = 3;
	
	public static final String HH_MM = "HH:mm";
	
	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	public static final short defaultBackgroundColor = 9999;

	int index();

	String title();

	int textType() default string;
	
	String timeFormat() default HH_MM;
	
	String CalendarFormat() default YYYY_MM_DD;

	short border() default Border.BORDER_THIN;

	short backgroundColor() default defaultBackgroundColor;
}