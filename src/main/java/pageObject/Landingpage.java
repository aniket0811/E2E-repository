package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {

	public WebDriver driver;
	
	
	By Signin=By.xpath("//span[contains(text(),'Login')]");
	
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	By NavBar= By.xpath("//header/div[2]/div[1]/nav[1]");
	
	
	
	
	public Landingpage(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage getLogin() {
		
		 driver.findElement(Signin).click();
		 return new LoginPage(driver);
		
		
	}
	
public WebElement getTitle() {
		
		return driver.findElement(title);
		
	}
public WebElement getNavBar() {
	
	return driver.findElement(NavBar);
	
}
	
	
}
