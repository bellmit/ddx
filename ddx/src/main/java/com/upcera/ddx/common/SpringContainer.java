/**   
 * @Title: SpringContainer.java 
 * @Package com.upcera.ddx.common 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:04:30 
 * @version V1.0   
 */
package com.upcera.ddx.common;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ClassName: SpringContainer
 * @Description: spring容器管理， 并直接通过该方式获取容器管理对象，可继续扩展
 * @author ERIC
 * @date 2014-6-11 下午02:04:30
 * 
 */

public class SpringContainer {

	private static WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

	/**
	 * 
	 * @Title: getBeanByName 
	 * @Description: 通过注解的方式获取实体
	 * @author ERIC 
	 * @date 2014-6-11下午02:05:25
	 * @param @param beanName
	 * @param @return
	 * @return Object
	 */
	public static Object getBeanByName(String beanName) {
		return context.getBean(beanName);
	}

	/**
	 * 
	 * @Title: getServletContext 
	 * @Description: 获取ServletContext
	 * @author ERIC 
	 * @date 2014-6-11下午02:05:41
	 * @param @return
	 * @return ServletContext
	 */
	public static ServletContext getServletContext() {
		return context.getServletContext();
	}

	/**
	 * 
	 * @Title: getWebApplicationContext 
	 * @Description: 获取web应用服务器上下文对象
	 * @author ERIC 
	 * @date 2014-6-11下午02:05:58
	 * @param @return
	 * @return WebApplicationContext
	 */
	public static WebApplicationContext getWebApplicationContext() {
		return context;
	}

}
