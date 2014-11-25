/**   
 * @Title: WebException.java 
 * @Package com.upcera.ddx.common.exception 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-9 下午04:28:08 
 * @version V1.0   
 */ 
package com.upcera.ddx.common.exception;

/** 
 * @ClassName: WebException 
 * @Description: 自定义Web异常
 * @author ERIC
 * @date 2014-6-9 下午04:28:08 
 *  
 */
@SuppressWarnings("serial")
public class WebException extends Exception {

	/**
	 * 
	 * <p>Title: </p> 
	 * <p>Description: 默认构造函数</p>
	 */
	public WebException() {
		super();
	}

	/**
	 * 
	 * <p>Title: </p> 
	 * <p>Description: 构造器，根据自定义异常信息打印异常</p> 
	 * @param message
	 */
	public WebException(String message) {
		super(message);
	}

	/**
	 * 
	 * <p>Title: </p> 
	 * <p>Description: 构造器，根据自定义异常信息和其他异常显示异常信息</p> 
	 * @param message
	 * @param cause
	 */
	public WebException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * <p>Title: </p> 
	 * <p>Description: 构造器，根据和其他异常显示异常信息</p> 
	 * @param cause
	 */
	public WebException(Throwable cause) {
		super(cause);
	}
	
}
