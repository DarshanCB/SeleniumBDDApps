package REST_API;


import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginAPI {

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
    void apivalidation(){
        given().get("https://reqres.in/api/users?page=2").then().
                statusCode(200).body("data.id[0]", equalTo(7));
    }

}
