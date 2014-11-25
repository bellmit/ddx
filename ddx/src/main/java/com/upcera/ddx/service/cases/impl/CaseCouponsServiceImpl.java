package com.upcera.ddx.service.cases.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseCouponsDao;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.entity.LabProcedure;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.AjaxResult.Booleans;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseCouponsService;
import com.upcera.ddx.service.lab.ILabProcedureService;
@Service
public class CaseCouponsServiceImpl extends BaseServiceImpl<LabCaseCoupons, Integer> implements ICaseCouponsService{
	@Resource ICaseCouponsDao caseCouponsDao;
	@Autowired
	private ILabProcedureService procedureService;
	
	@Override
	public IBaseDao<LabCaseCoupons, Integer> getDao() {
		// TODO Auto-generated method stub
		return caseCouponsDao;
	}
	@Override
	public String getCharAndNumr(int length) {
		String val = "";

		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

			if ("char".equalsIgnoreCase(charOrNum)) // 字符串
			{
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) // 数字
			{
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	@Override
	public List<LabCaseCoupons> loadCouponsByNewCases(User sessionUser, Integer requestLabId) {
		// TODO Auto-generated method stub
		return caseCouponsDao.loadCouponsByNewCases(sessionUser, requestLabId);
	}
	@Override
	public List<LabCaseCoupons> loadCouponsByNewCases(User sessionUser, Integer requestLabId, String code) {
		// TODO Auto-generated method stub
		return caseCouponsDao.loadCouponsByNewCases(sessionUser, requestLabId, code);
	}
	@Override
	public AjaxResult checkCoupontValid(User seesionUser, Integer requestLabId,String proceduresIds, String code) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.TRUE, "验证成功");
		List<LabCaseCoupons> lcList = this.loadCouponsByNewCases(seesionUser, requestLabId, code);
		LabCaseCoupons labCoupons = null;
		if (ToolsKit.EmptyCheckUtil.isEmpty(lcList)) {
			result.setResult(Booleans.FALSE);
			result.setFailReasons("优惠券无效，不存在");
		} else if (lcList.size() > 1) {
			result.setResult(Booleans.FALSE);
			result.setFailReasons("数据错误，检索出的优惠券大于1个");
		} else if (lcList.size() == 1) {
			labCoupons = lcList.get(0);
			if (labCoupons.getUseFrequency() >= labCoupons.getMaxUse()) {
				result.setResult(Booleans.FALSE);
				result.setFailReasons("优惠券无效，已被使用");
			} else if (labCoupons.getEffective().getTime() > ToolsKit.DateUtil.nowDate().getTime()
					|| labCoupons.getExpiry().getTime() < ToolsKit.DateUtil.nowDate().getTime()) {
				result.setResult(Booleans.FALSE);
				result.setFailReasons("优惠券无效，未生效或已过期");
			} else if (ToolsKit.EmptyCheckUtil.isNotEmpty(labCoupons.getProceduresid())) {
				String[] pid = proceduresIds.split(",");
				if (ToolsKit.EmptyCheckUtil.isEmpty(pid)) {
					result.setResult(Booleans.FALSE);
					result.setFailReasons("请先选择添加工序");
				} else {
					boolean isValid = false;
					for (int i = 0; i < pid.length; i++) {
						if (ToolsKit.TypeConversionUtil.asString(pid[i]).equals(
								ToolsKit.TypeConversionUtil.asString(labCoupons.getProceduresid()))) {
							isValid = true;
						}
					}
					if (!isValid) {
						result.setResult(Booleans.FALSE);
						result.setFailReasons("优惠券不能使用，该优惠券指定工序：" + procedureService.get(labCoupons.getProceduresid()).getDisplayName());
					}
				}
			}
		}
		if (result.getResult().equals(Booleans.TRUE)) {
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(labCoupons.getProceduresid())) {
				LabProcedure lp = procedureService.get(labCoupons.getProceduresid());
				labCoupons.setProceduresName(lp.getDisplayName());
			} else {
				labCoupons.setProceduresName("无指定");
			}
			result.setInfo(labCoupons);
		}
		return result;
	}
	@Override
	public LabCaseCoupons queryCouponsByPrefix(LabCaseCoupons coupons) {
		// TODO Auto-generated method stub
		return caseCouponsDao.queryCouponsByPrefix(coupons);
	}
	@Override
	public List<LabCaseCoupons> queryCouponsByCases(Cases caseQuery) {
		// TODO Auto-generated method stub
		return caseCouponsDao.queryCouponsByCases(caseQuery);
	}
	
	@Override
	public List<LabCaseCoupons> queryCouponsByLab(Cases caseQuery) {
		// TODO Auto-generated method stub
		return caseCouponsDao.queryCouponsByLab(caseQuery);
	}
	
	@Override
	public AjaxResult checkCaseCouponValid(Cases cases, Integer requestLabId, String proceduresIds, String code) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.TRUE, "验证成功");
		List<LabCaseCoupons> lcList = this.queryCouponsByLab(cases);
		LabCaseCoupons labCoupons = null;
		if (ToolsKit.EmptyCheckUtil.isEmpty(lcList)) {
			result.setResult(Booleans.FALSE);
			result.setFailReasons("优惠券无效，不存在");
		} else if (lcList.size() > 1) {
			result.setResult(Booleans.FALSE);
			result.setFailReasons("数据错误，检索出的优惠券大于1个");
		} else if (lcList.size() == 1) {
			labCoupons = lcList.get(0);
			if (labCoupons.getUseFrequency() >= labCoupons.getMaxUse()) {
				result.setResult(Booleans.FALSE);
				result.setFailReasons("优惠券无效，已被使用");
			} else if (labCoupons.getEffective().getTime() > ToolsKit.DateUtil.nowDate().getTime()
					|| labCoupons.getExpiry().getTime() < ToolsKit.DateUtil.nowDate().getTime()) {
				result.setResult(Booleans.FALSE);
				result.setFailReasons("优惠券无效，未生效或已过期");
			} else if (ToolsKit.EmptyCheckUtil.isNotEmpty(labCoupons.getProceduresid())) {
				String[] pid = proceduresIds.split(",");
				if (ToolsKit.EmptyCheckUtil.isEmpty(pid)) {
					result.setResult(Booleans.FALSE);
					result.setFailReasons("请先选择添加工序");
				} else {
					boolean isValid = false;
					for (int i = 0; i < pid.length; i++) {
						if (ToolsKit.TypeConversionUtil.asString(pid[i]).equals(
								ToolsKit.TypeConversionUtil.asString(labCoupons.getProceduresid()))) {
							isValid = true;
						}
					}
					if (!isValid) {
						result.setResult(Booleans.FALSE);
						result.setFailReasons("优惠券不能使用，该优惠券指定工序：" + procedureService.get(labCoupons.getProceduresid()).getDisplayName());
					}
				}
			}
		}
		if (result.getResult().equals(Booleans.TRUE)) {
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(labCoupons.getProceduresid())) {
				LabProcedure lp = procedureService.get(labCoupons.getProceduresid());
				labCoupons.setProceduresName(lp.getDisplayName());
			} else {
				labCoupons.setProceduresName("无指定");
			}
			result.setInfo(labCoupons);
		}
		return result;
	}
	
}
