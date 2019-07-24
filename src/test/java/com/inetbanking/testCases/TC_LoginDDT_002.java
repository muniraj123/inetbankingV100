package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.*;

import com.inetbanking.pageObjects.LoginPage_Objects;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;
public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	
	public void loginDDT(String user,String pass) throws IOException, Exception {
		
		LoginPage_Objects lp = new LoginPage_Objects(driver);
		lp.setUserName(user);
		logger.info("Username provided");
		lp.serPassword(pass);
		logger.info("Password is provided");
		lp.clickLogin();
		logger.info("Login button clicked");
		Thread.sleep(5000);
		
		if (isalertpresent()==true) {			
			//captureScreen(driver, "loginDDT");	
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);	
			logger.warn("login failed ");	
			
		}else {			
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Login passed");
		}
		
	}
	
	public boolean isalertpresent() {		
		try {
			driver.switchTo().alert();
			return true;			
		}catch (NoAlertPresentException e){
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx"; // get the path of xls file has data
		
		int rownum = XLUtils.getRowCount(path,"Sheet1");          // get the rowcount of Sheet1 
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);    // get the colcount of Sheet1 
		
		String logindata [][] = new String[rownum][colcount];
		
		for (int i=1; i<=rownum; i++) {  // starts with second row i.e (i=1) 
			for (int j=0; j<colcount; j++) { // start with fist col i.e (i=0)
				logindata [i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);  // i-1 represents 1-1=0, i.e 0 index of the array.				
			}
			
		}		
		return logindata;
		
	}
	
	
}
