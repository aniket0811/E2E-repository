package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By Email = By.cssSelector("[id='user_email']");
	By password = By.id("user_password");
	
	By Login = By.xpath("//input[@name='commit']");
	By forgotpassword = By.cssSelector("[href*='password/new']");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}


	public WebElement getEmail() {
		
		return driver.findElement(Email);
		
	}
	

	public WebElement getpassword() {
		
		return driver.findElement(password);
		
	}
	
	public WebElement getLogin() {
		
		return driver.findElement(Login);
		
	}
	
	public Forgotpassword forgotpassword() {
		
	driver.findElement(forgotpassword);
	return new Forgotpassword(driver);

	}
	
}
