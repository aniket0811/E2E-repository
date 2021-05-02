package E2EFramework;

import java.io.IOException;
//import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObject.Forgotpassword;
import pageObject.Landingpage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base {

	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialize successfully");

	}

	// @SuppressWarnings("deprecation")
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text)
			throws IOException, InterruptedException {

		// one is inheritance

		// creating object to that class and invoke methods of it
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("URL is hit successfully");
		// Thread.sleep(4000);
		Landingpage l = new Landingpage(driver);
		Thread.sleep(2000L);
     	LoginPage lp=l.getLogin();
		lp.getEmail().sendKeys(Username);
		lp.getpassword().sendKeys(Password);
		System.out.println(text);
		lp.getLogin().click();
		Forgotpassword fp =lp.forgotpassword();
		fp.getEmail().sendKeys("abc");
		fp.getsendmeinstruction().click();

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// coloumn stands for how many values per each test

		// Array size is 2
		// 0,1
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restrcited User";
		// 1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non restricted user";

		return data;

	}

}
