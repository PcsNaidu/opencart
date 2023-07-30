package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement displaymsg;
	
	@FindBy(xpath="//aside[@id='column-right']//a[normalize-space()='Logout']")
	WebElement logoutbtn;

	public boolean msgdisplay() {
	try{	
	return (displaymsg.isDisplayed());
	}
	catch(Exception e) {
		return(false);
	}
	}
	public void clicklogout() {
		logoutbtn.click();
	
	}
}
