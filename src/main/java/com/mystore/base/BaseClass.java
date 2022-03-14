package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	
	@BeforeTest
	public void loadConfig() {
		
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
	 
	public static void launchApp() {
		//browser get from properties files
		prop.getProperty("browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("driver : "+driver);
		driver.get(prop.getProperty("url"));
		
		//String browserName =
		
//		
//		if(browserName.contains("chrome")) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			
//		} else if (browserName.contains("firefox")) {
//			
//			WebDriverManager.firefoxdriver().setup();
//			
//			driver = new FirefoxDriver();
//
//		}
//		else if (browserName.contains("edge")) {
//			WebDriverManager.edgedriver().setup();
//			
//			driver = new  EdgeDriver();
//		} else {
//			System.out.println("please select the correct browser");
//		}
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//Action.implicitWait(driver, 10);
		//Action.pageLoadTimeOut(driver, 30);
		//loaded from properties files
		
	}
	
	

}
