package com.upcera.ddx.dao.lab;


import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabProceduresGroupLink;

@org.springframework.stereotype.Repository("labProceduresGroupLinkDao")
public interface ILabProceduresGroupLinkDao  extends IBaseDao<LabProceduresGroupLink, Integer>  {
	public void updateGroupLink(Integer procedureId,List<LabProceduresGroupLink> group)throws Exception;
}
