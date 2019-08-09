package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.DirectoryPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class AdminPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DirectoryPage dirPage;
	AdminPage adminPage;
	TestUtil utility;
	
	
	
	
	public AdminPageTest() {
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
		adminPage = new AdminPage();
		
	}
	
	
	/*
	@Test(priority=1)
	public void locationSearchTest() {
		
		adminPage.locationSearch();
		
	}
	
	
	@Test(priority=1)
	public void addNewLocation() throws InterruptedException {
		
		/* adminPage.addNewUser(prop.getProperty("employeeFName"), prop.getProperty("employeeFName")); 
		
		adminPage.addNewOrganizationLocation();
	} */
	
	
	/* @Test(priority=2)
	public void addJobTitleTest() {
		
		adminPage.addNewJobTitle();
	} */
	
	
	
	@DataProvider(name="getJobTitle")
	public Object[][] getJobTitle() {
		Object data[][] = TestUtil.getTestData("Title");
		return data;
	}
	
	
	@Test(dataProvider="getJobTitle")
	public void validateCreateNewJobTitle(String jobtitle) {
		adminPage.addNewJobTitle(jobtitle);
		
		
	}
	
	
	
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
