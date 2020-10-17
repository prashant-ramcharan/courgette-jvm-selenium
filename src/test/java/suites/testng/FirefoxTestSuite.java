package suites.testng;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CucumberOptions;
import courgette.api.testng.TestNGCourgette;
import org.testng.annotations.Test;

@Test
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        showTestOutput = true,
        reportTargetDir = "build/firefox",
        environmentInfo = "browser=firefox; project_info=Courgette-JVM is awesome!",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "steps",
                tags = {"@regression"},
                publish = true,
                plugin = {"pretty",
                        "json:build/firefox/cucumber-report/cucumber.json",
                        "html:build/firefox/cucumber-report/cucumber.html"}
        ))
public class FirefoxTestSuite extends TestNGCourgette {
}