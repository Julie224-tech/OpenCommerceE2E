package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactpage extends BasePage{

	public contactpage(WebDriver driver) 
	{
		super(driver);		
		
	}

	@FindBy(xpath="//input[@name='username']")
	private WebElement orangename ; 
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement orangepwd;
	
	@FindBy(css="button[type='submit']")
	private WebElement submit;
	
	public void EnterOrangename(String name )
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(orangename));
		orangename.sendKeys(name);
	}
	

	public void EnterOrangepwd (String pwd )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(orangepwd));
		 orangepwd.sendKeys(pwd);
	}
	

	public void OrangeSubmit ()
	{
		submit.click();
	}
}
