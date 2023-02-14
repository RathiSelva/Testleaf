package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass1;

public class LoginPage extends BaseClass1 {
	
	public LoginPage(RemoteWebDriver driver)
	{this.driver = driver;
	}
	
	

	public LoginPage enterUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
		return this;
	}
	//@And  ("Enter password as pwd")
	
	public LoginPage enterPassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
		return this;
	}
	//@When ("Click on login button")
	public HomePage clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new HomePage(driver);
	}

}

