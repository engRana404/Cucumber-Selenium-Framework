package com.qaplayground.pages;

import com.qaplayground.base.DriverFactory;
import com.qaplayground.utils.WaitUtils;
import org.openqa.selenium.By;

public class AccountPage {
    private final By totalBalance = By.cssSelector("[data-testid='summary-total-balance']");

    public void open() {
        DriverFactory.getDriver().get("https://www.qaplayground.com/bank/accounts");
    }

    public String getTitle() {
        return DriverFactory.getDriver().getTitle();
    }

    public String isBalanceDisplayed() {
        WaitUtils.waitForElementVisible(totalBalance);
        return DriverFactory.getDriver().findElement(totalBalance).getText();
    }
}
