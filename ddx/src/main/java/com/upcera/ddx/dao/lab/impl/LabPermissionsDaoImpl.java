package com.upcera.ddx.dao.lab.impl;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabPermissionsDao;
import com.upcera.ddx.entity.LabPermissions;
@Repository
public class LabPermissionsDaoImpl  extends BaseHibernateDao<LabPermissions, Integer> implements ILabPermissionsDao {

}
