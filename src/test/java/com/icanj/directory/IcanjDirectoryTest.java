package com.icanj.directory;

import com.icanj.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IcanjDirectoryTest extends BaseClass {

    @Parameters({"user_name", "pass_word"})
    @Test(priority = 1)
    public void paginationTest(String userName, String password) {
        // First, launch the browser
        launch();
        // Then, a successful login must be made to continue
        login(userName, password);
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
    @Test(priority = 2)
    public void searchTest(String searchUser) {
        // Find hyperlink to "Directory" and click on it
        driver.findElement(By.xpath("//a[contains(@href,\"/Directory/Families\")]")).click();
        // Type in the search box to search for a family member
        driver.findElement(By.xpath("//*[@id=\"directory_filter\"]/label/input")).sendKeys(searchUser);
        // Select the "More Info" button to access full info of the user
        driver.findElement(By.cssSelector("#directory > tbody > tr > td:nth-child(3) > button")).click();
        driver.navigate().back();
        // Lastly, log out of session
        logout();
    }

}



