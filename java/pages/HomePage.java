package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass1;
import io.cucumber.java.en.And;

	public class HomePage extends BaseClass1{
		
		
		 public HomePage(RemoteWebDriver driver) 
		 { this.driver = driver; }
		 
		
		
		@And ("Click on CRMSFA Link")
		public MyHomePage clickCRMSFA() {
			driver.findElement(By.linkText("CRM/SFA")).click();
			return new MyHomePage(driver);
		}
	}

