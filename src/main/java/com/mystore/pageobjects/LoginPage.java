package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id ="email")
	WebElement userName;
		
	
	@FindBy(id ="passwd")
	WebElement password;
	
	@FindBy(id ="SubmitLogin")
	WebElement SignInBtn;
	
	@FindBy(id ="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name ="SubmitCreate")
	WebElement createNewAccoutnBtn;
	
	
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage loginIn(String uname, String pswd) throws Throwable {
		
		Action.type(userName,uname);
		Action.type(password,pswd);
		
		Action.click(driver, SignInBtn);
		
		return new HomePage();
		
	}
	
	
	
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail );
		return new AccountCreationPage();
	}
	
	
	//coz we've 2 navigation
public AddressPage loginInAfterOrderPage(String uname, String pswd) throws Throwable {
		
		Action.type(userName,uname);
		Action.type(password,pswd);
		
		Action.click(driver, SignInBtn);
		
		return new AddressPage();
		
	}
	
	
	
	
}
