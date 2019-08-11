package BasicTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FlipCart_example {
	
	WebDriver driver;
	int sum = 0;
	String url = "https://www.flipkart.com/mobiles/mi~brand/pr?sid=tyy,4io&otracker=clp_metro_expandable_1_3.metroExpandable.METRO_EXPANDABLE_Mi_mobile-phones-store_ZHYC957RFL_wp3&fm=neo%2Fmerchandising&iid=M_24293ca9-fb80-4603-8f23-c2725d84e640_3.ZHYC957RFL&ppt=clp&ppn=mobile-phones-store&ssid=y6i8eh720w0000001563730525933";
  @Test
  public void f() {
	//*[@id="container"]//div[contains(@class,'_1vC4OE _2rQ-NK')]
	  List<WebElement> price = driver.findElements(By.xpath("//*[@id=\"container\"]//div[contains(@class,'_1vC4OE _2rQ-NK')]"));
	  
	  for(WebElement e: price) {
		  
//		  System.out.println(e.getSize());
		  System.out.println(e.getText().substring(1).trim());
		  String priceString = e.getText().substring(1).trim().replace(",", "");
		  
		  int priceInt = Integer.parseInt(priceString);
		  
		  
		  
		  sum = sum + priceInt;
		  
		 
	  }
	  
	  float avg = sum/price.size();
	  
	  System.out.println(avg);
	 
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Downloads\\Compressed\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
