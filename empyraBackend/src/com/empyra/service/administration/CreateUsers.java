package com.empyra.service.administration;

import java.util.Scanner;

import com.empyra.database.service.DatabaseConnectionService;
import com.empyra.service.administration.utility.SetRoleUtility;
import com.empyra.users.User;
import com.empyra.utils.Department;
import com.empyra.utils.Role;
import com.empyra.utils.RoleStatus;

public class CreateUsers {
	Scanner sc = new Scanner(System.in);
	DatabaseConnectionService dcs = new DatabaseConnectionService();
	SetRoleUtility roleUtil = new SetRoleUtility();
	
	public void createUser(User user) throws Exception {
		User newUser = new User();
		System.out.println("[ADMIN]=====Create User=====");
		System.out.print("First Name: ");
		newUser.setFirstName(sc.nextLine());
		System.out.print("Middle Name: ");
		newUser.setMiddleName(sc.nextLine());
		System.out.print("Last Name: ");
		newUser.setLastName(sc.nextLine());
		System.out.print("Contact Number: ");
		newUser.setContactNumber(sc.nextLine());
		System.out.println("For department, please choose from the following: ");
		System.out.println("[1] Administration");
		System.out.println("[2] Property Management Office (PMO)");
		System.out.println("[3] Maintenance");
		System.out.println("[4] Security");
		System.out.println("[5] Resident");
		System.out.print("Option: ");
		int departmentChoice = sc.nextInt();
		sc.nextLine();
		//newUser = setRole(departmentChoice, newUser);
		//newUser = SetRoleUtility.setRole(departmentChoice, newUser, sc, true);
		//Cannot make a static reference to the non-static method setRole(int, User, Scanner, boolean) from the type SetRoleUtility
		newUser = roleUtil.setRole(departmentChoice, newUser, sc, true);
		System.out.println(dcs.createUser(newUser, user));
	}
}