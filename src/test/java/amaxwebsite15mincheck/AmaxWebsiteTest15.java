package amaxwebsite15mincheck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmaxWebsiteTest15 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\browserdrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.amaxinsurance.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)

	public void amaxQuoteEnginePageTitleTest() throws InterruptedException {

		
		driver.findElement(By.xpath("//input[@class='cmp-form-text__text']")).sendKeys("75247");
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='form-button-314788994']")).click();

		String expectedTitle = "A-MAX Auto Insurance";

		String actualTitle = driver.getTitle();

		System.out.println(actualTitle);

		Assert.assertEquals(actualTitle, expectedTitle);

	}
	
	@Test(priority=2)
	public void amaxWebSiteHomePageTitleTest() {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "A-MAX Auto Insurance | Affordable Car Insurance";
		Assert.assertEquals(actualTitle, expectedTitle, "HomePage title does not match");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
