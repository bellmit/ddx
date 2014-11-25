package com.upcera.ddx.service.lab.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseHoldDao;
import com.upcera.ddx.dao.cases.ICaseRemakeDao;
import com.upcera.ddx.dao.cases.ICaseSchedulingHolidaDao;
import com.upcera.ddx.dao.lab.ILabProceduresCharacterisDao;
import com.upcera.ddx.dao.lab.ILabSignUpDirectSoundDao;
import com.upcera.ddx.dao.lab.IProcedureDisplayCategoryDao;
import com.upcera.ddx.entity.CaseHold;
import com.upcera.ddx.entity.CaseRemake;
import com.upcera.ddx.entity.Caseschedulingholida;
import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.entity.LabSignUpDirectSound;
import com.upcera.ddx.entity.ProcedureDisplayCategory;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabSignUpDirectSoundService;
@Service
public class LabSignUpDirectsoundServiceImpl extends BaseServiceImpl<LabSignUpDirectSound, Integer> implements ILabSignUpDirectSoundService{
	@Resource
	ILabSignUpDirectSoundDao labsignupdirectdao;
	@Resource
	ILabProceduresCharacterisDao characterisDao;
	@Resource
	IProcedureDisplayCategoryDao categoryDao;
	@Resource
	ICaseHoldDao caseHoldDao;
	@Resource
	ICaseRemakeDao caseRemakeDao;
	@Resource
	ICaseSchedulingHolidaDao caseSchedulingHolidaDao;
	@Override
	public IBaseDao<LabSignUpDirectSound, Integer> getDao(){
		return labsignupdirectdao;
	}

	@Override
	public void queryDirectSound(Integer labid) {
		// TODO Auto-generated method stub
		Integer labids=labid;
		addAcryliccolors(labids);
		addDisplayCategories(labids);
		addEnclosures(labids);
		addOnHoldType(labids);
		addMaterials(labids);
		addRemake(labids);
		addScheduling(labids);
	}
	//给类型为0的工序特征 -塑胶袋添加默认设置
	public void addAcryliccolors(Integer labids){
		Integer type=0;
		List<LabProceduresCharacteris> list2=new ArrayList<LabProceduresCharacteris>();
		LabProceduresCharacteris lpc=null;
		List<LabSignUpDirectSound> list=labsignupdirectdao.queryDirectSound(type);
		for (int i = 0; i < list.size(); i++) {
			lpc=new LabProceduresCharacteris();
			lpc.setCharacterName(list.get(i).getAcrylicColors());
			lpc.setLabId(labids);
			lpc.setType(Constans.PROCEDURES_CHARACTERIS_ACRYLICCOLORS);
			list2.add(lpc);
		}
		characterisDao.batchAdd(list2);
	}
	//给类型为1的工序-工序列表添加默认设置
	public void addDisplayCategories(Integer labids){
		Integer type=1;
		List<ProcedureDisplayCategory> list2=new ArrayList<ProcedureDisplayCategory>();
		ProcedureDisplayCategory pdc=null;
		List<LabSignUpDirectSound> list=labsignupdirectdao.queryDirectSound(type);
		for (int i = 0; i < list.size(); i++) {
			pdc=new ProcedureDisplayCategory();
			pdc.setName(list.get(i).getDisplayCategoriesName());
			pdc.setSort(list.get(i).getDisplayCategoriesSortRank());
			pdc.setLabId(labids);
			list2.add(pdc);
		}
		categoryDao.batchAdd(list2);
	}
	//给类型为2的工序特征-随单附件添加默认设置
	public void addEnclosures(Integer labids){
		Integer type=2;
		List<LabProceduresCharacteris> list2=new ArrayList<LabProceduresCharacteris>();
		LabProceduresCharacteris lpc=null;
		List<LabSignUpDirectSound> list=labsignupdirectdao.queryDirectSound(type);
		for (int i = 0; i < list.size(); i++) {
			lpc=new LabProceduresCharacteris();
			lpc.setCharacterName(list.get(i).getEnclosures());
			lpc.setLabId(labids);
			lpc.setType(Constans.PROCEDURES_CHARACTERIS_ENCLOSURES);
			list2.add(lpc);
		}
		characterisDao.batchAdd(list2);
	}
	
	//给一般情况-搁置类型添加默认设置
	public void addOnHoldType(Integer labids){
		Integer type=3;
		List<CaseHold> list2=new ArrayList<CaseHold>();
		CaseHold ch=null;
		List<LabSignUpDirectSound> list=labsignupdirectdao.queryDirectSound(type);
		for (int i = 0; i <list.size(); i++) {
			ch=new CaseHold();
			ch.setName(list.get(i).getHoldTypeName());
			ch.setLabId(labids);
			list2.add(ch);
		}
		caseHoldDao.batchAdd(list2);
	}
	
	
	
	//给类型为4的工序特征-工序材料添加默认设置
	public void addMaterials(Integer labids){
		Integer type=4;
		List<LabProceduresCharacteris> list2=new ArrayList<LabProceduresCharacteris>();
		LabProceduresCharacteris lpc=null;
		List<LabSignUpDirectSound> list= labsignupdirectdao.queryDirectSound(type);
		for (int i = 0; i < list.size(); i++) {
			lpc=new LabProceduresCharacteris();
			lpc.setCharacterName(list.get(i).getMaterials());
			lpc.setClassfication(list.get(i).getClassification());
			lpc.setLabId(labids);
			lpc.setType(Constans.PROCEDURES_CHARACTERIS_MATERIALS);
			list2.add(lpc);
		}
		characterisDao.batchAdd(list2);
		
	}
	//给类型为5的一般情况-返工类型添加默认设置
	public void addRemake(Integer labids){
		Integer type=5;
		List<CaseRemake> list2=new ArrayList<CaseRemake>();
		CaseRemake cr=null;
		List<LabSignUpDirectSound> list=labsignupdirectdao.queryDirectSound(type);
		for (int i = 0; i < list.size(); i++) {
			cr=new CaseRemake();
			cr.setName(list.get(i).getRemakeName());
			cr.setLabid(labids);
			list2.add(cr);
		}
		caseRemakeDao.batchAdd(list2);
	}
	
	//给类型为6的一般情况-时间设定添加默认设置
	public void addScheduling(Integer labids){
		Integer type=6;
		List<Caseschedulingholida> list2=new ArrayList<Caseschedulingholida>();
		Caseschedulingholida csh=null;
		List<LabSignUpDirectSound> list=labsignupdirectdao.queryDirectSound(type);
		for (int i = 0; i <list.size(); i++) {
			csh=new Caseschedulingholida();
			csh.setWorkdays(list.get(i).getShWorkdays());
			csh.setCutofftime(list.get(i).getShCutOfTime());
			csh.setCaseturnaround(list.get(i).getShTurnAround());
			csh.setLabid(labids);
			list2.add(csh);
		}
		caseSchedulingHolidaDao.batchAdd(list2);
	}
}
