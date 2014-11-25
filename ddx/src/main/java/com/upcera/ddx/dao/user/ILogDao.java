package com.upcera.ddx.dao.user;

import java.util.Date;
import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.DDXLog;

@org.springframework.stereotype.Repository("logDao")
public interface ILogDao extends IBaseDao<DDXLog, Integer> {
	public List<DDXLog> loadLog(DDXLog log, Date startDate, Date endDate)throws Exception;
}
