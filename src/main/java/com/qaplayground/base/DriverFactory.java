package com.qaplayground.base;

import com.qaplayground.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        String  browser = ConfigReader.getProperty("browser");
        driver.set(BrowserFactory.createDriver(browser));
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}
