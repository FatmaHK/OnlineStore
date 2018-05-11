package Selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class Test_addproduct{

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
			
			
			driver.findElement(By.name("sname")).clear();
			driver.findElement(By.name("sname")).sendKeys("s1");
			driver.findElement(By.name("pname")).clear();
			driver.findElement(By.name("pname")).sendKeys("product1");
			
			driver.findElement(By.name("price")).clear();
			driver.findElement(By.name("price")).sendKeys("52");
			driver.findElement(By.name("quantity")).clear();
			driver.findElement(By.name("quantity")).sendKeys("22");
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/form/input[5]")).click();
			String actualURL= driver.getCurrentUrl();
			String expectedUrl= "http://localhost:8081/SWE-Project/added.php";
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[5]/a")).click();
			Assert.assertEquals(expectedUrl, actualURL);
			
	}

}
