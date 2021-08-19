package StepDefinitions;

import cucumber.api.java.en.*;
import cucumber.api.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.function.Supplier;
import java.util.function.Consumer;


public class CalculationSteps {

    Calculator calculator;
    Integer result;

    @Given("I have a calculator")
    public void i_have_a_calculator()
    {
        calculator = new Calculator();

    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer a, Integer b) {
       result = Calculator.add(a, b);
    }

    @Then("I should get {int}")
    public void i_should_get(Integer c) {
        Assert.assertEquals(c, result);
    }

}
