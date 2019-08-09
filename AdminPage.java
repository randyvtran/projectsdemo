package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class AdminPage extends TestBase{
	
	
	@FindBy(xpath="//a[text()='Welcome Admin']") WebElement welcome;
	
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']") 
	WebElement adminTabLink;
	
	@FindBy(xpath="//a[@id='menu_admin_Organization']") 
	WebElement organizationDropDownMenu;
	
	@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']")
	WebElement userInSystem;

	@FindBy (xpath="//input[@id='btnAdd']")
	WebElement addBtn;
	
	@FindBy (xpath="//input[@id='systemUser_employeeName_empName']")
	WebElement nameEntry;
	
	@FindBy (xpath="//a[@id='menu_admin_viewLocations']")
	WebElement organizationLocation;
	
	@FindBy (xpath="//input[@id='location_name']")
	WebElement locationName;
	
	@FindBy (xpath="//input[@id='systemUser_confirmPassword']")
	WebElement confirmpasswdEntry;
	
	@FindBy (xpath="//input[@id='btnSearch']")
	WebElement searchBtn;
	
	@FindBy (xpath="//select[@id='location_country']")
	WebElement dropdownCountry;
	
	
	@FindBy (xpath="//input[@id='btnSave']")
	WebElement saveBtn;
	
	@FindBy (xpath="//a[@id='menu_admin_Job']")
	WebElement jobTab;
	
	@FindBy (xpath="//a[@id='menu_admin_viewJobTitleList']")
	WebElement jobTitles;
	
	@FindBy (xpath="//input[@id='jobTitle_jobTitle']")
	WebElement jobTitleInputField;
	
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AdminPage clickOnAdminLink() {	// use AdminPage because it's a type "object"
		adminTabLink.click();
		
		return new AdminPage();		// return AdminPage "objects" -- every objects in this Admin page
	}

	
	public void locationSearch() {
		
		adminTabLink.click();
		Actions action = new Actions(driver);	//start hover process
		action.moveToElement(organizationDropDownMenu).build().perform();	//hover over User Management 
		organizationLocation.click();
		locationName.sendKeys("Texas");
		searchBtn.click();
	
	}
	
	 public void addNewOrganizationLocation() throws InterruptedException {
		adminTabLink.click();
		Actions action = new Actions(driver);
		action.moveToElement(organizationDropDownMenu).build().perform();
		Thread.sleep(4000);
		organizationLocation.click();
		addBtn.click();
		
		/* nameEntry.sendKeys(fname, lname); */
		locationName.sendKeys("Bakerfield");
		
		Select country_dd = new Select(dropdownCountry);
		country_dd.selectByValue("US");
		
		saveBtn.click();
	}
	
	 
	 
	 public void addNewJobTitle(String title) {
		 
		 adminTabLink.click();
		 Actions action = new Actions(driver);
		 action.moveToElement(jobTab);
		 
		 jobTitles.click();
		 addBtn.click();
		 
		 jobTitleInputField.sendKeys(title);
		 saveBtn.click();
	 }
	
	
	
	
	
	
}
