package TestCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass1;
import pages.LoginPage;

public class TC003_Deleteleadw7d1  extends BaseClass1{
	@BeforeTest
	public void setData() {
		fileName = "DuplicateLead";
		testName = "TC003_Deleteleadw7d1";
		testDesc = "Delete Lead with Mandatory fields";
		testCategory = "Smoke";
		testAuthor = "Rathi";
	
	}
	@Test(dataProvider = "fetchData")
public void runDeleteLead(String uName,String pwd) {
		
		new LoginPage(driver)
		.enterUserName(uName)
		.enterPassword(pwd) 
		.clickLogin()	
		.clickCRMSFA() 
		.clickLeads()	
		.clickFindLeads()
		.clickPhone()
		.enterPhoneNo()
		.clickFindLead1()
		.getLeadID()
		.clickLeadID()
		.clickDelete()
		.clickFindLeads();
		
	}
}
