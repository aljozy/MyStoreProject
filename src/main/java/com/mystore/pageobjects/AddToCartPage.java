package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(css ="input#quantity_wanted")
	WebElement quantity;
	
	@FindBy(css="select#group_1")
	WebElement size;
	
	
	@FindBy(xpath ="button[name='Submit']")
	WebElement addToCartBtn ;
	
	@FindBy(id ="wishlist_button")
	WebElement wishListBtn ;
	
	@FindBy(xpath="//span[@class='cross']/..//h2")
	WebElement addToCartMessage;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;
	
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void enterQuantity(String number) throws Throwable {
		
		Action.type(quantity,number );
	}
	
public void selectSize(String size1) throws Throwable {
		
		Action.selectByVisibleText(size1, size);
	}

public void clickOnAddToCart() throws Throwable {
	
	Action.click(driver, addToCartBtn);
	
	
}


public boolean validateAddToCart( )throws Throwable {
	
	return Action.isDisplayed(driver, addToCartMessage);
	
	
}

public  OrderPage clickOnCheckOut()throws Throwable{
	
	Action.JSClick(driver,proceedToCheckOutBtn );
	return new OrderPage();
	
}



}