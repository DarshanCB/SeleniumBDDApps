package REST_API;
import static io.restassured.RestAssured.*;

import BaseClass.BaseClassFactory;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.apache.http.entity.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class PUT_apiTest extends BaseClassFactory {

    @Test
    public void put_test()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject(map);
        request.put("firstName", "darshan");
        request.put("lastName", "Automation_Engineer");

        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(String.valueOf(ContentType.APPLICATION_JSON)).
                body(request.toJSONString()).
                when().
                put(NODE_JS + "/users/" + 11).then().statusCode(200).
                log().all();

    }
}
