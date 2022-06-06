package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	@FindBy(xpath="//a[contains(@title,'wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath="//a[contains(@title,'by check')]")
	WebElement payByCheckMethod;
	
	
	
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	public OrderSummaryPage clickOnPaymentMethod() throws Throwable{
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummaryPage();
	}
	
	
}
