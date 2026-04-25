package PageObjects;
import PageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Loginpage extends BasePage
{
   
	public Loginpage(WebDriver driver) 
	{
		super(driver);
		
	}

	
	@FindBy (xpath ="//input[@name='name'][1]")
	private WebElement NameEnter;
	
	@FindBy(css= "input[name='email']")
	private WebElement EmailEnter ;
	
	@FindBy(css= "input[type='password']")
	private WebElement password;
	
	@FindBy(css ="input[value='option1']")
	private WebElement Employment ;
	
	@FindBy(css="input[value='Submit']")
	private WebElement Submit ;
	
	   public void enterName(String name) 
	    {
	        NameEnter.sendKeys(name);
	    }

	    public void enterEmail(String email) 
	    {
	        EmailEnter.sendKeys(email);
	        
	    }
	    public void enterpassword(String pwd) 
	    {
	       password.sendKeys(pwd);
	    }
	    
	    
	    public void SubmitClick() 
	    {
	       Submit.click();
	       
	    }
		
}
