package com.upcera.ddx.common.excel.impl;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.common.excel.AbstractExcelService;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.service.cases.ICaseCouponsService;
import com.upcera.ddx.service.cases.ICasesService;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.practice.IPracticeService;
@Controller
public class CouponsExcel extends AbstractExcelService<LabCaseCoupons>{
	
	@Autowired
	private ILabService labService;
	@Autowired
	private ICasesService casesService;
	@Autowired
	private ICaseCouponsService caseCoupons;
	@Autowired
	private IPracticeService practiceService;
	@Autowired
	private ILabProcedureService labProcedureService;
	
	private final Logger logger = LoggerFactory.getLogger(CouponsExcel.class);
	
	public String export(Lab lab) throws Exception{
		LabCaseCoupons lcc=new LabCaseCoupons();
		lcc.setLabid(lab.getId());
		List<LabCaseCoupons> clist = caseCoupons.listAllByEqual(lcc, 0, 0);
		for (int i = 0; i < clist.size(); i++) {
			clist.get(i).setLabName(lab.getName());
			String unitType = "";
			try {
				if(Constans.UNIT_LAB.equals(clist.get(i).getUnittype())){
					unitType = "技工间";
					clist.get(i).setUnitName(labService.get(clist.get(i).getUnitid()).getName());
				}else if(Constans.UNIT_PRACTICE.equals(clist.get(i).getUnittype())){
					unitType = "诊所";
					clist.get(i).setUnitName(practiceService.get(clist.get(i).getUnitid()).getName());
				}
			} catch (Exception e) {
				logger.error("指定的机构数据异常");
				e.printStackTrace();
			}
			clist.get(i).setUnittype(unitType);
			try {
				clist.get(i).setProceduresName(labProcedureService.get(clist.get(i).getProceduresid()).getDisplayName());
			} catch (Exception e) {
				logger.error("指定的工序数据异常");
				e.printStackTrace();
			}
			if(Constans.COUPONS_DISCOUNT_TYPE_PERCENTAGE.equals(clist.get(i).getDiscountType())){
				clist.get(i).setDiscountType("百分比");
			}else if(Constans.COUPONS_DISCOUNT_TYPE_FIXED_MONITARY.equals(clist.get(i).getDiscountType())){
				clist.get(i).setDiscountType("固定金额");
			}
			if(Constans.COUPONS_TYPE_SINGLE.equals(clist.get(i).getUseType())){
				clist.get(i).setUseType("单次使用");
			}else if(Constans.COUPONS_TYPE_MULTI.equals(clist.get(i).getUseType())){
				clist.get(i).setUseType("多次使用");
			}
			try {
				Cases cases = new Cases();
				cases.setCouponCode(clist.get(i).getPrefix());
				List li = casesService.listAllByEqual(cases, 0, 0);
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(li)){
					clist.get(i).setClaimed(li.size());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		File file = AbstractExcelService.create(clist, LabCaseCoupons.class, "Coupons", Constans.FILE_DOWNLAOD_PATH+"/coupons/");
		return file.getName();
	}
	public List<LabCaseCoupons> paser() throws Exception{
		return super.paser(new File(Constans.FILE_DOWNLAOD_PATH+"/coupons/"), LabCaseCoupons.class, 1);
	}
}
