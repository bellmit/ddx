package com.upcera.ddx.dao.lab.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.IPracticePreferencesDao;
import com.upcera.ddx.entity.LabPracticePreferences;

@Repository
public class PracticePreferencesDaoImpl extends BaseHibernateDao<LabPracticePreferences, Integer> implements IPracticePreferencesDao {

	@Override
	public int updateLabPracticePreferences(LabPracticePreferences labpp) {
		// TODO Auto-generated method stub
		String hql = "update LabPracticePreferences set priceGroupId=:priceGroupId,proceduresGroupId=:proceduresGroupId,shippingId=:shippingId,overrideTransitTime=:overrideTransitTime,inboundTransitDays=:inboundTransitDays,outboundTransitDays=:outboundTransitDays where id=:id";
		Query query = getSession().createQuery(hql);
		query.setInteger("id", labpp.getId());
		query.setInteger("priceGroupId", labpp.getPriceGroupId());
		query.setInteger("proceduresGroupId", labpp.getProceduresGroupId());
		query.setInteger("shippingId", labpp.getShippingId());
		query.setString("overrideTransitTime", labpp.getOverrideTransitTime());
		if(labpp.getOverrideTransitTime().equals("true")){
			query.setInteger("inboundTransitDays", labpp.getInboundTransitDays());
			query.setInteger("outboundTransitDays", labpp.getOutboundTransitDays());
		}else{
			query.setInteger("inboundTransitDays", 0);
			query.setInteger("outboundTransitDays", 0);
		}
		
		return query.executeUpdate();
	}

	@Override
	public int batchUpdatePriceGroup(String[] unitId, Integer priceGroupId,Integer thisLadId) {
		// TODO Auto-generated method stub
		String labId = "";
		String practiceId = "";
		for (int i = 0; i < unitId.length; i++) {
			String id = unitId[i].split(",")[0];
			String type = unitId[i].split(",")[1];
			if(Constans.UNIT_LAB.equals(type)){
				labId+=id+",";
			}else if(Constans.UNIT_PRACTICE.equals(type)){
				practiceId+=id+",";
			}
		}
		int count = 0;
		if(labId.length()>0){
			labId = labId.substring(0, labId.length()-1);
			String labHql = "update LabPracticePreferences set priceGroupId="+priceGroupId+",lid="+thisLadId+" where labId in ("+labId+")";
			Query query = getSession().createQuery(labHql);
			count+=query.executeUpdate();
		}
		if(practiceId.length()>0){
			practiceId = practiceId.substring(0, practiceId.length()-1);
			String practiceHql = "update LabPracticePreferences set priceGroupId="+priceGroupId+",lid="+thisLadId+" where practiceId in ("+practiceId+")";
			Query query = getSession().createQuery(practiceHql);
			count+=query.executeUpdate();
		}
		return count;
	}

	@Override
	public int batchUpdateShipping(String[] unitId, Integer ShippingId,Integer thisLadId) {
		// TODO Auto-generated method stub
		String labId = "";
		String practiceId = "";
		for (int i = 0; i < unitId.length; i++) {
			String id = unitId[i].split(",")[0];
			String type = unitId[i].split(",")[1];
			if(Constans.UNIT_LAB.equals(type)){
				labId+=id+",";
			}else if(Constans.UNIT_PRACTICE.equals(type)){
				practiceId+=id+",";
			}
		}
		int count = 0;
		if(labId.length()>0){
			labId = labId.substring(0, labId.length()-1);
			String labHql = "update LabPracticePreferences set shippingId="+ShippingId+",overrideTransitTime='false',inboundTransitDays=0,outboundTransitDays=0,lid="+thisLadId+" where labId in ("+labId+")";
			Query query = getSession().createQuery(labHql);
			count+=query.executeUpdate();
		}
		if(practiceId.length()>0){
			practiceId = practiceId.substring(0, practiceId.length()-1);
			String practiceHql = "update LabPracticePreferences set shippingId="+ShippingId+",overrideTransitTime='false',inboundTransitDays=0,outboundTransitDays=0,lid="+thisLadId+" where practiceId in ("+practiceId+")";
			Query query = getSession().createQuery(practiceHql);
			count+=query.executeUpdate();
		}
		return count;
	}

}
