package com.flipkart.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath="//input[@class=\"_3704LK\" and @name=\"q\"]")
	WebElement searchbar;
	@FindBy(xpath="//div[@class=\"exehdJ\" and text()=\"Ajay\"]")
	WebElement username;
	@FindBy(xpath="//div[@class=\"fMghEO\"]//ul[@class=\"_1xgFaf\"]//li[contains(text(),\"6 GB RAM\")][1]")
	WebElement mi10;
	
	public HomePage()throws Exception {
		PageFactory.initElements(driver, this);
	}
	public String validate_user() {
		log.debug("Validating UserName");
		String s=username.getText();
		return s;
	}
	
	public SearchItems search (String item) throws Exception {
		log.debug("Searching Item");
		searchbar.sendKeys(item);
		searchbar.submit();
		Thread.sleep(300);
		mi10.click();
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		return new SearchItems();
	}
	

}
