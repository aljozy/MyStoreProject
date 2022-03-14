package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest  extends HomePage {
	HomePage homePage = null;
	IndexPage indexPage =null;
	LoginPage loginPage = null;
	
	@BeforeMethod
	
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority = 1)
	public void wishListTest() throws Throwable {
		indexPage = new IndexPage(driver);
		loginPage=indexPage.clickOnSignIn();
		
		homePage=loginPage.loginIn(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
		
		}
	
		@Test(priority = 2)
		public void orderHistoryDetailsTest() throws Throwable {
		indexPage = new IndexPage(driver);
			
			
		loginPage =indexPage.clickOnSignIn();
		homePage=loginPage.loginIn(prop.getProperty("username"),prop.getProperty("password"));	
		
		boolean result = homePage.validateOrderHistory();
			
		Assert.assertTrue(result);	
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
	}
	
	
}
