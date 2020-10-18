package ua.pp.krotov;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		driver.get("https://my.icanj.org/");
		driver.findElement(By.id("j_username")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("j_password")).sendKeys("abc1234");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Find hyperlink to "Covid-19 Service Registration" and click on it
		driver.findElement(By.xpath("//a[contains(@href,\"/covid19/reservation/landing\")]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 1);
		// Scroll to user registration section to enable clickable checkbox function
		// The MyPledgeReport hyperlink is around where the registration section begins
		WebElement element = driver.findElement((By.linkText("My Pledge Report")));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.id("guest-checkbox3")).click();
		// Given time to double-check options before choice is made automatically
		Thread.sleep(4000);
		// Scroll down to bottom to mark the agreement checkbox
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.id("attestCheckbox")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Reserve')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href, \"/j_spring_security_logout\")]")).click();

		Thread.sleep(2000);
		// Close all browser windows to end session
		driver.quit();
	}

	}

