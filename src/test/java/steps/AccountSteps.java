package steps;

import com.qaplayground.pages.AccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountSteps{
    AccountPage accountPage = new AccountPage();

    @Given("I am on the account page")
    public void iAmOnTheAccountPage() {
        accountPage.open();
    }

    @Then("the title should be {string}")
    public void verifyTitle(String expectedTitle) {
        Assert.assertTrue(accountPage.getTitle().contains(expectedTitle));
    }

    @Then("I should see my account details")
    public void verifyAccountDetails() {
        String balanceText = accountPage.isBalanceDisplayed();
        Assert.assertNotNull("Total balance should be displayed", balanceText);
        Assert.assertFalse("Total balance text should not be empty", balanceText.trim().isEmpty());
    }
}

