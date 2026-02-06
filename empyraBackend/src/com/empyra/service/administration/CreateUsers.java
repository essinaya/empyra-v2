package com.empyra.service.administration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.empyra.users.User;
import com.empyra.users.administration.Administration;
import com.empyra.users.maintenance.Maintenance;
import com.empyra.users.propertymanagementoffice.PropertyManagementOffice;
import com.empyra.utils.Role;
import com.empyra.utils.Status;

public class CreateUsers {
	Scanner sc = new Scanner(System.in);
	
	public User createUser() {
		User newUser = new User();
		System.out.println("=====Create User=====");
		System.out.println("First Name: ");
		newUser.setFirstName(sc.nextLine());
		System.out.println("Middle Name: ");
		newUser.setMiddleName(sc.nextLine());
		System.out.println("Last Name: ");
		newUser.setLastName(sc.nextLine());
		System.out.println("Contact Number: ");
		newUser.setContactNumber(sc.nextLine());
		System.out.println("For department, please choose from the following: ");
		System.out.println("[1] Administration");
		System.out.println("[2] Property Management Office [PMO]");
		System.out.println("[3] Maintenance");
		System.out.println("[4] Security");
		System.out.println("[5] Resident");
		System.out.print("Option: ");
		int departmentChoice = sc.nextInt();
		sc.nextLine();
		newUser = setRole(departmentChoice, newUser);
		//for ID
		//get latest id from DB
		//increment from there
		return newUser;
	}
	
	private User setRole(int option, User userObj) {
		switch (option) {
		case 1: {
			//Approvals go to Sys Admin
			//ID Format: EMPYRA-SYS-XXXXX
			System.out.println("---->Administration");
			userObj.setRole(Role.SYSTEM_ADMINISTRATOR.getFullTitle());
			userObj.setDepartment(Role.SYSTEM_ADMINISTRATOR.getDepartment());
		}case 2: {
			//Approvals go to PMO
			//ID Format: EMPYRA-PMO-XXXXX
			System.out.println("---->Property Management Office");
			System.out.println("Available roles: [1] Property Manager | [2] PMO Supervisor | [3] PMO Clerk");
			System.out.print("Option: ");
			int pmoRole = sc.nextInt();
			sc.nextLine();
			switch (pmoRole) {
				case 1: {
					userObj.setRole(Role.PROPERTY_MANAGER.getFullTitle());
					userObj.setDepartment(Role.PROPERTY_MANAGER.getDepartment());
				}case 2: {
					userObj.setRole(Role.PMO_SUPERVISOR.getFullTitle());
					userObj.setDepartment(Role.PMO_SUPERVISOR.getDepartment());
				}case 3: {
					userObj.setRole(Role.PMO_CLERK.getFullTitle());
					userObj.setDepartment(Role.PMO_CLERK.getDepartment());
				}
			}
		}case 3: {
			//Approvals go to PMO
			//ID Format: EMPYRA-MNT-XXXXX
			System.out.println("---->Maintenance");
			System.out.println("Available roles: [1] Maintenance Coordinator | [2] Maintenance Staff");
			System.out.print("Option: ");
			int maintenanceRole = sc.nextInt();
			sc.nextLine();
			switch (maintenanceRole) {
				case 1: {
					userObj.setRole(Role.MAINTENANCE_COORDINATOR.getFullTitle());
					userObj.setDepartment(Role.MAINTENANCE_COORDINATOR.getDepartment());
				}case 2: {
					userObj.setRole(Role.MAINTENANCE_STAFF.getFullTitle());
					userObj.setDepartment(Role.MAINTENANCE_STAFF.getDepartment());
				}
			}
		}case 4: {
			//ID Format: EMPYRA-SEC-XXXXX
			System.out.println("---->Security");
			System.out.println("Available roles: [1] Security Head | [2] Roving Guard | [3] Gate Guard");
			System.out.print("Option: ");
			int securityRole = sc.nextInt();
			sc.nextLine();
			switch (securityRole) {
				case 1: {
					userObj.setRole(Role.SECURITY_HEAD.getFullTitle());
					userObj.setDepartment(Role.SECURITY_HEAD.getDepartment());
				}case 2: {
					userObj.setRole(Role.ROVING_GUARD.getFullTitle());
					userObj.setDepartment(Role.ROVING_GUARD.getDepartment());
				}
				case 3: {
					userObj.setRole(Role.GATE_GUARD.getFullTitle());
					userObj.setDepartment(Role.GATE_GUARD.getDepartment());
				}
		}
		}case 5: {
			//ID Format: EMPYRA-RES-XXXXX
			System.out.println("---->Resident");
			System.out.println("Available roles: [1] Unit Owner | [2] Tenant | [3] Household Member");
			System.out.print("Option: ");
			int securityRole = sc.nextInt();
			sc.nextLine();
			switch (securityRole) {
				case 1: {
					userObj.setRole(Role.UNIT_OWNER.getFullTitle());
					userObj.setDepartment(Role.UNIT_OWNER.getDepartment());
				}case 2: {
					userObj.setRole(Role.TENANT.getFullTitle());
					userObj.setDepartment(Role.TENANT.getDepartment());
				}
				case 3: {
					userObj.setRole(Role.HOUSEHOLD_MEMBER.getFullTitle());
					userObj.setDepartment(Role.HOUSEHOLD_MEMBER.getDepartment());
				}
			
			}
		}
	}
		userObj.setStatus(Status.PENDING.getStatusString());
		return userObj;

	}
		
	
}