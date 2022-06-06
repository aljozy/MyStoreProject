package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{
	IndexPage indexPage = null;
	LoginPage loginPage = null;
	HomePage homePage = null;
	@Parameters("browser")
@BeforeMethod(groups = {"smoke","sanity","sanity"})
	
public void setup(String browser) {
	launchApp(browser);
}
	@AfterClass(groups = {"smoke","sanity","sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "creds", dataProviderClass = DataProviders.class, groups = {"smoke", "sanity"})
	
	//dataprovider reads 2 values so we provide it as params
	public void loginTest(String usrname,String pswd) throws Throwable {
		Log.startTestCase("login test");
		
		indexPage = new IndexPage(getDriver());
		//we can store in login page since it returns the object of login page
		loginPage = new LoginPage();
		loginPage =	indexPage.clickOnSignIn();
		
		Log.info("user is going to signin ");
//		homePage=loginPage.loginIn(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.loginIn(usrname,pswd);

		Log.info("user is entering the credentials");
		String actualURL =homePage.getCurrentURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		
		Log.info("verify user is successfully login");
		Assert.assertEquals(actualURL,expectedURL);
		
		Log.info("user login successfully");
		
		Log.endTestCase("login test");
	}
	
	

}
