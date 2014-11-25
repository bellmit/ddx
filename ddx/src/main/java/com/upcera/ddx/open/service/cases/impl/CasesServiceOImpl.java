package com.upcera.ddx.open.service.cases.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.open.pojo.Request;
import com.upcera.ddx.open.service.cases.ICasesServiceO;
import com.upcera.ddx.open.servlet.OpenSerice;
import com.upcera.ddx.service.cases.ICasesService;
@Controller
public class CasesServiceOImpl implements ICasesServiceO {

	@Autowired
	private ICasesService casesService;
	
	@Override
	public List<Integer> queryCasesSerialsByLab(Request request) {
		Cases caseQuery = new Cases();
		Object sd_obj = request.getParameter().get("startDate");
		Object ed_obj = request.getParameter().get("endDate");
		Date sd = new Date();
		Date ed = sd;
		try{
		if(null != sd_obj){
			sd = ToolsKit.DateUtil.parse(sd_obj.toString(),"yyyy-MM-dd HH:mm:ss");
		}else{
			sd = ToolsKit.DateUtil.getDayBegin(sd);
		}
		if(null != ed_obj){
			ed = ToolsKit.DateUtil.parse(ed_obj.toString(),"yyyy-MM-dd HH:mm:ss");
		}else{
			ed = ToolsKit.DateUtil.getDayEnd(ed);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		User user = (User)OpenSerice.session_context.get(request.getPublicInfo().getToken()).get("user");
		Integer labId = user.getLabId();
		caseQuery.setLabId(labId);
		return casesService.queryCasesSerialsByLabO(caseQuery,sd,ed);
	}

	@Override
	public Cases queryCasesDetailById(Request request) {
		String caseId = (String) request.getParameter().get("caseId");
		Integer id = Integer.valueOf(caseId);
		Cases cases = casesService.get(id);
		return cases;
	}

}
