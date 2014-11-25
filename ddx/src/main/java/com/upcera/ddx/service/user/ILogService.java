package com.upcera.ddx.service.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.upcera.ddx.entity.DDXLog;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.service.base.IBaseService;

public interface ILogService  extends IBaseService<DDXLog, Integer>{
	public List<DDXLog> loadLog(DDXLog log,Date startDate,Date endDate)throws Exception;
	public List<Map<String, Object>> getActivitiesLog(String type,Date startTime,Date endTime,User sessionUser)throws Exception;

}
