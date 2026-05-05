package com.qaplayground.utils;

import com.qaplayground.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final int TIMEOUT_SECONDS = Integer.parseInt(ConfigReader.getProperty("timeout"));

    public static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    public static WebElement waitForElementVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForUrlContains(String text) {
        getWait().until(ExpectedConditions.urlContains(text));
    }
}
