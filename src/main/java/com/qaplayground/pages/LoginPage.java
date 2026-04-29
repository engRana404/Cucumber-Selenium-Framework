package com.qaplayground.pages;

import com.qaplayground.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-btn");
    private final By alertMessage = By.id("alert-message");

    public void open() {
        DriverFactory.getDriver().get("https://www.qaplayground.com/bank");
    }

    public void login(String user, String pass) {
        WebDriver driver = DriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for the username field to be present and visible before interacting
        wait.until(ExpectedConditions.presenceOfElementLocated(username));
        driver.findElement(username).sendKeys(user);
        
        // Wait for the password field to be present and visible
        wait.until(ExpectedConditions.presenceOfElementLocated(password));
        driver.findElement(password).sendKeys(pass);
        
        // Wait for the login button to be present and clickable
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
        return DriverFactory.getDriver().findElement(alertMessage).getText();
    }
}
