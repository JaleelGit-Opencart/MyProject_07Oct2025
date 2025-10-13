package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(linkText = "Signup / Login") WebElement Lnk_SignUpSignIn_Ele;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]/descendant::a[last()]") WebElement link_ActLoggedIn_ele;
	
	public String PageTitle()
	{
		
		return driver.getTitle();
	}
	
	public void SignUpSignIn()
	{
		Lnk_SignUpSignIn_Ele.click();
	}
	public String LoggedInMessage()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elem=wait.until(ExpectedConditions.visibilityOf(link_ActLoggedIn_ele));
		return elem.getText().trim();
	}
	
	
}
