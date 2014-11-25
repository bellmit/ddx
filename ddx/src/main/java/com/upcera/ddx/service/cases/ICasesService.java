/**   
 * @Title: ICasesService.java 
 * @Package com.upcera.ddx.service.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:15:50 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.cases;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.upcera.ddx.common.Response;
import com.upcera.ddx.entity.CaseNotes;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.Patient;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.CasesFilter;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ICasesService 
 * @Description: 订单Service 
 * @author ERIC
 * @date 2014-6-17 下午04:15:50 
 *  
 */

public interface ICasesService extends IBaseService<Cases, Integer> {
	
	public List<Cases> listCasesInId(Integer...id);

	public Response addData(Cases cases, Patient patient, CaseNotes notes);
	
	public Response updateResumeData(Cases cases, Patient patient, CaseNotes notes);
	
	public Response addDataBasePatient(Cases cases, Patient patient, CaseNotes notes);
	
	public PageModel listCaseTryIn(Cases caseQuery);
	
	public PageModel listCaseTryInByPractice(Cases caseQuery);
	
	public List<Cases> listCaseByMonth(CasesFilter cf ,Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long getCaseCountByMonth(CasesFilter cf,Cases caseQuery);
	
	public PageModel listCaseArriveToday(Cases cases);
	
	public PageModel listCaseShipToday(Cases cases);
	
	public PageModel listCaseTryInsInProgress(Cases cases);
	
	/**
	 * 
	 * @Title: listCaseCurWeek 
	 * @Description: 当前周的订单集合
	 * @author ERIC 
	 * @date 2014-8-5下午01:26:04
	 * @return PageModel
	 */
	public PageModel listCaseCurWeek(Cases caseQuery);
	
	/**
	 * 
	 * @Title: listCaseInDraf 
	 * @Description: 由诊所端创建并处于草稿状态的订单
	 * @author ERIC 
	 * @date 2014-8-5下午01:44:17
	 * @return PageModel
	 */
	public PageModel listCaseInDraf(Cases caseQuery);
	
	/**
	 * 
	 * @Title: listCaseIsFollowed 
	 * @Description: 由诊所端创建并处于followed状态的订单
	 * @author ERIC 
	 * @date 2014-9-2下午04:29:03
	 * @return PageModel
	 */
	public PageModel listCaseIsFollowed(Cases caseQuery);
	
	/**
	 * 
	 * @Title: queryShipCaseByLab 
	 * @Description: 技工间首页 查询发货订单
	 * @author ERIC 
	 * @date 2014-8-5下午03:15:14
	 * @return PageModel
	 */
	public PageModel queryShipCaseByLab(Cases caseQuery);
	
	/**
	 * 
	 * @Title: queryArriveCaseByLab 
	 * @Description: 技工间首页	查询到达的订单
	 * @author ERIC 
	 * @date 2014-8-5下午03:29:15
	 * @return PageModel
	 */
	public PageModel queryArriveCaseByLab(Cases caseQuery);
	
	/**
	 * 
	 * @Title: queryTryInCaseByLab 
	 * @Description: 技工间首页	查询试戴的订单
	 * @author ERIC 
	 * @date 2014-8-5下午04:10:12
	 * @return PageModel
	 */
	public PageModel queryTryInCaseByLab(Cases caseQuery);
	
	/**
	 * 
	 * @Title: queryOnHoldCaseByLab 
	 * @Description: 技工间首页 查询onHold状态的订单
	 * @author ERIC 
	 * @date 2014-8-28上午09:20:34
	 * @return PageModel
	 */
	public PageModel queryOnHoldCaseByLab(Cases caseQuery);
	
	/**
	 * 
	 * @Title: queryOutsourceCaseByLab 
	 * @Description: 技工间首页查询outsource的订单
	 * @author ERIC 
	 * @date 2014-9-16上午09:43:16
	 * @return PageModel
	 */
	public PageModel queryOutsourceCaseByLab(Cases caseQuery);
	
	/**
	 * 
	 * @Title: queryTryInCaseByLabPage 
	 * @Description: 分页查询试戴的订单
	 * @author ERIC 
	 * @date 2014-8-6上午11:03:57
	 * @return List<Cases>
	 */
	public List<Cases> queryTryInCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long queryTryInCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	
	public List<Cases> queryOnHoldCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public List<Cases> queryOutsourceCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long queryOnHoldCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	
	public Long queryOutsourceCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	
	public List<Cases> queryArriveCaseByLabPage(CasesFilter cf,Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long queryArriveCaseCountByLabPage(CasesFilter cf,Cases caseQuery);
	
	public List<Cases> queryShipCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize);
	
	public Long queryShipCaseCountByLabPage(CasesFilter cf, Cases caseQuery);
	
	public Cases getArriveCaseByLab(Integer caseId, Integer labId);
	
	public Cases getShipCaseByLab(Integer caseId, Integer labId);
	
	/**
	 * 
	 * @Title: updateCaseArriveBatch 
	 * @Description: 批量修改arrive字段
	 * @author ERIC 
	 * @date 2014-8-11下午03:45:19
	 * @return void
	 */
	public void updateCaseArriveBatch(Integer[] idArry);
	
	public void updateCasePracticeArriveBatch(Integer[] idArry);
	
	public void updateCaseShipBatch(List<Cases> casesList);
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
	 * @Title: addRemakeData 
	 * @Description: 重制订单
	 * @author ERIC 
	 * @date 2014-9-9下午04:32:28
	 * @return Response
	 */
	public Response addRemakeData(Cases sourceCases,Cases cases, Patient patient, CaseNotes notes);
	
	/**
	 * 
	 * 
	 * @Title: queryCaseRemake 
	 * @Description: 查询重制订单
	 * @author ERIC 
	 * @date 2014-9-10上午10:20:48
	 * @return List<Cases>
	 */
	public PageModel queryCaseRemake(CasesFilter cf,Cases caseQuery);
	
	/**
	 * 
	 * @Title: queryOutsourceCase 
	 * @Description: 外包订单查询
	 * @author ERIC 
	 * @date 2014-9-11下午04:48:24
	 * @return PageModel
	 */
	public PageModel queryOutsourceCase(Cases caseQuery);
	
	public List<String> queryTags(Cases caseQuery);
	
	/**
	 * 
	 * @Title: queryAllLabCases 
	 * @Description: 诊所向某个技工间下的所有单
	 * @author ERIC 
	 * @date 2014-10-9上午09:04:49
	 * @return List<Cases>
	 */
	public List<Cases> queryAllLabCases(CasesFilter cf,Cases caseQuery,int pageNo, int pageSize);
	
	/**
	 * 
	 * @Title: queryAllLabCasesCount 
	 * @Description: 诊所向某个技工间下单的总数
	 * @author ERIC 
	 * @date 2014-10-9上午09:17:12
	 * @return Long
	 */
	public Long queryAllLabCasesCount(CasesFilter cf,Cases caseQuery);
	
	public int updateCasesProcedure(Integer casesId,String procedures)throws Exception;
	
	public int updateCasesProcedureAndStatus(Integer casesId,String procedures,String status)throws Exception;
	
	public List<Cases> queryCasesBySearchCri(Cases caseQuery,int pageNo, int pageSize);
	
	public Long queryCasesCountBySearchCri(Cases caseQuery);
	
	public Double queryCasesPrice(Integer casesId)throws Exception;
	
	/**
	 * 
	 * @Title: updateCasesPrice 
	 * @Description: 根据订单id更新订单价格
	 * @author ERIC 
	 * @date 2014-10-24上午09:04:26
	 * @return int
	 */
	public int updateCasesPrice(Integer casesId) throws Exception;
	
	public int updateTryIn(Cases caseQuery, String proJson, CaseNotes note) throws Exception;
	
	public int updateCaseProcedureAndPrice(Cases caseQuery) throws Exception;
	
	/**
	 * 
	 * @Title: updateCaseFinishPrice 
	 * @Description: 单一订单议价成功后改价
	 * @author ERIC 
	 * @date 2014-10-25上午10:26:17
	 * @return int
	 */
	public int updateCaseFinishPrice(Cases cases) throws Exception;
	
	
	public Map<String, Object> casesFinanceReport(User sessionUser,Date beginDate,Date endDate,int pageSize,int pageNo) throws Exception;
	public List<Cases> queryArriveCasesByPratice(Cases caseQuery,Integer pageNo, Integer pageSize);
	
	public Long queryArriveCasesCountByPratice(Cases caseQuery);
	
	public List<Cases> queryCasesByPatient(Cases caseQuery,Integer pageNo, Integer pageSize);
	
	public Long queryCasesCountByPatient(Cases caseQuery);
	
	public List<Cases> queryCasesByTags(Cases caseQuery,Integer pageNo, Integer pageSize);
	
	public Long queryCasesCountByTags(Cases caseQuery);
	
	public List<Map<String,Object>> queryEveryTagAndCount(Cases caseQuery);
	
	/**
	 * 
	 * @Title: updateCasesWhenClose 
	 * @Description: 订单关闭时更新状态、价格
	 * @author ERIC 
	 * @date 2014-11-6下午04:16:37
	 * @return int
	 */
	public void updateCasesWhenClose(Cases cases);

	/**
	 * 
	 * @Title: updateCasesProcedureAndSendDate 
	 * @Description: 给订单添加工序、更新工序字段、发货日期、收货日期、交付日期、订单的牙位标识、价格
	 * @author ERIC 
	 * @date 2014-11-7下午03:47:25
	 * @return int
	 */
	public int updateCasesProcedureAndDate(Cases cases) throws Exception;
	
	public int updateCasesDates(Cases cases) throws Exception;
	
	public int updateCasesReschedule(Cases cases) throws Exception;
	
	public AjaxResult updateCouponDataToCases(Cases cases) throws Exception;
	
	/**
	 * 
	 * @Title: queryCasesSerialsByLabO 
	 * @Description: 获取订单序列号
	 * @author ERIC 
	 * @date 2014-11-24下午01:05:48
	 * @return List<Integer>
	 */
	public List<Integer> queryCasesSerialsByLabO(Cases caseQuery,Date sd,Date ed);
}
