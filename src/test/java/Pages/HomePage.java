package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver dri;
	
	public HomePage(WebDriver dri) {
		this.dri = dri;
	}
	
	private By username_txt = By.xpath("//input[@name='username']");
	private By password_txt = By.xpath("//input[@name='password']");
	
	
	public boolean isUsernameTxtExists() {
		WebElement ele = dri.findElement(username_txt);
		return ele.isDisplayed();
	}
	
	public void enterUsername(String username) {
		WebElement ele = dri.findElement(username_txt);
		ele.sendKeys(username);
	}
	
	
	public boolean isPasswordTxtExists() {
		WebElement ele = dri.findElement(password_txt);
		return ele.isDisplayed();
	}
	
	public void enterPassword(String password) {
		WebElement ele = dri.findElement(password_txt);
		ele.sendKeys(password);
	}
	
}
