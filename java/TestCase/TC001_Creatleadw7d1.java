package TestCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass1;
import pages.LoginPage;

public class TC001_Creatleadw7d1 extends BaseClass1 {
	@BeforeTest
	public void setData() {
		fileName = "CreateLead";
		testName = "TC001_CreateLeadw7d1";
		testDesc = "Create Lead with Mandatory fields";
		testCategory = "Smoke";
		testAuthor = "Rathi";
	}
	
	//testngparallel.xml,testngpomseq.xml both run with BaseClass
	
	@Test(dataProvider = "fetchData",retryAnalyzer=RetryEngine.class)
	public void runCreateLead(String username,String pwd,String desc) {
		
		new LoginPage(driver)
		.enterUserName(username)
		.enterPassword(pwd) 
		.clickLogin()	
		.clickCRMSFA() 
		.clickLeads()	
		.clickCreateLead()
		.enterCompanyName()
		.enterFirstName()
		.enterLastName()
		.enterLocalName()
		.enterDeptName()
		.enterDescription(desc)
		.enterEmailId()
		.selectCityName()
		.clickSubmit()
		.verifyFirstName();
	}

	
	}



