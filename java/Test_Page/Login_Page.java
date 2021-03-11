package Test_Page;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Page {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	static {
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void test_case1() throws InterruptedException {		
		Actions builder = new Actions(driver);		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
	}
	@Test(enabled=false)
	public void test_case2() {
		String username = "vd@yourcompany.com";
		String password = "Beacon2788";
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();		
	}
	@Test(enabled=false)
	public void test_case3() {
		String username = "vd@yourcompany.com";
		String password = "Beacon2788";
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("rememberUn")).click();
		
		
		driver.findElement(By.id("Login")).click();
		WebElement account = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userNav"))));
		account.click();
		List<WebElement> ls = new LinkedList<WebElement>();
		ls = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		Iterator it = ls.iterator();
		while(it.hasNext()) {
			WebElement menuItem = (WebElement) it.next();
			if(menuItem.getText().contains("Logout")){
				menuItem.click();
			}	
		}
	}
	@Test(enabled=false)
	public void test_case4a() {
		System.out.print("Page title:"+driver.getTitle());
		WebElement forgotPwd = driver.findElement(By.id("forgot_password_link"));
		forgotPwd.click();
		
		wait.until(ExpectedConditions.urlContains("forgotpassword"));
		WebElement header =  driver.findElement(By.xpath("//h2[@id='header']"));
		System.out.print("Page title:"+driver.getTitle());
		String username = "vd@yourcompany.com";
		driver.findElement(By.id("un")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		wait.until(ExpectedConditions.titleContains("Check Your Email"));
		System.out.print("Page title:"+driver.getTitle());
		String message = driver.findElement(By.className("message")).getText();
		System.out.println(message);
	}
	@Test
	public void test_case4b() {
		String username = "123";
		String password = "22131";
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		String message = driver.findElement(By.xpath("//div[@id='error']")).getText();
		System.out.print(message);
	}
}
