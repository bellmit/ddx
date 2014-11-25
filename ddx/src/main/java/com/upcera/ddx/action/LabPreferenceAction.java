/**   
 * @Title: LabPreferenceAction.java 
 * @Package com.upcera.ddx.action 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:10:17 
 * @version V1.0   
 */ 
package com.upcera.ddx.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.common.reflect.DXObject;
import com.upcera.ddx.entity.LabPreference;

/** 
 * @ClassName: LabPreferenceAction 
 * @Description: 技工间偏好设置Action 
 * @author ERIC
 * @date 2014-6-11 下午02:10:17 
 *  
 */
@Controller
@RequestMapping("/labPreferenceAction")
public class LabPreferenceAction extends BaseAction {
	
	/**
	 * 
	 * @Title: pageJump 
	 * @Description: 页面跳转
	 * @author ERIC 
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return ModelAndView
	 */
	@RequestMapping("/pageJump")
	public ModelAndView pageJump(){
		return null;
		
	}
	
	/**
	 * 
	 * @Title: addData	 
	 * @Description: 新增
	 * @author ERIC 
	 * @date 2014-6-11下午02:16:08
	 * @param 
	 * @return void
	 */
	@RequestMapping("/addData")
	public void addData(HttpServletRequest request,HttpServletResponse response){
		LabPreference labPreference = new LabPreference();
		DXObject.setValue(labPreference, request);
		
		
	}
	
	/**
	 * 
	 * @Title: updateData 
	 * @Description: 修改
	 * @author ERIC 
	 * @date 2014-6-11下午02:16:42
	 * @param 
	 * @return void
	 */
	@RequestMapping("/updateData")
	public void updateData(){
		
	}
	
	/**
	 * 
	 * @Title: deleteData 
	 * @Description: 删除
	 * @author ERIC 
	 * @date 2014-6-11下午02:17:01
	 * @param 
	 * @return void
	 */
	@RequestMapping("/deleteData")
	public void deleteData(){
		
	}
	
	/**
	 * 
	 * @Title: loadAndSearch 
	 * @Description: 加载或搜索功能记录
	 * @author ERIC 
	 * @date 2014-6-11下午02:18:14
	 * @param 
	 * @return void
	 */
	@RequestMapping("/loadAndSearch")
	public void loadAndSearch() {
		
	}
	
	/**
	 * 
	 * @Title: advancedSearch 
	 * @Description: 高级查找
	 * @author ERIC 
	 * @date 2014-6-11下午02:19:18
	 * @param 
	 * @return void
	 */
	@RequestMapping("/advancedSearch")
	public void advancedSearch(){
		
	}
	
	/**
	 * 
	 * @Title: selectDataForAccurate 
	 * @Description: 精确查找
	 * @author ERIC 
	 * @date 2014-6-11下午02:19:57
	 * @param 
	 * @return void
	 */
	@RequestMapping("/selectDataForAccurate")
	public void selectDataForAccurate(){
		
	}

}
