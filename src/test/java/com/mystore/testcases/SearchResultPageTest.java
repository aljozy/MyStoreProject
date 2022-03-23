package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	@BeforeMethod(groups = {"smoke","sanity","sanity"})
	
	public void setup() {
		launchApp();
	}
	
	@AfterMethod(groups = {"smoke","sanity","sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups = "smoke")
	public void productAvialabilityTest() throws Throwable {
		Log.startTestCase("search test");
		
		indexPage = new IndexPage(getDriver());
		
		searchResultPage=indexPage.searchProduct("t-shirt");
		
		Log.info("user is searching the product");
		
		Log.info("validating product availibility ");
		
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		
		Log.info("product availibilty successfully validated");
		
		Log.endTestCase("search test");
	}
	
	
	
}
