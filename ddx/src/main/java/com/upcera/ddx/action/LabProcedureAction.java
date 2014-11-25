/**   
 * @Title: LabProcedureAction.java 
 * @Package com.upcera.ddx.action 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:10:17 
 * @version V1.0   
 */ 
package com.upcera.ddx.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.common.reflect.DXObject;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.entity.LabProcedure;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.MyModelAndView;
import com.upcera.ddx.pojo.AjaxResult.Booleans;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.IProcedureDisplayCategoryService;

/** 
 * @ClassName: LabProcedureAction 
 * @Description: 技工间工序Action 
 * @author ERIC
 * @date 2014-6-11 下午02:10:17 
 *  
 */
@Controller
@RequestMapping("/labProcedureAction")
public class LabProcedureAction extends BaseAction {
	
	@Autowired
	private ILabProcedureService procedureService;
	
	@Autowired
	private IProcedureDisplayCategoryService displayCategoryService;
	
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
	public ModelAndView pageJump(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String type = req.getParameter("type");
		if("toNewProcedure".equals(type)){//跳转到新增页面
			mav = new MyModelAndView().setViewName("box/box_Select_Procedure");
		}
		return mav;
	}
	/**
	 * 
	 * @Title: deleteDisplayCategory 
	 * @Description: 删除工序显示类别
	 * @author king 
	 * @throws Exception 
	 * @date 2014-6-11下午02:13:59
	 */
	@RequestMapping("/deleteDisplayCategory")
	public void deleteDisplayCategory(HttpServletRequest request,HttpServletResponse response) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "删除失败");
		try {
			Integer id = getParameterAsInteger(request, "id");
			displayCategoryService.delete(id);
			result.setResult(Booleans.TRUE);
		} catch (Exception e) {
			result.setFailReasons(e.getMessage());
			e.printStackTrace();
		}
		outReturnAjaxResult(result, response);
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
		LabProcedure labProcedure = new LabProcedure();
		DXObject.setValue(labProcedure, request);
		
		
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

	/**
	 * 
	 * @Title: loadProcedure 
	 * @Description: 加载所属技工间的工序
	 * @author ERIC 
	 * @date 2014-7-16下午05:00:25
	 * @return void
	 */
	@RequestMapping("/loadProcedure")
	public void loadProcedure(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		List<LabProcedure> lpList = new ArrayList<LabProcedure>();
		StringBuffer buffer = new StringBuffer();
		LabProcedure lp  = new LabProcedure();
		Integer labId = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("labId"));
		lp.setLabId(labId);
		lpList = procedureService.getProedureByCriteria(lp);
		if(lpList.size() >= 0){
			buffer.append("<option>--请选择工序--</option>");
			buffer.append("<optgroup label='fixed'>");
			buffer.append("<option value='1'>fix1</option>");
			buffer.append("<option value='2'>fix2</option>");
			buffer.append("<option value='3'>fix3</option>");
			buffer.append("</optgroup>");
			buffer.append("<optgroup label='implant'>");
			buffer.append("<option value='11'>implant1</option>");
			buffer.append("<option value='12'>implant2</option>");
			buffer.append("<option value='13'>implant3</option>");
			buffer.append("</optgroup>");
		}
		outJson(buffer, "loadProcedure", "success", resp);
	}
}
