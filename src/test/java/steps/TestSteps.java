package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.pramcharan.wd.binary.downloader.WebDriverBinaryDownloader;
import io.github.pramcharan.wd.binary.downloader.enums.BrowserType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSteps {
    private WebDriver driver;

    @Before
    public void before() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase().trim()) {
            case "chrome":
                WebDriverBinaryDownloader.create().downloadLatestBinaryAndConfigure(BrowserType.CHROME);
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverBinaryDownloader.create().downloadLatestBinaryAndConfigure(BrowserType.FIREFOX);
                driver = new FirefoxDriver();
                break;
        }
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.write("Scenario failed so capturing a screenshot");

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            scenario.embed(screenshot.getScreenshotAs(OutputType.BYTES), "image/png");
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @When("^I navigate to (.*)$")
    public void iNavigateTo(String url) {
        driver.navigate().to(url);
    }

    @Then("^I verify the page title contains (.*)")
    public void iVerifyThePageTitleContainsGitHub(String expectedPageTitle) {
        final String actualPageTitle = driver.getTitle();

        if (!actualPageTitle.contains(expectedPageTitle)) {
            throw new RuntimeException(String.format("Expecting page title '%s' to be '%s'", actualPageTitle, expectedPageTitle));
        }
    }
}