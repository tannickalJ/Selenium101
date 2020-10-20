package com.tannickalJ;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTest {
    private WebDriver driver;

    @Parameters({"user_name", "pass_word"})
    @BeforeTest
    public void launch() {
        // Create a new instance of the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://my.icanj.org/");
        driver.findElement(By.id("j_username")).sendKeys("user_name");
        driver.findElement(By.id("j_password")).sendKeys("pass_word");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
    }

    @Test
    public void icanjRegistration() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Find hyperlink to "Covid-19 Service Registration" and click on it
        driver.findElement(By.xpath("//a[contains(@href,\"/covid19/reservation/landing\")]")).click();
        // Scroll to user registration section to enable clickable checkbox function
        // The MyPledgeReport hyperlink is around where the registration section begins
        WebElement element = driver.findElement(By.linkText("My Pledge Report"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.id("guest-checkbox3")).click();
        // Scroll down to bottom to mark the agreement checkbox
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.id("attestCheckbox")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Reserve')]")).click();
    }

    @AfterTest
    public void logout() {
        driver.findElement(By.xpath("//a[contains(@href, \"/j_spring_security_logout\")]")).click();
        // Close all browser windows to end session
        driver.quit();
    }
}

