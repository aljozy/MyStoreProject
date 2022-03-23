package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;

	@BeforeMethod(groups = {"smoke","sanity","sanity"})
	
	public void setup() {
		launchApp();
	}
	
	@AfterClass(groups = {"smoke","sanity","sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups = "smoke")
	public void verifyLogo() throws Throwable {
		Log.startTestCase("logo test");
		
		Log.info("validating logo");
		
		indexPage = new IndexPage(getDriver());
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		
		Log.info("logo successfully validated");
		
		Log.endTestCase("logo test");
		
	}
	@Test(groups = "smoke")
	
	public void verifyTitle() {
		
		Log.startTestCase("title test");
		
		indexPage = new IndexPage(getDriver());
		
		Log.info("validating title");
	String ActualTitle =	indexPage.getMyStoreTitle();//came from script
	 String expectedTitle = "My Store"; //came from real browser website
	Assert.assertEquals(ActualTitle, expectedTitle);
	
	Log.info("title successfully validated");
	
	Log.endTestCase("title test");
	
	}
	
	
	
}
