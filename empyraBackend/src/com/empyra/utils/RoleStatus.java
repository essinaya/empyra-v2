package com.empyra.utils;

public enum RoleStatus {
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE"),
	PENDING("PENDING");
	
	private String statusString;

	RoleStatus(String string) {
		this.setStatusString(string);
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

}
