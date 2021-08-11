package TestRunner;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/calculator.feature"},
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:reports/CucumberCalculationReport.html"},
        monochrome = true)

public class CalculatorTestRunner
{

}