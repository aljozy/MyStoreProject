package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	//declartion

	@FindBy(className =  "login")
	WebElement signInBtn;
	
	
	@FindBy(css = "img.logo")
	WebElement myStoreLogo;
	
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	
	
	
	//construtor calling
	
	public IndexPage() {
		//here this means it will initialized all the objects
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage ClickOnSignIn() throws Throwable {
		Action.click(driver, signInBtn);
		//linking the page as we click on sign in it will return the object of login page
		return new LoginPage();
		
	}
	
	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(driver, myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		
		String title =driver.getTitle();
		
		return title;
	}
	
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		
		Action.type(searchBox, productName);
		Action.click(driver, searchButton);
		//coz it will return the page with search results
		return new SearchResultPage();
		
	}
	
	
	 
	
}
