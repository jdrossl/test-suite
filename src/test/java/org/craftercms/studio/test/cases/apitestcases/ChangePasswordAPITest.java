package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.UserManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro
 */

public class ChangePasswordAPITest {

	private SecurityAPI securityAPI;
	private UserManagementAPI userManagementAPI;

	public ChangePasswordAPITest() {
		 APIConnectionManager apiConnectionManager = new APIConnectionManager();
		 JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api,apiConnectionManager);
		userManagementAPI = new UserManagementAPI(api,apiConnectionManager);
	}

	@BeforeMethod
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		userManagementAPI.testCreateUser();
		
	}

	@Test(priority = 1)
	public void testChangePassword() {
		securityAPI.logOutFromStudioUsingAPICall();
		securityAPI.loginWithOtherUser(userManagementAPI.getNewusername(), userManagementAPI.getNewpassword());
		userManagementAPI.testChangePassword();
		securityAPI.logOutFromStudioOtherUserUsingAPICall(userManagementAPI.getNewusername(), userManagementAPI.getNewpassword());
		securityAPI.logInIntoStudioUsingAPICall();
	}

	@Test(priority = 2)
	public void testInvalidParameters() {
		securityAPI.logOutFromStudioUsingAPICall();
		securityAPI.loginWithOtherUser(userManagementAPI.getNewusername(), userManagementAPI.getNewpassword());
		userManagementAPI.testChangePasswordInvalidParameters();
		securityAPI.logOutFromStudioOtherUserUsingAPICall(userManagementAPI.getNewusername(), userManagementAPI.getNewpassword());
		securityAPI.logInIntoStudioUsingAPICall();
		
	}

	@Test(priority = 3)
	public void testUnauthorized() {
		securityAPI.logOutFromStudioUsingAPICall();
		userManagementAPI.testChangePasswordUnauthorized();
		securityAPI.logInIntoStudioUsingAPICall();
	}

	//TODO: Pending to review this scenario currently it is returning a 401, expected 404
//	@Test(priority = 4)
//	public void tesUserNotFound() {
//		securityAPI.logOutFromStudioUsingAPICall();
//		securityAPI.loginWithOtherUser(userManagementAPI.getNewusername(), userManagementAPI.getNewpassword());
//		userManagementAPI.testChangePasswordUserNotFound();
//		securityAPI.logOutFromStudioOtherUserUsingAPICall(userManagementAPI.getNewusername(), userManagementAPI.getNewpassword());
//		securityAPI.logInIntoStudioUsingAPICall();
//	}
	
	@AfterMethod
	public void afterTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		userManagementAPI.testDeleteUser();
		securityAPI.logOutFromStudioUsingAPICall();
	}

}
