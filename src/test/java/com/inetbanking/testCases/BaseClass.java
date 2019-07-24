package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetbanking.utilities.ReadConfig;
public class BaseClass {

	public static WebDriver driver;	
	public static Logger logger;	
	ReadConfig read = new ReadConfig();
	
	public String baseURL = read.getapplicationURL();
	public String Username=read.getUsername();	
	public String pass =read.getPass();
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if (br.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\Drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
		}		
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		if (br.equals("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logger.info("URL is opened");
						
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
		
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
		
	
	public String randomstring() {
		String generatedstring =RandomStringUtils.randomAlphabetic(8) ;
		return generatedstring;
	}
	
	public String randomalphanumeric() {
		String alphanumeric = RandomStringUtils.randomAlphanumeric(4);
		return alphanumeric;
	}
	
}
