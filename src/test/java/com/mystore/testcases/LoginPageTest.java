package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass{
	IndexPage indexPage = null;
	LoginPage loginPage = null;
	HomePage homePage = null;
	
@BeforeMethod
	
	public void setup() {
		launchApp();
	}
	
	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void loginTest() throws Throwable {
		
		indexPage = new IndexPage(getDriver());
		//we can store in login page since it returns the object of login page
		loginPage = new LoginPage();
		loginPage =	indexPage.clickOnSignIn();
		
		homePage=loginPage.loginIn(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL =homePage.getCurrentURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	

}
