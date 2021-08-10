package StepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

import javax.swing.*;

public class loginPage {

    WebDriver driver;
    String URL = "https://www.amazon.de/";

    @Given("^Launch chrome browser chrome$")
    public void launch_chrome_browser()  {
        try
        {

            System.setProperty("webdriver.chrome.driver", "/Users/darshancb/IdeaProjects/SeleniumBDDApps/chromedriver");
            driver = new ChromeDriver();
            driver.get(URL);
            driver.manage().window().maximize();
            Thread.sleep(4000);


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            driver.close();
        }
    }


    @Then("^Set the english language$")
    public void set_english_language() {
        try
        {
            driver.findElement(By.xpath("//*[@id='icp-nav-flyout']/span/span[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[2]/div/label/i")).click();
            driver.findElement(By.xpath("//*[@id=\"icp-btn-save\"]/span/input")).click();
            Thread.sleep(4000);
        }

        catch (Exception e)
        {

            System.out.println(e.getMessage());
            driver.close();

        }
    }


    @When("Click on the login page and login page of the Amazon portal should open {string}")
    public void clickLoginPage(String signin) {

        try
        {
            Actions action = new Actions(driver);
            WebElement loginelement = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
            action.moveToElement(loginelement).moveToElement(driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span"))).click().build().perform();
            String signinpage = driver.findElement(By.xpath("//*[@id='authportal-main-section']/div[2]/div/div[1]/form/div/div/div/h1")).getText();
            Assert.assertEquals(signinpage, signin);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
            driver.close();

        }

    }

    @Then("Input the valid user name {string}")
    public void validUserName(String user)
    {
        try
        {
            driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(user);
            driver.findElement(By.xpath("//*[@id='continue']")).click();
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            driver.close();
        }


    }

    @Then("Input the invalid username {string}")
    public void invaliduser(String invaluser) {
        try
        {
            driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(invaluser);
            driver.findElement(By.xpath("//*[@id='continue']")).click();
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            driver.close();
        }


    }


    @Then("validate the error message {string}")
    public void validateerrormsg(String errorval)
    {
        try
        {
            String errormsg = driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div/div/ul/li/span")).getText();
            Assert.assertEquals("Error message is not correct", errormsg, errorval);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            driver.close();
        }


    }


    @Then("Input the valid password {string}")
    public void validPassword(String pwd)
    {
        try
        {
            driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(pwd);
            driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            driver.close();
        }
    }


    @Then("Input the invalid password {string}")
    public void invalidpassword(String invalpwd)
    {
        try
        {
            driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(invalpwd);
            driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            driver.close();
        }



    }


    @Then("Validate password error message {string}")
    public void passwordErrormsg(String pwderror)
    {
        try
        {
            String errormsg = driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div/h4")).getText();
            Assert.assertEquals(errormsg, pwderror);
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            driver.close();
        }
    }

    @Then("Validate password error {string}")
    public void errorpassword(String errormsg)
    {
        try
        {
            String pwderror = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
            Assert.assertEquals(pwderror, errormsg);
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            driver.close();
        }

    }


    @Then("Click on the login button to open the amazon and Validate the user {string}")
    public void clickLoginbuttonValidateUser(String username)
    {
        try
        {
            String usernamevalidation = driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']")).getText();
            Assert.assertEquals(usernamevalidation, username);
            Thread.sleep(4000);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            driver.close();
        }
    }


    @Then("Close the browser")
    public void closeBrowser()
    {
        driver.close();
    }



}
