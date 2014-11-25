package com.upcera.ddx.open.service.user;

import java.io.File;
import java.util.Map;

import com.upcera.ddx.open.pojo.Request;

public interface IUserServiceO {
	public Map<String, Object> login(Request request);
	public File downLoad(Request request);
	
	/***
	 * @desc 根据用户获取机构
	 * @return unit
	 */
	public Object getSessionUnitByUser(Request request);
}
