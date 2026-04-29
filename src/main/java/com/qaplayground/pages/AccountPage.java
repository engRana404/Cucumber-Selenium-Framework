package com.qaplayground.pages;

import com.qaplayground.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private By totalBalance = By.cssSelector("[data-testid='summary-total-balance']");

    public void open() {
        DriverFactory.getDriver().get("https://www.qaplayground.com/bank/accounts");
    }

    public String getTitle() {
        return DriverFactory.getDriver().getTitle();
    }

    public String isBalanceDisplayed() {
        WebDriver driver = DriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the balance element to be present before accessing it
        wait.until(ExpectedConditions.presenceOfElementLocated(totalBalance));
        return driver.findElement(totalBalance).getText();
    }
}
