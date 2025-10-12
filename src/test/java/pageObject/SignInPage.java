package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//*[normalize-space() ='New User Signup!']") WebElement label_SignUpLabel_ele;
	@FindBy(name = "name") WebElement txt_Name_ele;
	@FindBy(xpath="//*[@data-qa=\"signup-email\"]") WebElement txt_email_ele;
	@FindBy(xpath= "//*[@data-qa=\"signup-button\"]") WebElement But_SignUp_ele;
	
	public Boolean IsSignUpLabelDisplayed()
	{
		return label_SignUpLabel_ele.isDisplayed();
	}
	
	public void SetName(String name)
	{
		txt_Name_ele.sendKeys(name);
	}
	
	public void setEmail(String email)
	{
		txt_email_ele.sendKeys(email);
	}
	
	public void ClickSignUp()
	{
		But_SignUp_ele.click();
	}
}
