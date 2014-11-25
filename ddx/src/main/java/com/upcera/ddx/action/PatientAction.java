/**   
 * @Title: PatientAction.java 
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

/** 
 * @ClassName: CaseNotesAction 
 * @Description: 案例笔记Action 
 * @author ERIC
 * @date 2014-6-11 下午02:10:17 
 *  
 */
@Controller
@RequestMapping("/patientAction")
public class PatientAction extends BaseAction {
	
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

}
