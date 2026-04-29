package steps;

import com.qaplayground.base.DriverFactory;
import com.qaplayground.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps{
    LoginPage loginPage = new LoginPage();

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
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        // Wait for ANY success indicator (e.g., welcome message, dashboard element, etc.)
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("dashboard"),
                ExpectedConditions.presenceOfElementLocated(By.id("welcome-message"))));
    }

    @Then("I should see an error message saying {string}")
    public void iShouldSeeError(String expected) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(expected));
    }

    @Then("I should see an error message saying {string} and {string}")
    public void iShouldSeeAnErrorMessageIndicatingThatFieldsCannotBeEmpty(String expectedUsernameError, String expectedPasswordError) {
        String actualUsernameError = DriverFactory.getDriver().findElement(By.id("username-error")).getText();
        String actualPasswordError = DriverFactory.getDriver().findElement(By.id("password-error")).getText();
        Assert.assertEquals("Expected username error message: " + expectedUsernameError + " but got: " + actualUsernameError, expectedUsernameError, actualUsernameError);
        Assert.assertEquals("Expected password error message: " + expectedPasswordError + " but got: " + actualPasswordError, expectedPasswordError, actualPasswordError);
    }
}

