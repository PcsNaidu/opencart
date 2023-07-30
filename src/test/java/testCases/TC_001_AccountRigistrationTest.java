package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRigistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	void AccountRegistrationTest() throws InterruptedException {
		logger.info("***********Starting TC_001_AccountRigistrationTest *********");
		logger.debug(".....Generating debug logs........");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		logger.info("clicked on My account");
		hp.clickregister();
		logger.info("clicked on Register account");
		
		AccountRegistrationPage reg=new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		reg.setfirstname(randomAlpha().toUpperCase());
		reg.setlastname(randomAlpha().toUpperCase());
		logger.info("entered last name");
		reg.setemail(randomAlpha()+"@gmail.com");
		reg.setphonenumber(randomNumber());
		
		String password=alphanumeric();
		reg.setpassword(password);
		reg.setconfirmpassword(password);
	
		
		//reg.newsletter_btn();
		//logger.info("clicked on newsletter button");
		Thread.sleep(3000);
		reg.agree_btn();
		logger.info("clicked on agree button");
		Thread.sleep(1000);
		reg.continue_button();
		logger.info("clicked on continue button");
		String msgg=reg.confirmationmsg();
		System.out.println(msgg);
		if(msgg.equals("Your Account Has Been Created!"))
		{
			logger.info("Test passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
		Assert.assertTrue(false);	
		}
		
	}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***********Finished TC_001_AccountRigistrationTest *********");
	}
}	
	
	


