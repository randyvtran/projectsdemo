package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DirectoryPage extends TestBase{

	@FindBy (xpath="//a[@class='toggle tiptip activated']")
	WebElement SearchDirectory;

	@FindBy (xpath="//a[@id='menu_directory_viewDirectory']")
	WebElement dirTabLink;
	
	@FindBy (xpath="//input[@id='searchDirectory_emp_name_empName']")
	WebElement empNameInput;
	
	@FindBy (xpath="//input[@id='searchBtn']")
	WebElement searchButton;
	
	public DirectoryPage() {
		
		PageFactory.initElements(driver, this);
	}

	
	public boolean verifySearchDirectoryLabel() {
		
		return SearchDirectory.isDisplayed();
	}
	
	public void clickOnDirectoryTab() throws InterruptedException {
		dirTabLink.click();
		
		/*empNameInput.sendKeys("Linda Anderson");
		Thread.sleep(15000);
		searchButton.click(); */
		
		
		/*
		WebElement employeeName = driver.findElement(By.xpath("//input[@id='searchDirectory_emp_name_empName']"));
		employeeName.sendKeys("Linda Anderson");
		Thread.sleep(5000);		*/
	}
	
	/*public boolean verifyNameSearch() {
		
		dirTabLink.click();
		
		SearchDirectory.click();
		WebElement employeeName = driver.findElement(By.xpath("//input[@id='searchDirectory_emp_name_empName']"));
		employeeName.sendKeys("Linda Anderson");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		WebElement empname = driver.findElement(By.xpath("//b[contains(text(),'Linda Anderson')"));
		return empname.isDisplayed();	
	}*/
	
	
}
