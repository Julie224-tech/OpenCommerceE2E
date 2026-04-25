package TestClass;
import  org.testng.annotations.Test;
import  com.aventstack.extentreports.ExtentTest;
import  BaseClass.BaseTest;
import  PageObjects.Loginpage;
import PageObjects.contactpage;
import  utilities.ConfigReader;
import  utilities.DataClass;
import  utilities.ExtentReportManager;

public class TC_02 extends BaseTest
{
	@Test(dataProvider="excelData", dataProviderClass=DataClass.class, priority=1)
	public void loginpagetest(String name, String email, String password)
	
{			
		  // ExtentTest test = extent.createTest(name + "-" + browserName);
		ConfigReader config = new ConfigReader();

		driver.get(config.getProperty("url"));
	    ExtentReportManager.extentTest.get().pass("Running test for " + name + " on " + browserName);

		    Loginpage lp1 = new Loginpage(driver);     

	        lp1.enterName(name);
	        test.info("Entered Name");
	        log.info("Entering username");

	        lp1.enterEmail(email);
	        test.info("Entered Email");
	        log.info("Entering Email");
	        
	        lp1.enterpassword(password);
	        test.info("Entered Password");
	        log.info("Entered Password");

	        lp1.SubmitClick();
	        test.pass("Form submitted successfully");
	        log.info("Form submitted successfully");
}
	        @Test(priority=2)
	    	public void contactpagetest()
	    	{
	    	ConfigReader config = new ConfigReader();
	    	driver.get(config.getProperty("url2"));
	    	ExtentReportManager.extentTest.get().pass("Running test for " +" Admin" + " on " + browserName);
	    	contactpage cp = new contactpage(driver);
	    	
	    	cp.EnterOrangename("Admin");
	    	log.info("Entering username");
	    	
	    	cp.EnterOrangepwd("admin123");
	    	log.info("Entering password");
	    	
	    	cp.OrangeSubmit();
	    	log.info("Submitted successfully");
	        
}
	        }