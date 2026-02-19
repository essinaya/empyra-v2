package com.empyra.utils;

public enum ActivityStatus {
	SUCCESS("Success"),
	ERROR("Error");
	
	private String statusString;

	ActivityStatus(String string) {
		this.setStatusString(string);
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

}
