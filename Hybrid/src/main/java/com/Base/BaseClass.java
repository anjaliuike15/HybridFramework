package com.Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utils.PropertyUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public static WebDriver driver= null;
	public static Logger log= Logger.getLogger(BaseClass.class);
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test= null;
	
	public void initialization() throws Exception{
		log.info("initializing the browser");
		String BrowserName=PropertyUtils.readproperties("browser");
		if(BrowserName.contains("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver= new ChromeDriver();
		}
		driver.get(PropertyUtils.readproperties("url"));
		driver.manage().window().maximize();

	}
	public static void ReportInit(){
		String path=System.getProperty("user.dir")+"/target/ExtentReport.html";
		report= new ExtentReports();
		spark= new ExtentSparkReporter(path);
		report.attachReporter(spark);
	}

}
