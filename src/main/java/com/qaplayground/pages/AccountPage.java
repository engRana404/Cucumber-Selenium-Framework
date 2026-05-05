package com.qaplayground.pages;

import com.qaplayground.base.DriverFactory;
import com.qaplayground.utils.ConfigReader;
import com.qaplayground.utils.ElementUtils;
import org.openqa.selenium.By;

public class AccountPage {
    private final By totalBalance = By.cssSelector("[data-testid='summary-total-balance']");

    public void open() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("accountUrl"));
    }

    public String getTitle() {
        return DriverFactory.getDriver().getTitle();
    }

    public String isBalanceDisplayed() {
        return ElementUtils.getText(totalBalance);
    }
}
