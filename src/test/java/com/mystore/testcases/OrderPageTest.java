package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass
{
	
	
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	LoginPage loginPage;
	HomePage homePage;
	
	OrderPage orderPage;
	
	@BeforeMethod
	
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	
	@Test
	public void verifyTotalPrice() throws Throwable {
		
		Log.startTestCase("order  test");
		
		indexPage = new IndexPage(getDriver());
		
		Log.info("user is searching the product");
		
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		
		Log.info("product found and clicked by the user");
		
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		
		addToCartPage.clickOnAddToCart();
		
		Log.info("user clicked on add to cart");
		
		orderPage=addToCartPage.clickOnCheckOut();
		Log.info("user is checking out the product");
		
		Double unitPrice =orderPage.getUnitPrice();
		Double totalPrice =orderPage.getTotalPrice();
		
		Double totalExpectedPrice = (unitPrice *2)+2;
		
		Log.info("validating price");
		
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		
		Log.info("price successfully validated");
		
		Log.startTestCase("order test");
		
	}
	
	
	
	
}
