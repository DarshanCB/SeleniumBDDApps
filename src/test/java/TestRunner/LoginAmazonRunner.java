package TestRunner;


import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/loginPage.feature"},
        glue = {"StepDefinitions"},
        plugin = {"pretty", "json:reports/cucumber.json"},
        monochrome = true)
public class LoginAmazonRunner {
}
