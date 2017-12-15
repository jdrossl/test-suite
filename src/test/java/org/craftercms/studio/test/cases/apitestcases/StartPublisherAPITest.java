package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.PublishAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by gustavo ortiz
 */

public class StartPublisherAPITest {

	private SiteManagementAPI siteManagementAPI;
	private SecurityAPI securityAPI;
	private PublishAPI publishAPI;

	public StartPublisherAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	securityAPI = new SecurityAPI(api, apiConnectionManager);
    	publishAPI = new PublishAPI(api, apiConnectionManager);
    	siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteManagementAPI.getSiteId());
	}

	@Test(priority = 1)
	public void testStartPublisher() {
		publishAPI.testStartPublisher(siteManagementAPI.getSiteId());
	}

	@Test(priority = 2)
	public void testStartPublisherInvalidParameters() {
		publishAPI.testStartPublisherInvalidParameters(siteManagementAPI.getSiteId());
	}

	@Test(priority = 3)
	public void testStartPublisherSiteNotFound() {
		publishAPI.testStartPublisherSiteNotFound(siteManagementAPI.getSiteId());
	}
	
	@AfterTest
	public void afterTest(){
		siteManagementAPI.testDeleteSite(siteManagementAPI.getSiteId());
		securityAPI.logOutFromStudioUsingAPICall();
	}

}
