package com.crm.qa.testcases;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DirectoryPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DirectoryPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DirectoryPage dirPage;

	
	public DirectoryPageTest() {
		
		super();	//user of super at very 1st line of constructor and make use of Methods inside TestBase
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		//testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dirPage = new DirectoryPage();
	
	}
	
	
	
	
	@Test()
	public void clickDirTabLink() throws InterruptedException {
		dirPage.clickOnDirectoryTab();
	/*public void searchForEmployeeName() {
		dirPage.verifyNameSearch();*/
		
	}
	
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	
}
