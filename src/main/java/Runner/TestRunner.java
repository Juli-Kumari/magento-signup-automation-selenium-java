package Runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/resources/features/Signup.feature",
        glue = "StepDefinitions",
        monochrome = true,
        dryRun = true, // Enable dry run
        plugin = {
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "com.epam.reportportal.cucumber.ScenarioReporter"
        }
)
public class TestRunner {
}