package com.empyra.unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.empyra.service.login.LoginService;
import com.empyra.users.User;

@DisplayName("Unit Test for LoginService.java")
class LoginServiceTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	@Test
	@DisplayName("Test method for login (Positive)")
	void loginTest() throws Exception {
		String username = "ecdborel", password = "ecdborel";
		LoginService loginService = new LoginService();
		
		User actualResult = loginService.login(username, password);
		assertNotNull(actualResult.getUsername());
	}
	
	@Test
	@DisplayName("Test method for login (negative)")
	void loginTestNegative() throws Exception {
		String username = "ecdborellll", password = "ecdborel";
		LoginService loginService = new LoginService();
		
		User actualResult = loginService.login(username, password);
		
		assertNull(actualResult.getUsername());
	}

}
