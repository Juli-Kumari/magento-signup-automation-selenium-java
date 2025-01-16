package Runner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/resources/features",
        tags = "@valid_registration",
        glue = "StepDefinitions", monochrome = true,
        plugin = {"html:target/cucumber.html", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty", "com.epam.reportportal.cucumber.ScenarioReporter"})
public class TestRunner {
}