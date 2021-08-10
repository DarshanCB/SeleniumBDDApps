package StepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class NetflixLoginPageValidation {

    WebDriver driver;
    String URL = "https://www.netflix.com/de-en/";

    @Given("^Launch chrome browser$")
    public void launch_chrome_browser() throws Throwable{
        try
        {

            System.setProperty("webdriver.chrome.driver", "/Users/darshancb/IdeaProjects/SeleniumBDDApps/chromedriver");
            driver = new ChromeDriver();
            driver.get(URL);
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//*[@id=\"cookie-disclosure\"]/div[1]/button[1]")).click();

        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


    @When("^Input valid email \\\"(.*?)\\\"$")
    public void input_valid_email_darshancbeceng_gmail_com(String email)
    {
        driver.findElement(By.xpath("//*[@id=\"id_email_hero_fuji\"]")).sendKeys(email);
    }


    @Then("^Click on the getstarted button$")
    public void click_on_the_getstarted_button() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[2]/div[1]/div[2]/form/div/div/button/span[1]")).click();
        Thread.sleep(4000);
        boolean siginpage = driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[2]/div/form/div/div[1]/div/h1/span")).isDisplayed();
        Assert.assertTrue(siginpage);
    }

    @Then("^Input valid password \\\"(.*?)\\\"$")
    public void input_valid_password_qwER1234(String pwd)
    {
        driver.findElement(By.xpath("//*[@id=\"id_password\"]")).sendKeys(pwd);
        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[2]/div/form/div/div[4]/button")).click();
    }


    @When("^Next button should be displayed$")
    public void next_button_should_be_displayed()
    {
        String next_button = driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[2]/div/form/div/div[4]/button")).getText();
        Assert.assertEquals(next_button, "Next");
    }


    @Then("^Click on the next button$")
    public void click_on_the_next_button() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[2]/div/form/div/div[4]/button")).click();
        Thread.sleep(4000);
    }


    @When("^Choose your plan page should open \\\"(.*?)\\\"$")
    public void choose_your_plan_page_should_open(String pageval)
    {
       String plan_page_val = driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[2]/div/div[1]/div[2]/div/h1")).getText();
       System.out.println(plan_page_val);
       Assert.assertEquals(plan_page_val, pageval);
    }


    @Then("^Click on next button again$")
    public void click_on_next_button() throws Throwable
    {
        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[2]/div/div[2]/button")).click();
        Thread.sleep(3000);
    }


    @Then("^Planning page should open \\\"(.*?)\\\"$")
    public void planning_page_should_open(String plan)
    {
        String planning_page = driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/h1")).getText();
        Assert.assertEquals(planning_page, plan);
    }


    @And("^Close browser$")
    public void close_browser()
    {
        driver.close();
    }

}
