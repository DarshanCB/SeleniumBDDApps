package REST_API;

import TestNG_Functions.TestPriority;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestNG_Functions.UserManager;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.lang.reflect.Method;
import REST_Utilities.DuplicateUserException;
import TestNG_Functions.TestPriority.*;


public class TestNG implements TestPriority {

    UserManager um;
    CloseableHttpClient client;
    CloseableHttpResponse response;



    @BeforeMethod
    public void setUp(Method testMethod) throws IOException {
        String desc = testMethod.getAnnotation(Test.class).description();

        System.out.println("String test: " + testMethod.getName() + "with description" + desc);

        um = new UserManager();
        client = HttpClientBuilder.create().build();
        response = client.execute(new HttpGet("https://api.github.com/"));

        int status = response.getStatusLine().getStatusCode();
        if(status != 200){
            throw new SkipException("expecting 200 but got someting different");
        }
    }

    @Test(description = "Verify the response should return true", priority = MEDIUM)
    public void HardAssertStopsImmediately() throws IOException, InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);


    }

    @Test(description = "Git hub endpoint is validated", priority = HIGH)
    public void gitHubValidation() throws IOException {
        //Act
        response = client.execute(new HttpGet("https://github.com/DarshanCB"));
        int actualStatusCode = response.getStatusLine().getStatusCode();

        //Assert
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test(description = "   Soft assertion is needed in order to verify the user respectively", priority = MEDIUM)
    public void softAsset() throws IOException {


        SoftAssert sa = new SoftAssert();
        sa.assertEquals(response.getStatusLine().getStatusCode(), 404);
        sa.assertEquals(response.getStatusLine().getStatusCode(), 200);
        sa.assertEquals(response.getEntity().getContentType(), "Content-Type: application/json; charset=utf-8");
        sa.assertAll();


    }

    @Test(description = "Verify the added user method returns true successfully", priority = LOW)
    public void successfulAddUserReturnTrue() throws DuplicateUserException {
        //Arrange
        UserManager um = new UserManager();

        //Act
        boolean result = um.addUser("darshancbeceng@gmail.com");

        //Assert
        Assert.assertTrue(result);

    }

    @Test(description = "Get that desired user respectively", priority = LOW)
    public void getUserReturnExistingSavedUser() throws DuplicateUserException {
        //Arrange
        UserManager um = new UserManager();
        um.addUser("Vinay@gmail.com");
        //Act
        String user = um.getUser("Vinay@gmail.com");
        //Assert
        Assert.assertEquals(user, "Vinay@gmail.com");
    }

    @Test(description = "Non existing user must return Null", priority = LOW)
    public void getNonExistingUserReturnNull(){
        //Arrange
        //Act
        String user = um.getUser("Vinay@gmail.com");

        Assert.assertNull("The method should return null if it odes find the user", user);
    }



    @Test(description = "Duplicates found", priority = LOW)
    public void addDuplicateCustomexception() throws DuplicateUserException {
        um.addUser("darshancbecenggfzgz@gmail.com");
    }



    @Test(description = "Not a valid email address", expectedExceptions = DuplicateUserException.class, priority = LOW)
    public void NotavalidEmailandCheck() throws DuplicateUserException {
        um.addUser("darshancom");
    }

    @AfterMethod(alwaysRun = true, description = "Close the response connection once the response is created")
    public void cleanUp() throws IOException {
        client.close();
        response.close();
    }

}
