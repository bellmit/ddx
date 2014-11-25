package com.upcera.ddx.common.util;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.DDXLog;
import com.upcera.ddx.entity.PartnerLab;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.LogPojo;
import com.upcera.ddx.pojo.LogPojo.LogLevel;
import com.upcera.ddx.pojo.LogPojo.LogType;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.ILogService;
import com.upcera.ddx.service.user.IUserService;
@Component
public class LogUtil {
	private static ILogService logService;
	private static IUserService userService;
	private static ILabService labService;
	private static IPracticeService practiceService;
	
	@Autowired
	public void setUserService(IUserService userService) {
		LogUtil.userService = userService;
	}
	@Autowired
	public void setLogService(ILogService logService) {
		LogUtil.logService = logService;
	}
	@Autowired
	public void setLabService(ILabService labService) {
		LogUtil.labService = labService;
	}
	@Autowired
	public void setPracticeService(IPracticeService practiceService) {
		LogUtil.practiceService = practiceService;
	}
	private static IUserService getUserService() {
		return userService;
	}
	public static ILogService getLogService() {
		return logService;
	}
	public static ILabService getLabService() {
		return labService;
	}
	public static IPracticeService getPracticeService() {
		return practiceService;
	}
	/**
	 * @Description: 插入日志
	 * @author king
	 * @date 2014-6-11 下午02:10:17
	 * 
	 */
	public static void add(LogPojo log)throws Exception{
		if(checkLog(log)){
			saveLog(log);
		}
	}
	/**
	 * @Description: 插入对账户的增删改日志
	 * @author king
	 * @throws Exception 
	 * @date 2014-6-11 下午02:10:17
	 * 
	 */
	public static void addUserLog(User user,String remarks) throws Exception{
		LogPojo log = new LogPojo();
		log.setLogLevel(LogLevel.GENERAL);
		log.setLogType(LogType.ACCOUNT);
		log.setPrimaryId(user.getAccountId());
		log.setRemarks(remarks);
		LogUtil.add(log);
	
	}
	/**
	 * @Description: 插入对合作技工间的审批操作日志
	 * @author king
	 * @throws Exception 
	 * @date 2014-6-11 下午02:10:17
	 * 
	 */
	public static void addPartnerLabAccountApprovalLog(String approvalStatus,PartnerLab plab) throws Exception{

		LogPojo log = new LogPojo();
		log.setLogLevel(LogLevel.GENERAL);
		log.setLogType(LogType.ACCOUNT);
		
		String unitName = "";
		if(Constans.UNIT_LAB.equals(plab.getUnitType())){
			unitName = LogUtil.getLabService().get(plab.getUnitId()).getName();
		}else if(Constans.UNIT_LAB.equals(plab.getUnitType())){
			unitName = LogUtil.getPracticeService().get(plab.getUnitId()).getName();
		}
		log.setPartnerId(plab.getUnitId());
		log.setPartnerUnitType(plab.getUnitType());
		log.setPartnerUnitName(unitName);
		log.setRemarks(Constans.approvalStatus.get(approvalStatus)+"合作机构："+unitName);
		LogUtil.add(log);
	}
	/**
	 * @Description: 插入订单操作日志
	 * @author king
	 * @throws Exception 
	 * @date 2014-6-11 下午02:10:17
	 * 
	 */
	public static void addCasesLog(LogType logType,LogLevel logLevel,String remarks,Object... object) throws Exception{
		User user = LogUtil.getUserService().getSessionUserByLoginEmail();
		try {
			for (int i = 0; i < object.length; i++) {
				LogPojo log = new LogPojo();
				log.setLogLevel(logLevel);
				log.setLogType(logType);
				Cases cases = (Cases)object[i];
				log.setPrimaryId(cases.getCaseId());
				
				String punitName = "";
				try {
					if(Constans.UNIT_LAB.equals(user.getUnitType()) && !user.getLabId().equals(cases.getLabId())){
						//当前为下单方（技工间）
						log.setPartnerId(cases.getLabId());
						log.setPartnerUnitType(Constans.UNIT_LAB);
						punitName = LogUtil.getLabService().get(cases.getLabId()).getName();
					}else if(Constans.UNIT_LAB.equals(user.getUnitType()) && user.getLabId().equals(cases.getLabId())){
						//当前为接收定单方（技工间）
						log.setPartnerId(cases.getPracticeId());
						String unitType = ToolsKit.TypeConversionUtil.asString(cases.getUnitType());
						log.setPartnerUnitType(unitType);
						if(Constans.UNIT_LAB.equals(unitType)){
							punitName = LogUtil.getLabService().get(cases.getPracticeId()).getName();
						}else if(Constans.UNIT_PRACTICE.equals(unitType)){
							punitName = LogUtil.getPracticeService().get(cases.getPracticeId()).getName();
						}
					}else if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
						//当前为下单方（诊所）
						log.setPartnerId(cases.getLabId());
						log.setPartnerUnitType(Constans.UNIT_LAB);
						punitName = LogUtil.getLabService().get(cases.getLabId()).getName();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				log.setPartnerUnitName(punitName);
				log.setRemarks(remarks);
				LogUtil.add(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * @Description: 校验日志，根据用户设定的ddx活动日志来按条件插入日志
	 * @author king
	 * @date 2014-6-11 下午02:10:17
	 * 
	 */
	private static boolean checkLog(LogPojo log)throws Exception{
		boolean flag = false;
		
		LogType logType = log.getLogType();
		User user = LogUtil.getUserService().getSessionUserByLoginEmail();
		User.DDXActivityLog logSetting = null;
		try {
			logSetting = ToolsKit.jsonUitl.toBean(User.DDXActivityLog.class, user.getDdxActivityLog());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(logSetting==null){
			return flag;
		}else if(ToolsKit.EmptyCheckUtil.isEmpty(logType)){
			
			throw new Exception("日志类型[LogType]不能为空");
			
		}else if(LogType.PICKUP_REQUEST.equals(logType)){
			if(logSetting.isPickupRequests()){
				flag = true;
			}
		}else if(LogType.PAYMENT.equals(logType)){
			if(logSetting.isBalancePayments()){
				flag = true;
			}
		}else if(LogType.BILL_REPORT.equals(logType)){
			if(logSetting.isStatements()){
				flag = true;
			}
		}else if(LogType.INVOICE.equals(logType)){
			if(logSetting.isInvoices()){
				flag = true;
			}
		}else if(LogType.ACCOUNT.equals(logType)){
			if(logSetting.isAccounts() && !logSetting.isAccountsLabUpdatesOnly() && !logSetting.isAccountsPracticeUpdatesOnly()){
				flag = true;
			}
			if(logSetting.isAccountsLabUpdatesOnly() && Constans.UNIT_LAB.equals(user.getUnitType())){
				flag = true;
			}
			if(logSetting.isAccountsPracticeUpdatesOnly() && Constans.UNIT_PRACTICE.equals(user.getUnitType())){
				flag = true;
			}
		}else if(LogType.CASE_CREATE.equals(logType)){
			if(logSetting.isCasesCreated() && !logSetting.isCasesCreatedLabUpdatesOnly() && !logSetting.isCasesCreatedPracticeUpdatesOnly()){
				flag = true;
			}
			if(logSetting.isCasesCreatedLabUpdatesOnly() && Constans.UNIT_LAB.equals(user.getUnitType())){
				flag = true;
			}
			if(logSetting.isCasesCreatedPracticeUpdatesOnly() &&  Constans.UNIT_PRACTICE.equals(user.getUnitType())){
				flag = true;
			}
		}else if(LogType.CASE_UPDATE.equals(logType)){
			if(logSetting.isUpdatedCases() && !logSetting.isUpdatedCasesLabUpdatesOnly() && !logSetting.isUpdatedCasesPracticeUpdatesOnly()){
				flag = true;
			}
			if(logSetting.isUpdatedCasesLabUpdatesOnly() && Constans.UNIT_LAB.equals(user.getUnitType())){
				flag = true;
			}
			if(logSetting.isUpdatedCasesPracticeUpdatesOnly() &&  Constans.UNIT_PRACTICE.equals(user.getUnitType())){
				flag = true;
			}
		
		}else if(LogType.OTHER.equals(logType)){
			flag = true;
		}
		return flag;
	}
	/**
	 * @Description: 保存日志
	 * @author king
	 * @date 2014-6-11 下午02:10:17
	 * 
	 */
	private static void saveLog(LogPojo log)throws Exception{
		User user = LogUtil.getUserService().getSessionUserByLoginEmail();
		DDXLog dlog = new DDXLog();
		dlog.setPrimaryId(log.getPrimaryId());
		try {
			dlog.setLogLevel(log.getLogLevel().toString());
		} catch (Exception e) {
		}
		try {
			dlog.setLogType(log.getLogType().toString());
		} catch (Exception e) {
		}
		dlog.setPartnerUnitId(log.getPartnerId());
		dlog.setPartnerUnitName(log.getPartnerUnitName());
		try {
			dlog.setPartnerUnitType(log.getPartnerUnitType().toString());
		} catch (Exception e) {
		}
		dlog.setRemarks(log.getRemarks());
		if(Constans.UNIT_LAB.equals(user.getUnitType())){
			dlog.setUnitId(user.getLabId());
			dlog.setUnitName(LogUtil.getLabService().get(user.getLabId()).getName());
		}else if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
			dlog.setUnitId(user.getPracticeId());
			dlog.setUnitName(LogUtil.getPracticeService().get(user.getPracticeId()).getName());
		}
		try {
			dlog.setUnitType(user.getUnitType());
		} catch (Exception e) {
		}
		dlog.setUserId(user.getAccountId());
		dlog.setCreateDate(new Timestamp(ToolsKit.DateUtil.nowDate().getTime()));
		dlog.setUserName(user.getFirstName()+user.getLastName());
		LogUtil.getLogService().add(dlog);
	}
}
