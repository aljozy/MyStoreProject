package com.mystore.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentURL() {
		String homePageURL= driver.getCurrentUrl();
		return homePageURL;
	}
	
	

}
