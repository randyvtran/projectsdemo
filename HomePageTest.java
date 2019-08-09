package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DirectoryPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DirectoryPage dirPage;
	
	public HomePageTest() {
		// use super() to call the parent TestBase Constructor, which deal with Properties
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		//call initialization() method from TestBase to pick browser
		
	
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// why we need to use login again ?  Because the test starts with the "url" given in 
		// the TestBase.java, which ask for login.  That's why we need to login.
		// the login called the method login() from LoginPage.java which is type 'HomePage' 
	
		dirPage = new DirectoryPage();
		
	}
	
	// Good Practice : Test Cases should be independent of each other
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle, "OrangeHRM","Home page title not match");
	}
	
	
	@Test(priority=2)
	public void verifyUserName() {
		Assert.assertTrue(homePage.verifyCorrectUserIsLogin());
	}
	
	@Test(priority=3)
	public void verifyDirectoryLinkTest() {
		dirPage = homePage.clickOnDirectoryTabLink();
		
	}
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	

}
