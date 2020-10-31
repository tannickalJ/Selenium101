package com.icanj.directory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IcanjDirectoryTest {
    private WebDriver driver;

    @Parameters({"user_name", "pass_word"})
    @BeforeTest(timeOut = 5000)
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
    public void paginationTest() {
        // Find hyperlink to "Directory" and click on it
        driver.findElement(By.xpath("//a[contains(@href,\"/Directory/Families\")]")).click();
        // Select a page number from the pagination selections at the bottom
        // And go through the list of listed church families
        driver.findElement(By.xpath("//*[@id=\"directory_paginate\"]/span/a[5]")).click();
        // Select the "More Info" button to access full info of the user or family
        driver.findElement(By.xpath("//*[@id=\"directory\"]/tbody/tr[6]/td[3]/button")).click();
        driver.navigate().back();
    }

    @Parameters({"search_user"})
    @Test
    public void searchTest(String searchUser) {
        // Find hyperlink to "Directory" and click on it
        driver.findElement(By.xpath("//a[contains(@href,\"/Directory/Families\")]")).click();
        // Type in the search box to search for a family member
        driver.findElement(By.xpath("//*[@id=\"directory_filter\"]/label/input")).sendKeys(searchUser);
        // Select the "More Info" button to access full info of the user
        driver.findElement(By.cssSelector("#directory > tbody > tr > td:nth-child(3) > button")).click();
        driver.navigate().back();
    }

    @AfterTest
    public void logout() {
        driver.findElement(By.xpath("//a[contains(@href, \"/j_spring_security_logout\")]")).click();
        // Close all browser windows to end session
        driver.quit();
    }
}



