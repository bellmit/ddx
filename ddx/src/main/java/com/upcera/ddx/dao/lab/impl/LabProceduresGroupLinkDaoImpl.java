package com.upcera.ddx.dao.lab.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabProceduresGroupLinkDao;
import com.upcera.ddx.entity.LabProceduresGroupLink;

@Repository
public class LabProceduresGroupLinkDaoImpl extends BaseHibernateDao<LabProceduresGroupLink, Integer> implements ILabProceduresGroupLinkDao {

	@Override
	public void updateGroupLink(Integer procedureId,List<LabProceduresGroupLink> group) throws Exception {
		// TODO Auto-generated method stub
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(procedureId)){
			String sql = "DELETE FROM DDX_LAB_PROCEDURES_GROUP_LINK A WHERE A.PROCEDURES_ID = "+procedureId;
			getSession().createSQLQuery(sql).executeUpdate();
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(group)){
				super.batchAdd(group);
			}
		}
	}



}
