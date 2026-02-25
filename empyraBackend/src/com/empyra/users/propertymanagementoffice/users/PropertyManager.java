package com.empyra.users.propertymanagementoffice.users;

import com.empyra.users.propertymanagementoffice.PropertyManagementOffice;
import com.empyra.utils.Department;
import com.empyra.utils.Role;

public class PropertyManager extends PropertyManagementOffice {

	public PropertyManager(String id, String firstName, String middleName, String lastName, Role role,
			String contactNumber, String status, String createdAt, String createdBy, Department department,
			String username, String userPassword, String updatedBy, String updatedDt) {
		super(id, firstName, middleName, lastName, role, contactNumber, status, createdAt, createdBy, department,
				username, userPassword, updatedBy, updatedDt);
		// TODO Auto-generated constructor stub
	}

}
