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

public class AddToCartPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
	}
	
	
	@Test
	public void addToCartTest() throws Throwable {
		
		indexPage = new IndexPage(driver);
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		
		addToCartPage.clickOnAddToCart();
		//Thread.sleep(5000);
		boolean result=addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
		
		
		
		
	}
	
	
	
	
}