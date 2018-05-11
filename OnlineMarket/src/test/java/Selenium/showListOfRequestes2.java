package Selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class showListOfRequestes2 {

	@Test
	void test() {
	
		 System.setProperty("webdriver.chrome.driver", "G:/Programs/Selenium/chromedriver_win32/chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("http://localhost:8081/SWE-Project/Log%20In.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys("Salma666");
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys("555");
			
			driver.findElement(By.xpath("/html/body/div/div[2]/form/input[4]")).click();
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/a/button")).click();
			driver.findElement(By.xpath("/html/body/div/form[1]/input[3]")).click();
		
			String actualURL= driver.getCurrentUrl();
			String expectedUrl= "http://localhost:8081/SWE-Project/added.php";
			Assert.assertEquals(expectedUrl, actualURL);
	}

}
