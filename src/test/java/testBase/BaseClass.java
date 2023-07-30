package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
     
	public  static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br) {
		
		rb=ResourceBundle.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass());
		if(br.equalsIgnoreCase("chrome")) {
			logger.info("Launching Chrome Browser");
		driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge")) {
			logger.info("Launching Edge Browser");
			driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appUrl"));
		driver.manage().window().maximize();
		}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
    public void close() {
    	driver.close();
    }
	
	public String randomAlpha() {
		
	String randomalpha=	RandomStringUtils.randomAlphabetic(5);
	return randomalpha;
	}
	
	public String randomNumber() {
		String  randomnumber=RandomStringUtils.randomNumeric(10);
		return randomnumber;
	}
	
	public String alphanumeric() {
		String randomalpha=	RandomStringUtils.randomAlphabetic(5);
		String  randomnumber=RandomStringUtils.randomNumeric(5);
		return(randomalpha+randomnumber);
	}
	
	public String CaptureScreen(String tname) throws IOException {
		
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		try {
		FileUtils.copyFile(source,new File(destination));
		}
		
		catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
	
	
	
	
	
	
	
	
	
}
