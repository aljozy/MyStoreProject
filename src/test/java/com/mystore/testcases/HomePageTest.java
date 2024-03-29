package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest  extends BaseClass {
	HomePage homePage = null;
	IndexPage indexPage =null;
	LoginPage loginPage = null;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"smoke","sanity","sanity"})
	
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"smoke","sanity","sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(priority = 1, groups = "smoke")
	public void wishListTest() throws Throwable {
		Log.startTestCase("wishlist testcase");
		
		indexPage = new IndexPage(getDriver());
		loginPage=indexPage.clickOnSignIn();
		
		Log.info("user click on signin button");
		
		homePage=loginPage.loginIn(prop.getProperty("username"), prop.getProperty("password"));
		
		Log.info("user entered valid credentials");
		
		
		boolean result = homePage.validateMyWishList();
		
		Log.info("validating wishlist");
		Assert.assertTrue(result);
		
		
		
		Log.endTestCase("wishlist testcase");
		
		Log.info("wishlist successfully validated");
		
		}
	
		@Test(priority = 2, groups = "smoke")
		public void orderHistoryDetailsTest() throws Throwable {
		indexPage = new IndexPage(getDriver());
		Log.startTestCase("order history testcase");	
			
		loginPage =indexPage.clickOnSignIn();
		Log.info("user click on sigin button");
		
		homePage=loginPage.loginIn(prop.getProperty("username"),prop.getProperty("password"));	
		Log.info("user entered the valid credentials");
		
		boolean result = homePage.validateOrderHistory();
		
		Log.info("validating order history");
			
		Assert.assertTrue(result);	
		
		Log.info("order history validated successfully");
			
		Log.endTestCase("order history testcase");	
			
			
			
			
			
			
			
		
		
		
		
		
	}
	
	
}
