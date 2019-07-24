package com.inetbanking.testCases;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbanking.pageObjects.LoginPage_Objects;

public class TC_Login_001 extends BaseClass {

	@Test
	public void logintest() throws InterruptedException, IOException {
		
		LoginPage_Objects lp = new LoginPage_Objects(driver);		
		
		lp.setUserName(Username);
		logger.info("User name is entered");
		
		lp.serPassword(pass);
		logger.info("Password is entered");
		
		lp.clickLogin();
		logger.info("Login button clicked. ");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{			
			Assert.assertTrue(true);
			logger.info("User is logged in successfully and navigate to Home page");	
		}
		else
		{	
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.warn("user not logged in");
			
		}
		
	}
	
	
	
	
}
