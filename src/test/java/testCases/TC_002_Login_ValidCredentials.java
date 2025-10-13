package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseTest.TestBase;
import pageObject.HomePage;
import pageObject.SignInPage;

public class TC_002_Login_ValidCredentials extends TestBase{

	@Test
	@Parameters("ExpectedUsername")
	public void LoginWithValidCredentials(String name)
	{
		logger.info("*** Test Started ***");
		try
		{
		HomePage hp=new HomePage(driver);
		String act_title=hp.PageTitle();
		String exp_title= rb.getString("HomePageTitle");
		Assert.assertEquals(act_title, exp_title, "Home page title is not matched");
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
		System.out.println("expected :"+exp_msg+" actual :"+act_msg);
		logger.info("LoggedIn success message displayed");
		logger.info("*** Test Ended ***");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
	}
}
