package E2EFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import pageObject.LoginPage;
import resources.Base;

public class ValidatePage extends Base {

	private static Logger log = LogManager.getLogger(ValidatePage.class.getName());
	public WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}

	@AfterTest

	public void closedriver() {
		driver.close();

	}

	@Test
	public void basenavigation() throws IOException, InterruptedException {

		Landingpage l = new Landingpage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("Validated Successfully");
		Assert.assertTrue(l.getNavBar().isDisplayed());

	}

}
