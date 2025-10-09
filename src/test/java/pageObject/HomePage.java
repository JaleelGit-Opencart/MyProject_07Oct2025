package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(linkText = "Signup / Login") WebElement Lnk_SignUpSignIn_Ele;
	
	public String PageTitle()
	{
		
		return driver.getTitle();
	}
	
	public void SignUpSignIn()
	{
		Lnk_SignUpSignIn_Ele.click();
	}
	
	
}
