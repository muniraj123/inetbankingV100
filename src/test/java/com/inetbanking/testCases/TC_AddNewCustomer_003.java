package com.inetbanking.testCases;


import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbanking.pageObjects.AddCustomerPage_Objects;
import com.inetbanking.pageObjects.LoginPage_Objects;

public class TC_AddNewCustomer_003 extends BaseClass {
	
	@Test
	public void AddNewCustomer() throws InterruptedException {
		
		LoginPage_Objects lp = new LoginPage_Objects(driver);
		AddCustomerPage_Objects ac = new AddCustomerPage_Objects(driver);
		
		lp.setUserName(Username);
		lp.serPassword(pass);
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("User is logged in successfully and moved to home page");
		}else {
			Assert.assertTrue(false);
			logger.info("Login failed");
		}
			
		ac.getNewCustomerLink();
		ac.getTxt_CustName("Test");
		ac.getDOB("10", "10", "2010");
		ac.getAddress("Bangalore Address");
		ac.getCity("Bangalore");
		ac.getState("Karnataka");
		ac.getPIN("101010");
		ac.getTelephone("1234567890");
		String email = randomstring() + "@gmail.com";
		ac.getEmail(email);		
		ac.getpassword("a123345");
		ac.getSubmitbutton();
		
		Thread.sleep(5000);
		
		//p[@class='heading3'][contains(text(),'Customer Registered Successfully!!!')]
		Boolean SuccessMsg = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (SuccessMsg==true) {
			Assert.assertTrue(true);
			logger.info("New Customer is created successfully ");
		}else {
			Assert.assertTrue(false);
			logger.warn("customer is not created");
		}		
	}
	
}
