package com.empyra.utils;

public enum Department {
	SYSTEM_ADMINISTRATION("System Administration", "SYS"),
	PROPERTY_MANAGEMENT("Property Management Office", "PMO"),
	SECURITY("Security", "SEC"),
	MAINTENANCE("Maintenance", "MNT"),
	RESIDENT_SERVICES("Resident Services", "RES");

	private String fullTitle;
	private String abbreviation;
	
	Department(String dpt, String abbrv) {
		this.fullTitle = dpt;
		this.abbreviation = abbrv;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}
