package com.upcera.ddx.service.lab;

import java.util.List;

import com.upcera.ddx.entity.LabProceduresGroupLink;
import com.upcera.ddx.service.base.IBaseService;

public interface ILabProceduresGroupLinkService extends IBaseService<LabProceduresGroupLink, Integer> {
	
	public void updateGroupLink(Integer procedureId,List<LabProceduresGroupLink> group)throws Exception;
}
