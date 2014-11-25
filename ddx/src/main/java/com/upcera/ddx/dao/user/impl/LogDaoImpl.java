package com.upcera.ddx.dao.user.impl;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.common.util.ToolsKit.TypeConversionUtil;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.user.ILogDao;
import com.upcera.ddx.entity.DDXLog;
@Repository
public class LogDaoImpl extends BaseHibernateDao<DDXLog, Integer> implements ILogDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DDXLog> loadLog(DDXLog log, Date startDate, Date endDate) throws Exception {
		List<DDXLog> resultList = new ArrayList<DDXLog>();
		String sql = "select * from (select c.*, d.first_name, d.last_name from (select a.*, b.patient_id from ddx_log a left join ddx_case b on a.primary_id = b.case_id) c left join ddx_lab_practice_patients d on c.patient_id = d.id) s where 1=1 and 2=2 and s.CREATE_DATE >:startDate and s.CREATE_DATE <:endDate and (s.UNIT_ID =:unitId and s.UNIT_TYPE =:unitType or s.PARTNER_UNIT_ID =:unitId and s.PARTNER_UNIT_TYPE =:partnerUnitType) order by s.CREATE_DATE desc";
		if(!"all".equals(log.getLogType())){
			sql = sql.replace("1=1", "s.LOG_TYPE in (:logType)");
		}
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(log.getLogLevel())){
			sql = sql.replace("2=2", "s.LOG_LEVEL=:logLevel");
		}
		SQLQuery sqlquersy = getSession().createSQLQuery(sql);
		if(!"all".equals(log.getLogType())){
			sqlquersy.setParameterList("logType", log.getLogType().split(","));
		}
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(log.getLogLevel())){
			sqlquersy.setString("logLevel", log.getLogLevel());
		}
		sqlquersy.setInteger("unitId", log.getUnitId());
		sqlquersy.setString("unitType", log.getUnitType());
		sqlquersy.setString("partnerUnitType", log.getPartnerUnitType());
		sqlquersy.setTimestamp("startDate", startDate);
		sqlquersy.setTimestamp("endDate", endDate);
		List<Object> list = sqlquersy.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[])list.get(i);
			DDXLog ddxlog = new DDXLog();
			ddxlog.setId(TypeConversionUtil.asInteger(obj[0]));
			ddxlog.setCreateDate((Timestamp)obj[1]);
			ddxlog.setLogLevel(TypeConversionUtil.asString(obj[2]));
			ddxlog.setLogType(TypeConversionUtil.asString(obj[3]));
			ddxlog.setPartnerUnitId(TypeConversionUtil.asInteger(obj[4]));
			ddxlog.setPartnerUnitName(TypeConversionUtil.asString(obj[5]));
			ddxlog.setPartnerUnitType(TypeConversionUtil.asString(obj[6]));
			ddxlog.setRemarks(TypeConversionUtil.asString(obj[7]));
			ddxlog.setUnitId(TypeConversionUtil.asInteger(obj[8]));
			ddxlog.setUnitType(TypeConversionUtil.asString(obj[9]));
			ddxlog.setUserId(TypeConversionUtil.asInteger(obj[10]));
			ddxlog.setUserName(TypeConversionUtil.asString(obj[11]));
			ddxlog.setPrimaryId(TypeConversionUtil.asInteger(obj[12]));
			ddxlog.setUnitName(TypeConversionUtil.asString(obj[13]));
			ddxlog.setPatientId(TypeConversionUtil.asInteger(obj[14]));
			ddxlog.setPatientFirstName(TypeConversionUtil.asString(obj[15]));
			ddxlog.setPatientLastName(TypeConversionUtil.asString(obj[16]));
			resultList.add(ddxlog);
		
		}
		
		return resultList;
		/*String hql = "from DDXLog l where 1=1 and ((l.unitId=:unitId and l.unitType=:unitType) or (partnerUnitId=:unitId and partnerUnitType=:partnerUnitType)) and l.createDate>:startDate and l.createDate<:endDate order by l.createDate desc";
		if(!"all".equals(log.getLogType())){
			hql = hql.replace("1=1", "l.logType in(:logType)");
		}
		Query query = getSession().createQuery(hql);
		if(!"all".equals(log.getLogType())){
			query.setParameterList("logType", log.getLogType().split(","));
		}
		query.setInteger("unitId", log.getUnitId());
		query.setString("unitType", log.getUnitType());
		query.setString("partnerUnitType", log.getPartnerUnitType());
		query.setTimestamp("startDate", startDate);
		query.setTimestamp("endDate", endDate);
		return query.list();*/
	}

}
