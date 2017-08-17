package org.craftercms.studio.test.cases.sitespagetestcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * 
 * @author luishernandez
 *
 */

public class CreateSiteWithWebSiteEditorialBluePrintTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private CreateSitePage createSitePage;



	 @BeforeTest
	 public void beforeTest() {
	 this.driverManager = new WebDriverManager();
	 UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
	 FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
	 this.loginPage = new LoginPage(driverManager,
			 uIElementsPropertiesManager);
	 this.homePage = new HomePage(driverManager,
			 uIElementsPropertiesManager);
	 this.createSitePage = new CreateSitePage(driverManager,
			 uIElementsPropertiesManager);

	
	 }

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)
	public void createSiteWithWebSiteEditorialBluePrintTest() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");
		
		// MaximizeWindow
		driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the Id of the site

		//createSitePage.fillIdSite("");

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo

		createSitePage.openBlueprintCombo();

		// Select empty blueprint

		createSitePage.selectWebEditorialBlueprint();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show site content panel

		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert

		String head = driverManager.getDriver()
				.findElement(By.cssSelector("#activeContentActions > li:nth-child(1) > span")).getText();
		Assert.assertEquals(head, "Live :");

	}

}