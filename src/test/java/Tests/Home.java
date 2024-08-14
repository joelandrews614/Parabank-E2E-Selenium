package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {

	public static WebDriver dri = null;
	public static HomePage homePage = null;
	
	@BeforeClass
	public void setup() {
		
		dri = WebDriverManager.chromedriver().create();
		homePage = new HomePage(dri);
		
		dri.manage().window().maximize();
		dri.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void TC_01_NavigateToHomepage() {
			
		dri.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
		
	}
	
	@Test
	public void TC_02_ValidateHomePage() {
		
		homePage.validateTopPanel();
		
	}
	
	@Test
	public void TC_03_ValidateLoginFields() {
		
		homePage.validateCustomerLoginFields();
		
	}	
	
	@Test
	public void TC_04_TryingToLoginWithoutGivingAnyValuesToUsernameAndPasswordFields() {
		
		homePage.clickLoginbtn();
		Assert.assertEquals(homePage.getErrorMessage(), "Please enter a username and password.");
		
	}

}
