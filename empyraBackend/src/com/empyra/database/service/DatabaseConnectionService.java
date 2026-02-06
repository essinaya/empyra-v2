package com.empyra.database.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.empyra.database.Database;
import com.empyra.users.User;
import com.empyra.utils.FileReaderUtil;

public class DatabaseConnectionService {
	public List<User> getUsers() throws SQLException, IOException  {
		List<User> usersList = new ArrayList<User>();
		try {
			FileReaderUtil fru = new FileReaderUtil();
			Database db = new Database();
			db = fru.readTextFile("database.txt");
			Connection con = DriverManager.getConnection(db.getDbUrl(), db.getDbUsername(), db.getDbPassword());
			
			User dbUser = new User();
			if(con!=null) {
				System.out.println("Connected to the database");
				Statement st = con.createStatement();
				ResultSet result = st.executeQuery("SELECT * FROM USERS");
				if(result != null) {
					while (result.next()) {
						dbUser = new User();
					    dbUser.setId(result.getString("USER_ID"));
					    dbUser.setFirstName(result.getString("FIRST_NAME"));
					    dbUser.setMiddleName(result.getString("MIDDLE_NAME"));
					    dbUser.setLastName(result.getString("LAST_NAME"));
					    usersList.add(dbUser);
					}

				}
			}
		} catch (SQLException sqlEx) {
			throw new SQLException("Error encountered connecting to the database. Logs: "+sqlEx);
		} catch (IOException ioEx) {
			throw new IOException("Error encountered reading file. Logs: "+ioEx);
		}
		return usersList;
	}	
}
