package com.qaplayground.utils;

import com.qaplayground.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final int TIMEOUT_SECONDS = Integer.parseInt(ConfigReader.getProperty("timeout"));

    public static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    public static void waitForElementVisible(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementClickable(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForUrlContains(String text) {
        getWait().until(ExpectedConditions.urlContains(text));
    }
}
