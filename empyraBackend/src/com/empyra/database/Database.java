package com.empyra.database;

public class Database {
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	
	public Database() {
		
	}
	
	public Database(String url, String username, String password) {
		this.dbUrl = url;
		this.dbUsername = username;
		this.dbPassword = password;
	}
	
	
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbUsername() {
		return dbUsername;
	}
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
}
