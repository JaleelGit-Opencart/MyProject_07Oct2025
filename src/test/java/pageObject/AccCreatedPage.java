package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseTest.TestBase;

public class AccCreatedPage extends BasePage {

	public AccCreatedPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]") WebElement label_SuccessMsg_ele;
	@FindBy(xpath = "//a[normalize-space()='Continue']") WebElement but_continue_ele;
	
	public Boolean IsSucccessMsgDisplayed()
	{
		return label_SuccessMsg_ele.isDisplayed();
	}
	
	public void clickContinue()
	{
		but_continue_ele.click();
	}
	
}
