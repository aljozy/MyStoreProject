package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	@FindBy(xpath = "//span[text() ='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath ="//span[text() ='Order history and details']")
	WebElement orderHistory;
	

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentURL() {
		String homePageURL= driver.getCurrentUrl();
		return homePageURL;
	}
	
	public boolean validateMyWishList() throws Throwable {
		
		return Action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		
		return Action.isDisplayed(driver, orderHistory);
	}
	
	
	
	
	
	

}
