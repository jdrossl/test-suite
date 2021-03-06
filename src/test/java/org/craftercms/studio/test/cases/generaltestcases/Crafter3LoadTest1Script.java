/**
 * 
 */
package org.craftercms.studio.test.cases.generaltestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author luishernandez
 *
 */
public class Crafter3LoadTest1Script {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;
	private DashboardPage dashboardPage;

	private String userName;
	private String password;

	private String parentFolderName;
	private String harnessFolderName;
	private String emptyFolderName;
	private String bigTree1FolderName;
	private String bigTree2FolderName;
	private String myTestFolderName;
	private String anotherTestFolderName;
	private String parentFolderLocator;
	private String harnessFolderLocator;
	private String emptyFolderLocator;
	private String bigTree1FolderLocator;
	private String bigTree2FolderLocator;
	private String parentFolderDivOnTreeSelectorLocator;
	private String mytestFolderLocator;
	private String anotherTestFolderLocator;
	private String bigTree1FolderDivOnSelectorXPath;
	private String bigTree2BigTree1ChildFolderLocator;
	private String myTestBigTreeChildFolderLocator;
	private String anotherTestBigTreeChildFolderLocator;
	private String styleLocator;
	private String entertainmentLocator;
	private String healthLocator;
	private String technologyLocator;

	private WebElement harnessFolder;
	private WebElement emptyFolder;
	private WebElement bigTree1Folder;
	private WebElement bigTree2Folder;
	private WebElement myTestFolder;
	private WebElement anotherTestFolder;
	private WebElement bigTree2BigTree1ChildFolder;
	
	private String siteDropdownElementXPath;
	private String homeElementXPath;
	private String createFormArticleMainTitleElementXPath;
	private String createFormSaveAndCloseElementId;
	private String historyFirstItemCheckbBox;
	private String historySecondItemCheckbBox;
	private String differencesDialogId;
	private String differencesDialogRemovedMarkXpath;
	private String differencesDialogAddedMarkXpath;
	private String historyInitialCommitRevertButton;
	private String studioLogo;
	private String approveForPublishDialogTitle;
	private String createFormFrameElementCss;
	private String createFormTitleElementXPath;
	private String dashboardMenuOption;

	@BeforeMethod
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

		this.parentFolderName = "tester-" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		this.harnessFolderName = "harness";
		this.emptyFolderName = "empty-folder";
		this.bigTree1FolderName = "big-tree1";
		this.bigTree2FolderName = "big-tree2";
		this.myTestFolderName = "mytest";
		this.anotherTestFolderName = "anothertest";

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

		this.parentFolderLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.parentfolder") + this.parentFolderName + "')]";
		harnessFolderLocator = this.parentFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.harnessFolderName + "')]";
		emptyFolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.emptyFolderName + "')]";
		bigTree1FolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.bigTree1FolderName + "')]";
		bigTree2FolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.bigTree2FolderName + "')]";
		mytestFolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.myTestFolderName + "')]";
		anotherTestFolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.anotherTestFolderName + "')]";
		parentFolderDivOnTreeSelectorLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.parentfolderdivontreeselector");
		styleLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.stylecontentpage");
		entertainmentLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.entertaimentcontentpage");
		healthLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.healthcontentpage");
		technologyLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.technologycontentpage");
		siteDropdownElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		homeElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.home");
		createFormFrameElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormArticleMainTitleElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformMainTitle");
		createFormTitleElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformtitle");
		createFormSaveAndCloseElementId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		historyFirstItemCheckbBox = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.historydialog.firstitemcheckbox");
		historySecondItemCheckbBox = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.historydialog.seconditemcheckbox");
		differencesDialogId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.differencedialogid");
		differencesDialogRemovedMarkXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.differencedialog_removedmark");
		differencesDialogAddedMarkXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.differencedialog_addedmark");
		historyInitialCommitRevertButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.historydialog.initialcommittrevertbutton");
		studioLogo = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		approveForPublishDialogTitle = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.approveforpublishdialogtitle");
		dashboardMenuOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.dashboard_menu_option");
	}

	@AfterMethod
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createFolderOnAPresentFolder(String folderName, WebElement Parent) {
		// Right click and click on New Folder option
		dashboardPage.rightClickNewFolderOnAPresentFolder(Parent);
		// Set the name of the folder
		dashboardPage.setFolderName(folderName);
		// Create folder button
		dashboardPage.clickCreateButton();
	}

	public void createFolderOnHome(String folderName) {
		// right click to see the the menu
		dashboardPage.rightClickToFolderOnHome();
		// Set the name of the folder
		dashboardPage.setFolderName(folderName);
		// Create folder button
		dashboardPage.clickCreateButton();
	}

	public void loginAndGoToSiteContentPagesStructure() {
		// login to application
		loginPage.loginToCrafter(userName, password);
		// go to preview page
		homePage.goToPreviewPage();
		if (this.driverManager.isElementPresentByXpath(siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");
	}

	public void prepareTestArea() {
		// Create the parent folder on Home Step1 of Test Case
		this.createFolderOnHome(parentFolderName);

		// Checking if parent folder is present
		Assert.assertTrue(driverManager.isElementPresentByXpath(parentFolderLocator));
		WebElement parentFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				parentFolderLocator);

		// creating a new folder on a given parentFolder
		this.driverManager.isElementPresentAndClickableByXpath(parentFolderLocator);
		this.createFolderOnAPresentFolder(harnessFolderName, parentFolder);

		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", harnessFolderLocator);
		this.driverManager.isElementPresentAndClickableByXpath(harnessFolderLocator);
		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(emptyFolderName, harnessFolder);

		emptyFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", emptyFolderLocator);
		this.driverManager.isElementPresentAndClickableByXpath(harnessFolderLocator);

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(bigTree1FolderName, harnessFolder);

		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", bigTree1FolderLocator);
		this.driverManager.isElementPresentAndClickableByXpath(harnessFolderLocator);

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(bigTree2FolderName, harnessFolder);
		this.driverManager.isElementPresentByXpath(homeElementXPath);

		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", bigTree2FolderLocator);
		this.driverManager.isElementPresentAndClickableByXpath(bigTree2FolderLocator);

		this.driverManager.isElementPresentAndClickableByXpath(styleLocator);
		WebElement styleCategoryLandingStyle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				styleLocator);

		dashboardPage.rightClickCopyContentPage(styleCategoryLandingStyle);

		this.driverManager.isElementPresentAndClickableByXpath(bigTree1FolderLocator);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", bigTree1FolderLocator);
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		WebElement entertainmentCategoryLandingStyle = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", entertainmentLocator);

		dashboardPage.rightClickCopyContentPage(entertainmentCategoryLandingStyle);

		this.driverManager.isElementPresentAndClickableByXpath(bigTree1FolderLocator);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				bigTree1FolderLocator);
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		WebElement healthCategoryLandingStyle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				healthLocator);

		dashboardPage.rightClickCopyContentPage(healthCategoryLandingStyle);

		this.driverManager.isElementPresentAndClickableByXpath(bigTree1FolderLocator);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				bigTree1FolderLocator);
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		WebElement technologyCategoryLandingStyle = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", technologyLocator);

		this.driverManager.isElementPresentAndClickableByXpath(bigTree1FolderLocator);
		dashboardPage.rightClickCopyContentPage(technologyCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				bigTree1FolderLocator);
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

	}

	public void createNewPageArticleContent() {

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", createFormFrameElementCss));

		driverManager.isElementPresentBycssSelector(createFormFrameElementCss);

		// creating random values for URL field and InternalName field
		String randomURL = "newPageURL" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String randomInternalName = "newPageInternalName" + RandomStringUtils.randomAlphabetic(5).toLowerCase();

		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewPageArticleContent(randomURL, randomInternalName, "newPageArticlesTitle");

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormArticleMainTitleElementXPath)
				.sendKeys("MainTitle");

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createFormSaveAndCloseElementId).click();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.isElementPresentAndClickableByXpath(homeElementXPath);
	}

	public void createPageCategoryLandingPage(WebElement folderWebElement) {
		// right clicking and clikc on create New Content option
		dashboardPage.rightClickCreatePageOnAPresentFolder(folderWebElement);
		// selecting Page Category Landing Page
		dashboardPage.selectPageArticleContentType();
		// click on the Ok button to confirm the select content type above
		dashboardPage.clickOKButton();
		// creating new Page Article into the empty folder
		driverManager.getDriver().switchTo().defaultContent();
		this.createNewPageArticleContent();
	}

	public void editSelectedContent() {

		// switch to from
		dashboardPage.switchToAFormByCssSelector(createFormFrameElementCss);

		// Typing new text on title text field
		WebElement titleElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				createFormTitleElementXPath);

		// clear the input totally
		titleElement.clear();
		// set new value for title
		titleElement.sendKeys(RandomStringUtils.randomAlphabetic(5).toLowerCase());

		// Save and close button.
		dashboardPage.clickSaveClose();

		this.driverManager.isElementPresentByXpath(homeElementXPath);

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void compareTwoVersionsOfAContentPage() {

		// Switch to the iframe
	    driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();

		this.driverManager.isElementPresentAndClickableByXpath(historyFirstItemCheckbBox);
		// Checking the first row version
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", historyFirstItemCheckbBox)
				.click();

		// Checking the second row version
		this.driverManager.isElementPresentAndClickableByXpath(historySecondItemCheckbBox);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", historySecondItemCheckbBox)
				.click();

		// click on Compare button
		dashboardPage.clickCompareButton();

		// switching to the compare frame
		driverManager.getDriver().switchTo().frame(differencesDialogId);
		this.driverManager.isElementPresentAndClickableByName(differencesDialogId);

		// checkin if is present the removed-red-highlight text
		Assert.assertTrue(driverManager.isElementPresentByXpath(differencesDialogRemovedMarkXpath));

		// checkin if is present the added-green-highlight text
		Assert.assertTrue(driverManager.isElementPresentByXpath(differencesDialogAddedMarkXpath));

		// click on close button
		dashboardPage.clickCloseButton();

	}

	public void revertLastVersionChanges() {

		// Switch to the iframe
		// driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();

		// Clickin the revert changes option for the initial version
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", historyInitialCommitRevertButton)
				.click();

		// Comparing first two versions of the content
		compareTwoVersionsOfAContentPage();
		// Click on close button
		dashboardPage.clickHistoryCloseButton();

		this.driverManager.isElementPresentByXpath(homeElementXPath);

		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void confirmPublishAction() {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		this.driverManager.isElementPresentByXpath(approveForPublishDialogTitle);
		// Click on Publish button
		dashboardPage.clickApproveAndPublishSubmitButton();

		// switch to default content
		this.driverManager.isElementPresentByXpath(homeElementXPath);

		driverManager.getDriver().switchTo().defaultContent();

	}

	public void publishAllPagesOnAFolder(String folderLocator) {
		// getting the entire list of content pages on a folder
		driverManager.elementHasChildsByXPath(folderLocator + "/../../../../../div/div/table/tbody/tr/td/span");
		this.driverManager.isElementPresentAndClickableByXpath(folderLocator);
		
		// Switch to the form
		driverManager.getDriver().navigate().refresh();
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", dashboardMenuOption).click();
		this.driverManager.scrollDown();
		this.driverManager.isElementPresentAndClickableByXpath(
				folderLocator + "/../../../../../div/div[1]/table/tbody/tr/td/span");
		WebElement firstChild = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				folderLocator + "/../../../../../div/div[1]/table/tbody/tr/td/span");

		dashboardPage.rightClickOnAContentPageByJavascript(firstChild);
		// selecting the Publish option
		dashboardPage.clickOnPublishOption();
		// moving to the publish dialog, clicking on Submit and confirm action
		this.confirmPublishAction();
		// refreshing
		this.driverManager.getDriver().navigate().refresh();
		this.driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", dashboardMenuOption).click();
		this.driverManager.scrollDown();
		this.driverManager.isElementPresentAndClickableByXpath(
				folderLocator + "/../../../../../div/div[2]/table/tbody/tr/td/span");
		WebElement secondChild = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				folderLocator + "/../../../../../div/div[2]/table/tbody/tr/td/span");

		dashboardPage.rightClickOnAContentPageByJavascript(secondChild);
		// selecting the Publish option
		dashboardPage.clickOnPublishOption();
		// moving to the publish dialog, clicking on Submit and confirm action
		this.confirmPublishAction();
		// refreshing
		this.driverManager.getDriver().navigate().refresh();
		this.driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", dashboardMenuOption).click();
		this.driverManager.scrollDown();
		this.driverManager.isElementPresentAndClickableByXpath(
				folderLocator + "/../../../../../div/div[3]/table/tbody/tr/td/span");
		WebElement thirdChild = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				folderLocator + "/../../../../../div/div[3]/table/tbody/tr/td/span");
		dashboardPage.rightClickOnAContentPageByJavascript(thirdChild);
		// selecting the Publish option
		dashboardPage.clickOnPublishOption();
		// moving to the publish dialog, clicking on Submit and confirm action
		this.confirmPublishAction();
		// refreshing
		this.driverManager.getDriver().navigate().refresh();
		this.driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", dashboardMenuOption).click();
		this.driverManager.scrollDown();
		this.driverManager.isElementPresentAndClickableByXpath(
				folderLocator + "/../../../../../div/div[4]/table/tbody/tr/td/span");
		WebElement fourthChild = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				folderLocator + "/../../../../../div/div[4]/table/tbody/tr/td/span");
		dashboardPage.rightClickOnAContentPageByJavascript(fourthChild);
		// selecting the Publish option
		dashboardPage.clickOnPublishOption();
		// moving to the publish dialog, clicking on Submit and confirm action
		this.confirmPublishAction();
		// refreshing
		this.driverManager.getDriver().navigate().refresh();
		this.driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", dashboardMenuOption).click();
		this.driverManager.scrollDown();
		this.driverManager.isElementPresentAndClickableByXpath(
				folderLocator + "/../../../../../div/div[5]/table/tbody/tr/td/span");
		WebElement fifthChild = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				folderLocator + "/../../../../../div/div[5]/table/tbody/tr/td/span");

		dashboardPage.rightClickOnAContentPageByJavascript(fifthChild);
		// selecting the Publish option
		dashboardPage.clickOnPublishOption();
		// moving to the publish dialog, clicking on Submit and confirm action
		this.confirmPublishAction();
		// refreshing
		this.driverManager.getDriver().navigate().refresh();
		this.driverManager.getDriver().navigate().refresh();

	}

	public void confirmDeleteAction() {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// Click on delete button
		dashboardPage.clickDeleteDeleteSubmitButton();
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void createMultipleContentPagesOnFolder() {

		// creating multiple content pages
		for (int count = 0; count < 1; count++) {
			// reload page
			driverManager.getDriver().navigate().refresh();
			bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					bigTree1FolderLocator);
			this.createPageCategoryLandingPage(bigTree1Folder);
		}
	}

	public void step1() {
		emptyFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", emptyFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(emptyFolderLocator));

		// Step 1
		this.createPageCategoryLandingPage(emptyFolder);

		// creating multiple content pages on bigtree1
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", bigTree1FolderLocator);
		this.createMultipleContentPagesOnFolder();
	}

	public void step2() {
		// Step2 a)
		this.driverManager.isElementPresentAndClickableByXpath(bigTree1FolderLocator);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				bigTree1FolderLocator);
		
		this.driverManager.isElementPresentAndClickableByXpath(bigTree1FolderLocator);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", bigTree1FolderLocator)
				.click();
		dashboardPage.rightClickCopyFolder(bigTree1Folder);

		// Step2 b)
		bigTree1FolderDivOnSelectorXPath = this.parentFolderDivOnTreeSelectorLocator + "/site/website/"
				+ parentFolderName + "/" + harnessFolderName + "/" + bigTree1FolderName + "']";
		dashboardPage.selectAllTreeOnSelector(bigTree1FolderDivOnSelectorXPath);

		dashboardPage.clickCopyButtonOnTreeSelector();

		// Step2 c)
		this.driverManager.isElementPresentAndClickableByXpath(bigTree2FolderLocator);
		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				bigTree2FolderLocator);
		dashboardPage.rightClickPasteOnAFolder(bigTree2Folder);

		bigTree2BigTree1ChildFolderLocator = bigTree2FolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step3() {
		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", harnessFolderLocator);
		this.createFolderOnAPresentFolder(myTestFolderName, harnessFolder);

	}

	public void step4() {
		// Step4
		this.driverManager.isElementPresentAndClickableByXpath(bigTree1FolderLocator);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				bigTree1FolderLocator);
		dashboardPage.rightClickCopyFolder(bigTree1Folder);

		dashboardPage.selectAllTreeOnSelector(bigTree1FolderDivOnSelectorXPath);
		dashboardPage.clickCopyButtonOnTreeSelector();

		this.driverManager.isElementPresentAndClickableByXpath(mytestFolderLocator);
		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", mytestFolderLocator);
		dashboardPage.rightClickPasteOnAFolder(myTestFolder);

		myTestBigTreeChildFolderLocator = mytestFolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step5() {
		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", harnessFolderLocator);
		this.driverManager.isElementPresentAndClickableByXpath(harnessFolderLocator);
		this.createFolderOnAPresentFolder(anotherTestFolderName, harnessFolder);
		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				anotherTestFolderLocator);

	}

	public void step6() {
		// Step6

		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", mytestFolderLocator);

		//dashboardPage.expandParentFolder(myTestFolder);
		dashboardPage.expandParentFolder(myTestFolder);

		this.driverManager.isElementPresentAndClickableByXpath(myTestBigTreeChildFolderLocator);
		WebElement myTestBigTreeChildFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				myTestBigTreeChildFolderLocator);

		dashboardPage.rightClickCutAFolder(myTestBigTreeChildFolder);

		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				anotherTestFolderLocator);

		dashboardPage.rightClickPasteOnAFolder(anotherTestFolder);

		anotherTestBigTreeChildFolderLocator = anotherTestFolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step7() {
		// Step7 a)
		this.driverManager.isElementPresentByXpath(homeElementXPath);

		dashboardPage.clicOnHomeTree();

		dashboardPage.clickOnContextualNavigationEditOption();

		// Step7 b)
		this.editSelectedContent();

	}

	public void step8() {
		// Step8
		this.driverManager.isElementPresentByXpath(homeElementXPath);

		dashboardPage.clicOnHomeTree();

		dashboardPage.clickOnContextualNavigationHistoryOption();
	}

	public void step9() {
		// Step9
		this.compareTwoVersionsOfAContentPage();
	}

	public void step10() {
		// Step10
		this.revertLastVersionChanges();
	}

	public void step11() {
		// Step11

		this.driverManager.isElementPresentAndClickableByXpath(anotherTestFolderLocator);
		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				anotherTestFolderLocator);
		dashboardPage.expandParentFolder(anotherTestFolder);

		this.driverManager.isElementPresentAndClickableByXpath(anotherTestBigTreeChildFolderLocator);
		WebElement anotherTestBigTreeChildFolder = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", anotherTestBigTreeChildFolderLocator);
		dashboardPage.expandParentFolder(anotherTestBigTreeChildFolder);

		this.driverManager.isElementPresentAndClickableByXpath(anotherTestBigTreeChildFolderLocator);
		this.driverManager.isElementPresentAndClickableByXpath(
				anotherTestBigTreeChildFolderLocator + "/../../../../../div/div[5]/table/tbody/tr/td/span");
		this.publishAllPagesOnAFolder(anotherTestBigTreeChildFolderLocator);

		this.driverManager.isElementPresentAndClickableByXpath(bigTree2FolderLocator);
		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				bigTree2FolderLocator);
		dashboardPage.expandParentFolder(bigTree2Folder);

		this.driverManager.isElementPresentAndClickableByXpath(bigTree2BigTree1ChildFolderLocator);
		bigTree2BigTree1ChildFolder = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", bigTree2BigTree1ChildFolderLocator);
		dashboardPage.expandParentFolder(bigTree2BigTree1ChildFolder);

		this.driverManager.isElementPresentAndClickableByXpath(bigTree2BigTree1ChildFolderLocator);
		this.driverManager.isElementPresentAndClickableByXpath(
				bigTree2BigTree1ChildFolderLocator + "/../../../../../div/div[5]/table/tbody/tr/td/span");
		this.publishAllPagesOnAFolder(bigTree2BigTree1ChildFolderLocator);

		this.driverManager.isElementPresentByXpath(homeElementXPath);
	}

	public void step12() {
		// Step12
		this.driverManager.isElementPresentAndClickableByXpath(mytestFolderLocator);
		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", mytestFolderLocator);
		dashboardPage.rightClickDeleteAFolder(myTestFolder);
		this.confirmDeleteAction();

		this.driverManager.isElementPresentAndClickableByXpath(anotherTestFolderLocator);
		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				anotherTestFolderLocator);
		dashboardPage.rightClickDeleteAFolder(anotherTestFolder);
		this.confirmDeleteAction();

		this.driverManager.isElementPresentAndClickableByXpath(bigTree2FolderLocator);
		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", bigTree2FolderLocator);

		this.driverManager.isElementPresentAndClickableByXpath(bigTree2BigTree1ChildFolderLocator);
		bigTree2BigTree1ChildFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				bigTree2BigTree1ChildFolderLocator);
		dashboardPage.rightClickDeleteAFolder(bigTree2BigTree1ChildFolder);
		this.confirmDeleteAction();
	}

	public void crafter3LoadTest() {
		// login and go to dashboard page, later open the content site (site
		// dropdown panel)
		this.loginAndGoToSiteContentPagesStructure();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// create the folders structure according with script
		this.prepareTestArea();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// Step1
		this.step1();

		driverManager.getDriver().navigate().refresh();
		
		// Step2
		this.step2();

		// Step3
		this.step3();
		
		driverManager.getDriver().navigate().refresh();
		// Step4
		this.step4();

		// Step5
		this.step5();
		
		this.driverManager.getDriver().navigate().refresh();
		// Step6
		this.step6();

		// go to dashboard
		this.driverManager.getDriver().navigate().refresh();
		this.driverManager.isElementPresentAndClickableById(studioLogo);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", studioLogo).click();

		// Step7
		this.step7();

		// go to dashboard
		this.driverManager.getDriver().navigate().refresh();
		this.driverManager.isElementPresentAndClickableById(studioLogo);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", studioLogo).click();

		// Step8
		this.step8();

		// Step9
		this.step9();

		// Step10
		this.step10();

		// Step11
		this.step11();

		// Step12
		this.step12();
	}

	@Test(priority = 0, sequential = true)
	public void crafter3LoadTestTestUser1() {
		this.crafter3LoadTest();
	}

}
