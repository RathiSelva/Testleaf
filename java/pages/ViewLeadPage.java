package pages;


	import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

	import base.BaseClass1;

	public class ViewLeadPage extends BaseClass1{

		
		 public ViewLeadPage(RemoteWebDriver driver) { this.driver = driver; }
		 
		
		public void verifyFirstName() {
			String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
			if(text.equals("View Lead")) {
				System.out.println("Created Lead");
			}
			else {System.out.println("Have to do well");
		}
		
		}

		public CreatePage clickEdit() {
		driver.findElement(By.linkText("Edit")).click();
		return new CreatePage(driver);	
		}

		public void verifyEditFirstName() {
			String title = driver.getTitle(); 
			  System.out.println(title);
			  }
		public LeadPage clickDelete() {
			driver.findElement(By.linkText("Delete")).click();
			return new LeadPage(driver);
		}
		
	}
	
