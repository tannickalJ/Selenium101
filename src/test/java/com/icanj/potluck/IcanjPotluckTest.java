package com.icanj.potluck;

import com.icanj.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IcanjPotluckTest extends BaseClass {

    @Parameters({"user_name", "pass_word"})
    @Test
    public void potluckMenuTest(String userName, String password) {
        // First, launch the browser
        launch();
        // Then, a successful login must be made to continue
        login(userName, password);
        // Find hyperlink to "Potluck Menu Selection" and click on it
        driver.findElement(By.xpath("//a[contains(@href,\"/ThanksGiving\")]")).click();
        // Select a food item from the dropdown menu
        Select foodItem = new Select(driver.findElement(By.xpath("//*[@id=\"receiptManagement\"]/div[1]/div/select")));
        foodItem.selectByIndex(2);
        // Click "Select Item" button to confirm choice
       // driver.findElement(By.xpath("#receiptManagement > div.form-actions > button")).click();
        // Lastly, log out of session
        logout();
    }
}
