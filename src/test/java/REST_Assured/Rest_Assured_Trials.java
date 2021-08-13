package REST_Assured;

import BaseClass.BaseClassFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Rest_Assured_Trials extends BaseClassFactory {

    @Test
    public void test_apps()
    {

        given().get(LOCAL_APP).then().statusCode(200).
        body("data.id[1]", equalTo(8)).log().all();

    }


}
