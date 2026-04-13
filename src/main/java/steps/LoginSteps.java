package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.qaplayground.com/bank");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @When("I enter credentials with username {string} and password {string}")
    public void iEnterCredentialsWithUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-btn")).click();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for ANY success indicator (e.g., welcome message, dashboard element, etc.)
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("dashboard"),
                ExpectedConditions.presenceOfElementLocated(By.id("welcome-message"))
        ));

        String url = driver.getCurrentUrl();

        assertTrue(url.contains("dashboard"),
                "Login might have failed. Current URL: " + url);
        driver.quit();
    }

    @Then("I should see an error message saying {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.id("alert-message")).getText();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Expected: " + expectedErrorMessage + " but got: " + actualErrorMessage);
        driver.quit();
    }

    @Then("I should see an error message saying {string} and {string}")
    public void iShouldSeeAnErrorMessageIndicatingThatFieldsCannotBeEmpty(String expectedUsernameError, String expectedPasswordError) {
        String actualUsernameError = driver.findElement(By.id("username-error")).getText();
        String actualPasswordError = driver.findElement(By.id("password-error")).getText();
        assertEquals(expectedUsernameError, actualUsernameError,
                "Expected username error message: " + expectedUsernameError + " but got: " + actualUsernameError);
        assertEquals(expectedPasswordError, actualPasswordError,
                "Expected password error message: " + expectedPasswordError + " but got: " + actualPasswordError);
        driver.quit();
    }
}
