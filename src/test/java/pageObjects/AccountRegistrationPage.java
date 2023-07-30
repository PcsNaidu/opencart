package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);	
	}
	
	//Locate Elements
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cnfrmpassword;
	
	//@FindBy(xpath="//input[@id='input-newsletter']")
	//WebElement btn_newsletter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btn_agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationmsg;
	
	
	//Actions
	public void setfirstname(String fname) {
		txtfirstname.sendKeys(fname);
	}
	public void setlastname(String lname) {
		txtlastname.sendKeys(lname);
	}
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setphonenumber(String number) {
		
		phonenumber.sendKeys(number);
		
	}
	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
		}
		
	
	public void setconfirmpassword(String pwd) {
		cnfrmpassword.sendKeys(pwd);
	
	}
	/*public void newsletter_btn() {
		btn_newsletter.sendKeys(Keys.RETURN);
	}*/
	public void agree_btn() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btn_agree);
       // btn_agree.click();
    
	}
	public void continue_button() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btn_continue);
		
		//btn_continue.click();
	}
	public String confirmationmsg() {
		try {
		return confirmationmsg.getText();
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
}
	
	