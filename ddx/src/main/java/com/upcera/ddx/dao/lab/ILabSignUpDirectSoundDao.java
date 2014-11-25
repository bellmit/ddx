package com.upcera.ddx.dao.lab;

import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabSignUpDirectSound;

@org.springframework.stereotype.Repository("LabSignUpDirectSoundDao")
public interface ILabSignUpDirectSoundDao extends IBaseDao<LabSignUpDirectSound, Integer>{
	public List<LabSignUpDirectSound> queryDirectSound(Integer type);
}
