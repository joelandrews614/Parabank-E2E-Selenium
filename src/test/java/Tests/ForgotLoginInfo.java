package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.ForgotLoginInfoPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotLoginInfo {

	public static WebDriver dri = null;
	public static HomePage homePage;
	public static ForgotLoginInfoPage forgotLoginInfoPage;
	
	@BeforeClass
	public void setUp() {
		
		dri = WebDriverManager.chromedriver().create();
		
		dri.manage().window().maximize();
		dri.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dri.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
		
		homePage = new HomePage(dri);
		forgotLoginInfoPage = new ForgotLoginInfoPage(dri);
		
		homePage.clickForgotLoginInfo();
		
	}
	
	@Test
	public void TC_01_ValidateForgotLoginInfoPageFields() {
		
		forgotLoginInfoPage.validateCustomerLookUpSection();
		
	}
	
}
