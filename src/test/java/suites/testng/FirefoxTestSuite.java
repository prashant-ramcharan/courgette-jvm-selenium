package suites.testng;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.testng.TestNGCourgette;
import cucumber.api.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        showTestOutput = true,
        reportTargetDir = "build/firefox",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "steps",
                tags = {"@regression"},
                plugin = {"pretty",
                        "json:build/firefox/cucumber-report/cucumber.json",
                        "html:build/firefox/cucumber-report/cucumber.html"},
                strict = true
        ))
public class FirefoxTestSuite extends TestNGCourgette {
}