package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",
    glue = {"steps", "hooks"},
    plugin = {
        "pretty",
        "html:target/reports/cucumber-reports.html",
        "json:target/reports/cucumber-reports.json",
    }
    //tags = "@smoke"
)
public class TestRunner {
}

