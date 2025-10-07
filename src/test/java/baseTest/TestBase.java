package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBase {

	public WebDriver driver;
	@BeforeClass
	public void SetUp()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
