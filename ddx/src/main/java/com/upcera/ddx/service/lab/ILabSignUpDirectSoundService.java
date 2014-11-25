package com.upcera.ddx.service.lab;

import com.upcera.ddx.entity.LabSignUpDirectSound;
import com.upcera.ddx.service.base.IBaseService;

public interface ILabSignUpDirectSoundService extends IBaseService<LabSignUpDirectSound, Integer>{
	public void queryDirectSound(Integer labid);
}
