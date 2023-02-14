package pages;


	import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass1;

	public class LeadPage extends BaseClass1{

		
		  public LeadPage(RemoteWebDriver driver)
		  { this.driver = driver; }
		 
		
		//@And("Click on CreateLead")
		public CreatePage clickCreateLead() {
			driver.findElement(By.linkText(prop2.getProperty("links_create_leads"))).click();
			return new CreatePage(driver);
		}


		public FindLeadPage clickFindLeads() {
			driver.findElement(By.linkText("Find Leads")).click();
			return new FindLeadPage(driver);
		}}		
		
			
		
		
	


