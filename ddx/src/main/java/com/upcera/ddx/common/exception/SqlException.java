/**   
 * @Title: SqlException.java 
 * @Package com.upcera.ddx.common.exception 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-9 下午04:28:24 
 * @version V1.0   
 */ 
package com.upcera.ddx.common.exception;

/** 
 * @ClassName: SqlException 
 * @Description: 自定义SQL异常
 * @author ERIC
 * @date 2014-6-9 下午04:28:24 
 *  
 */
@SuppressWarnings("serial")
public class SqlException extends Exception {
	
	/**
	 * 
	 * <p>Title: SqlException</p> 
	 * <p>Description: 默认构造函数 </p>
	 */
	public SqlException() {
		super();
	}

	/**
	 * 
	 * <p>Title: SqlException</p> 
	 * <p>Description: 构造器，根据自定义异常信息打印异常 </p> 
	 * @param message
	 */
	public SqlException(String message) {
		super(message);
	}

	/**
	 * 
	 * <p>Title: SqlException</p> 
	 * <p>Description: 构造器，根据自定义异常信息和其他异常显示异常信息</p> 
	 * @param message
	 * @param cause
	 */
	public SqlException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * <p>Title: SqlException</p> 
	 * <p>Description: 构造器，根据和其他异常显示异常信息</p> 
	 * @param cause
	 */
	public SqlException(Throwable cause) {
		super(cause);
	}
}
