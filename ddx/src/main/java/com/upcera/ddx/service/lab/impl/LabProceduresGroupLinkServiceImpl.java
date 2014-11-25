package com.upcera.ddx.service.lab.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabProceduresGroupLinkDao;
import com.upcera.ddx.entity.LabProceduresGroupLink;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabProceduresGroupLinkService;
@Service
public class LabProceduresGroupLinkServiceImpl extends BaseServiceImpl<LabProceduresGroupLink, Integer> implements ILabProceduresGroupLinkService{
	@Autowired
	private ILabProceduresGroupLinkDao labProceduresGroupLinkDao;
	@Override
	public IBaseDao<LabProceduresGroupLink, Integer> getDao() {
		// TODO Auto-generated method stub
		return labProceduresGroupLinkDao;
	}
	@Override
	public void updateGroupLink(Integer procedureId,List<LabProceduresGroupLink> group) throws Exception {
		// TODO Auto-generated method stub
		labProceduresGroupLinkDao.updateGroupLink(procedureId, group);
	}
}
