package BasicTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGBasics_NAL {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Downloads\\Compressed\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test
	public void googleTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	public void logoTest() {
		boolean b= driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
		System.out.println(b);
		
	}
	
	@Test
	public void emailLinkTest() {
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(b);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
