package com.empyra.utils;

public enum Role {
	SYSTEM_ADMINISTRATOR("System Administrator", Department.SYSTEM_ADMINISTRATION),
	PROPERTY_MANAGER("Property Manager", Department.PROPERTY_MANAGEMENT),
	PMO_SUPERVISOR("PMO Supervisor", Department.PROPERTY_MANAGEMENT),
	PMO_CLERK("PMO Clerk", Department.PROPERTY_MANAGEMENT),
	MAINTENANCE_COORDINATOR("Maintenance Coordinator", Department.MAINTENANCE),
	MAINTENANCE_STAFF("Maintenance Staff", Department.MAINTENANCE),
	SECURITY_HEAD("Security Head", Department.SECURITY),
	ROVING_GUARD("Roving Guard", Department.SECURITY),
	GATE_GUARD("Gate Guard", Department.SECURITY),
	UNIT_OWNER("Unit Owner", Department.RESIDENT_SERVICES),
	TENANT("Tenant", Department.RESIDENT_SERVICES),
	HOUSEHOLD_MEMBER("Household Member", Department.RESIDENT_SERVICES);
	
	private String fullTitle;
	private Department department;
	
	private Role(String fullTitle, Department residentServices) {
		this.fullTitle = fullTitle;
		this.department = residentServices;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
