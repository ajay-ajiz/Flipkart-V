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

public class PaymentTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	SearchItems searchitems;
	Payment payment;
	public PaymentTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		searchitems=new SearchItems();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//searchitems=homepage.search(prop.getProperty("item"));
		Map<String,String>testData = ExcelUtil.getMap();

		searchitems=homepage.search(testData.get("product name"));
		payment=searchitems.orderIt();
		
	}
	//@Test(priority=1)
	public void proceedpayment() throws Exception {
		Map<String,String>testData = ExcelUtil.getMap();

		String s=(testData.get("card_number"));
		payment.proceedPayment(s);
	}
	//@Test(priority=1)
	public void checkReceiver() {
		String s=payment.checkReceiver();
		Assert.assertEquals(s, "Abikrishnan M P");
	}
	@Test(priority=2)
	public void getMessage() throws Exception {
		Map<String,String>testData = ExcelUtil.getMap();

		String s=(testData.get("card_number"));
		payment=payment.proceedPayment(s);
		String msg=payment.errorMsg();
		
		Assert.assertEquals(msg, "Not a valid card number");
	}
	
	
	@AfterMethod
	public void terminate() {
		//driver.quit();
	}
}
