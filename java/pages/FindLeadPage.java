package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass1;

public class FindLeadPage extends BaseClass1{
	public FindLeadPage(RemoteWebDriver driver) 
	{this.driver = driver;}
	 public  static String leadID;
	

	public FindLeadPage clickPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;}

	public FindLeadPage enterPhoneNo() {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		return this;
}
	public FindLeadPage clickFindLead1() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
}
	public FindLeadPage getLeadID() {
		WebElement leadID1 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
				String leadID = leadID1.getText();
		return this;
}
	public FindLeadPage clickLeadID() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return this;
}
	
	public FindLeadPage enterleadID() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		return this;	
		}
	public FindLeadPage clickNewfindLeadLink() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;	
		}
	public LeadPage clickDelete() {
		driver.findElement(By.linkText("Delete")).click();
		return new LeadPage(driver);	
	}
	
	
	
	}