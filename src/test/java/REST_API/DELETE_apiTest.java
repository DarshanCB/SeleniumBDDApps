package REST_API;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class DELETE_apiTest {

    @Test
    public void DeleteTest()
    {
        when().
                delete("https://reqres.in/api/users/2").then().statusCode(204).
                log().all();
    }

}
