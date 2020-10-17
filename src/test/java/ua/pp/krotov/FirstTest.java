package ua.pp.krotov;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FirstTest {
	
	private WebDriver driver;
	//private String name;


//	private void getName() throws ParserConfigurationException, IOException, SAXException {
////		Scanner scanner = new Scanner(System.in);
////		System.out.println("Enter the name to be registered: ");
////		name = scanner.nextLine();
//
//		File file = new File("pom.xml");
//		DocumentBuilderFactory doc = DocumentBuilderFactory.newInstance();
//		DocumentBuilder documentBuilder = doc.newDocumentBuilder();
//		Document document = documentBuilder.parse(file);
//		String user = document.getElementsByTagName("names").item(0).getTextContent();
//		name = user;
//	}

	@BeforeClass // Runs this method before the first test method is run
	public void launch() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the name to be registered: ");
//		name = scanner.nextLine();
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1) // Marking this method as part of the test
	public void gotoIcanjPage() throws InterruptedException {

		driver.get("https://my.icanj.org/");
		driver.findElement(By.id("j_username")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("j_password")).sendKeys("abc1234");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		// Wait for page to load
		// TODO: find a better way for page to load in Selenium
		Thread.sleep(4000);
	}

	@Test(priority = 2)
	public void serviceRegistration() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value ="";
		String elementId ="";

		// Find hyperlink to "Covid-19 Service Registration" and click on it
		driver.findElement(By.xpath("//a[contains(@href,\"/covid19/reservation/landing\")]")).click();
		Thread.sleep(4000);
		// Scroll to user registration section to enable clickable checkbox function
		// The MyPledgeReport hyperlink is around where the registration section begins
		WebElement element = driver.findElement((By.linkText("My Pledge Report")));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);


		// Choose user using web element id
//		List<WebElement> elements = driver.findElements(By.className("input-large search-query"));
//		for (int i = 0; i < elements.size(); i++) {
//			value = elements.get(i).getAttribute("value");
//			if (name.equalsIgnoreCase(value)) {
//				elementId = elements.get(i).getAttribute("id");
//				break;
//			}
//		}
//		driver.findElement(By.id(elementId)).click();


		driver.findElement(By.id("guest-checkbox3")).click();
		Thread.sleep(4000);
		// Scroll down to bottom to mark the agreement checkbox
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.id("attestCheckbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Reserve')]")).click();
		Thread.sleep(4000);
	}

	@Test(priority = 3)
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(@href, \"/j_spring_security_logout\")]")).click();
		Thread.sleep(2000);
	}

//	@Test // Marking this method as part of the test
//	public void gotoIcanjPageFailure() {
//		// Go to the Wikipedia home page
//		driver.get("https://my.icanj.org/");
//		// Find the email input box and type in username
//		driver.findElement(By.id("j_username")).sendKeys("tannickal@yahoo.com");
//		// Find the password input box and type in password
//		driver.findElement(By.id("j_password")).sendKeys("Janice254");
//		// Click sign in button
//		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
//		String header = driver.findElement(By.xpath("//h3[contains(text(),'Latest Podcasts')]")).getText();
//		// Verify there is a header called "Latest Podcasts" after successful login
//		Assert.assertEquals(header, "Latest Podcasts");
//	}

	@AfterClass // Runs this method after all the test methods in the current class have been run
	public void closeScreen() {
		// Close all browser windows and safely end the session
		driver.quit();
	}

}
