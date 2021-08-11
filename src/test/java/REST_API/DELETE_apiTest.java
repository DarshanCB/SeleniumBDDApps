package REST_API;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.entity.ContentType;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DELETE_apiTest {

    @Test
    public void DeleteTest()
    {
        when().
                delete("https://reqres.in/api/users/2").then().statusCode(204).
                log().all();
    }

}
