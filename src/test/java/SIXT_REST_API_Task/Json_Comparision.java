package SIXT_REST_API_Task;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import BaseClass.BaseClassFactory;
import REST_Utilities.Server_Utilities;
import TestNG_Functions.Utility;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;


public class Json_Comparision extends BaseClassFactory {

    Server_Utilities utils;
    CloseableHttpClient client;
    private static HttpURLConnection connection;

    @Test
    public void testresponse() throws IOException {
        Utility utils = new Utility();
        utils.InputFilePath("/Applications/Coding Challenge/File1.txt", "/Applications/Coding Challenge/File2.txt");

    }

    @Test
    public void response() throws IOException {

        baseURI = "https://reqres.in/api/users?page=3";
        String URL = "https://reqres.in/api/users?page=3";

        Response response1 = given().contentType(ContentType.JSON).get(baseURI);
        Response response2 = given().contentType(ContentType.JSON).get(URL);

        System.out.println(response1.getBody().equals(response2));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode1 = objectMapper.readTree(response1.getBody().asString());
        JsonNode jsonNode2 = objectMapper.readTree(response2.getBody().asString());

        Assert.assertTrue(jsonNode1.equals(jsonNode2));
        // Checking if both json objects are same
        System.out.println(jsonNode1.equals(jsonNode2));

    }
}
