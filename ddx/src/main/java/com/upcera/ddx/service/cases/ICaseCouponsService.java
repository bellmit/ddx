package com.upcera.ddx.service.cases;

import java.util.List;

import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.service.base.IBaseService;

public interface ICaseCouponsService extends IBaseService<LabCaseCoupons, Integer>{
	public String getCharAndNumr(int length); 
	public List<LabCaseCoupons> loadCouponsByNewCases(User sessionUser, Integer requestLabId);
	public List<LabCaseCoupons> loadCouponsByNewCases(User sessionUser, Integer requestLabId,String code);
	public AjaxResult checkCoupontValid(User seesionUser, Integer requestLabId,String proceduresIds, String code)throws Exception;
	
	public LabCaseCoupons queryCouponsByPrefix(LabCaseCoupons coupons);
	
	/**
	 * 
	 * @Title: queryCouponsByCases 
	 * @Description: 技工间查询某个订单可用的优惠券
	 * @author ERIC 
	 * @date 2014-11-12下午05:00:53
	 * @return List<LabCaseCoupons>
	 */
	public List<LabCaseCoupons> queryCouponsByCases(Cases caseQuery);
	
	public List<LabCaseCoupons> queryCouponsByLab(Cases caseQuery);
	
	public AjaxResult checkCaseCouponValid(Cases cases, Integer requestLabId,String proceduresIds, String code)throws Exception;

}
