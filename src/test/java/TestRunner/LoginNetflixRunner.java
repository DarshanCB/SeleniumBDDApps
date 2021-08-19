package TestRunner;


import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/NetflixLoginPageValidation.feature"},
        glue = {"StepDefinitions"},
        plugin = {"pretty", "json:reports/LoginNetflix.json"},
        monochrome = true)

public class LoginNetflixRunner {
}
