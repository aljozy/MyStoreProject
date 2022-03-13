package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;

	@BeforeMethod
	
	public void setup() {
		launchApp();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void verifyLogo() throws Throwable {
		indexPage = new IndexPage(driver);
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		
		
		
		
	}
	@Test
	
	public void verifyTitle() {
		indexPage = new IndexPage(driver);
	String ActualTitle =	indexPage.getMyStoreTitle();//came from script
	 String expectedTitle = "My Store"; //came from real browser website
	Assert.assertEquals(ActualTitle, expectedTitle);
	}
	
	
	
}
