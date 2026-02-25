package com.empyra;

import java.util.Scanner;

import com.empyra.service.login.LoginService;
import com.empyra.users.User;

public class EmpyraMain {
	
	public static void main(String[] args) throws Exception{
		//i tried declaring this outside of main (just like what I do in services) but you can't do this in a class
		//with main because the main method is always ran first.
		ConsolePages displayPage = new ConsolePages();
		displayPage.asciiArt();
		
		LoginService login = new LoginService();
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Empyra Condominium Management System!");
		System.out.print("Username: ");
		String username = sc.nextLine();
		System.out.print("Password: ");
		String password = sc.nextLine(); 
		user = login.login(username, password);
		displayPage.mainMenu(user);
		
		
		sc.close();
	}
	
}
