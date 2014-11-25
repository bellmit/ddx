package com.upcera.ddx.dao.lab;

import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.PartnerLab;
@org.springframework.stereotype.Repository("partnerLabDao")
public interface IPartnerLabDao  extends IBaseDao<PartnerLab, Integer> {
	
	/***
	 * 根据实验室ID查询伙伴实验室
	 */
	public List<PartnerLab> queryListByLabId(Integer labId);
}
