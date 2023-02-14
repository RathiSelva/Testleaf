package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;

public class VerifyfindLeadPage extends BaseClass {
	 public  VerifyfindLeadPage(RemoteWebDriver driver) { 
		  this.driver = driver; }
	 
		

	public void verifyFindleadName() {
		String text = driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText();
		if (text.equals("Find Leads")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
}}
