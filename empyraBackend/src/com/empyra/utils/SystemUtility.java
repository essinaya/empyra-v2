package com.empyra.utils;

public class SystemUtility {

	public void printSeparator(int separatorType, String msg) {
		switch (separatorType) {
		case 1:
			System.out.println("===========================================["+msg+"]");
			break;
		case 2:
			System.out.println("[EMPYRA]===========================================");
			break;
		default:
			System.out.println("===========================================");
			break;
		}
	}
	
}
