package pages;


	import java.util.List;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;

	import base.BaseClass1;

	
	public class LoginpageHF extends BaseClass1{	
		
		public LoginpageHF(RemoteWebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
//		@FindBy(how = How.ID, using = "username") 
//		WebElement eleUsername;
		
		// AND condition
//		@FindBys(
//				{
//					@FindBy(how = How.ID, using = "username123"),
//					@FindBy(how = How.XPATH, using = "//input[@name='USERNAME']")
//				}
//				)
		// OR Condition
		@CacheLookup
		@FindAll(
				{
					@FindBy(how = How.ID, using = "username"),
					@FindBy(how = How.XPATH, using = "//input[@name='USERNAME']")
				}
				)
		WebElement eleUsername;
		
		@FindBy(how = How.ID, using = "password") 
		List<WebElement> elePassword;
		@FindBy(how = How.CLASS_NAME, using = "decorativeSubmit") 
		WebElement eleLogin;
		
		public LoginpageHF enterUserName(String uName) {
//			WebElement eleUsername = driver.findElement(By.id("username"));
			try {
				eleUsername.sendKeys(uName);
				reportStep("Username is entered successfully", "Pass");
			} catch (Exception e) {
				reportStep("Username is not entered successfully", "fail");
			}
			return this;
		}
		
		public LoginpageHF enterPassword(String pwd) {
			try {
				elePassword.get(0).sendKeys(pwd);
				reportStep("Password is entered successfully", "Pass");
			} catch (Exception e) {
				reportStep("Password is not entered successfully", "fail");
			}
			return this;
		}
		
		public HomePage clickLogin() {
			eleLogin.click();
			return new HomePage(driver);
		}

	}


