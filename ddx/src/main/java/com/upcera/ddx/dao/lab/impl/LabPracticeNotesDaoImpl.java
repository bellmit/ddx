package com.upcera.ddx.dao.lab.impl;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabPracticeNotesDao;
import com.upcera.ddx.entity.LabPracticeNotes;

@Repository
public class LabPracticeNotesDaoImpl extends BaseHibernateDao<LabPracticeNotes, Integer> implements ILabPracticeNotesDao {

}
