package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	@FindBy(css=".cheque-indent")
	WebElement confirmMessage ;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateConfimMessage () throws Throwable {
		String Msg =confirmMessage.getText();
		return Msg;
		
	}
	
	
}
