package com.empyra.utils;

import java.io.BufferedReader;
import java.io.IOException;
import com.empyra.database.Database;

public class FileReaderUtil {
	
//	public static void main(String[] args) throws IOException {
//		Database dBase = new Database();
//		FileReaderUtil fru = new FileReaderUtil();
//		dBase = fru.readTextFile("database.txt");
//		System.out.println("URL: "+dBase.getDbUrl());
//		System.out.println("Username: "+dBase.getDbUsername());
//		System.out.println("Password: "+dBase.getDbPassword());
//	}
	public Database readTextFile(String textFileName) throws IOException {
		//TODO: put in try catch, create an exception class for this, throw exceptions properly.
		String path = "C:\\textFiles\\"+textFileName;
		BufferedReader bfro = new BufferedReader(new java.io.FileReader(path));
		Database dBase = new Database();
		String result;
		//TODO put in stream
		while ((result = bfro.readLine()) != null) {
			if(result.contains("database_url")) {
				dBase.setDbUrl(result.substring(13));
			}else if(result.contains("database_username")) {
				dBase.setDbUsername(result.substring(18));
			}else if(result.contains("database_password")) {
				dBase.setDbPassword(result.substring(18));
			} else {
				System.out.println("Nothing to add.");
				break;
			}
		}
		bfro.close();
		
		return dBase;
	}
}
