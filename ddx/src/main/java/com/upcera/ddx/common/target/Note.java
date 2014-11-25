package com.upcera.ddx.common.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @desc 方法注释
 * @author king
 * @date 2014-7-23 14:59:46
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Note {
	
	String name() default "";//标记名称
	
	//增加价格的时候，是否显示在面板上（前提是该属性设置不为“不需要”）
	boolean isShowByPriceAdd() default true;
	//获取当前属性的默认值的方法
	String getValueMethod() default "";
	//获取当前属性默认值的备注说明
	String getValueDescriptionMethod() default "";
	//工序属性在创建案例页面的显示类型（input/select）
	String createCaseShowType() default "select";
	//工序属性对应的值加载通道
	String valueLoadChannel() default "xml";
	//工序属性数据类型（int/string）
	String dataType() default "string";
	//工序属性值是否为分号分割数组方式
	boolean isSplitArray() default false;
}
