package com.empyra.service.administration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.empyra.database.service.DatabaseConnectionService;
import com.empyra.service.administration.utility.SetRoleUtility;
import com.empyra.users.User;
import com.empyra.utils.SystemUtility;

public class UpdateUsers {
	
	Scanner sc = new Scanner(System.in);
	SystemUtility su = new SystemUtility();
	SetRoleUtility roleUtil = new SetRoleUtility();
	//get users that are active in db
	//iterate the names, show in console
	//user chooses from the list
	//choose which to update
	//confirm changes, loop
	//if yes, update in db. if no, just loop
	
	//method to get the users and return a list
	//method to update the users from the option
	//method to update the user arguments: User obj.
	//then lets the user choose what to update
	//based on what the option is. ONLY THE AVAILABLE OPTIONS
	
	//scenarios:
	//positive testing: normal update. expected output
	
	DatabaseConnectionService dcs = new DatabaseConnectionService();
	
	private List<User> retrieveActiveUsersFromDb() throws SQLException, IOException {
		
		return dcs.getActiveUsers();
	}
	
	public void updateUser(User authUser) throws SQLException, IOException {
		//welcome to the update user section.
		//please choose who to update.
		//selected: {User}.
		//Please select WHAT to update.
		//user chooses, decides changes
		//overview first, maybe comparison of before and after of the values?
		//to proceed with the changes, please press [1].
		//Otherwise, press [0] to go back.
		//retain new values.
		User updateUserProfile = new User();
		boolean noUsersFound = true;
		boolean stillHasChanges = true;
		boolean validUserChosen = true;
		List<User> activeUsers = new ArrayList<User>();
		System.out.println("Welcome to Update User Section.");
		System.out.println("Retrieving available active users...");
		activeUsers = retrieveActiveUsersFromDb();
		if(activeUsers.size() > 0) {
			noUsersFound = false;
			for(int i = 0; i < activeUsers.size(); i++) {
				su.printSeparator(1, String.valueOf(i));
				System.out.println("User ID: "+activeUsers.get(i).getId());
				System.out.println("Name (LN, FN MN) : "+activeUsers.get(i).getLastName()+", "+activeUsers.get(i).getFirstName()+" "+activeUsers.get(i).getMiddleName());
				//show
				//get index
				//return the user object
			}
		} else {
			System.out.println("There are no active users at the moment.");
		}
		if(!noUsersFound) {
			System.out.println("Please choose who to update.");
			int userIndex = sc.nextInt();
			sc.nextLine();
			if(userIndex < activeUsers.size() && userIndex != activeUsers.size()) {
				updateUserProfile = activeUsers.get(userIndex);
				//show profile
				showUserProfile(updateUserProfile);
				//confirm
				System.out.println("Are you sure you want to update "+updateUserProfile.getId()+"?");
				System.out.println("[1] Yes | [2] No");
				su.printSeparator(0, null);
				int updateChoice = sc.nextInt();
				sc.nextLine();
				if(updateChoice == 1) {
					while(stillHasChanges) {
						su.printSeparator(0, null);
						System.out.println("[1] First Name");
						System.out.println("[2] Middle Name");
						System.out.println("[3] Last Name");
						System.out.println("[4] User Role");
						System.out.println("[5] Contact Number");
						System.out.print("Please choose which field to change: ");
						int fieldChoice = sc.nextInt();
						sc.nextLine();
						updateUserProfile = updateField(fieldChoice, updateUserProfile);
						su.printSeparator(0, null);
						System.out.println("Done updating user profile for "+updateUserProfile.getId()+". Please review the changes.");
						showUserProfile(updateUserProfile);
						System.out.println("Are you satisfied with the changes? [1] Yes | [2] No");
						int updateUserChoice = sc.nextInt();
						sc.nextLine();
						stillHasChanges = (updateUserChoice == 1) ? true: false;
					}
					
				}
				//add if no
			} else {
				
			}
			
			//negatve scenario is what if user chose number beyond (array out of bounds)
			
			
		}
	}
	
	private void showUsers() throws SQLException, IOException {

	}
	
	private void getUsers() {
		
	}
	
	private void showUserProfile(User toUpdateUser) {
		System.out.println("User ID: "+toUpdateUser.getId());
		System.out.println("Name (LN, FN MN): "+toUpdateUser.getLastName()+", "+toUpdateUser.getFirstName()+" "+toUpdateUser.getMiddleName());
		System.out.println("Role: "+toUpdateUser.getRole());
		System.out.println("Contact Number: "+toUpdateUser.getContactNumber());
		System.out.println("Status: "+toUpdateUser.getStatus());
		System.out.println("Created At: "+toUpdateUser.getCreatedAt());
		System.out.println("Created By: "+toUpdateUser.getCreatedBy());
		System.out.println("Department: "+toUpdateUser.getDepartment());
		System.out.println("Username: "+toUpdateUser.getUsername());
	}
	
	private User updateField(int fieldChoice, User toUpdateUser) {
		String change = "";
		switch (fieldChoice) {
		case 1:
			System.out.print("Please enter new First Name:");
			change = sc.nextLine();
			toUpdateUser.setFirstName(change);
			break;
		case 2:
			System.out.print("Please enter new Middle Name:");
			change = sc.nextLine();
			toUpdateUser.setMiddleName(change);
			break;
		case 3:
			System.out.print("Please enter new Last Name:");
			change = sc.nextLine();
			toUpdateUser.setLastName(change);
			break;
		case 4:
			System.out.println("For department, please choose from the following: ");
			System.out.println("[1] Administration");
			System.out.println("[2] Property Management Office (PMO)");
			System.out.println("[3] Maintenance");
			System.out.println("[4] Security");
			System.out.println("[5] Resident");
			System.out.print("Please enter new User Role:");
			change = sc.nextLine();
			int changeInt = Integer.parseInt(change);
			toUpdateUser = roleUtil.setRole(changeInt, toUpdateUser, sc, false);
			break;
		case 5:
			System.out.print("Please enter new Contact Number:");
			change = sc.nextLine();
			toUpdateUser.setContactNumber(change);
			break;
		default:
			break;
		}
		
		return toUpdateUser;
	}
	
	
	
}
