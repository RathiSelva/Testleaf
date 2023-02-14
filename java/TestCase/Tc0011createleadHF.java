package TestCase;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import base.BaseClass1;
	import pages.LoginpageHF;

	public class Tc0011createleadHF  extends BaseClass1{
		@BeforeTest
		public void setData() {
			fileName = "CreateLead";
			testName = "TC001_CreateLeadw7d1";
			testDesc = "Create Lead with Mandatory fields";
			testCategory = "Smoke";
			testAuthor = "Rathi";
		}
		
		//testngparallel.xml,testngpomseq.xml both run with BaseClass
		
		@Test(dataProvider = "fetchData")
		public void runCreateLead(String username,String pwd) {
			
			new LoginpageHF(driver)
			.enterUserName(username)
			.enterPassword(pwd) 
			.clickLogin()	
			.clickCRMSFA() 
			.clickLeads()	
			.clickCreateLead();
			
		}

		
		}



