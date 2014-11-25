package com.upcera.ddx.common.cache.impl;

import java.util.Map;

import org.springframework.stereotype.Controller;
@Controller
public class SironaConnectCache {

	private Map<String, Object> sironaConnectType;
	private Map<String, Object> sironaConnectDesign;
	private Map<String, Object> sironaConnectMaterial;

	public Map<String, Object> getSironaConnectType() {
		return sironaConnectType;
	}

	public void setSironaConnectType(Map<String, Object> sironaConnectType) {
		this.sironaConnectType = sironaConnectType;
	}

	public Map<String, Object> getSironaConnectDesign() {
		return sironaConnectDesign;
	}

	public void setSironaConnectDesign(Map<String, Object> sironaConnectDesign) {
		this.sironaConnectDesign = sironaConnectDesign;
	}

	public Map<String, Object> getSironaConnectMaterial() {
		return sironaConnectMaterial;
	}

	public void setSironaConnectMaterial(Map<String, Object> sironaConnectMaterial) {
		this.sironaConnectMaterial = sironaConnectMaterial;
	}
}
