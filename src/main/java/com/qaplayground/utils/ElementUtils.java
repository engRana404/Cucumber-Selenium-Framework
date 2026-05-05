package com.qaplayground.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class ElementUtils {
    public static void click(By locator) {
        Objects.requireNonNull(WaitUtils.waitForElementClickable(locator)).click();
    }

    public static void type(By locator, String text) {
        WebElement element = WaitUtils.waitForElementVisible(locator);
        if (element == null) {
            throw new RuntimeException("Element not found: " + locator);
        }
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(By locator) {
        WebElement element = WaitUtils.waitForElementVisible(locator);
        if (element == null) {
            throw new RuntimeException("Element not found: " + locator);
        }
        return element.getText();
    }
}
