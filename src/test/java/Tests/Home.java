package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.OverviewPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {

	public static WebDriver dri = null;
	public static HomePage homePage = null;
	public static OverviewPage overviewPage = null;
	
	@BeforeClass
	public void setup() {
		
		dri = WebDriverManager.chromedriver().create();
		homePage = new HomePage(dri);
		overviewPage = new OverviewPage(dri);
		
		
		dri.manage().window().maximize();
		dri.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void TC_01_NavigateToHomepage() {
			
		dri.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
		
	}
	
	@Test
	public void TC_02_ValidateHomePage() throws InterruptedException {
		
		Thread.sleep(Duration.ofSeconds(5));
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

	@Parameters({"loginEmail", "loginPassword"})
	@Test
	public void TC_05_SuccessfulLoginWithCorrectCredientials(String loginEmail, String loginPassword) {
		
		dri.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
		
		homePage.enterUsername(loginEmail);
		homePage.enterPassword(loginPassword);
		homePage.clickLoginbtn();
	
		Assert.assertEquals(overviewPage.isWelcomeMessageExists(), true);
		
	}
	
}
