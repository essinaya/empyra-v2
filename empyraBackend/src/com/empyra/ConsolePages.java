package com.empyra;

import java.util.Scanner;

import com.empyra.service.administration.CreateUsers;
import com.empyra.users.User;
import com.empyra.utils.Role;

public class ConsolePages {

	Scanner sc = new Scanner(System.in);
	
	public void asciiArt() {
		System.out.println(""
				+ "..................................-=+****+=-:..................................\r\n"
				+ "............................:=#%%%%%#######%%%%%*-:............................\r\n"
				+ ".........................-*%%%*+-............:=+#%%%+:.........................\r\n"
				+ ".......................=#%%*-....................:=#%%*-.......................\r\n"
				+ ".....................=%%#=............=#:...........:+%%#:.....................\r\n"
				+ "...................:*%%+.............*%%%=.............#%%+....................\r\n"
				+ "..................-%%#.............:*%%%%%=.............-%%+...................\r\n"
				+ ".................:%%*:.............#%%=.#%%+.............:#%*..................\r\n"
				+ ".................%%*:..............#%%=.#%%+..............-#%+.................\r\n"
				+ "................*%#:.............:.#%%=.#%%+.-.............=%%:................\r\n"
				+ "...............:#%*............=%=.#%%=.#%%+.##=............*%#................\r\n"
				+ "...............+%%:..........-%%%=.#%%=.#%%+.#%%#:..........*%%................\r\n"
				+ "...............*%%...........%%%%=.#%%=.#%%+.#%%%+..........+%%:...............\r\n"
				+ "...............*%%...........%%%+..#%%=.#%%+.:#%%+..........=%%-...............\r\n"
				+ "...............*%%...........%%%-..#%%=.#%%+..=%%+..........=%%-...............\r\n"
				+ "...............*%%...........%%%-..#%%=.#%%+..=%%+..........=%%-...............\r\n"
				+ "...............*%%........-+.%%%-..#%%=.#%%+..=%%+:*........=%%-...............\r\n"
				+ "...............*%%......:#%*.%%%-..#%%=.#%%+..=%%+:%%+......=%%-...............\r\n"
				+ "...............*%%.....:%%%*.%%%-..#%%=.#%%+..=%%+:%%%*:....=%%-...............\r\n"
				+ "...............*%%.....:%%%*.%%%-..#%%=.#%%+..=%%+:%%%*:....=%%-...............\r\n"
				+ "...............*%%.....:%%%*.%%%-..#%%=.#%%+..=%%+:%%%*:....=%%-...............\r\n"
				+ "...............*%%.....:%%%*.%%%-..#%%=.#%%+..=%%+:%%%*:....=%%-...............\r\n"
				+ "...............*%%.....:%%%*.%%%-..#%%=.#%%+..=%%+:%%%*:....=%%-...............\r\n"
				+ "...............*%%.....:%%%*.%%%-.-%%%=.#%%#:.=%%+:%%%*:....=%%-...............\r\n"
				+ "...............*%%.....:%%%*.%%%#%%%%%-.*%%%%%*%%+:%%%*:....=%%-...............\r\n"
				+ "...............*%%...-#%%%%*.%%%%%%%+:...-#%%%%%%+:%%%%%=:..=%%-...............\r\n"
				+ "...............*%%:+%%%%%%%*.%%%%#=........:+%%%%+:%%%%%%%#=+%%-...............\r\n"
				+ "...............*%%%%%%%%%%%*.%%*:.............=#%+:%%%%%%%%%%%%:...............\r\n"
				+ "...............:::::::::::::.:..................::.::::::::::::................\r\n");
		System.out.println();
		System.out.println("                 		 E M P Y R A                 ");

	}
	
	public void mainMenu(User authUser) throws Exception {
		separator();
		int menuChoice = 0;
		while(menuChoice != 20) {
			System.out.println("Welcome, "+authUser.getFirstName());
			System.out.println("Please choose from the following: ");
			System.out.println("[1] Messages");//Announcements, Complaints raised to you, Violations
			System.out.println("[2] Tickets");//Complaints
			System.out.println("[3] Create Request"); //car pass, visitor pass
			System.out.println("[4] Search / View Directory");
			System.out.println("[5] My Profile");
			
			
			//Role related
			roleSpecificMenu(authUser.getRole());
			System.out.println("[20] Logout");
			menuChoice = sc.nextInt();
			sc.nextLine();
			if(menuChoice ==6) {
				CreateUsers cu = new CreateUsers();
				cu.createUser(authUser);
			} else if (menuChoice == 20) {
				System.out.println("Thank you for using Empyra. Goodbye!");
			} else {
				System.out.println("Feature is still under development. Please choose another.");
			}
			
			
		}
		
	}
	
	private void separator() {
		System.out.println("[EMPYRA]===========================================");
	}
	
	public void roleSpecificMenu(Role userRole) {
		//in future 
		switch (userRole) {

	        case SYSTEM_ADMINISTRATOR:
	            System.out.println("[6] Create User");
	            System.out.println("[7] Update User");
	            System.out.println("[8] Assign Role / Department");
	            System.out.println("[9] Activate / Suspend User");
	            System.out.println("[10] Manage Buildings / Floors / Units");
	            break;
	
	        case PROPERTY_MANAGER:
	            System.out.println("[6] View Operations Dashboard");
	            System.out.println("[7] View Escalations");
	            System.out.println("[8] Review Closures");
	            System.out.println("[9] Final Approval Actions");
	            break;
	
	        case PMO_SUPERVISOR:
	            System.out.println("[6] View Incoming Complaints");
	            System.out.println("[7] Assign Complaints");
	            System.out.println("[8] Escalate Unresolved Cases");
	            System.out.println("[9] Review Closures");
	            break;
	
	        case PMO_CLERK:
	            System.out.println("[6] Log New Request");
	            System.out.println("[7] Update Request Status");
	            System.out.println("[8] Communicate With Residents");
	            System.out.println("[9] View Assigned Queue");
	            break;
	
	        case SECURITY_HEAD:
	            System.out.println("[6] Review Pass Issuance");
	            System.out.println("[7] Revoke / Override Pass");
	            System.out.println("[8] View Entry / Exit Logs");
	            break;
	
	        case GATE_GUARD:
	            System.out.println("[6] Issue Visitor Pass");
	            System.out.println("[7] Issue Car Pass");
	            System.out.println("[8] Log Entry");
	            System.out.println("[9] Log Exit");
	            System.out.println("[10] Validate Pass");
	            break;
	
	        case ROVING_GUARD:
	            System.out.println("[6] Log Incident");
	            System.out.println("[7] Update Incident Status");
	            System.out.println("[8] View Assigned Incidents");
	            break;
	
	        case MAINTENANCE_COORDINATOR:
	            System.out.println("[6] View Maintenance Requests");
	            System.out.println("[7] Create Work Order");
	            System.out.println("[8] Assign Staff / Vendor");
	            System.out.println("[9] Schedule Work");
	            System.out.println("[10] Verify Completion");
	            break;
	
	        case MAINTENANCE_STAFF:
	            System.out.println("[6] View Assigned Work Orders");
	            System.out.println("[7] Update Work Status");
	            System.out.println("[8] Add Completion Notes");
	            break;
	
	        case UNIT_OWNER:
	        case TENANT:
	            System.out.println("[6] View Unit Notices");
	            System.out.println("[7] Track My Requests");
	            break;
	
	        case HOUSEHOLD_MEMBER:
	            System.out.println("[6] Submit Request");
	            System.out.println("[7] View My Requests");
	            break;
	
	        default:
	            System.out.println("No role-specific actions available.");
		}
	}
	
	
	
}
