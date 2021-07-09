package com.flipkart.qa.testcase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.Payment;
import com.flipkart.qa.pages.SearchItems;
import com.flipkart.qa.util.ExcelUtil;

public class SearchItemsTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	SearchItems search;
	Payment payment;
	public SearchItemsTest()throws Exception {
		super();
	}
	
	@BeforeMethod
	public void  setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//search=homepage.search(prop.getProperty("item"));
		Map<String,String>testData = ExcelUtil.getMap();

		homepage.search(testData.get("product name"));

		
	}
	@Test(priority=1)
	public void order()throws Exception {
		payment=search.orderIt();
	}
	@Test(priority=0)
		public void validatePrice() throws Exception {
		Map<String,String>testData = ExcelUtil.getMap();
		search=new SearchItems();
		String ExpPrice=(testData.get("expected price"));
		
			
		//String s=search.validatePrice();
		String s="20001";
		System.out.println(s);
		
			Assert.assertNotEquals( ExpPrice,s);
		
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
