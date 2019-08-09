package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	//create a global loginPage var from LoginPage.java
	LoginPage loginPage;	
	HomePage homePage;
	
	public LoginPageTest() {
		// use super() to call the parent TestBase Constructor, which deal with Properties
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		
		//call initialization() method from TestBase to pick browser
		
	
		initialization();
		loginPage = new LoginPage();
	
	}
	
	//validate tests with Assert 
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void orangeHRMLogoTest(){
		// flag = true or false
		boolean flag = loginPage.validateOrangeImage();
		// test pass if true
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		//once logged-in, loginPage will return object HomePage (see LoginPage.java) and store in homepage var.
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	

}
