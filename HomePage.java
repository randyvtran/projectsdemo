package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	
	@FindBy(xpath="//b[contains(text(),'Directory')]") 
	WebElement DirectoryTabLink;

	@FindBy(xpath="//a[text()='Welcome Admin']") 
	WebElement welcome;
	
	@FindBy(xpath="//b[contains(text(),'Admin')]")
	WebElement adminTabLink;

	// Initialize the Page Objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserIsLogin(){
		return welcome.isDisplayed();
	}
	
	
	// go to Directory Page
	public DirectoryPage clickOnDirectoryTabLink() {
		DirectoryTabLink.click();
		
		return new DirectoryPage();
	}
	
	// go to Admin Page
	public AdminPage clickOnAdminPageTabLink() {
		adminTabLink.click();
		return new AdminPage();
	}
	
}


	
