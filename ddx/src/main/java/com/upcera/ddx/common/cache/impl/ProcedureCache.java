package com.upcera.ddx.common.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.common.cache.AbstractCache;
import com.upcera.ddx.entity.ProcedureCategory;
import com.upcera.ddx.entity.ProcedureSubCategory;
import com.upcera.ddx.entity.ProcedureType;
import com.upcera.ddx.service.lab.IProcedureCategoryService;
import com.upcera.ddx.service.lab.IProcedureSubCategoryService;
import com.upcera.ddx.service.lab.IProcedureTypeService;
@Controller
public class ProcedureCache  extends AbstractCache {
	@Autowired
	private IProcedureCategoryService procedureCategoryService;
	@Autowired
	private IProcedureSubCategoryService procedureSubCategoryService;
	@Autowired
	private IProcedureTypeService procedureTypeService;
	
	private static List<ProcedureCategory> labProcedureCategory = new ArrayList<ProcedureCategory>();
	private static List<ProcedureSubCategory> labProcedureSubCategory = new ArrayList<ProcedureSubCategory>();
	private static List<ProcedureType> labProcedureType = new ArrayList<ProcedureType>();
	/**
	 * 
	 * @Description: 获取工序类别-第一级
	 * @author king
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception
	 */
	public List<ProcedureCategory> getProcedureCategoryList() throws Exception {
		return load(labProcedureCategory);
	}

	/**
	 * 
	 * @Description: 获取工序类别-第二级
	 * @author king
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception
	 */
	public List<ProcedureSubCategory> getProcedureSubCategoryList() throws Exception {
		return load(labProcedureSubCategory);
	}

	/**
	 * 
	 * @Description: 获取工序类
	 * @author king
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception
	 */
	public List<ProcedureType> getProcedureTypeList() throws Exception {
		return load(labProcedureType);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		List<ProcedureCategory> pcList = procedureCategoryService.listAll();
		for (int i = 0; i < pcList.size(); i++) {
			labProcedureCategory.add(pcList.get(i));
		}

		List<ProcedureSubCategory> pscList = procedureSubCategoryService.listAll();
		for (int i = 0; i < pscList.size(); i++) {
			labProcedureSubCategory.add(pscList.get(i));
		}
		List<ProcedureType> ptList = procedureTypeService.listAll();
		for (int i = 0; i < ptList.size(); i++) {
			labProcedureType.add(ptList.get(i));
		}

	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		labProcedureCategory.clear();
		labProcedureSubCategory.clear();
		labProcedureType.clear();
		init();
	}

}
