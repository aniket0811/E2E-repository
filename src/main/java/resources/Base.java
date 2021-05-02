package resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {   

	public WebDriver driver;
	public Properties prop;
	
	//@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {
		
		//Invoke chrome 
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Eclipse Workspace\\E2EFramework\\src\\main\\java\\resources\\Config.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenuim Jar\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
					
		}
		else if(browser.equals("firefox")) {
			//code
			
		}
		else if(browser.equals("IE")) {
			//code
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public String getScreenShotsmethod(String TestCaseName,WebDriver driver) throws IOException {
		
		 TakesScreenshot ts =(TakesScreenshot)driver;
		 File source =ts.getScreenshotAs(OutputType.FILE);
		 String destinationfile = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		// FileUtils.CopyFile(source,new File(destinationfile));
		 FileUtils.copyFile(source,new File(destinationfile));
		 return destinationfile;
		
	} 
	
	
}
