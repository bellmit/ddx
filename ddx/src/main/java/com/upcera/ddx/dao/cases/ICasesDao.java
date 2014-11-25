/**   
 * @Title: ICasesDao.java 
 * @Package com.upcera.ddx.dao.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:15:26 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.CasesFilter;
import com.upcera.ddx.pojo.PageModel;

/** 
 * @ClassName: ICasesDao 
 * @Description: 订单DAO
 * @author ERIC
 * @date 2014-6-17 下午03:15:26 
 *  
 */
@Repository("casesDao")
public interface ICasesDao extends IBaseDao<Cases, Integer> {
	public List<Cases> listCasesInId(Integer...id);
	
	public PageModel listCaseTryIn(Cases caseQuery);
	
	public PageModel listCaseTryInByPractice(Cases caseQuery);
	
	public List<Cases> listCaseByMonth(CasesFilter cf,Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long getCaseCountByMonth(CasesFilter cf,Cases caseQuery);
	
	public PageModel listCaseArriveToday(Cases cases);

	public PageModel listCaseShipToday(Cases cases);
	
	public PageModel listCaseTryInsInProgress(Cases cases);
	
	public PageModel listCaseCurWeek(Cases caseQuery);
	
	public PageModel listCaseInDraf(Cases caseQuery);
	
	public PageModel queryShipCaseByLab(Cases caseQuery);
	
	public PageModel queryArriveCaseByLab(Cases caseQuery);
	
	public PageModel queryTryInCaseByLab(Cases caseQuery);
	
	public List<Cases> queryTryInCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long queryTryInCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	
	public List<Cases> queryArriveCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long queryArriveCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	
	public List<Cases> queryShipCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);

	public Long queryShipCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	
	public Cases getArriveCaseByLab(Integer caseId, Integer labId);
	
	public Cases getShipCaseByLab(Integer caseId, Integer labId);
	
	public void updateCaseArriveBatch(Integer[] idArry);
	
	public void updateCasePracticeArriveBatch(Integer[] idArry);
	
	public void updateCaseShipBatch(List<Cases> casesList);
	
	public PageModel queryOnHoldCaseByLab(Cases caseQuery);
	
	public List<Cases> listAllLabCases(Cases caseQuery, Integer pageNo, Integer pageSize);

	public Long getAllLabCasesCount(Cases caseQuery);
	
	public List<Cases> queryOnHoldCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);

	public Long queryOnHoldCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	/**
	 * 
	 * @Description: 统计标签以及案例数
	 * @author king  
	 * @date 2014-8-11下午03:45:19
	 * @return void
	 */
	public List<Map<String, Object>> countTags(Integer unitId,Integer unitType)throws Exception ;
	
	/**
	 * 
	 * @Title: listCaseIsFollowed 
	 * @Description: 由诊所端创建并处于followed状态的订单
	 * @author ERIC 
	 * @date 2014-9-2下午04:29:03
	 * @return PageModel
	 */
	public PageModel listCaseIsFollowed(Cases caseQuery);
	
	public PageModel queryCaseRemake(CasesFilter cf,Cases caseQuery);
	
	public PageModel queryOutsourceCase(Cases caseQuery);
	
	public PageModel queryOutsourceCaseByLab(Cases caseQuery);
	
	public List<Cases> queryOutsourceCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long queryOutsourceCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	
	public List<String> queryTags(Cases caseQuery);
	
	public List<Cases> queryAllLabCases(CasesFilter cf,Cases caseQuery,int pageNo, int pageSize);
	
	public Long queryAllLabCasesCount(CasesFilter cf,Cases caseQuery);
	
	public int updateCasesProcedure(Integer casesId,String procedures);
	
	public int updateTeethNotation(Integer caeseId,String TeethNotation);
	
	public int updateCasesStatus(Integer casesId,String status);
	
	public List<Cases> queryCasesBySearchCri(Cases caseQuery,int pageNo, int pageSize);
	
	public Long queryCasesCountBySearchCri(Cases caseQuery);
	
	public int updateAppointDate(Cases caseQuery);
	
	public int updateCasesOnHoldStatus(Cases caseQuery);
	
	public int updateCasesPrice(Integer casesId, Double originalPrice);
	
	public int updateCaseFinishPrice(Cases cases) throws Exception;
	/**
	 * 
	 * @Title: casesFinanceReport 
	 * @Description: 根据时间段统计机构的订单报表
	 * @author king 
	 * @date 2014-9-2下午04:29:03
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> casesFinanceReport(User sessionUser,Date beginDate,Date endDate,int pageSize,int pageNo) throws Exception;
	/**
	 * 
	 * @Title: casesFinanceReport 
	 * @Description: 根据时间段统计机构的订单总费用
	 * @author king 
	 * @date 2014-9-2下午04:29:03
	 * @return List<Map<String, Object>>
	 */
	public Map<String, Object> casesFinanceReport(User sessionUser,Date beginDate,Date endDate) throws Exception;
	
	public List<Cases> queryArriveCasesByPratice(Cases caseQuery, Integer pageNo, Integer pageSize);

	public Long queryArriveCasesCountByPratice(Cases caseQuery);
	
	public List<Cases> queryCasesByPatient(Cases caseQuery,Integer pageNo, Integer pageSize);
	
	public Long queryCasesCountByPatient(Cases caseQuery);
	
	public List<Cases> queryCasesByTags(Cases caseQuery,Integer pageNo, Integer pageSize);
	
	public Long queryCasesCountByTags(Cases caseQuery);
	
	public List<Map<String,Object>> queryEveryTagAndCount(Cases caseQuery);
	
	public int updateCasesDates(Cases cases) throws Exception;
	
	public int updateCasesDeliveryDates(Cases cases) throws Exception;

	public List<Integer> queryCasesSerialsByLabO(Cases caseQuery, Date sd, Date ed);
		
}
