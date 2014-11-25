/**   
 * @Title: ListUtil.java 
 * @Package com.upcera.ddx.common.util 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-10 上午08:55:22 
 * @version V1.0   
 */ 
package com.upcera.ddx.common.util;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: ListUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author ERIC
 * @date 2014-6-10 上午08:55:22 
 *  
 */

public class ListUtil {
	
	public static List<Object> pickList(List<Object> list, int index, int count) {
		List<Object> newList = new ArrayList<Object>();
		if (list != null) {
			int k = list.size();
			int fromIndex = (index - 1) * count;
			int toIndex = index * count;
			toIndex = toIndex > k ? k : toIndex;
			newList = list.subList(fromIndex, toIndex);
		}
		return newList;
	}
	
}
