package com.empyra.utils;

public enum Status {
	ACTIVE("Active"),
	INACTIVE("Inactive"),
	PENDING("Pending");
	
	private String statusString;

	Status(String string) {
		this.setStatusString(string);
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

}
