package com.upcera.ddx.service.lab.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.IPartnerLabDao;
import com.upcera.ddx.entity.PartnerLab;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.IPartnerLabService;
@Service
public class PartnerLabServiceImpl extends BaseServiceImpl<PartnerLab, Integer> implements IPartnerLabService{

	@Resource IPartnerLabDao partnerLabDao;
	@Override
	public IBaseDao<PartnerLab, Integer> getDao() {
		// TODO Auto-generated method stub
		return partnerLabDao;
	}
	/***
	 * 根据实验室ID查询伙伴实验室
	 */
	public List<PartnerLab> queryListByLabId(Integer labId){
		return partnerLabDao.queryListByLabId(labId);
	}
}
