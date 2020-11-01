package com.icanj.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver driver;

    public void launch() {
        // Create a new instance of the Chrome driver
        System.setProperty("webdriver.chrome.driver", "/home/jason/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://my.icanj.org/");
    }

    public void login(String userName, String password) {
        driver.findElement(By.id("j_username")).sendKeys(userName);
        driver.findElement(By.id("j_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        driver.manage().window().maximize();
    }

    public void logout() {
        driver.findElement(By.xpath("//a[contains(@href, \"/j_spring_security_logout\")]")).click();
        // Close all browser windows to end session
        driver.quit();
    }
}
