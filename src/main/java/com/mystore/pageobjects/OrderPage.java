package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {

	@FindBy(xpath ="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id ="total_price")
	WebElement totalPrice;
	
	
	@FindBy(xpath="(//a[contains(@title,'Proceed to ')])[2]")
	WebElement proceedToCheckout;
	
	public OrderPage() {
		PageFactory.initElements(driver,this);
	}
	
	public double getUnitPrice() throws Throwable {
		
		String price = unitPrice.getText();
		String unit =price.replaceAll("[^a-zA-Z0-9]", "");
		Double finalUnitPrice =Double.parseDouble(unit);
		return finalUnitPrice/100;
		
	}
	
	public double getTotalPrice() throws Throwable {
		
		String price = totalPrice.getText();
		String unit =price.replaceAll("[^a-zA-Z0-9]", "");
		Double finalTotalPrice =Double.parseDouble(unit);
		return finalTotalPrice/100;
		
	}
	
	public LoginPage clickOnCheckOut() {
	
		Action.click(driver, proceedToCheckout);
		return new LoginPage();
		
	}
	
	

}
