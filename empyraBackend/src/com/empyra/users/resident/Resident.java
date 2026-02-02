package com.empyra.users.resident;

import java.util.Date;

import com.empyra.users.User;

public class Resident extends User {

	public Resident(String id, String firstName, String middleName, String lastName, String role, String contactNumber,
			String status, Date createdAt, String createdBy, String department) {
		super(id, firstName, middleName, lastName, role, contactNumber, status, createdAt, createdBy, department);
		// TODO Auto-generated constructor stub
	}

}
