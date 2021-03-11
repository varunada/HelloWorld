package Test_Page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpty {

	static WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,5000);
	
	static {
		WebDriverManager.chromedriver().setup();
		driver.get("https://login.salesforce.com");
		Properties p = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("/Users/varunadamodaran/eclipse-workspace/TESTING/Login.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String username = (String) p.get("username");
		String password = (String) p.get("password");
		System.out.println(p.get("username"));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();	
	}
	public void waitTillVisible(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	@Test
	public void test15() {
		
	}
}
