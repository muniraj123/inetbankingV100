package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.ReadConfig;

public class LoginPage_Objects {

	WebDriver local_driver;
	
	public LoginPage_Objects(WebDriver rdriver)
	{
		local_driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(name="uid") WebElement txtUserName;
	
	@FindBy(name="password") WebElement txtPassword;
	
	@FindBy(name="btnLogin") WebElement btnLogin;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]") WebElement lnkLogout;

	
	public void setUserName(String uname){
		txtUserName.sendKeys(uname);
	}	
	public void serPassword(String pass){
		txtPassword.sendKeys(pass);
	}	
	public void clickLogin(){
		btnLogin.click();
	}	
	public void clickLogout() {
		lnkLogout.click();
	}	
	
}













