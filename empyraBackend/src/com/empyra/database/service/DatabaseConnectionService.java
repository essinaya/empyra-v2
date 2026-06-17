package com.empyra.database.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.empyra.database.Database;
import com.empyra.users.User;
import com.empyra.utils.DateUtility;
import com.empyra.utils.Department;
import com.empyra.utils.FileReaderUtil;
import com.empyra.utils.Role;
import com.empyra.utils.UserUtility;

public class DatabaseConnectionService {
	public List<User> getUsers() throws SQLException, IOException  {
		List<User> usersList = new ArrayList<User>();
		try {
			Connection con = connectToDatabase();
			
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
					    dbUser.setRole(Role.valueOf(result.getString("USER_ROLE")));
					    dbUser.setContactNumber(result.getString("CONTACT_NUMBER"));
					    dbUser.setStatus(result.getString("STATUS"));
					    dbUser.setCreatedAt(result.getString("CREATED_AT"));
					    dbUser.setCreatedBy(result.getString("CREATED_BY"));
					    dbUser.setDepartment(Department.valueOf(result.getString("DEPARTMENT")));
					    dbUser.setUsername(result.getString("USERNAME"));
					    dbUser.setUser_password(result.getString("USER_PASSWORD"));
					    dbUser.setUpdatedBy(result.getString("UPDATED_BY"));
					    dbUser.setUpdatedDt(result.getString("UPDATED_DT"));
					    usersList.add(dbUser);
					}

				}
				st.close();
				result.close();
			}
		} catch (SQLException sqlEx) {
			throw new SQLException("Error encountered connecting to the database. Logs: "+sqlEx);
		} catch (IOException ioEx) {
			throw new IOException("Error encountered reading file. Logs: "+ioEx);
		}
		return usersList;
	}	
	
	public String createUser(User newUser, User authUser) throws Exception {
		DateUtility dtUtil = new DateUtility();
		String generatedUsername = newUser.getFirstName().toLowerCase().concat("."+newUser.getLastName());
		Connection con = connectToDatabase();
		String sql = "INSERT INTO USERS (USER_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, USER_ROLE,"
				   + "CONTACT_NUMBER, STATUS, CREATED_AT, CREATED_BY, DEPARTMENT, USERNAME, USER_PASSWORD, "
				   + "UPDATED_BY, UPDATED_DT)"
				   + "VALUES (?, ?, ?, ?, ?,"
				   + "?, ?, ?, ?, ?, ?, ?,"
				   + "?, ?)";
		
		// Using PreparedStatement is safer and prevents SQL injection
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,generateUserId(newUser.getRole()));
		ps.setString(2, newUser.getFirstName().toUpperCase());
		ps.setString(3, newUser.getMiddleName().toUpperCase());
		ps.setString(4, newUser.getLastName().toUpperCase());
		ps.setString(5, newUser.getRole().toString());
		ps.setString(6, newUser.getContactNumber());
		ps.setString(7, newUser.getStatus());
		ps.setString(8, dtUtil.getDateTime());
		ps.setString(9, authUser.getId());
		ps.setString(10, newUser.getDepartment().toString());
		ps.setString(11, generatedUsername);
		ps.setString(12, newUser.getFirstName().toLowerCase());
		ps.setString(13, authUser.getId());
		ps.setString(14, dtUtil.getDateTime());
		ps.executeUpdate();
		
		return "Done creating user "+generatedUsername;
	}
	
	private Connection connectToDatabase() throws IOException, SQLException {
		FileReaderUtil fru = new FileReaderUtil();
		Database db = new Database();
		Connection con = null;
		try {
			db = fru.readTextFile("database.txt");
			con = DriverManager.getConnection(db.getDbUrl(), db.getDbUsername(), db.getDbPassword());
			System.out.println("Successfully connected to database.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Error encountered reading file.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error encountered connecting to database");
		}
		return con;
	}
	
	private String generateUserId(Role userRole) throws Exception {
		//get abbreviation in department table (or maybe just let the enum do it?)
		//filter user tables by getting the department full name from department table, order by ascending
		int latestUserId = 0;
		String userId = "";
		try {
			Connection con = connectToDatabase();
			if(con!=null) {
				Statement st = con.createStatement();
				
				ResultSet result = st.executeQuery("SELECT * FROM USERS WHERE DEPARTMENT = '"+userRole.getDepartment()
								   +"' ORDER BY USER_ID DESC FETCH FIRST 1 ROWS ONLY;");
				if(result != null) {
					while(result.next()) {
						userId = result.getString("USER_ID").trim().substring(0, 7);
						//EMPYRA-SYS-00001
						
						latestUserId = Integer.parseInt(result.getString("USER_ID").trim().substring(12));
					}
					latestUserId = ++latestUserId;

					String latestUserIdWithZeroes = String.format("%05d", latestUserId);
					userId = userId.concat(latestUserIdWithZeroes);
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error encoutered during generating of ID.");
		}
		return userId;
		
	}

}
