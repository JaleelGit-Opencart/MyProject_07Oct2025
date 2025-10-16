package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.TestBase;
import pageObject.HomePage;
import pageObject.SignInPage;

public class TC_005_RegUser_ExistingEmail extends TestBase{

	@Test
	public void RegUserWithExistingEmail()
	{
		logger.info("*** Test Started ***");
		try
		{
		HomePage hp=new HomePage(driver);
		String act_title=hp.PageTitle();
		String exp_title= rb.getString("HomePageTitle");
		Assert.assertEquals(act_title, exp_title, "Home page title is not matched");
		logger.info("HomePage title is matched....");
		hp.SignUpSignIn();
		SignInPage sip= new SignInPage(driver);
		Boolean lab=sip.IsSignUpLabelDisplayed();
		Assert.assertTrue(lab);
		logger.info("SignUp is displayed....");
		sip.SetName(alpha());
		sip.setEmail(rb.getString("ValidMail"));
		sip.ClickSignUp();
		Boolean exists=sip.EmailExists().contains("already exist");
		logger.info("Error message 'Email already exists' is displayed....");
		Assert.assertEquals(exists, true);
		logger.info("*** Test ended ***");
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			Assert.fail();
		}
	}
}
