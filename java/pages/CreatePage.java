package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseClass1;

public class CreatePage extends BaseClass1{

	public CreatePage(RemoteWebDriver driver) 
	{this.driver = driver;}
	

	public CreatePage enterCompanyName() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		return this;
	}

	public CreatePage enterFirstName() {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rathi");
		return this;
	}

	public CreatePage enterLastName() {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Selva");
		return this;
	}

	public CreatePage enterLocalName() {
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("S.Rathi");
		return this;
	}
     
	public CreatePage enterDeptName() {
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		return this;

	}

	public CreatePage enterDescription(String desc) {
		driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
		return this;
	}

	public CreatePage enterEmailId() {
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("srathi.msc@gmail.com");
		return this;
	}

	public CreatePage selectCityName() {
		WebElement Element = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		Select dropdown = new Select(Element);

		dropdown.selectByVisibleText("New York");
		return this;
	}

	public ViewLeadPage clickSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

	
	  public CreatePage clearDescr() {
	  driver.findElement(By.id("updateLeadForm_description")).clear(); 
	  return new CreatePage(driver); }
	 
	 public CreatePage enterNewDescr(String Ndesc) {
	  driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys(Ndesc);
	  return new CreatePage(driver); }
	 

	public ViewLeadPage clickNewsubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
		
	}
	public ViewLeadPage clickFindLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new ViewLeadPage(driver);
		
	}


	public FindLeadPage clickPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return new FindLeadPage(driver);
	
	
}}


	