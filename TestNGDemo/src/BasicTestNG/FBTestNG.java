package BasicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class FBTestNG {
	WebDriver driver;
	@BeforeSuite	
	@Parameters({"browsername", "url"})
	public void setup(@Optional("Chrome")String browsername,String url) {	
		switch (browsername) {
		case "IE":
		//Code to initialize webdriver instance
//			C:\Downloads\Compressed\IEDriverServer.exe
			System.setProperty("webdriver.ie.driver","C:\\Downloads\\Compressed\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			break;
		case "Firefox":
			//Code to initialize webdriver instance
//			C:\Downloads\Compressed\geckodriver.exe
			System.setProperty("webdriver.gecko.driver","C:\\Downloads\\Compressed\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			break;
		case "Chrome":
			//Code to initialize webdriver instance
			System.setProperty("webdriver.chrome.driver","C:\\Downloads\\Compressed\\chromedriver.exe"); 
			driver = new ChromeDriver();
			driver.get(url);
			break;
			
			
		}	
		
		
		
	}
	
	@Test(dataProvider="getData")
	  public void login(String username,String password) throws InterruptedException 
	  {	 
		   //Code to Login to the application
				driver.findElement(By.id("email")).sendKeys(username);
				Thread.sleep(2000);
				driver.findElement(By.id("pass")).sendKeys(password);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@value= 'Log In']")).click();
				Thread.sleep(2000);
	            try
				{
		         //verifying the presence of webelement
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")));
				System.out.println("login success");
				}
				catch(Exception e)
				{
					System.out.println("Login failure");
					
				}
	            String message = driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).getText();
				System.out.println(message);
//				driver.findElement(By.xpath("//*[@id=\"userNavigationLabel\"]")).click();
//				driver.findElement(By.xpath("//*[@id=\"js_m\"]")).click();
		  }
	
	
	 @DataProvider
	  public Object[][] getData() {
	      Object[][]data=new Object[2][2];
	      data[0][0]="9029426575";
	      data[0][1]="friforeve951904";
	      data[1][0]="pgAlmacho";
	      data[1][1]="freezeray";
	      return data;	
	  }
		@AfterSuite
		  public void tearDown() {
			  driver.quit();	  
		  }
}

