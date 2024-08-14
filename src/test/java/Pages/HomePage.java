package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class HomePage {

	private WebDriver dri;
	
	public HomePage(WebDriver dri) {
		this.dri = dri;
	}
	
	//Home Page Top Panel Locators:	
	private By homepagelogo_gif = By.xpath("//img[@alt='ParaBank']");
	private By headerPanel_div = By.xpath("//div[@id='headerPanel']"); 
	
	//Login Functionality Locators:
	private By username_txt = By.xpath("//input[@name='username']");
	private By password_txt = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By loginTitle = By.xpath("//div[@id='leftPanel']/h2");
	private By forgetLogin_Link = By.linkText("Forgot login info?");
	private By register_Link = By.linkText("Register");
	
	//Right Panel Locators:
	private By errorMessage_p = By.xpath("//div[@id='rightPanel']/p");
	
	public void validateTopPanel() {
		Assert.assertEquals(dri.findElement(homepagelogo_gif).isDisplayed(), true);
		Assert.assertEquals(dri.findElement(headerPanel_div).isDisplayed(), true);
	}
	
	public void validateCustomerLoginFields() {
		Assert.assertEquals(dri.findElement(loginTitle).getText(), "Customer Login");
		Assert.assertEquals(dri.findElement(username_txt).isDisplayed(), true);
		Assert.assertEquals(dri.findElement(password_txt).isDisplayed(), true);
		Assert.assertEquals(dri.findElement(loginBtn).isDisplayed(), true);	
		Assert.assertEquals(dri.findElement(forgetLogin_Link).isDisplayed(), true);
		Assert.assertEquals(dri.findElement(register_Link).isDisplayed(), true);
	}
	
	public void enterUsername(String username) {		
		dri.findElement(username_txt).sendKeys(username);
	}
	public void enterPassword(String password) {
		dri.findElement(password_txt).sendKeys(password);
	}
	public void clickLoginbtn() {
		dri.findElement(loginBtn).click();
	}
	
	public void clickForgotLoginInfo() {
		dri.findElement(forgetLogin_Link).click();
	}
	
	public String getErrorMessage() {
		return dri.findElement(errorMessage_p).getText();
	}
	
}
