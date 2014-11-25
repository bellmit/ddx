package com.upcera.ddx.dao.lab;


import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabProceduresOutLink;

@org.springframework.stereotype.Repository("labProceduresOutLinkDao")
public interface ILabProceduresOutLinkDao  extends IBaseDao<LabProceduresOutLink, Integer>  {
	
	public List<Integer> queryOutLinks(List<Integer> idList);
	public void deleteOutLinkByProceduresId(Integer id) throws Exception ;
}
