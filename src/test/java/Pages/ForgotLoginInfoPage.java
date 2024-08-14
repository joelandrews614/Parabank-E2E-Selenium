package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgotLoginInfoPage {

	private WebDriver dri;
	
	public ForgotLoginInfoPage(WebDriver dri) {
		this.dri = dri;
	}
	
	By customerLookupTitle = By.xpath("//div[@id='rightPanel']/h1");
	By lookUpForm = By.xpath("//form[@id='lookupForm']");
	
	public void validateCustomerLookUpSection() {
		Assert.assertEquals(dri.findElement(customerLookupTitle).isDisplayed(), true);
		Assert.assertEquals(dri.findElement(lookUpForm).isDisplayed(), true);
	}
	
}
