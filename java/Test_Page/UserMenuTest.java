package Test_Page;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class UserMenuTest {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	static {
		WebDriverManager.chromedriver().setup();
	}
	@Test(enabled=false)
	public void tc05() {
		String username = "vd@yourcompany.com";
		String password = "Beacon2788";
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
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
	public void tc06() throws InterruptedException {
		String username = "vd@yourcompany.com";
		String password = "Beacon2788";
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		WebElement account = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userNavButton"))));
		account.click();
		List<WebElement> ls = new LinkedList<WebElement>();
		Thread.sleep(5000);
		ls = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		Iterator it = ls.iterator();
		while(it.hasNext()) {
			WebElement menuItem = (WebElement) it.next();
			System.out.println(menuItem.getText());
			if(menuItem.getText().contains("My Profile")){
				menuItem.click();
				System.out.println("Page title"+  driver.getTitle());
				wait.until(ExpectedConditions.titleContains("User:"));
				WebElement edit = driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch')]"));
				edit.click();
				Thread.sleep(5000);
				WebElement contactinfo = driver.findElement(By.id("contactInfo"));
				wait.until(ExpectedConditions.visibilityOf(contactinfo));
				driver.switchTo().frame("contactInfoContentId");
				WebElement about = driver.findElement(By.id("aboutTab"));
				about.click();
				driver.findElement(By.id("lastName")).clear();
				driver.findElement(By.id("lastName")).sendKeys("D");
				driver.findElement(By.xpath("//input[@value='Save All']")).click();
				String name = driver.findElement(By.id("tailBreadcrumbNode")).getAttribute("title");
				System.out.print(name);
				break;
			}
			
		}
		Actions a = new Actions(driver);
		WebElement photosection = driver.findElement(By.xpath("//div[@id='photoSection']"));
		a.moveToElement(photosection).build().perform();
		
	}
	
	@Test(enabled=false)
	public void tc07() throws InterruptedException {
		String username = "vd@yourcompany.com";
		String password = "Beacon2788";
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		WebElement account = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userNavButton"))));
		account.click();
		List<WebElement> ls = new LinkedList<WebElement>();
		Thread.sleep(2000);
		ls = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		Iterator it = ls.iterator();
		while(it.hasNext()) {
			WebElement menuItem = (WebElement) it.next();
			System.out.println(menuItem.getText());
			if(menuItem.getText().contains("My Settings")) {
				WebElement settings = menuItem;
				menuItem.click();
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("PersonalInfo")))).click();
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("LoginHistory_font")))).click();
				if(driver.findElement(By.className("bPageTitle")).getText().contains("Login History")){
					System.out.println("true");
					break;
				}
			}
		}
		/*
		driver.findElement(By.id("DisplayAndLayout")).click();
		driver.findElement(By.id("CustomizeTabs_font")).click();
		if(driver.findElement(By.xpath("//div[@class='content']//h1")).getText().contains("Customize My Tabs")) {
			Select so = new Select(driver.findElement(By.id("duel_select_0")));
			so.selectByValue("report");
			driver.findElement(By.xpath("//a[@id='duel_select_0_right']")).click();
		}
		Select so = new Select(driver.findElement(By.id("duel_select_1")));
		List<WebElement> ls1 = new LinkedList<WebElement>();
		ls1 = so.getOptions();
		for(WebElement e:ls1) {
			if(e.getAttribute("value").contains("report")) {
				System.out.print("Report is added");
			}
		}
		driver.findElement(By.id("bottomButtonRow")).click();
		
		driver.findElement(By.id("EmailSetup")).click();
		driver.findElement(By.id("EmailSettings_font")).click();
		driver.findElement(By.id("sender_name")).sendKeys("Varuna");
		driver.findElement(By.id("auto_bcc0")).click();
		driver.findElement(By.name("save")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("meSaveCompleteMessage"))));
		WebElement m = driver.findElement(By.id("meSaveCompleteMessage"));
		String message = m.findElement(By.xpath(".//div[@class='messageText']")).getText();
		System.out.print(message);
		*/
		driver.findElement(By.id("CalendarAndReminders")).click();
		driver.findElement(By.id("Reminders_font")).click();
		driver.findElement(By.id("testbtn")).click();
		Thread.sleep(3000);
		for(String win:driver.getWindowHandles()) {
			driver.switchTo().window(win);
			System.out.println("window title   "+ driver.getTitle());
			//driver.findElement(By.id("ids0")).click();
			if(driver.getTitle().contains("2 Reminders")) {
				System.out.print(driver.getTitle());
				driver.findElement(By.id("dismiss_all")).click();
			}
		}
		
	}
	
	@Test(enabled=true)
	public void tc08() throws InterruptedException {
		String username = "vd@yourcompany.com";
		String password = "Beacon2788";
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		WebElement account = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userNavButton"))));
		account.click();
		List<WebElement> ls = new LinkedList<WebElement>();
		Thread.sleep(2000);
		ls = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		Iterator it = ls.iterator();
		while(it.hasNext()) {
			WebElement menuItem = (WebElement) it.next();
			System.out.println(menuItem.getText());
			if(menuItem.getText().contains("Developer Console")){
				menuItem.click();
				for(String win:driver.getWindowHandles()) {
					driver.switchTo().window(win);
					System.out.println("window title   "+ driver.getTitle());
					//driver.findElement(By.id("ids0")).click();
					if(driver.getTitle().contains("Developer Console")) {
						System.out.print(driver.getTitle());
						driver.close();
						break;
					}
				}
			}
		}
	}
}
