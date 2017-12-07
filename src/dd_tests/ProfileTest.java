package dd_tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.TestUtil;

public class ProfileTest extends TestCore{
	
	
	@BeforeTest
	public void skipException(){
		
		if(!TestUtil.isExecutable("ProfileTest")){
			
			throw new SkipException("Skipping the test case as run mode is set to No");
			
			
		}
	}
	
	@Test(priority=2)
	public void doProfile() throws InterruptedException, IOException{
		
		try{
			
			
		WebElement element = driver.findElement(By.xpath(object.getProperty("MyAccount")));
	
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		//driver.findElement(By.xpath(object.getProperty("Profilelink"))).click();
		
		//driver.findElement(By.xpath(object.getProperty("ViewAllLink"))).click();
		Thread.sleep(5000);
		
		}catch(Throwable t){
			
			TestUtil.CaptureScreenshot();
			Assert.assertTrue(false, t.getMessage());
		}
		
	}
	
	

	
}
