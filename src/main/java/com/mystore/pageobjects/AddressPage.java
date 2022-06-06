package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	@FindBy(name="processAddress")
	WebElement proceedToCheckOut;
	
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public ShippingPage clickOnCheckOut() throws Throwable {
		
		Action.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}
}
