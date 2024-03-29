package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	//declare Thread local driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	
	@BeforeSuite(groups = { "smoke", "sanity", "regression" })
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
					"\\Configuration\\config.properties");
			prop.load(fis);
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		//Get driver from threadLocalMap
		return driver.get();
	}
	
	
	//@Parameters("browser")
	public  void launchApp(String browserName) {
		//browser get from properties files
		//String browserName = prop.getProperty("browser");
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
//		driver.set(new ChromeDriver());
//		System.out.println("driver : "+driver);
//		getDriver().get(prop.getProperty("url"));
		
		//String browserName =
		
//		
	if(browserName.equalsIgnoreCase("chrome")) {

		WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
		
		driver.set(new ChromeDriver());
		}
		else if (browserName.contains("firefox")) {
				WebDriverManager.firefoxdriver().setup();
//			
//			driver = new FirefoxDriver();
				driver.set(new FirefoxDriver());
//
		}
//		else if (browserName.contains("edge")) {
//			WebDriverManager.edgedriver().setup();
//			
//			driver = new  EdgeDriver();
//		} 
	else {
		System.out.println("please select the correct browser");
		}
	getDriver().get(prop.getProperty("url"));
	
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//Action.implicitWait(driver, 10);
		//Action.pageLoadTimeOut(driver, 30);
		//loaded from properties files
		
	}
	
	@AfterSuite
	public void end() {
		
		ExtentManager.endReport();
		
	}

}
