package com.upcera.ddx.service.lab.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabPracticeNotesDao;
import com.upcera.ddx.entity.LabPracticeNotes;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabPracticeNotesService;
@Service
public class LabPracticeNotesServiceImpl extends BaseServiceImpl<LabPracticeNotes, Integer> implements ILabPracticeNotesService{
	@Autowired
	private ILabPracticeNotesDao labPracticeNotesDao;
	@Override
	public IBaseDao<LabPracticeNotes, Integer> getDao() {
		// TODO Auto-generated method stub
		return labPracticeNotesDao;
	}
}
