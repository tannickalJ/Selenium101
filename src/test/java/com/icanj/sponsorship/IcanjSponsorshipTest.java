package com.icanj.sponsorship;

import com.icanj.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IcanjSponsorshipTest extends BaseClass {

    @Parameters({"user_name", "pass_word"})
    @Test
    public void clickSponsor(String userName, String password) {
        // First, launch the browser
        launch();
        // Then, a successful login must be made to continue
        login(userName, password);
        // Find hyperlink to "Sponsorship" and click on it
        driver.findElement(By.xpath("//a[contains(@href,\"/Sponsor/serviceSponsorForm\")]")).click();
        // Choose which month and event to sponsor
        driver.findElement(By.cssSelector("#wrap > div.container-fluid > div.row-fluid > div.span9 > div > table > tbody > tr:nth-child(4) > td:nth-child(3) > a")).click();
        // Select the "Sponsor Event" button from the popup to confirm sponsorship
        driver.findElement(By.xpath("//*[@id=\"addConatct\"]/div[3]/button")).click();
        driver.navigate().back();
        // Lastly, log out of session
        logout();
    }
}
