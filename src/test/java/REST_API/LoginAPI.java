package REST_API;


import static io.restassured.RestAssured.*;

import BaseClass.BaseClassFactory;
import BaseClass.DataProviderTestClass;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginAPI extends BaseClassFactory {




    @Test
    void loginValidation()
    {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void TestMultipleContents(){
        given().get("https://reqres.in/api/users/").then().
                statusCode(200).
                body("data.email", hasItems("charles.morris@reqres.in",
                        "george.bluth@reqres.in", "janet.weaver@reqres.in",
                        "emma.wong@reqres.in", "eve.holt@reqres.in",
                        "charles.morris@reqres.in", "tracey.ramos@reqres.in"));
    }

    @Test(dataProvider = "myInputProvider", dataProviderClass = DataProviderTestClass.class)
    public void TestMultipleEmail(String email){
        given().get("https://reqres.in/api/users/").
                then().statusCode(200).
                body("data.email", hasItems(email));
    }





}
