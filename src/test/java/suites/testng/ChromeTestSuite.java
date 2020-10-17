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
        reportTargetDir = "build/chrome",
        environmentInfo = "browser=chrome; project_info=Courgette-JVM is awesome!",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "steps",
                tags = {"@regression"},
                publish = true,
                plugin = {"pretty",
                        "json:build/chrome/cucumber-report/cucumber.json",
                        "html:build/chrome/cucumber-report/cucumber.html"}
        ))
public class ChromeTestSuite extends TestNGCourgette {
}