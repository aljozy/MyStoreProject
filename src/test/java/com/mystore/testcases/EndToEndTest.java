package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass {

	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	LoginPage loginPage;
	HomePage homePage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummeryPage;
	OrderConfirmationPage orderConfirmationPage;
	

	@BeforeMethod
	
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void endToEndTest() throws Throwable {
		
		Log.startTestCase("end to end test case");
		
		indexPage = new IndexPage(getDriver());
		
		Log.info("user is searching the product");
		
		searchResultPage = indexPage.searchProduct("t-shirt");
		
		addToCartPage = searchResultPage.clickOnProduct();
		
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		
		addToCartPage.clickOnAddToCart();
		Log.info("user clicked on add to cart button");
		
		orderPage=addToCartPage.clickOnCheckOut();
		
		loginPage=orderPage.clickOnCheckOut();
		
		Log.info("user click on checkout button and redirected to login page ");
		
		addressPage =loginPage.loginInAfterOrderPage(prop.getProperty("username"), prop.getProperty("password"));
		
		Log.info("user entered the valid credentials");
		
		
		shippingPage =addressPage.clickOnCheckOut();
		
		Log.info("user click on checkout button");
		
		shippingPage.checkTheTerms();
		Log.info("user accepted the terms");
		
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummeryPage=paymentPage.clickOnPaymentMethod();
		
		Log.info("payment confirmation");
		orderConfirmationPage=orderSummeryPage.clickOnConfirmOrderBtn();
		
		Log.info("order confimation");
		
		String ActualMsg  =orderConfirmationPage.validateConfimMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(ActualMsg,expectedMsg);
		
		Log.info("order successfully placed");
	
		Log.endTestCase("end to end test case");
		
	}
	
	
	
}
