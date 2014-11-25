package com.upcera.ddx.service.lab.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabProceduresOutLinkDao;
import com.upcera.ddx.entity.LabProceduresOutLink;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabProceduresOutLinkService;
@Service
public class LabProceduresOutLinkServiceImpl extends BaseServiceImpl<LabProceduresOutLink, Integer> implements ILabProceduresOutLinkService{
	@Autowired
	private ILabProceduresOutLinkDao labProceduresOutLinkDao;
	@Override
	public IBaseDao<LabProceduresOutLink, Integer> getDao() {
		// TODO Auto-generated method stub
		return labProceduresOutLinkDao;
	}
	@Override
	public List<Integer> queryOutLinks(List<Integer> idList) {
		return labProceduresOutLinkDao.queryOutLinks(idList);
	}
	@Override
	public void deleteOutLinkByProceduresId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		labProceduresOutLinkDao.deleteOutLinkByProceduresId(id);
	}
}