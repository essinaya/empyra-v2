package com.empyra.utils;

public enum Role {
	SYSTEM_ADMINISTRATOR("System Administrator", "Administration"),
	PROPERTY_MANAGER("Property Manager", "Property Management Office"),
	PMO_SUPERVISOR("PMO Supervisor", "Property Management Office"),
	PMO_CLERK("PMO Clerk", "Property Management Office"),
	MAINTENANCE_COORDINATOR("Maintenance Coordinator", "Maintenance"),
	MAINTENANCE_STAFF("Maintenance Staff", "Maintenance"),
	SECURITY_HEAD("Security Head", "Security"),
	ROVING_GUARD("Roving Guard", "Security"),
	GATE_GUARD("Gate Guard", "Security"),
	UNIT_OWNER("Unit Owner", "Resident"),
	TENANT("Tenant", "Resident"),
	HOUSEHOLD_MEMBER("Household Member", "Resident");
	
	private String fullTitle;
	private String department;
	
	private Role(String fullTitle, String department) {
		this.fullTitle = fullTitle;
		this.department = department;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
