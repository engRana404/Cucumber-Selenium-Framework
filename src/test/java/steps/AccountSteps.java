package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSteps {
    private WebDriverContext context;

    public AccountSteps(WebDriverContext context) {
        this.context = context;
    }

    @Given("I am on the account page")
    public void iAmOnTheAccountPage() {
        WebDriver driver = context.getDriver();
        driver.navigate().to("https://www.qaplayground.com/bank/accounts");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Then("the title should be {string}")
    public void theTitleShouldBe(String expectedTitle) {
        WebDriver driver = context.getDriver();
        String actualTitle = driver.getTitle();
        Assert.assertTrue("Expected title to contain: " + expectedTitle + " but got: " + actualTitle,
                actualTitle.contains(expectedTitle));
        driver.quit();
    }

    @Then("I should see my account details")
    public void iShouldSeeMyAccountDetails() {
        WebDriver driver = context.getDriver();
        String totalBalance = driver.findElement(By.cssSelector("[data-testid='summary-total-balance']")).getText();
        Assert.assertNotNull("Total balance should be displayed", totalBalance);
        driver.quit();
    }
}

