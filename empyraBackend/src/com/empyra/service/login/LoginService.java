package com.empyra.service.login;

import java.util.ArrayList;
import java.util.List;

import com.empyra.database.service.DatabaseConnectionService;
import com.empyra.users.User;

public class LoginService {

	public User login(String username, String password) throws Exception {
		//check db for username and password
		//retrieve the user
		//return if success or not (soon: HTTP)
		//TODO add password in db, then encryption
		DatabaseConnectionService dcs = new DatabaseConnectionService();
		List<User> userList = new ArrayList<User>();
		User authUser = new User();
		userList = dcs.getUsers();
		try {
			for(User user : userList) {
				if(username.equals(user.getUsername())) {
					authUser = user;
					break;
				} else {
					System.out.println("Issue encountered retrieving users");
				}
			}
		} catch (Exception e2) {
			throw new Exception("Issue encountered retrieveing users"+e2);
		}
		
		return authUser;
	}
	
}
