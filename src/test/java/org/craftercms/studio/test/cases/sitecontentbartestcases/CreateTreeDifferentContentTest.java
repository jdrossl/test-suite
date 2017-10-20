package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class CreateTreeDifferentContentTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private SiteConfigPage siteConfigPage;
	
	private String userName;
	private String password;
	private int defaultTimeOut;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Create_Tree_Different_Content_Test() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a").click();

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#admin-console").click();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#yui-gen6").click();

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();
		

		// save
		siteConfigPage.saveDragAndDropProcess();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#cstudio-logo").click();

		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();

		// Select Entry Content Type
		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
	
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "services");

		// Expand all fields
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#cstudio-form-expand-all")
				.click();
	
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudioSaveAndClose").click();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		// expand home content
		dashboardPage.expandHomeTree();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionService();

		// Right click and paste content.

		dashboardPage.rightClickToPasteOption();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Click on edit option of recent activity section
		homePage.clickOnEditOptionRecentActivity();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		
		// edit internal name
		dashboardPage.editInternalName("TREE");

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 1

		dashboardPage.rightClickToPasteToTheTree1();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 2

		dashboardPage.rightClickToPasteToTheTree2();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 3

		dashboardPage.rightClickToPasteToTheTree3();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 4

		dashboardPage.rightClickToPasteToTheTree4();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Assert of the tree created

		String contentCopied = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", "//tr/td[contains(span, 'ServicesTREE')]")
				.getText();

		// driverManager.getDriver()
		// .findElement(By.xpath("//tr/td[contains(span, 'ServicesTREE')]")).getText();
		Assert.assertEquals(contentCopied, "ServicesTREE *");

	}

}
