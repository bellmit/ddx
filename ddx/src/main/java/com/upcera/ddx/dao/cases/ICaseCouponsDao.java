package com.upcera.ddx.dao.cases;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.entity.User;
@Repository("caseCouponsDao")
public interface ICaseCouponsDao extends IBaseDao<LabCaseCoupons, Integer>{
	public List<LabCaseCoupons> loadCouponsByNewCases(User sessionUser,Integer requestLabId);
	public List<LabCaseCoupons> loadCouponsByNewCases(User sessionUser, Integer requestLabId,String code);
	
	public LabCaseCoupons queryCouponsByPrefix(LabCaseCoupons coupons);
	
	public List<LabCaseCoupons> queryCouponsByCases(Cases caseQuery);
	
	public List<LabCaseCoupons> queryCouponsByLab(Cases caseQuery);
	
}
