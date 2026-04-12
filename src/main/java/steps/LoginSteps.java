package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver;
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("Expected URL: " + expectedUrl + " but got: " + actualUrl);
        }
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        driver.findElement(By.id("username")).sendKeys("incorrectUser");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = driver.findElement(By.id("error")).getText();
        if (!actualErrorMessage.equals(expectedErrorMessage)) {
            throw new AssertionError("Expected error message: " + expectedErrorMessage + " but got: " + actualErrorMessage);
        }
        driver.quit();
    }

    @When("I leave the username and password fields empty")
    public void iLeaveTheUsernameAndPasswordFieldsEmpty() {
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("submit")).click();
    }

    @Then("I should see an error message indicating that fields cannot be empty")
    public void iShouldSeeAnErrorMessageIndicatingThatFieldsCannotBeEmpty() {
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = driver.findElement(By.id("error")).getText();
        if (!actualErrorMessage.equals(expectedErrorMessage)) {
            throw new AssertionError("Expected error message: " + expectedErrorMessage + " but got: " + actualErrorMessage);
        }
        driver.quit();
    }
}
