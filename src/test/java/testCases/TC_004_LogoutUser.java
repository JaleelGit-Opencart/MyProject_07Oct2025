package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseTest.TestBase;
import pageObject.HomePage;
import pageObject.SignInPage;

public class TC_004_LogoutUser extends TestBase {

	@Test
	@Parameters("ExpectedUsername")
	public void LogoutUser(String name)
	{
		logger.info("*** Test started ***");
		try
		{
		HomePage hp=new HomePage(driver);
		String act_title=hp.PageTitle();
		String exp_title= rb.getString("HomePageTitle");
		Assert.assertEquals(act_title, exp_title, "Home page title is not matched");
		logger.info("HomePage title is matched");
		hp.SignUpSignIn();
		SignInPage sip= new SignInPage(driver);
		Boolean Login=sip.IsLoginToYourAccountDisplayed();
		Assert.assertEquals(Login, true);
		logger.info("'Login to your account' is displayed");
		sip.EnterLoginMail(rb.getString("ValidMail"));
		sip.EnterLoginPassword(rb.getString("ValidPassword"));
		sip.ClickLogin();
		String act_msg=hp.LoggedInMessage();
		String exp_msg="Logged in as "+name;
		Assert.assertEquals(exp_msg, act_msg , "Actual and expected labels are not matched. expected is: "+exp_msg+" but found: "+act_msg);
		logger.info("Logged in successfully");
		hp.ClickLogOut();
		logger.info("Clicked Logout");
		String act_SipTitle=sip.PageTitle();
		Boolean exp_SipTitleWord=act_SipTitle.contains("Login");
		Assert.assertEquals(exp_SipTitleWord, true);
		logger.info("Re-directed to HomePage");
		logger.info("*** Test ended ***");
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			Assert.fail();
		}
	}
}
