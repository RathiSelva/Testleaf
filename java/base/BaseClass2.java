package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass2 extends AbstractTestNGCucumberTests {

	private static final ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<RemoteWebDriver>();
//		public static RemoteWebDriver driver;
	public String fileName;
	public String shIndex;

	// Encapsultion (getters and setters)
	public void setDriver(RemoteWebDriver driver) {
		tlDriver.set(driver);
	}

	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}

	@BeforeMethod()
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			tlDriver.set(new ChromeDriver());
		setDriver(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().get("http://leaftaps.com/opentaps");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod()
	public void postCondition() {
		getDriver().close();
	}

	@DataProvider(name = "fetchData", indices = 0, parallel = true)
	public String[][] getData() throws IOException {
		return ReadExcel.readData(fileName);
	}

}
