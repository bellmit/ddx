/**   
 * @Title: CaseSettingAction.java 
 * @Package com.upcera.ddx.action 
 * @author ERIC
 * @company UPCERA
 * @date 2014-7-28 下午02:10:17 
 * @version V1.0   
 */ 
package com.upcera.ddx.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upcera.ddx.common.reflect.DXObject;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.entity.LabProceduresComposition;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.lab.ILabProceduresCharacterisService;
import com.upcera.ddx.service.lab.ILabProceduresCompositionService;


/** 
 * @ClassName: CaseSettingAction 
 * @Description: 案例设置Action 
 * @author ERIC
 * @date 2014-7-28 下午02:10:17
 *  
 */
@Controller
@RequestMapping("/casesSettingAction")
public class CaseSettingAction extends BaseAction {
	
	@Autowired
	private ILabProceduresCharacterisService characterisService;
	
	@Autowired
	private ILabProceduresCompositionService compositionService;
	
	@RequestMapping("/addMaterial")
	public void addMaterial(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException,
			IOException {
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		String compostionStr = request.getParameter("composition");
		List<LabProceduresComposition> compList = ToolsKit.jsonUitl.toBeanList(LabProceduresComposition.class, compostionStr);
		DXObject.setValue(characteris, request);
		characteris.setType(Constans.PROCEDURES_CHARACTERIS_MATERIALS);
		characteris.setLabId(getSessionLab().getId());
		characterisService.addMaterialAndComposition(characteris, compList);
		try {
			result.setInfo("新增成功");
			outJson(result, "addMaterial", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateMaterial")
	public void updateMaterial(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresCharacteris characteris0 = new LabProceduresCharacteris();
		DXObject.setValue(characteris0, request);
		characteris = characterisService.get(characteris0.getId());
		characteris.setCharacterName(characteris0.getCharacterName());
		characteris.setClassfication(characteris0.getClassfication());
		characteris.setDefaultPrice(characteris0.getDefaultPrice());
		characteris.setTaxable(characteris0.getTaxable());
		String compostionStr = request.getParameter("composition");
		List<LabProceduresComposition> compList = ToolsKit.jsonUitl.toBeanList(LabProceduresComposition.class, compostionStr);
		characterisService.updateMaterialAndCompostion(characteris, compList);
		try {
			result.setInfo("更新成功");
			outJson(result, "updateMaterial", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addEnclosure")
	public void addEnclosures(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		DXObject.setValue(characteris, request);
		characteris.setType(Constans.PROCEDURES_CHARACTERIS_ENCLOSURES);
		characteris.setLabId(getSessionLab().getId());
		characterisService.add(characteris);
		try {
			result.setInfo("新增成功");
			outJson(result, "addEnclosure", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateEnclosure")
	public void updateEnclosures(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresCharacteris characteris0 = new LabProceduresCharacteris();
		DXObject.setValue(characteris0, request);
		characteris = characterisService.get(characteris0.getId());
		characteris.setCharacterName(characteris0.getCharacterName());
		characteris.setDefaultPrice(characteris0.getDefaultPrice());
		characteris.setTaxable(characteris0.getTaxable());
		characterisService.update(characteris);
		try {
			result.setInfo("更新成功");
			outJson(result, "updateEnclosure", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addAcrylicColor")
	public void addAcrylicColor(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		DXObject.setValue(characteris, request);
		characteris.setType(Constans.PROCEDURES_CHARACTERIS_ACRYLICCOLORS);
		characteris.setLabId(getSessionLab().getId());
		characterisService.add(characteris);
		try {
			result.setInfo("新增成功");
			outJson(result, "addAcrylicColor", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@RequestMapping("/updateAcrylicColor")
	public void updateAcrylicColor(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresCharacteris characteris0 = new LabProceduresCharacteris();
		DXObject.setValue(characteris0, request);
		characteris = characterisService.get(characteris0.getId());
		characteris.setCharacterName(characteris0.getCharacterName());
		characteris.setDefaultPrice(characteris0.getDefaultPrice());
		characteris.setTaxable(characteris0.getTaxable());
		characterisService.update(characteris);
		try {
			result.setInfo("更新成功");
			outJson(result, "updateAcrylicColor", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addSportGuardColor")
	public void addSportGuardColor(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		DXObject.setValue(characteris, request);
		characteris.setType(Constans.PROCEDURES_CHARACTERIS_SPORTGUARDCOLORS);
		characteris.setLabId(getSessionLab().getId());
		characterisService.add(characteris);
		try {
			result.setInfo("新增成功");
			outJson(result, "addSportGuardColor", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/updateSportGuardColor")
	public void updateSportGuardColor(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresCharacteris characteris0 = new LabProceduresCharacteris();
		DXObject.setValue(characteris0, request);
		characteris = characterisService.get(characteris0.getId());
		characteris.setCharacterName(characteris0.getCharacterName());
		characteris.setDefaultPrice(characteris0.getDefaultPrice());
		characteris.setTaxable(characteris0.getTaxable());
		characterisService.update(characteris);
		try {
			result.setInfo("更新成功");
			outJson(result, "updateSportGuardColor", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addOrthodonticColor")
	public void addOrthodonticColor(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		DXObject.setValue(characteris, request);
		characteris.setType(Constans.PROCEDURES_CHARACTERIS_ORTHODONTICCOLORS);
		characteris.setLabId(getSessionLab().getId());
		characterisService.add(characteris);
		try {
			result.setInfo("新增成功");
			outJson(result, "addOrthodonticColor", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateOrthodonticColor")
	public void updateOrthodonticColor(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresCharacteris characteris0 = new LabProceduresCharacteris();
		DXObject.setValue(characteris0, request);
		characteris = characterisService.get(characteris0.getId());
		characteris.setCharacterName(characteris0.getCharacterName());
		characteris.setDefaultPrice(characteris0.getDefaultPrice());
		characteris.setTaxable(characteris0.getTaxable());
		characterisService.update(characteris);
		try {
			result.setInfo("更新成功");
			outJson(result, "updateOrthodonticColor", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addOrthodonticDesign")
	public void addOrthodonticDesign(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		DXObject.setValue(characteris, request);
		characteris.setType(Constans.PROCEDURES_CHARACTERIS_ORTHODONTICDESIGNS);
		characteris.setLabId(getSessionLab().getId());
		characterisService.add(characteris);
		try {
			result.setInfo("新增成功");
			outJson(result, "addOrthodonticDesign", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateOrthodonticDesign")
	public void updateOrthodonticDesign(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresCharacteris characteris0 = new LabProceduresCharacteris();
		DXObject.setValue(characteris0, request);
		characteris = characterisService.get(characteris0.getId());
		characteris.setCharacterName(characteris0.getCharacterName());
		characteris.setDefaultPrice(characteris0.getDefaultPrice());
		characteris.setTaxable(characteris0.getTaxable());
		characterisService.update(characteris);
		try {
			result.setInfo("更新成功");
			outJson(result, "updateOrthodonticDesign", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addImplantSystem")
	public void addImplantSystem(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		DXObject.setValue(characteris, request);
		characteris.setType(Constans.PROCEDURES_CHARACTERIS_IMPLANTSYSTEMS);
		characteris.setLabId(getSessionLab().getId());
		characterisService.add(characteris);
		try {
			result.setInfo("新增成功");
			outJson(result, "addImplantSystem", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/updateImplantSystem")
	public void updateImplantSystem(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresCharacteris characteris0 = new LabProceduresCharacteris();
		DXObject.setValue(characteris0, request);
		characteris = characterisService.get(characteris0.getId());
		characteris.setCharacterName(characteris0.getCharacterName());
		characteris.setClassfication(characteris0.getClassfication());
		characteris.setDefaultPrice(characteris0.getDefaultPrice());
		characteris.setTaxable(characteris0.getTaxable());
		characterisService.update(characteris);
		try {
			result.setInfo("更新成功");
			outJson(result, "updateImplantSystem", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addImplantMarker")
	public void addImplantMarker(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		DXObject.setValue(characteris, request);
		characteris.setType(Constans.PROCEDURES_CHARACTERIS_IMPLANTMARKERS);
		characteris.setLabId(getSessionLab().getId());
		characterisService.add(characteris);
		try {
			result.setInfo("新增成功");
			outJson(result, "addImplantMarker", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateImplantMarker")
	public void updateImplantMarker(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresCharacteris characteris0 = new LabProceduresCharacteris();
		DXObject.setValue(characteris0, request);
		characteris = characterisService.get(characteris0.getId());
		characteris.setCharacterName(characteris0.getCharacterName());
		characteris.setDefaultPrice(characteris0.getDefaultPrice());
		characteris.setTaxable(characteris0.getTaxable());
		characterisService.update(characteris);
		try {
			result.setInfo("更新成功");
			outJson(result, "updateImplantMarker", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/delCharacter")
	public void delCharacter(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		String genre = request.getParameter("genre");
		DXObject.setValue(characteris, request);
		characterisService.delete(characteris.getId());
		try {
			result.setInfo("删除成功");
			outJson(result, genre, "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/delMaterial")
	public void delMaterial(HttpServletRequest request, HttpServletResponse response){
		AjaxResult result = new AjaxResult();
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		LabProceduresComposition comp = new LabProceduresComposition();
		String genre = request.getParameter("genre");
		DXObject.setValue(characteris, request);
		comp.setCharacterId(characteris.getId());
		PageModel pm = new PageModel();
		List<LabProceduresComposition> compostionList = null;
		List<Integer> ids = new ArrayList<Integer>();
		pm = compositionService.getCompositionByCriteria(comp);
		compostionList = (List<LabProceduresComposition>) pm.getDatas();
		if(compostionList != null && pm.getTotal() > 0){
			for(int i = 0;i < pm.getTotal();i++){
				ids.add(compostionList.get(i).getId());
			}
		}
		characterisService.deleteMaterial(comp.getCharacterId(),ids);
		try {
			result.setInfo("删除成功");
			outJson(result, genre, "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
