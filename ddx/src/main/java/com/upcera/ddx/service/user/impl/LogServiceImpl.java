package com.upcera.ddx.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.common.util.LogUtil;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.user.ILogDao;
import com.upcera.ddx.entity.DDXLog;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.LogPojo;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.user.ILogService;
import com.upcera.ddx.service.user.IUserService;
@Service
public class LogServiceImpl extends BaseServiceImpl<DDXLog, Integer> implements ILogService {

	
	@Resource ILogDao logDao;
	@Resource IUserService userService;
	@Override
	public IBaseDao<DDXLog, Integer> getDao() {
		// TODO Auto-generated method stub
		return logDao;
	}
	@Override
	public List<DDXLog> loadLog(DDXLog log, Date startDate, Date endDate) throws Exception{
		// TODO Auto-generated method stub
		return logDao.loadLog(log, startDate, endDate);
	}
	@Override
	public List<Map<String, Object>> getActivitiesLog(String type,Date startTime, Date endTime,User sessionUser) throws Exception {
		DDXLog log = new DDXLog();
		log.setUnitId(sessionUser.getUnitId());
		log.setUnitType(sessionUser.getUnitType());
		log.setPartnerUnitType(sessionUser.getUnitType());
		log.setLogType(type);
		List<DDXLog> logs = LogUtil.getLogService().loadLog(log, startTime, endTime);
		
		//group by day
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(logs)){
			
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < logs.size(); i++) {
				//过滤掉未订阅的机构订单日志
				if(Constans.UNIT_LAB.equals(sessionUser.getUnitType()) && logs.get(i).getUnitType().equals(Constans.UNIT_PRACTICE)){
					User.DDXActivityLog logObj = ToolsKit.jsonUitl.toBean(User.DDXActivityLog.class, sessionUser.getDdxActivityLog());
					if(LogPojo.LogType.CASE_CREATE.toString().equals(logs.get(i).getLogType()) && !logObj.isCasesCreatedPracticeUpdatesOnly()){
						continue;
					}else if(LogPojo.LogType.CASE_UPDATE.toString().equals(logs.get(i).getLogType()) && !logObj.isUpdatedCasesPracticeUpdatesOnly()){
						continue;
					}
				}else if(Constans.UNIT_PRACTICE.equals(sessionUser.getUnitType()) && logs.get(i).getUnitType().equals(Constans.UNIT_LAB)){
					User.DDXActivityLog logObj = ToolsKit.jsonUitl.toBean(User.DDXActivityLog.class, sessionUser.getDdxActivityLog());
					if(LogPojo.LogType.CASE_CREATE.toString().equals(logs.get(i).getLogType()) && !logObj.isCasesCreatedLabUpdatesOnly()){
						continue;
					}else if(LogPojo.LogType.CASE_UPDATE.toString().equals(logs.get(i).getLogType()) && !logObj.isUpdatedCasesLabUpdatesOnly()){
						continue;
					}
				}
				String createDate = ToolsKit.DateUtil.formatDate(logs.get(i).getCreateDate(), "yyyy-MM-dd");
				List<DDXLog> list = (List)map.get(createDate);
				if(list==null){
					list = new ArrayList<DDXLog>();
					map.put(createDate, list);
				}
				list.add(logs.get(i));
			}
			for (int i = 1; i <= 7; i++) {
				String day = ToolsKit.DateUtil.formatDate(ToolsKit.DateUtil.addDay(endTime, -i), "yyyy-MM-dd");
				Map<String, Object> imap = new HashMap<String, Object>();
				imap.put("day", day);
				imap.put("data", map.get(day));
				result.add(imap);
			}
		}
		return result;
	}

}
