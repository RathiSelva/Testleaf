package base;


	import java.time.Duration;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {

		//public static RemoteWebDriver driver;(this can be used to create sequence of execution else
                                              //   we have to use the Baseclass1 with driver details in starting
		                                    // we have to use Baseclass2 with threadlocal but it is the method in live case used)
		public RemoteWebDriver driver;
		public String fileName;
		
		@BeforeMethod()
		public void preCondition() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		}

		@AfterMethod()
		public void postCondition() {
			driver.close();
		}

	}


