package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage_Objects {

	WebDriver ldrvier;
	
	public AddCustomerPage_Objects(WebDriver rdriver) {		
		ldrvier =  rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]") WebElement Link_NewCust;	
	@FindBy(how = How.XPATH, using = "//input[@name='name']")  WebElement Txt_CustName;	
	@FindBy(how = How.XPATH, using ="//tbody//tr[5]//td[2]//input[1]")  WebElement Radio_Male;	
	@FindBy(how = How.XPATH, using = "//input[@id='dob']")  WebElement DOB;		
	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")  WebElement Address;	
	@FindBy(xpath="//input[@name='city']") WebElement City;	
	@FindBy(xpath = "//input[@name='state']") WebElement State;	
	@FindBy(xpath = "//input[@name='pinno']") WebElement PIN;	
	@FindBy(xpath = "//input[@name='telephoneno']") WebElement Telephonenumber;	
	@FindBy(xpath = "//input[@name='emailid']") WebElement Email;	
	@FindBy(xpath = "//input[@name='password']") WebElement Password;	
	@FindBy(xpath = "//input[@value='Submit']") WebElement SubmitButton;
	
	public void getNewCustomerLink() {
		Link_NewCust.click();
	}
	public void getTxt_CustName(String CustName) {
		Txt_CustName.sendKeys(CustName);
	}
	public void getRadio_Male() {
		Radio_Male.click();
	}
	public void getDOB(String dd, String mm, String yy) {
		DOB.sendKeys(dd);
		DOB.sendKeys(mm);
		DOB.sendKeys(yy);
	}
	public void getAddress(String address) {
		Address.sendKeys(address);
	}
	public void getCity(String city) {
		City.sendKeys(city);
	}
	public void getState(String state) {
		State.sendKeys(state);
	}
	public void getPIN(String pin) {
		PIN.sendKeys(pin);
	}
	public void getTelephone(String telephone) {
		Telephonenumber.sendKeys(telephone);
	}
	public void getEmail(String email) {
		Email.sendKeys(email);
	}
	public void getpassword(String passw) {
		Password.sendKeys(passw);
	}
	public void getSubmitbutton() {
		SubmitButton.click();
	}
	
	
	
	
}
