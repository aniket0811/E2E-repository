package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentreportNG {


static ExtentReports extent;
	
	public static  ExtentReports getreportObject() {
		
		
		
		// ExtentReports , ExtentSparkReporter

		String path =System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Aniket Balsaraf");
		
		
		return extent;
		
	}
	
	
	
}
