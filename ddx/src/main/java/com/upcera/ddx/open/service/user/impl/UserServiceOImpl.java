package com.upcera.ddx.open.service.user.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.open.pojo.Request;
import com.upcera.ddx.open.service.user.IUserServiceO;
import com.upcera.ddx.open.servlet.OpenSerice;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.practice.IPracticeService;
@Controller
public class UserServiceOImpl implements IUserServiceO {
	@Autowired
	private ILabService labService;
	@Autowired
	private IPracticeService practiceService;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> login(Request request) {
		Map retMap = new HashMap();
		User user = (User)OpenSerice.session_context.get(request.getPublicInfo().getToken()).get("user");
		retMap.put("user", user);
		retMap.put("unit", getSessionUnitByUser(request));
		retMap.put("token", request.getPublicInfo().getToken());
		return retMap;
	}
	
	/***
	 * @desc 根据用户获取机构
	 * @return unit
	 */
	public Object getSessionUnitByUser(Request request){
		try {
			User user = (User)OpenSerice.session_context.get(request.getPublicInfo().getToken()).get("user");
			if(Constans.UNIT_LAB.equals(user.getUnitType())){
				return labService.get(user.getLabId());
			}else if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
				return practiceService.get(user.getPracticeId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public File downLoad(Request request) {
		// TODO Auto-generated method stub
		String file = Constans.FILE_DOWNLAOD_PATH + request.getParameter().get("fileName");
		return new File(file);
	}
}
