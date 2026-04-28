package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private WebDriverContext context;

    public LoginSteps(WebDriverContext context) {
        this.context = context;
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.qaplayground.com/bank");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        context.setDriver(driver);
    }

    @When("I enter credentials with username {string} and password {string}")
    public void iEnterCredentialsWithUsernameAndPassword(String username, String password) {
        WebDriver driver = context.getDriver();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-btn")).click();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        WebDriver driver = context.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for ANY success indicator (e.g., welcome message, dashboard element, etc.)
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("dashboard"),
                ExpectedConditions.presenceOfElementLocated(By.id("welcome-message"))
        ));

        String url = driver.getCurrentUrl();

        Assert.assertTrue("Login might have failed. Current URL: " + url, 
                url.contains("dashboard"));
        driver.quit();
    }

    @Then("I should see an error message saying {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        WebDriver driver = context.getDriver();
        String actualErrorMessage = driver.findElement(By.id("alert-message")).getText();
        Assert.assertTrue("Expected: " + expectedErrorMessage + " but got: " + actualErrorMessage,
                actualErrorMessage.contains(expectedErrorMessage));
        driver.quit();
    }

    @Then("I should see an error message saying {string} and {string}")
    public void iShouldSeeAnErrorMessageIndicatingThatFieldsCannotBeEmpty(String expectedUsernameError, String expectedPasswordError) {
        WebDriver driver = context.getDriver();
        String actualUsernameError = driver.findElement(By.id("username-error")).getText();
        String actualPasswordError = driver.findElement(By.id("password-error")).getText();
        Assert.assertEquals("Expected username error message: " + expectedUsernameError + " but got: " + actualUsernameError,
                expectedUsernameError, actualUsernameError);
        Assert.assertEquals("Expected password error message: " + expectedPasswordError + " but got: " + actualPasswordError,
                expectedPasswordError, actualPasswordError);
        driver.quit();
    }
}

