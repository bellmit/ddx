package com.upcera.ddx.service.lab;

import java.util.List;

import com.upcera.ddx.entity.LabProceduresOutLink;
import com.upcera.ddx.service.base.IBaseService;

public interface ILabProceduresOutLinkService extends IBaseService<LabProceduresOutLink, Integer> {
	
	public List<Integer> queryOutLinks(List<Integer> idList);
	public void deleteOutLinkByProceduresId(Integer id) throws Exception ;
}
