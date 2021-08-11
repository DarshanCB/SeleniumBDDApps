package REST_API;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.testng.annotations.Test;

public class GET_apiTest {

    @Test
    public void loginGETTest()
    {
        given().header("Content-Type", "application/json").
                get("https://reqres.in/api/users?page=2").then().
                statusCode(200).body("data.id[1]", equalTo(8)).
        body("data.first_name", hasItems("Michael", "Lindsay"));
    }

    @Test
    public void githubGETRequest()
    {
        given().header("Content-Type", "application/json").
                get("https://github.com/").then().
                statusCode(200).log().all();
    }

}
