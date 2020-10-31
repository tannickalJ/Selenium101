package com.icanj.sponsorship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IcanjSponsorshipTest {
    private WebDriver driver;

    @Parameters({"user_name", "pass_word"})
    @BeforeTest
    public void launch(String userName, String password) {
        // Create a new instance of the Chrome driver
        System.setProperty("webdriver.chrome.driver", "/home/jason/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://my.icanj.org/");
        driver.findElement(By.id("j_username")).sendKeys(userName);
        driver.findElement(By.id("j_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        driver.manage().window().maximize();
    }

    @Test
    public void clickSponsor() {
        // Find hyperlink to "Directory" and click on it
        driver.findElement(By.xpath("//a[contains(@href,\"/Sponsor/serviceSponsorForm\")]")).click();
        // Choose which month and event to sponsor
        driver.findElement(By.cssSelector("#wrap > div.container-fluid > div.row-fluid > div.span9 > div > table > tbody > tr:nth-child(4) > td:nth-child(3) > a")).click();
        // Select the "Sponsor Event" button from the popup to confirm sponsorship
        driver.findElement(By.xpath("//*[@id=\"addConatct\"]/div[3]/button")).click();
        driver.navigate().back();
    }

    @AfterTest
    public void logout() {
        driver.findElement(By.xpath("//a[contains(@href, \"/j_spring_security_logout\")]")).click();
        // Close all browser windows to end session
        driver.quit();
    }
}
