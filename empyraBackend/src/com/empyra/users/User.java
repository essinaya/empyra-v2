package com.empyra.users;

import com.empyra.utils.Department;
import com.empyra.utils.Role;

public class User {
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Role role;
	private String contactNumber;
	private String status;
	private String createdAt;
	private String createdBy;
	private Department department;
	
	//new columns
	private String username;
	private String user_password;
	private String updatedBy;
	private String updatedDt;
	
	public User() {
		
	}
	
	
	public User(String id, String firstName, String middleName, String lastName, Role role,
				String contactNumber, String status, String createdAt, String createdBy, Department department,
				String username, String password, String updatedBy, String updatedDt) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.role = role;
		this.contactNumber = contactNumber;
		this.status = status;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.department = department;
		this.username = username;
		this.user_password = password;
		this.createdBy = createdBy;
		this.updatedDt = updatedDt;
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getUpdatedDt() {
		return updatedDt;
	}


	public void setUpdatedDt(String updatedDt) {
		this.updatedDt = updatedDt;
	}
	
	
}
