package REST_API;

import BaseClass.BaseClassFactory;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class JSONschemaValidator extends BaseClassFactory {

    @Test(priority = 2)
    public void testGet()
    {
        given().get(LOCAL_APP).then().
                assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George", "Rachel"));


    }

    @Test(priority = 1)
    public void TestGet()
    {
        given().when().get(USERS).
                then().statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                assertThat().
                body("data[4].first_name", equalTo("Charles"));

    }
}
