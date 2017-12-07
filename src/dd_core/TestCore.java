package dd_core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dd_util.Xls_Reader;

public class TestCore {
	
	/*
	 * 	Initializing Properties, xls, generating logs, init WebDriver
	 * 
	 */

	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static Xls_Reader excel = null;
	public static WebDriver driver = null;
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public static void init() throws IOException{
		
		if(driver == null){
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\config.properties");
			config.load(fis);
			app_logs.debug("Loading the Config Properties");
			
			
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\object.properties");
			object.load(fis);
			app_logs.debug("Loading the Object Properties");
			
			excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\dd_properties\\testdata.xls");
			app_logs.debug("Loading the Excel");
			
			if(config.getProperty("Browser").equals("Firefox")){
				
				driver = new FirefoxDriver();
			
			}else if(config.getProperty("Browser").equals("Chrome")){
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\indianic\\Desktop\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
				driver = new ChromeDriver();
			}/*else if(config.getProperty("Browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "C:\\Users\\indianic\\Desktop\\Selenium\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			
		
			}*/ // Comment Internet Explore Browser Code
				driver.get(config.getProperty("testsite"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
		}
	
		
  
	}
	
	@AfterSuite
	public static void closeBrowser(){
		
		driver.quit();
	}
	
	
}
	
