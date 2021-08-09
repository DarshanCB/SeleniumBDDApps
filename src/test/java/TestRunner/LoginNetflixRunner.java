package TestRunner;


import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
glue = {"StepDefinitions"})
public class LoginNetflixRunner {
}
