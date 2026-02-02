package com.empyra.users.resident.users;

import java.util.Date;

import com.empyra.users.resident.Resident;

public class Tenant extends Resident {

	public Tenant(String id, String firstName, String middleName, String lastName, String role, String contactNumber,
			String status, Date createdAt, String createdBy, String department) {
		super(id, firstName, middleName, lastName, role, contactNumber, status, createdAt, createdBy, department);
		// TODO Auto-generated constructor stub
	}

}
