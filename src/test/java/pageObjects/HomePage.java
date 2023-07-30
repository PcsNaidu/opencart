 package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	 
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	//locating elements
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccountlnk;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerlnk;
	
	@FindBy(xpath="//div[@id='top-links']//a[normalize-space()='Login']")
	WebElement clickloginlnk;
	
	//Action methods
	public void clickmyaccount() {
		myaccountlnk.click();
	}
	public void clickregister() {
		registerlnk.click();	
	}
    public void clicklogin() {
    	clickloginlnk.click();
    }
	
}
