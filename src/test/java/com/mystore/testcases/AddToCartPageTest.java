package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class AddToCartPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod(groups = {"smoke","sanity","regression"})
	
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups = {"smoke","sanity","regression"})
	public void tearDown() {
		getDriver().quit();
	
	}
	
	
	@Test(groups = {"regression","sanity"})
	public void addToCartTest() throws Throwable {
		
		Log.startTestCase("add to cart test");
		
		indexPage = new IndexPage(getDriver());
		
		searchResultPage = indexPage.searchProduct("t-shirt");
		
		Log.info("user is searching the product");
		
		addToCartPage = searchResultPage.clickOnProduct();
		
		Log.info("user clicked on the product");
		
		addToCartPage.enterQuantity("2");
		Log.info("user entered the quantity");
		
		
		addToCartPage.selectSize("M");
		
		Log.info("user selected the size of the product");
		
		addToCartPage.clickOnAddToCart();
		Log.info("user click on add to cart button");
		
		//Thread.sleep(5000);
		boolean result=addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
		
		Log.info("product added to cart successfullyt");
		
		Log.endTestCase("add to cart test");
		
		
	}
	
	
	
	
}