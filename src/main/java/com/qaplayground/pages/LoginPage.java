package com.qaplayground.pages;

import com.qaplayground.base.DriverFactory;
import com.qaplayground.utils.ConfigReader;
import com.qaplayground.utils.ElementUtils;
import org.openqa.selenium.By;

public class LoginPage {
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-btn");
    private final By alertMessage = By.id("alert-message");

    public void open() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    public void login(String user, String pass) {
        ElementUtils.type(username, user);
        ElementUtils.type(password, pass);
        ElementUtils.click(loginBtn);
    }

    public String getErrorMessage() {
        return DriverFactory.getDriver().findElement(alertMessage).getText();
    }
}
