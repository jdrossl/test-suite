/**
 * 
 */
package org.craftercms.studio.test.cases.contenttypepagetestcases;

import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author luishernandez
 *
 */
public class ContentTypesAddVideoTest {
	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private SiteConfigPage siteConfigPage;

	private String controlsSectionFormSectionLocator;
	private String contentTypeContainerLocator;
	private String controlsSectionVideoLocator;
	private String contentTypeContainerFormSectionContainerLocator;
	private String contentTypeContainerVideoTitleLocator;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);
		this.controlsSectionFormSectionLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlssectionformsection");
		this.contentTypeContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainer");
		this.controlsSectionVideoLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlsvideo");
		this.contentTypeContainerFormSectionContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerformsectioncontainer");
		this.contentTypeContainerVideoTitleLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainervideotitle");
	
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDropForVideo() {


		driverManager.setImplicitlyWaitTimeForFindElements();

		// Getting the Form Section control input for drag and drop action
		WebElement FromControlSectionFormSectionElement = driverManager.getDriver()
				.findElement(By.xpath(controlsSectionFormSectionLocator));

		// Getting the Content Type Container for drag and drop action
		// (destination)
		WebElement ToContentTypeContainer = driverManager.getDriver()
				.findElement(By.xpath(contentTypeContainerLocator));

		driverManager.dragAndDropElement(FromControlSectionFormSectionElement, ToContentTypeContainer);
		// wait for element

		homePage.getDriverManager().driverWait();

		driverManager.setImplicitlyWaitTimeForFindElements();

		WebElement FromVideo= driverManager.getDriver()
				.findElement(By.xpath(controlsSectionVideoLocator));

		WebElement ToDefaultSection = driverManager.getDriver()
				.findElement(By.xpath(contentTypeContainerFormSectionContainerLocator));

		siteConfigPage.getDriverManager().dragAndDropElement(FromVideo, ToDefaultSection);

		// Complete the input fields basics
		siteConfigPage.completeVideoFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefaul");

		// Save the data
		siteConfigPage.saveDragAndDropProcess();

	}

	@Test(priority = 0)
	public void contentTypeAddVideo() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element
		homePage.getDriverManager().driverWait();

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait();

		// reload page
		driverManager.getDriver().navigate().refresh();
		
		driverManager.setImplicitlyWaitTimeForFindElements();
		
		// Show site content panel
		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a")).click();

		// Show admin console page
		driverManager.getDriver().findElement(By.xpath(".//a[@id='admin-console']")).click();

		// wait for element
		homePage.getDriverManager().driverWait();

		// Select the content type to the test
		siteConfigPage.selectEntryContentTypeFromAdminConsole();

		// wait for element
		siteConfigPage.getDriverManager().driverWait();

		// drag and drop
		this.dragAndDropForVideo();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// wait for element
		siteConfigPage.getDriverManager().driverWait();

		// Select the generic content type
		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// wait for element
		homePage.getDriverManager().driverWait();

		
		driverManager.setImplicitlyWaitTimeForFindElements();
		
		// Click on input section to can view the properties
		siteConfigPage.clickVideoSection();

		// Asserts that fields are not empty.
		String titleText = driverManager.getDriver()
				.findElement(By.xpath(contentTypeContainerVideoTitleLocator)).getText();

		Assert.assertTrue(titleText.contains("TestTitle"));

	}
}
