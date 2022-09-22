package test_Cases;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;

public class TestCase001 {
	
	public WebDriver driver;
	HomePage home;
	public static final ArrayList<String> String = null;
	@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vwo.com/#/analyze/heatmap/129/reports?token=eyJhY2NvdW50X2lkIjo2LCJleHBlc%20mltZW50X2lkIjoxMjksImNyZWF0ZWRfb24iOjE1MDc3ODk0ODcsInR5cGUiOiJjYW1wYWlnbiIsI%20nZlcnNpb24iOjEsImhhc2giOiJiMzlmMTQ4MWE0ZDMyN2Q4MDllNTM1YzVlNWFjOGVlMCJ9");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void validateWindow() {
		home = new HomePage(driver);
		home.heatmapClick();
		Set<String> ids = driver.getWindowHandles();
		ArrayList<String> a1 = new ArrayList<String>(ids);
		String childID = a1.get(1);
		if(ids.size() == 2) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.switchTo().window(childID);
		Actions act = new Actions(driver);
		act.moveToElement(home.element()).click().perform();
//		
	}
	
//	@Test(priority = 2)
//	public void verifyElementList() {
//		Set<String> ids = driver.getWindowHandles();
//		ArrayList<String> a1 = new ArrayList<String>(ids);
//		String childID = a1.get(1);
//		driver.switchTo().window(childID);
//		
//		home = new HomePage(driver);
//		home.elementList();
//		home.verifyElementList();	
//	}
//	
//	@AfterClass
//	public void close() {
//		driver.quit();
//	}

}
