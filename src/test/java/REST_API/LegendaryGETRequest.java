package REST_API;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LegendaryGETRequest {

    public static final String BASE_ENDPOINT = "https://github.com/";
    HttpClient client = HttpClientBuilder.create().build();

    @Test
    public void baseUrlReturns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        HttpResponse response = client.execute(get);

        int actualResponse = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualResponse, 200);
    }



}
