package Selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class DeleteProductStoreOWNER {

	@Test
	void test() {

		
		
		 System.setProperty("webdriver.chrome.driver", "G:/Programs/Selenium/chromedriver_win32/chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("http://localhost:8081/SWE-Project/Log%20In.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys("Fatma");
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys("123");
			
			driver.findElement(By.xpath("/html/body/div/div[2]/form/input[4]")).click();
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/form/input[1]")).clear();
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/form/input[1]")).sendKeys("s1");
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/form/input[2]")).clear();
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/form/input[2]")).sendKeys("product1");
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/form/input[3]")).click();
			
			String actualURL= driver.getCurrentUrl();
			String expectedUrl= "http://localhost:8081/SWE-Project/added.php";
			Assert.assertEquals(expectedUrl, actualURL);
	}

}
