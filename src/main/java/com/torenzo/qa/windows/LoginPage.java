package com.torenzo.qa.windows;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends com.torenzo.qa.base.TestBase{
	
	//Page Factory - OR:
	@FindBy(id="usernm")
	WebElement username;
	
	@FindBy(id="pwd")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='loginForm']/button")
	WebElement loginBtn;
	

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		//driver.get(prop.getProperty("url1"));
		return new HomePage();
}
}