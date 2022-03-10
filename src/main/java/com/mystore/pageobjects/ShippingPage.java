package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	@FindBy(id ="cgv")
	WebElement terms;
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable{
		Action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage();
	
	}
	
	public void checkTheTerms() throws Throwable{
		Action.click(driver, terms);
		
	
	}
	
	
	
}
