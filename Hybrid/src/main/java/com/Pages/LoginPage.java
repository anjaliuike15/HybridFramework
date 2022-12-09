package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;

public class LoginPage extends BaseClass {
	
	WebDriver driver=null;
	@FindBy (id="email")
	WebElement username;
	
	@FindBy(id="password")
    WebElement pass;
	
	@FindBy(xpath="//button")
	WebElement LoginBut;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginToApplication(String name, String id){
		username.sendKeys(name);
		pass.sendKeys(id);
		LoginBut.click();
	}	
}
