package Test_Page;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatAccount {
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,5000);
	
	static {
		WebDriverManager.chromedriver().setup();
	}
	public void waitTillVisible(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	@Test(enabled=false)
	public void test10() throws IOException, InterruptedException {
		driver.get("https://login.salesforce.com");
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("/Users/varunadamodaran/eclipse-workspace/TESTING/Login.properties");
		p.load(fis);
		String username = (String) p.get("username");
		String password = (String) p.get("password");
		System.out.println(p.get("username"));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();	
		driver.findElement(By.id("Account_Tab")).click();
		Thread.sleep(5000);
		waitTillVisible(driver.findElement(By.xpath("//h1[@class='pageType']")));
		Assert.assertEquals("Accounts", driver.findElement(By.xpath("//h1[@class='pageType']")).getText());
	}
	
	@Test(enabled=false)
	public void test11() throws InterruptedException, IOException {
		driver.get("https://login.salesforce.com");
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("/Users/varunadamodaran/eclipse-workspace/TESTING/Login.properties");
		p.load(fis);
		String username = (String) p.get("username");
		String password = (String) p.get("password");		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();	
		driver.findElement(By.id("Account_Tab")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='fFooter']/a[2]")).click();	
		driver.findElement(By.id("fname")).sendKeys("NewSelview");
		driver.findElement(By.id("devname")).sendKeys("");
		driver.findElement(By.name("save")).click();
		WebElement sel = driver.findElement(By.id("00B5Y00000BKZlg_listSelect"));
		Select so = new Select(sel);
		System.out.print(so.getFirstSelectedOption().getText());	
	}
	@Test(enabled=true)
	public void test12() throws IOException, Exception {
		driver.get("https://login.salesforce.com");
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("/Users/varunadamodaran/eclipse-workspace/TESTING/Login.properties");
		p.load(fis);
		String username = (String) p.get("username");
		String password = (String) p.get("password");		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();	
		driver.findElement(By.id("Account_Tab")).click();
		Thread.sleep(3000);
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='lbBody']/ul/li"));
		for(WebElement e:ls) {
			if(e.findElement(By.xpath(".//a")).getText().contains("Accounts with last activity > 30 days")) {
				e.findElement(By.xpath(".//a")).click();
				System.out.print("clicked:");
				driver.findElement(By.id("ext-gen152")).click();
				Thread.sleep(4000);
				/*
				WebElement tbody = driver.findElement(By.xpath("//table[@id='ext-gen268']"));
				List<WebElement> te = tbody.findElements(By.xpath(".//table[@class='x-date-inner']/tbody/tr"));
				
				for(WebElement row:te) {
					List<WebElement> days = row.findElements(By.xpath(".//td"));
					for(WebElement day:days) {
						if(day.getAttribute("title").contains("Today")) {
							System.out.print(day.getText());
							day.click();
							break;
						}
					}
				}*/
				
				driver.findElement(By.xpath("//td[contains(@class,'date-today')]")).click();				
				driver.findElement(By.xpath("//td[@class='x-btn-mc']")).click();
				waitTillVisible(driver.findElement(By.id("saveReportDlg")));
				driver.findElement(By.id("saveReportDlg_reportNameField")).sendKeys("newr1");
				driver.findElement(By.id("saveReportDlg_DeveloperName")).sendKeys("r877878786");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@id='dlgSaveReport']//button[contains(@class,' x-btn-text')]")).click();
				break;
			}
		}
	
	
	
	}
	
}
