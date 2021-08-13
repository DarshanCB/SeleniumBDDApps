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

public class PutPatchDeleteExamples extends BaseClassFactory {


    @Test
    public void testPUT(){
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
                put(LOCAL_APP + "/users/2").
                then().statusCode(200).log().all();

    }

    @Test
    public void testPATCH(){
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
                patch(LOCAL_APP + "/users/2").
                then().statusCode(200).log().all();

    }


}
