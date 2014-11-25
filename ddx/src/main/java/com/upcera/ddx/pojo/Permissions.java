package com.upcera.ddx.pojo;

import com.upcera.ddx.entity.LabPermissions;

public class Permissions {
	private LabPermissions.Cases cases;
	private LabPermissions.Finances finances;
	public LabPermissions.Cases getCases() {
		return cases;
	}
	public void setCases(LabPermissions.Cases cases) {
		this.cases = cases;
	}
	public LabPermissions.Finances getFinances() {
		return finances;
	}
	public void setFinances(LabPermissions.Finances finances) {
		this.finances = finances;
	}

}
