package REST_Assured;

import BaseClass.BaseClassFactory;
import io.restassured.http.ContentType;
import org.apache.commons.collections.map.HashedMap;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class GET_POST_Examples extends BaseClassFactory {

    @Test
    public void testGET()
    {
        given().
                get(LOCAL_APP).
                then().
                statusCode(200).
                body("data[5].first_name", equalTo("Rachel")).
        body("data.first_name", hasItems("George", "Rachel"));

    }

    @Test
    public void testPOST(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Raghav");
        map.put("job", "Teacher");

        JSONObject request = new JSONObject(map);

        System.out.println(request);

        given().header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request).
                when().
                post(LOCAL_APP + "/users").
                then().statusCode(201).log().all();

    }



}
