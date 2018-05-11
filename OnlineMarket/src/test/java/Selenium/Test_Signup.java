package Selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class Test_Signup {

	@Test
	void test() {	
			System.setProperty("webdriver.chrome.driver", "G:/Programs/Selenium/chromedriver_win32/chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("http://localhost:8081/SWE-Project/SignUp.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.name("name")).sendKeys("Salma");
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys("Salma666");
			driver.findElement(By.name("email")).sendKeys("Salma@gmail.com");
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys("555");
			Select type = new Select(driver.findElement(By.name("type")));
			type.selectByIndex(2);
			
			driver.findElement(By.xpath("/html/body/div/div[2]/form/a/input")).click();
			
			
			String actualURL= driver.getCurrentUrl();
			String expectedUrl= "http://localhost:8081/SWE-Project/Buyer.html";
			Assert.assertEquals(expectedUrl, actualURL);
	}

}
