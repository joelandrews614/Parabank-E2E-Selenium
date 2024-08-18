package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

	private WebDriver dri = null;
	
	public OverviewPage(WebDriver dri) {
		this.dri = dri;
	}
	
	By welcomeMessage = By.xpath("//div[@id='leftPanel']/p");
	
	public boolean isWelcomeMessageExists(){
		
		return dri.findElement(welcomeMessage).isDisplayed();
		
	}
}
