package com.empyra.service.administration.utility;

import java.util.Scanner;

import com.empyra.users.User;
import com.empyra.utils.Department;
import com.empyra.utils.Role;
import com.empyra.utils.RoleStatus;

public class SetRoleUtility {

	public User setRole(int option, User userObj, Scanner sc, boolean isCreateUserService) {
		switch (option) {
		case 1: {
			//Approvals go to Sys Admin
			//ID Format: EMPYRA-SYS-XXXXX
			System.out.println("---->Administration");
			userObj.setRole(Role.SYSTEM_ADMINISTRATOR);
			userObj.setDepartment(Department.SYSTEM_ADMINISTRATION);
			break;
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
					userObj.setRole(Role.PROPERTY_MANAGER);
					userObj.setDepartment(Department.PROPERTY_MANAGEMENT);
					break;
				}case 2: {
					userObj.setRole(Role.PMO_SUPERVISOR);
					userObj.setDepartment(Department.PROPERTY_MANAGEMENT);
					break;
				}case 3: {
					userObj.setRole(Role.PMO_CLERK);
					userObj.setDepartment(Department.PROPERTY_MANAGEMENT);
					break;
				}
			}
			break;
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
					userObj.setRole(Role.MAINTENANCE_COORDINATOR);
					userObj.setDepartment(Department.MAINTENANCE);
					break;
				}case 2: {
					userObj.setRole(Role.MAINTENANCE_STAFF);
					userObj.setDepartment(Department.MAINTENANCE);
					break;
				}
			}
			break;
		}case 4: {
			//ID Format: EMPYRA-SEC-XXXXX
			System.out.println("---->Security");
			System.out.println("Available roles: [1] Security Head | [2] Roving Guard | [3] Gate Guard");
			System.out.print("Option: ");
			int securityRole = sc.nextInt();
			sc.nextLine();
			switch (securityRole) {
				case 1: {
					userObj.setRole(Role.SECURITY_HEAD);
					userObj.setDepartment(Department.SECURITY);
					break;
				}case 2: {
					userObj.setRole(Role.ROVING_GUARD);
					userObj.setDepartment(Department.SECURITY);
					break;
				}
				case 3: {
					userObj.setRole(Role.GATE_GUARD);
					userObj.setDepartment(Department.SECURITY);
					break;
				}
		}
			break;
		}case 5: {
			//ID Format: EMPYRA-RES-XXXXX
			System.out.println("---->Resident");
			System.out.println("Available roles: [1] Unit Owner | [2] Tenant | [3] Household Member");
			System.out.print("Option: ");
			int securityRole = sc.nextInt();
			sc.nextLine();
			switch (securityRole) {
				case 1: {
					userObj.setRole(Role.UNIT_OWNER);
					userObj.setDepartment(Department.RESIDENT_SERVICES);
					break;
				}case 2: {
					userObj.setRole(Role.TENANT);
					userObj.setDepartment(Department.RESIDENT_SERVICES);
					break;
				}
				case 3: {
					userObj.setRole(Role.HOUSEHOLD_MEMBER);
					userObj.setDepartment(Department.RESIDENT_SERVICES);
					break;
				}
			}
			break;
		}
	}
		if(isCreateUserService) userObj.setStatus(RoleStatus.PENDING.getStatusString());
		return userObj;
	}
}
