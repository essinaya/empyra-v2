package com.empyra.utils;

import com.empyra.users.User;

public class UserUtility {

	public String generateDefaultUsername(User user) {
		String generatedUsername = "";
		switch (user.getDepartment()) {

		case SYSTEM_ADMINISTRATION: {
			generatedUsername = Department.SYSTEM_ADMINISTRATION.getAbbreviation().toLowerCase()
						.concat("."+user.getFirstName().toLowerCase());
			break;
		} case PROPERTY_MANAGEMENT: {
			generatedUsername = Department.PROPERTY_MANAGEMENT.getAbbreviation().toLowerCase()
					.concat("."+user.getFirstName().toLowerCase());
			break;
		} case SECURITY: {
			generatedUsername = Department.SECURITY.getAbbreviation().toLowerCase()
					.concat("."+user.getFirstName().toLowerCase());
			break;
		} case MAINTENANCE: {
			generatedUsername = Department.MAINTENANCE.getAbbreviation().toLowerCase()
					.concat("."+user.getFirstName().toLowerCase());
			break;
		} case RESIDENT_SERVICES: {
			generatedUsername = Department.RESIDENT_SERVICES.getAbbreviation().toLowerCase()
					.concat("."+user.getFirstName().toLowerCase());
			break;
		} 
		default:
			throw new IllegalArgumentException("Unexpected value: " + user.getDepartment());
		}
		
		return generatedUsername;
	}
	
	public String generateDefaultPassword(User user) {
		//to be further enhanced
		String generatedPassword = "";
		switch (user.getDepartment()) {

		case SYSTEM_ADMINISTRATION: {
			generatedPassword = Department.SYSTEM_ADMINISTRATION.getAbbreviation().toLowerCase()
						.concat("."+user.getFirstName().toLowerCase());
			break;
		} case PROPERTY_MANAGEMENT: {
			generatedPassword = Department.PROPERTY_MANAGEMENT.getAbbreviation().toLowerCase()
					.concat("."+user.getFirstName().toLowerCase());
			break;
		} case SECURITY: {
			generatedPassword = Department.SECURITY.getAbbreviation().toLowerCase()
					.concat("."+user.getFirstName().toLowerCase());
			break;
		} case MAINTENANCE: {
			generatedPassword = Department.MAINTENANCE.getAbbreviation().toLowerCase()
					.concat("."+user.getFirstName().toLowerCase());
			break;
		} case RESIDENT_SERVICES: {
			generatedPassword = Department.RESIDENT_SERVICES.getAbbreviation().toLowerCase()
					.concat("."+user.getFirstName().toLowerCase());
			break;
		} 
		default:
			throw new IllegalArgumentException("Unexpected value: " + user.getDepartment());
		}
		
		return generatedPassword;
	}
}
