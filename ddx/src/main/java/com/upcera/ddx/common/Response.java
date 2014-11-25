/**   
 * @Title: Response.java 
 * @Package com.upcera.ddx.common 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-9 下午02:31:17 
 * @version V1.0   
 */ 
package com.upcera.ddx.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/** 
 * @ClassName: Response 
 * @Description: 自定义DAO通用返回对象，可继续扩展
 * <ul>
 *      <li>id: 可以用来设置/获取记录的自增长ID</li>
 *      <li>statusCode：数据库操作返回的状态码</li>
 *      <li>object：查询记录时返回的对象</li>
 *      <li>list：查询记录时返回的对象List集合</li>
 *      <li>map：查询记录时返回的对象Map集合</li>
 * </ul> 
 * @author ERIC
 * @date 2014-6-9 下午02:31:17 
 *  
 */

public class Response {

	private int id;
	private int statusCode = StatusCode.SUCCESS;
	private StringBuffer message = new StringBuffer();
	private Object object;
	private List<?> list = new ArrayList<Object>();
	private Set<?> set = new HashSet<Object>();
	private Map<String, ?> map = new HashMap<String, Object>();
	private Collection<?> collection;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the message
	 */
	public StringBuffer getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(StringBuffer message) {
		this.message = message;
	}
	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}
	/**
	 * @return the set
	 */
	public Set<?> getSet() {
		return set;
	}
	/**
	 * @param set the set to set
	 */
	public void setSet(Set<?> set) {
		this.set = set;
	}
	/**
	 * @return the map
	 */
	public Map<String, ?> getMap() {
		return map;
	}
	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, ?> map) {
		this.map = map;
	}
	/**
	 * @return the collection
	 */
	public Collection<?> getCollection() {
		return collection;
	}
	/**
	 * @param collection the collection to set
	 */
	public void setCollection(Collection<?> collection) {
		this.collection = collection;
	}

}
