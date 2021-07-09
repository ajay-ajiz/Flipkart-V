package com.flipkart.qa.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;
import org.openqa.selenium.WebElement;
public class LoginPage extends TestBase{
	
	@FindBy(xpath="//*[text()=\"Login\"]")
	WebElement login;
	@FindBy(xpath="//input[@class=\"_2IX_2- VJZDxU\" and @type=\"text\"]")
	WebElement user;
	@FindBy(xpath="//input[@class=\"_2IX_2- _3mctLh VJZDxU\" and @type=\"password\"]")
	WebElement password;
	@FindBy(xpath="//button[@type=\"submit\" and @class=\"_2KpZ6l _2HKlqd _3AWRsL\"]")
	WebElement submit;
	
	public LoginPage()throws Exception {						//initializing page objects
		PageFactory.initElements(driver, this);
		
	}
	
	public String vlaidateTitle() {
		log.debug("Validating Title in LoginPage");
		return driver.getTitle();
	}
	
	
	public HomePage login(String un,String pwd) throws Exception {
		//login.click();
		log.debug("Loggin to Flipkart");
		user.sendKeys(un);
		password.sendKeys(pwd);
		submit.submit();
		Thread.sleep(300);
		return new HomePage();
	}
}