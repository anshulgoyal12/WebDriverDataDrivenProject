package dd_tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.TestUtil;

public class LoginTest extends TestCore{
	
	@BeforeTest
	public void skipException(){
		
		
		if(!TestUtil.isExecutable("LoginTest")){
			
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}

		@Test(priority=1,dataProvider="getData")
		public void doLogin(String Email, String Password) throws InterruptedException, IOException{
			
			try{
			app_logs.debug("Executing the Login Test");
			driver.findElement(By.xpath(object.getProperty("signInlink"))).click();
			driver.findElement(By.xpath(object.getProperty("signInasBuyerlink"))).click();
			driver.findElement(By.xpath(object.getProperty("username"))).sendKeys(Email);
			driver.findElement(By.xpath(object.getProperty("password"))).sendKeys(Password);
			driver.findElement(By.xpath(object.getProperty("SignInButton"))).click();
			Thread.sleep(5000);
			}catch(Throwable t){
				
				TestUtil.CaptureScreenshot();
				Assert.assertTrue(false, t.getMessage());
			}
			
		}
		
		@DataProvider
		public static Object[][] getData(){
					 

			return TestUtil.getData("LoginTest");
			
			
			
			
		}


}
