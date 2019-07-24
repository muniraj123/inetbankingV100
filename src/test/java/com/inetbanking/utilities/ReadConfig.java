package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro = new Properties(); 

	public ReadConfig()   // This constructor will be invoked when ReadConfig is executed.
	{
		File src = new File("./Configuration/config.properties");		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);			
		}
		catch(Exception e) {
			System.out.println("Exception is : - " + e.getMessage());
		}		
	}	
	
	public String getapplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username = pro.getProperty("Username");
		return username;
	}
	
	public String getPass() {
		String pass = pro.getProperty("pass");
		return pass;
	}
	
	
	
}






