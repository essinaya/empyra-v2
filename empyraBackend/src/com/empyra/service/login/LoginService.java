package com.empyra.service.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empyra.database.service.DatabaseConnectionService;
import com.empyra.users.User;

public class LoginService {

	public String login(String username, String password) throws SQLException, IOException {
		//check db for username and password
		//retrieve the user
		//return if success or not (soon: HTTP)
		//TODO add password in db
		String status = "Username not found";
		DatabaseConnectionService dcs = new DatabaseConnectionService();
		List<User> userList = new ArrayList<User>();
		userList = dcs.getUsers();
		for(User user : userList) {
			if(username.equals(user.getId())) {
				status = "Login Success";
			}
		}
		return status;
	}
	
}
