package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	void testlogin()
	{
		logger.info("login test starting.....");//login test started
		try 
		{
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setemail(rb.getString("email"));
		lp.setpassword(rb.getString("password"));
		lp.loginclick();
		
		MyAccountPage mp= new MyAccountPage(driver);
		boolean target=mp.msgdisplay();
		Assert.assertEquals(target,true);
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
	        logger.info(".....Finished testing.....");
	}
}
