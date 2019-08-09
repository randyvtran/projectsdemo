package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

/* the use of TestBase class is to initialize or prepare before tests run*/

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Selenium_training\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		
			prop.load(ip);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void initialization() {
		
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver","C:\\Selenium_training\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Selenium_training\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
		
		
				
		
	}

}
