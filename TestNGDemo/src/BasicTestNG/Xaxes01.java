package BasicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Xaxes01 {
	WebDriver driver;
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Downloads\\Compressed\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Desktop/Book.html");
	}
	
	public void book(String BookName) {
		driver.findElement(By.xpath("//td[contains(text(),BookName)]/preceding-sibling::td/a")).click();
	}
	
	public static void main(String []args) {
		Xaxes01 x = new Xaxes01();
		x.setUp();
		x.book("Selenium RC");
		
	}
}
