package TestCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass1;
import pages.LoginPage;


public class TC002_EditLeadw7d1 extends BaseClass1{
	@BeforeTest
	public void setData() {
		fileName = "EditLead";
		testName = "TC002_EditLeadw7d1";
		testDesc = "Edit Lead with Mandatory fields";
		testCategory = "Smoke";
		testAuthor = "Rathi";
	
	}
	@Test(dataProvider = "fetchData")
	public void runEditLead(String uName,String pwd,String desc, String Ndesc) {
		
	
	new LoginPage(driver)
	.enterUserName(uName)
	.enterPassword(pwd) 
	.clickLogin()	
	.clickCRMSFA() 
	.clickLeads()	
	.clickCreateLead()
	.enterCompanyName()
	.enterFirstName()
	.enterLastName()
	.enterDescription(desc)
	.clickSubmit()
	.clickEdit()
	.clearDescr()
	.enterNewDescr(Ndesc)
	.clickNewsubmit()
	.verifyEditFirstName();
	
}}