package com.upcera.ddx.common.excel.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.upcera.ddx.common.excel.AbstractExcelService;
import com.upcera.ddx.entity.Cases;

public class Test extends AbstractExcelService<Cases>{
	public static void main(String[] args) throws Exception {
		create();
		new Test().paser();
	}
	//创建excel
	public static void create() throws Exception{
		List<Cases> list = new ArrayList<Cases>();
		Cases ca = new Cases();
		ca.setCaseId(100000);
		ca.setLabId(20000);
		ca.setPracticeId(30000);
		ca.setCaseName("测试");
		ca.setInvoice("爱尔创");
		ca.setEnclosures("test");
		list.add(ca);
		File file = AbstractExcelService.create(list, Cases.class, "cases", "c:/");
		System.out.println(file.getName());
	}
	//解析excel
	public void paser() throws Exception{
		List<Cases> list = super.paser(new File("c:/cases_201408191553390494.xlsx"), Cases.class, 0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCaseName());
		}
	}
	
}
