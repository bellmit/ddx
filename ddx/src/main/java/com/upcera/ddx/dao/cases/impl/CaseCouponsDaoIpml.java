package com.upcera.ddx.dao.cases.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseCouponsDao;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.entity.User;
@Repository
public class CaseCouponsDaoIpml extends BaseHibernateDao<LabCaseCoupons, Integer> implements ICaseCouponsDao{

	@Override
	public List<LabCaseCoupons> loadCouponsByNewCases(User sessionUser, Integer requestLabId) {
		// TODO Auto-generated method stub
		String hql = "from LabCaseCoupons a where ((a.unitid=:unitid and a.unittype=:unittype) or a.unitid is null) " +
				"and a.labid=:labid and a.effective<:nowDate and a.expiry>:nowDate " +
				"and ((a.useType='"+Constans.COUPONS_TYPE_MULTI+"' and a.useFrequency<a.maxUse) or (a.useType='"+Constans.COUPONS_TYPE_SINGLE+"' and a.useFrequency < 1))";
		Query query = getSession().createQuery(hql);
		query.setInteger("unitid", sessionUser.getUnitId());
		query.setString("unittype", sessionUser.getUnitType());
		query.setInteger("labid", requestLabId);
		query.setTimestamp("nowDate", ToolsKit.DateUtil.nowDate());
		return query.list();
	}

	@Override
	public List<LabCaseCoupons> loadCouponsByNewCases(User sessionUser, Integer requestLabId, String code) {
		// TODO Auto-generated method stub
		String hql = "from LabCaseCoupons a where ((a.unitid=:unitid and a.unittype=:unittype) or a.unitid is null) " +
				"and a.labid=:labid and a.effective<:nowDate and a.expiry>:nowDate " +
				"and ((a.useType='"+Constans.COUPONS_TYPE_MULTI+"' and a.useFrequency<a.maxUse) or (a.useType='"+Constans.COUPONS_TYPE_SINGLE+"' and a.useFrequency < 1)) and a.prefix=:prefix";
		Query query = getSession().createQuery(hql);
		query.setInteger("unitid", sessionUser.getUnitId());
		query.setString("unittype", sessionUser.getUnitType());
		query.setInteger("labid", requestLabId);
		query.setTimestamp("nowDate", ToolsKit.DateUtil.nowDate());
		query.setString("prefix", code);
		return query.list();
	}

	@Override
	public LabCaseCoupons queryCouponsByPrefix(LabCaseCoupons coupons) {
		String hqlString = "from LabCaseCoupons lcc where lcc.prefix = ? order by lcc.id desc";
		Query query = getSession().createQuery(hqlString);
		query.setString(0, coupons.getPrefix());
		List list = query.list();
		LabCaseCoupons coupon = null;
		if(list != null && list.size()>0){
			coupon = (LabCaseCoupons) list.get(0);
		}
		return coupon;
	}

	@Override
	public List<LabCaseCoupons> queryCouponsByCases(Cases caseQuery) {
		String hql = "from LabCaseCoupons a where ((a.unitid=:unitid and a.unittype=:unittype) or a.unitid is null) "
				+ "and a.labid=:labid and a.effective<:nowDate and a.expiry>:nowDate " + "and ((a.useType='" + Constans.COUPONS_TYPE_MULTI
				+ "' and a.useFrequency<a.maxUse) or (a.useType='" + Constans.COUPONS_TYPE_SINGLE + "' and a.useFrequency < 1))";
		Query query = getSession().createQuery(hql);
		query.setInteger("unitid", caseQuery.getPracticeId());
		query.setInteger("unittype", caseQuery.getUnitType());
		query.setInteger("labid", caseQuery.getLabId());
		query.setTimestamp("nowDate", ToolsKit.DateUtil.nowDate());
		return query.list();
	}

	@Override
	public List<LabCaseCoupons> queryCouponsByLab(Cases caseQuery) {
		// TODO Auto-generated method stub
		String hql = "from LabCaseCoupons a where ((a.unitid=:unitid and a.unittype=:unittype) or a.unitid is null) "
				+ "and a.labid=:labid and a.effective<:nowDate and a.expiry>:nowDate " + "and ((a.useType='" + Constans.COUPONS_TYPE_MULTI
				+ "' and a.useFrequency<a.maxUse) or (a.useType='" + Constans.COUPONS_TYPE_SINGLE
				+ "' and a.useFrequency < 1)) and a.prefix=:prefix";
		Query query = getSession().createQuery(hql);
		query.setInteger("unitid", caseQuery.getPracticeId());
		query.setInteger("unittype", caseQuery.getUnitType());
		query.setInteger("labid", caseQuery.getLabId());
		query.setTimestamp("nowDate", ToolsKit.DateUtil.nowDate());
		query.setString("prefix", caseQuery.getCouponCode());
		return query.list();
	}
	
}
