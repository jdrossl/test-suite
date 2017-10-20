package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.UsersPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class TryToDeleteUserConnectedTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UsersPage usersPage;
	
	private String userName;
	private String password;
	private int defaultTimeOut;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void try_to_delete_user() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// Go to users tab
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssselector",
				"body > ui-view > header > nav > div > div.collapse.navbar-collapse.ng-scope > ul > li:nth-child(1) > a")
				.click();
		
		// Try to delete the user current 
		usersPage.clickOnDeleteUser();

		// Confirmation to delete user connected
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssselector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();
		// Verify
		Assert.assertTrue(this.driverManager.isElementPresentBycssSelector(defaultTimeOut,
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-body.ng-scope > p"));

		WebElement validation = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssselector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-body.ng-scope > p");

		Assert.assertTrue(validation.getText().contains("Unable to delete user"));

	}

}
