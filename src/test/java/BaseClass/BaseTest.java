package BaseClass ; 
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.lang.reflect.Method;

import utilities.ExtentReportManager;
public class BaseTest 
{
	
	 protected WebDriver driver ; 
	 protected String browserName;  
	 protected ExtentReports extent;
	 protected ExtentTest test;
	 protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);

	  @BeforeTest
	    public void setupReport() {
	        extent = ExtentReportManager.getReportObject();
	    }

	  	@Parameters("browser")
	    @BeforeMethod
		public void setUp(@Optional("chrome")String browser, Method method)
		{
	  		browserName = browser;
	  	    String testName = method.getName() + "-" + browserName;
	  	    test = extent.createTest(testName);
	  	    ExtentReportManager.extentTest.set(test);		 
		    if(browser.equalsIgnoreCase("chrome"))
		    {
		        driver = new ChromeDriver();
		    }
		    else if(browser.equalsIgnoreCase("firefox"))
		    {
		        driver = new FirefoxDriver();
		    }
		driver.manage().window().maximize();
	    }
	
	 
	@AfterMethod 
	public void teardown(ITestResult result)
	{
	    if (result.getStatus() == ITestResult.SUCCESS) 
	    {
	        captureScreenshot(result.getName());
	    }

	    driver.quit();
	}
	
	@AfterTest
	public void endReport() {
	    extent.flush(); // 🔥 flush ONCE at end
	}
	
	public String captureScreenshot(String testName) 
	{
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String path = System.getProperty("user.dir") + "/screenshots/" + testName +browserName+ ".png";
	    
	    try 
	    {
	        FileUtils.copyFile(src, new File(path));
	    } 
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return path;
	}
}
