package com.empyra.users.security.users;

import com.empyra.users.security.Security;
import com.empyra.utils.Department;
import com.empyra.utils.Role;

public class SecurityHead extends Security {

	public SecurityHead(String id, String firstName, String middleName, String lastName, Role role,
			String contactNumber, String status, String createdAt, String createdBy, Department department,
			String username, String userPassword, String updatedBy, String updatedDt) {
		super(id, firstName, middleName, lastName, role, contactNumber, status, createdAt, createdBy, department,
				username, userPassword, updatedBy, updatedDt);
		// TODO Auto-generated constructor stub
	}

}
