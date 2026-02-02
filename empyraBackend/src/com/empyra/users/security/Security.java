package com.empyra.users.security;

import java.util.Date;

import com.empyra.users.User;

public class Security extends User {

	public Security(String id, String firstName, String middleName, String lastName, String role, String contactNumber,
			String status, Date createdAt, String createdBy, String department) {
		super(id, firstName, middleName, lastName, role, contactNumber, status, createdAt, createdBy, department);
		// TODO Auto-generated constructor stub
	}

}
