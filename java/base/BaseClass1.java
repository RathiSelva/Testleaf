package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass1 {

	public RemoteWebDriver driver;
	public String fileName;
	public static Properties prop2;
	public ExtentReports extent;
	public String testName, testDesc, testCategory, testAuthor;
	public static ExtentTest test;

	@BeforeMethod()
	public void preCondition() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(new File("src/main/resources/confiq.properties"));
		prop.load(fis);
		String url = prop.getProperty("url");

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String lang = prop.getProperty("lang");
		prop2 = new Properties();
		FileInputStream fis2 = new FileInputStream(new File("src/main/resources/" + lang + ".properties"));
		prop2.load(fis2);

	}

	@AfterMethod()
	public void postCondition() {
		driver.close();
	}

	@DataProvider(name = "fetchData", indices = 0, parallel = true)
	public String[][] getData() throws IOException {
		return ReadExcel.readData(fileName);
	}

	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		reporter.setAppendExisting(true);
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDesc);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	public void reportStep(String message, String status) {
		int random;
		if (status.equalsIgnoreCase("PASS")) {
			try {
				random = takeSnap();
				test.pass(message,
						MediaEntityBuilder.createScreenCaptureFromPath(".././images/img" + random + ".png").build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (status.equalsIgnoreCase("FAIL")) {
			test.fail(message);
		}
	}

	public int takeSnap() throws IOException {
		int random = (int) (Math.random() * 9999999);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/img" + random + ".png");
		FileUtils.copyFile(src, dest);
		return random;
	}
}
