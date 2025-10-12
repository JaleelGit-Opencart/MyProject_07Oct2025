package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.TestBase;
import pageObject.AccCreatedPage;
import pageObject.HomePage;
import pageObject.SignInPage;
import pageObject.SignUpPage;
public class TC_001_RegisterUser extends TestBase {

	@Test
	public void RegisterUser()
	{
		try {
		logger.info("*** Test started ***");
		HomePage hp=new HomePage(driver);
		String act_title=hp.PageTitle();
		String exp_title= rb.getString("HomePageTitle");
		Assert.assertEquals(act_title, exp_title, "Home page title is not matched");
		hp.SignUpSignIn();
		SignInPage sip= new SignInPage(driver);
		Boolean lab=sip.IsSignUpLabelDisplayed();
		Assert.assertTrue(lab);
		sip.SetName(alpha());
		sip.setEmail(alphaNumeric()+"@gmail.com");
		sip.ClickSignUp();
		SignUpPage sup= new SignUpPage(driver);
		Boolean AccDet=sup.IsEnterAccInfoDisplayed();
		Assert.assertTrue(AccDet);
		sup.SelectGender();
		sup.SetPassword(alphaNumeric());
		sup.SetDay();
		sup.SetMonth();
		sup.SetYear();
		sup.SelectNews();
		sup.SelectOffers();
		sup.setAddress(alpha(), alpha(), alpha(), alpha(), alpha(), alpha(), numeric(), numeric());
		sup.ClickCreateAcc();
		AccCreatedPage cre= new AccCreatedPage(driver);
		Boolean success=cre.IsSucccessMsgDisplayed();
		Assert.assertEquals(success, true);
		logger.info("*** Test ended ***");
		}catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
	}
}
