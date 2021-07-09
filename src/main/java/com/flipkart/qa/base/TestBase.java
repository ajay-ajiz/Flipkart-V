package com.flipkart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.log4testng.Logger;

import com.flipkart.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	
	public TestBase()  {
		  File file=new File(".\\src\\main\\java\\com\\flipkart\\qa\\config\\conf.properties");
		  FileInputStream fileInput = null;
		  try{
			  fileInput = new FileInputStream(file);
		  }
		  catch (FileNotFoundException e){
			  e.printStackTrace();
		  }
		  
		  prop=new Properties();
		  try {
			  prop.load(fileInput);
		  }
		  catch (IOException e){
			  e.printStackTrace();
		  }
		  

		
	}
	public static void initialization() {
		//String s=prop.getProperty("flipkart_url");
		  System.setProperty("webdriver.chrome.driver",".\\chrome driver\\chromedriver.exe");
		  driver= new ChromeDriver();
		  log = Logger.getLogger("Flipkart logger");
		 
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		  driver.get(prop.getProperty("flipkart_url"));
	}
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	
	
}

