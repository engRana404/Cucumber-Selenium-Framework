package steps;

import com.qaplayground.base.DriverFactory;
import com.qaplayground.pages.LoginPage;
import com.qaplayground.utils.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps{
    LoginPage loginPage = new LoginPage();
    private final By WELCOME_MESSAGE = By.id("welcome-message");
    private final By USERNAME_ERROR = By.id("username-error");
    private final By PASSWORD_ERROR = By.id("password-error");

    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        loginPage.open();
    }

    @When("I enter credentials with username {string} and password {string}")
    public void iEnterCredentials(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirected() {
        // Wait for ANY success indicator (e.g., welcome message, dashboard element, etc.)
        WaitUtils.getWait().until(ExpectedConditions.or(
                ExpectedConditions.urlContains("dashboard"),
                ExpectedConditions.presenceOfElementLocated(WELCOME_MESSAGE)));
    }

    @Then("I should see an error message saying {string}")
    public void iShouldSeeError(String expected) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(expected));
    }

    @Then("I should see an error message saying {string} and {string}")
    public void iShouldSeeAnErrorMessageIndicatingThatFieldsCannotBeEmpty(String expectedUsernameError, String expectedPasswordError) {
        String actualUsernameError = DriverFactory.getDriver().findElement(USERNAME_ERROR).getText();
        String actualPasswordError = DriverFactory.getDriver().findElement(PASSWORD_ERROR).getText();
        Assert.assertEquals("Expected username error message: " + expectedUsernameError + " but got: " + actualUsernameError, expectedUsernameError, actualUsernameError);
        Assert.assertEquals("Expected password error message: " + expectedPasswordError + " but got: " + actualPasswordError, expectedPasswordError, actualPasswordError);
    }
}
