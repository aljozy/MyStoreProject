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
		driver.quit();
	}
	
	@Test
	public void endToEndTest() throws Throwable {
		
		
		indexPage = new IndexPage(driver);
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		
		addToCartPage.clickOnAddToCart();
		
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage =loginPage.loginInAfterOrderPage(prop.getProperty("username"), prop.getProperty("password"));
		
		shippingPage =addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummeryPage=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummeryPage.clickOnConfirmOrderBtn();
		
		String ActualMsg  =orderConfirmationPage.validateConfimMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(ActualMsg,expectedMsg);
	
		
	}
	
	
	
}
