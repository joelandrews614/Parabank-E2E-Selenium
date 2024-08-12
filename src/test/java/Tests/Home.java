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
	public void TC_01_Navigate_To_Homepage() {
			
		dri.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
		
	}
	
	@Test
	public void TC_02_Validate_Login_Fields() {
		
		Assert.assertEquals(homePage.isUsernameTxtExists(), true);
		Assert.assertEquals(homePage.isPasswordTxtExists(), true);
		
	}	

}
