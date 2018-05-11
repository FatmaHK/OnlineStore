package Selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BuyProduct {

	@Test
	void test() {
		
		 System.setProperty("webdriver.chrome.driver", "G:/Programs/Selenium/chromedriver_win32/chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("http://localhost:8081/SWE-Project/Log%20In.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys("eee");
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys("555");
			
			driver.findElement(By.xpath("/html/body/div/div[2]/form/input[4]")).click();
			

			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys("eee");
			driver.findElement(By.name("productname")).clear();
			driver.findElement(By.name("productname")).sendKeys("product2");
			driver.findElement(By.name("storeName")).clear();
			driver.findElement(By.name("storeName")).sendKeys("s1");

			driver.findElement(By.name("shipingAddress")).clear();
			driver.findElement(By.name("shipingAddress")).sendKeys("e@com");
			
			driver.findElement(By.name("requiredAmount")).clear();
			driver.findElement(By.name("requiredAmount")).sendKeys("1");
		
			
			driver.findElement(By.xpath(	"/html/body/div/div[2]/form/input[6]")).click();
			
			
			
			
			String actualURL= driver.getCurrentUrl();
			String expectedUrl= "http://localhost:8081/SWE-Project/added.php";
			Assert.assertEquals(expectedUrl, actualURL);
	}

}
