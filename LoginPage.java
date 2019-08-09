package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
		
		//Page Factory - ObjectRepository:
		//Page Factory has 2 annotations @FindBy and @FindAll
		
		@FindBy(id="txtUsername") WebElement username;
		
		@FindBy(id="txtPassword") WebElement password;
		
		@FindBy (id="btnLogin") WebElement login_btn;

		@FindBy (xpath="//img[@src='/webres_5cfea87b4387f2.35910947/themes/default/images/login/logo.png']") WebElement OrangeLogo;


		//create a constructor, remember constructor shares the same name as Class

		// Below is how you initialize your PageFactory by using 
		// PageFactory.initElements() 
		public LoginPage() {
			
			PageFactory.initElements(driver, this);  //"this" means objects of current Class LoginPage and they are initialize with "driver"
			
		}
	
		
		//Actions
		public String validateLoginPageTitle() {
			
			return driver.getTitle();
			
		}
		
		public boolean validateOrangeImage() {
			
			return OrangeLogo.isDisplayed();
		}
	
		
		public HomePage login(String uname, String pwd) {
			
			username.sendKeys(uname);
			password.sendKeys(pwd);
			login_btn.click();
			
			return new HomePage();
		}
		
		
		
		
		
		
		
}