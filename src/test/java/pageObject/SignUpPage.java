package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//b[normalize-space()='Enter Account Information']") WebElement Label_EnterAccInfo_ele;
	@FindBy(id = "id_gender1") WebElement radio_Mr_ele;
	@FindBy(name="password") WebElement txt_Password_ele;
	@FindBy(id="days") WebElement drop_SelectDay_ele;
	@FindBy(id="months") WebElement drop_SelectMonth_ele;
	@FindBy(id="years") WebElement drop_SelectYear_ele;
	@FindBy(name="newsletter") WebElement chk_News_ele;
	@FindBy(name="optin") WebElement chk_Offers_ele;
	@FindBy(xpath= "//input[@id='first_name']") WebElement txt_Fname_ele;
	@FindBy(xpath= "//input[@id='last_name']") WebElement txt_Lname_ele;
	@FindBy(xpath="//input[@id='address1']") WebElement txt_address1_ele;
	@FindBy(xpath="//input[@id='address2']") WebElement txt_address2_ele;
	@FindBy(id="country") WebElement drop_SelectCountry_ele;
	@FindBy(xpath="//input[@id='state']") WebElement txt_state_ele;
	@FindBy(xpath="//input[@id='city']") WebElement txt_city_ele;
	@FindBy(xpath="//input[@id='zipcode']") WebElement txt_zip_ele;
	@FindBy(xpath="//input[@id='mobile_number']") WebElement txt_phone_ele;
	@FindBy(xpath="//button[normalize-space()='Create Account']") WebElement but_createAcc_ele;

	
	public Boolean IsEnterAccInfoDisplayed()
	{
		return Label_EnterAccInfo_ele.isDisplayed();
	}
	
	public void SelectGender()
	{
		radio_Mr_ele.click();
	}
	
	public void SetPassword(String password)
	{
		txt_Password_ele.sendKeys(password);
	}
	
	public void SetDay()
	{
		Select s= new Select(drop_SelectDay_ele);
		s.selectByVisibleText("4");
	}
	
	public void SetMonth()
	{
		Select s= new Select(drop_SelectMonth_ele);
		s.selectByVisibleText("September");
	}
	
	public void SetYear()
	{
		Select s= new Select(drop_SelectYear_ele);
		s.selectByVisibleText("1992");
	}
	
	public void SelectNews()
	{
		chk_News_ele.click();
	}
	public void SelectOffers()
	{
		chk_Offers_ele.click();
	}
	
	public void setAddress(String random1, String random2, String random3, String random4, 
			               String random5, String random6,String random7,String random8)
	{
		txt_Fname_ele.sendKeys(random1);
		txt_Lname_ele.sendKeys(random2);
		txt_address1_ele.sendKeys(random3);
		txt_address2_ele.sendKeys(random4);
		Select s= new Select(drop_SelectCountry_ele);
		s.selectByVisibleText("India");
		txt_state_ele.sendKeys(random5);
		txt_city_ele.sendKeys(random6);
		txt_zip_ele.sendKeys(random7);
		txt_phone_ele.sendKeys(random8);
	}
	
	public void ClickCreateAcc()
	{
		but_createAcc_ele.click();
	}
}
