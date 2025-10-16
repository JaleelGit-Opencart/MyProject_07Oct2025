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
	@FindBy(xpath="//div[@class=\"login-form\"]/descendant::h2") WebElement label_Login_ele;
	@FindBy(xpath="//div[@class=\"login-form\"]/descendant::input[2]") WebElement txt_LoginMail_ele;
	@FindBy(xpath="//div[@class=\"login-form\"]/descendant::input[3]") WebElement txt_LoginPass_ele;
	@FindBy(xpath="//div[@class=\"login-form\"]/descendant::button") WebElement but_Login_ele;
	@FindBy(xpath="//input[@type=\"password\"]/following-sibling::p") WebElement label_ErrorMsg_ele;
	@FindBy(xpath="//form[@action=\"/signup\"]/child::p") WebElement label_EmailExists_ele;
	
	public String PageTitle()
	{
		return driver.getTitle();
	}
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
	
	public Boolean IsLoginToYourAccountDisplayed()
	{
		return label_Login_ele.isDisplayed();
	}
	public void EnterLoginMail(String mail)
	{
		txt_LoginMail_ele.sendKeys(mail);
	}
	public void EnterLoginPassword(String pass)
	{
		txt_LoginPass_ele.sendKeys(pass);
	}
	public void ClickLogin()
	{
		but_Login_ele.click();
	}
	public String ErrorMsg()
	{
		return label_ErrorMsg_ele.getText().trim();
	}
	public String EmailExists()
	{
		return label_EmailExists_ele.getText();
	}
}
