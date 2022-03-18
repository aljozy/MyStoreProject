package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationPageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	IndexPage ip ;
	AccountCreationPage accountCreation;
	@BeforeMethod
	
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	
	@Test
	public void verifyCreateAccountPage() throws Throwable
	{
		Log.startTestCase("verify account creation test");
		
		ip = new IndexPage(getDriver());
		lp =ip.clickOnSignIn();
		
		Log.info("user clicked on signin button");
		accountCreation=lp.createNewAccount("abc@mail.com");
		
		Log.info("user entered email");
		Thread.sleep(3000);
		boolean result =accountCreation.validateAccountCreatePage();
		
		Assert.assertFalse(result);
		
		Log.info("test verified successfully");
		
		Log.endTestCase("verify account creation test");
		
		
		
		
		
		
		
	}
	
	
	
}
