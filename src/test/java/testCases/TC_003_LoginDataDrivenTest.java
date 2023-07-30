package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_LoginDataDrivenTest extends BaseClass {
	
   @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
   public void DataDrivenTest(String emaill,String passwordd,String exp) {
	   
	   logger.info("......Started data driven test.....");
	 
	   try {
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setemail(emaill);
		lp.setpassword(passwordd);
		lp.loginclick();
		
		MyAccountPage mp= new MyAccountPage(driver);
		boolean target=mp.msgdisplay();
		
		if(exp.equals("Valid")) {
			
			if(target==true) {
				mp.clicklogout();
				Assert.assertTrue(true);
				}
			
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid")) {
			
			if(target==true) {
				mp.clicklogout();
				Assert.assertTrue(false);
				}
			
			else {
				Assert.assertTrue(true);
			}
			
			
		}
	   }
	   catch(Exception e) {
		   Assert.fail();
	   }
		logger.info("........Finished data driven test.........");  
   }
}
