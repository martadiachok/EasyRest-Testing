package com.easyrest.tests;

import com.easyrest.constants.Constants;
import com.easyrest.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestTimePicker extends BaseTest {

    private final By hours = By.xpath("//span[contains(@class,'MuiPickersClockNumber-clockNumber')]");
    private final By hour = By.xpath("//h2[contains (@class, 'MuiPickersToolbarButton')][1]");
    private final By minute = By.xpath("//h2[contains (@class, 'MuiPickersToolbarButton')][3]");

    @Test
    public void test() {
    driver.get("http://localhost:3000/log-in");
    SignInPage signInPage = new SignInPage(driver);
    signInPage.inputEmail("stevenhall@test.com");
    signInPage.inputPassword("1111");
    signInPage.clickSignIn();
    driver.findElement(By.xpath("//span[text()='Watch Menu']")).click();

    List<WebElement> addToCartList = driver.findElements(By.xpath("//button[@aria-label='Add to cart']"));
    //addToCartList.get(0).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@aria-label='Show cart']")).click();
    driver.findElement(By.xpath("//span[text()='Submit order']")).click();
    driver.findElement(By.xpath("//*[text()='Time picker']/..")).click();

    List<WebElement> hoursList = driver.findElements(hours);
    //hoursList.get(2).click();

        for(int i = 0; i < hoursList.size(); i++){
            System.out.println(hoursList.get(i).getText());
        }

    }


}