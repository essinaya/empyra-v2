package com.empyra.users.security;

import com.empyra.users.User;
import com.empyra.utils.Department;
import com.empyra.utils.Role;

public class Security extends User {

	public Security(String id, String firstName, String middleName, String lastName, Role role, String contactNumber,
			String status, String createdAt, String createdBy, Department department,
			String username, String userPassword, String updatedBy, String updatedDt) {
		super(id, firstName, middleName, lastName, role, contactNumber, status, createdAt, createdBy, department,
				username, userPassword, updatedBy, updatedDt);
		// TODO Auto-generated constructor stub
	}

}
