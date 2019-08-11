package BasicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo09_SSL_FF {
	private WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() {
		DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();       
		handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", "C:\\Downloads\\Compressed\\chromedriver.exe");
		WebDriver driver = new ChromeDriver (handlSSLErr);
		driver.manage().window().maximize();
	}
	@Test
	public void openApplication() throws InterruptedException {
		driver.get("https://cacert.org/");
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		Thread.sleep(2000);
		String expectedTitle = "Welcome to CAcert.org";
		Assert.assertEquals(pageTitle, expectedTitle);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}