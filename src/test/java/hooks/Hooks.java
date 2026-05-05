package hooks;

import com.qaplayground.base.DriverFactory;
import com.qaplayground.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks{
    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.capture(scenario.getName());
        }
        DriverFactory.quitDriver();
    }
}
