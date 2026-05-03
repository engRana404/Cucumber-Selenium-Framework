package com.qaplayground.pages;

import com.qaplayground.base.DriverFactory;
import com.qaplayground.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        WaitUtils.waitForElementVisible(username);
        driver.findElement(username).sendKeys(user);

        WaitUtils.waitForElementVisible(password);
        driver.findElement(password).sendKeys(pass);
        
        WaitUtils.waitForElementClickable(loginBtn);
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
        return DriverFactory.getDriver().findElement(alertMessage).getText();
    }
}
