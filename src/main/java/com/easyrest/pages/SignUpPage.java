package com.easyrest.pages;

import com.easyrest.config.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.easyrest.components.Calendar;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private By nameField = By.xpath("//input[@name='name']");
    private By emailField = By.xpath("//input[@name='email']");
    private By phoneNumberField = By.xpath("//input[@name='phoneNumber']");
    private By birthDateField = By.xpath("//input[@name='birthDate']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By confirmPasswordField = By.xpath("//input[@name='repeated_password']");
    private By createAccountButton = By.xpath("//span[text()='Create account']");
    private By signInInsteadButton = By.xpath("//span[text()='Sign in instead']");
    private By signInMenuButton = By.xpath("//span[text()='Sign In']");
    Calendar calendar = new Calendar(driver);

    /**
     * General methods
     */
    public SignUpPage goToSignInPage() {
        driver.get(ConfigProvider.signUpPageUrlMac);
        return this;
    }

    /**
     * Methods to find one element and fill one field
     */
    public SignUpPage inputName (String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage inputEmail (String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage inputPhone(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    public SignUpPage inputPassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        return this;
    }

    public void inputBirthDay(String year, String month, String date){
        driver.findElement(birthDateField).click();
        calendar.inputDate(year, month, date);
    }

    /**
     * Methods to click on element
     */
    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public void clickSignInInstead() {
        driver.findElement(signInInsteadButton).click();
    }

    public void clickSignInInMenu() {
        driver.findElement(signInMenuButton).click();
    }

}
