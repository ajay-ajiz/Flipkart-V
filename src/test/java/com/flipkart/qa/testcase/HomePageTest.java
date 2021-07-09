package com.flipkart.qa.testcase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.SearchItems;
import com.flipkart.qa.util.ExcelUtil;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	SearchItems Sitems;
	public HomePageTest()throws Exception {
		super();
	}
	@BeforeMethod
	public void setUp()throws Exception {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	@Test(priority=1)
	public void searchitem() throws Exception {
		//Sitems=homepage.search(prop.getProperty("item"));
		Map<String,String>testData = ExcelUtil.getMap();

		homepage.search(testData.get("product name"));
		
	}
	@Test(priority=0)
	public void usernametest(){
		String s=homepage.validate_user();
		Assert.assertEquals(s, "Ajay");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
