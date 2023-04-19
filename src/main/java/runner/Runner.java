package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featureFiles",
        glue = "steps",
        tags = "@HomePage",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter", "com.epam.reportportal.cucumber.ScenarioReporter"}
)
public class Runner {
}
