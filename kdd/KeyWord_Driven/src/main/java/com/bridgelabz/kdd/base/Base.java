package com.bridgelabz.kdd.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public static WebDriver driver;
	public static Properties property;
	
	
	public static WebDriver openBrowser(String browsername) {
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/admin1/Desktop/SeleniumDriver/chromedriver_linux64/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			return driver;
		}
		return driver;		
	}
	
	public static Properties init_property() throws IOException {
		property = new Properties();
		
			FileInputStream fis = new FileInputStream("/home/admin1/Desktop/JavaAdvanced/KeyWordDriven/"																	
												+"src/main/java/com/bridgelabz/kdd/repository/config.properties");
			property.load(fis);	
			return property;
			
		
	}
	
	
	
}
