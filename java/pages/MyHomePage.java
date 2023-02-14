package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass1;
import io.cucumber.java.en.And;

public class MyHomePage extends BaseClass1{
	
	
	  public MyHomePage(RemoteWebDriver driver) {
		  this.driver = driver; }
	 
	@And ("Click Lead button")
	public LeadPage clickLeads() {
		driver.findElement(By.linkText(prop2.getProperty("links_leads"))).click();
		return new LeadPage(driver);
	}
}


