package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword {

	public WebDriver driver;
	
	By Email = By.cssSelector("[id='user_email']");
	By sendmeinstruction = By.cssSelector("[type='submit']");
	
	
	
	
	public Forgotpassword(WebDriver driver) {
		
		this.driver=driver;
	}


	public WebElement getEmail() {
		
		return driver.findElement(Email);
		
	}
	
   public WebElement getsendmeinstruction() {
	   
	   return driver.findElement(sendmeinstruction);
	   
   }
	
}
