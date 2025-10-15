package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.TestBase;
import pageObject.HomePage;
import pageObject.SignInPage;

public class TC_003_Login_InValidCredentials extends TestBase {

	@Test
	public void LoginWithInvalidCredentials()
	{
		try
		{
		logger.info("*** Test started ***");
		HomePage hp=new HomePage(driver);
		String act_title=hp.PageTitle();
		String exp_title= rb.getString("HomePageTitle");
		logger.info("HomePage is displayed");
		Assert.assertEquals(act_title, exp_title, "Home page title is not matched");
		hp.SignUpSignIn();
		SignInPage sip= new SignInPage(driver);
		Boolean Login=sip.IsLoginToYourAccountDisplayed();
		Assert.assertEquals(Login, true);
		logger.info("'Login to your account' is displayed");
		sip.EnterLoginMail(rb.getString("inValidMail"));
		sip.EnterLoginPassword(rb.getString("inValidPassword"));
		sip.ClickLogin();
		String act_error=sip.ErrorMsg();
		String exp_error=rb.getString("ErrorMsg");
		Assert.assertEquals(act_error, exp_error);
		logger.info("error message is validated");
		logger.info("*** Test ended ***");
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			Assert.fail();
		}
	}
}
