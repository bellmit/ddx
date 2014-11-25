package com.upcera.ddx.service.lab;

import java.util.List;

import com.upcera.ddx.entity.PartnerLab;
import com.upcera.ddx.service.base.IBaseService;

public interface IPartnerLabService extends IBaseService<PartnerLab, Integer> {
	/***
	 * 根据实验室ID查询伙伴实验室
	 */
	public List<PartnerLab> queryListByLabId(Integer labId);
}
