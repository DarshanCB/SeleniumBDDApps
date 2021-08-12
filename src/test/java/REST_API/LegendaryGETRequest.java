package REST_API;

import BaseClass.BaseClassFactory;

import REST_Utilities.JsonReader;
import REST_Utilities.Server_Utilities;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.auth.Credentials;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import static org.testng.Assert.*;

import org.apache.http.util.EntityUtils;
import org.codehaus.plexus.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.json.Json;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class LegendaryGETRequest extends BaseClassFactory {

    Server_Utilities utils;
    CloseableHttpClient client;
    CloseableHttpResponse response;
    private static HttpURLConnection connection;


    @DataProvider
    private Object[][] endpoints() {
        return new Object[][]{
                {"/darshanfsfsvshshbbsh"},
                {"/users/dshshusbsjsjn"}
        };
    }


    @BeforeMethod
    public void setup()
    {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeresponse() throws IOException {
        client.close();
    }


    @Test
    public void baseUrlReturns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        HttpResponse response = client.execute(get);

        int actualResponse = response.getStatusLine().getStatusCode();
        assertEquals(actualResponse, 200);
    }

    @Test(dataProvider = "endpoints")
    public void baseUrlReturns400(String endpoint) throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + endpoint);
        HttpResponse response = client.execute(get);

        int actualResponse = response.getStatusLine().getStatusCode();
        assertEquals(actualResponse, 404);
    }

    @Test
    public void contentTypeIsJson() throws IOException
    {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        Header contentTyPe = response.getEntity().getContentType();

        assertEquals(contentTyPe.getValue(), "text/html; charset=utf-8");

        ContentType req = ContentType.getOrDefault(response.getEntity());

        assertEquals(req.getMimeType(), "text/html");

    }

    @Test
    public void sereverIsGitHub() throws Exception
    {
        HttpGet get = new HttpGet(BASE_ENDPOINT);

        response = client.execute(get);

        String header_value = getHeader(response, "Server");

        assertEquals(header_value, "GitHub.com");
    }

    @Test
    public void Check_X_limit() throws Exception
    {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        String limit_value = getHeaderJava8Way(response, "X-RateLimit-Limit");
        System.out.println(limit_value);
        assertEquals(limit_value, "60");
    }

    @Test
    public void headerPresence() throws Exception
    {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        assertTrue(headerIsPresent(response, "ETag"));

    }

    @Test
    public void rateLimitReturns200() throws IOException {
        HttpGet get = new HttpGet(GOOGLE_ENDPOINT );
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void JSON_reader() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/DarshanCB");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);
        System.out.println(jsonObject);

    }



    @Test
    public void returnCorrectLogin() throws IOException
    {
        BufferedReader reader;
        StringBuffer responsecontent = new StringBuffer();
        String line;
        String req;

        try {

            URL url = new URL(BASE_ENDPOINT);
            connection = (HttpURLConnection) url.openConnection();
            HttpGet get = new HttpGet(BASE_ENDPOINT + "/DarshanCB");
            response = client.execute(get);
            int status = response.getStatusLine().getStatusCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null)
                {
                    responsecontent.append(line);
                }
                reader.close();

            }
            else
            {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responsecontent.append(line);
                }
                reader.close();
            }

            //System.out.println(responsecontent.toString());
            Document doc = Jsoup.connect("http://GitHub.com/DarshanCB").get();
            doc.select("title").forEach(System.out::println);
            System.out.println(responsecontent.toString());

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }

    }

    @Test
    public void JSON_Request()
    {
        HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(GOOGLE_ENDPOINT)).build();
        client.sendAsync(request, java.net.http.HttpResponse.BodyHandlers.ofString()).
                thenApply(java.net.http.HttpResponse::body).
                thenAccept(System.out::println).
                join();


    }


    public static String JsonParse(String respBody){

        JSONArray githubresps = new JSONArray(respBody);
        String title = "";
        for(int i = 0; i< githubresps.length(); i++)
        {
            JSONObject githubrep = githubresps.getJSONObject(i);
            title = githubrep.getString("type");
        }

        return title;
        

    }

    @Test
    public void DeleteRepFromGitHUB() throws IOException {

        HttpDelete request = new HttpDelete("https://github.com/DarshanCB/deleteme");

        String auth = "darshancbeceng@gmail.com" + ":" + "**qwER1234##";
        byte [] encodeAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodeAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);


        //request.setHeader(HttpHeaders.AUTHORIZATION, "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");
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(actualStatusCode, 403);

    }

    @Test
    public void PostRequestGITHub() throws IOException
    {
        HttpPost request = new HttpPost("https://github.com/DarshanCB/deleteme");

        String auth = "darshancbeceng@gmail.com" + ":" + "**qwER1234##";
        byte [] encodeAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodeAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

        String json = "{\"name\": \"deletemeagain\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 201);
    }



    public String getHeader(CloseableHttpResponse response, String server) {

        //Get all header
        Header[] header = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(header);
        String returnHeader = "";

        for(Header headers: httpHeaders){
            if(server.equalsIgnoreCase(headers.getName()))
            {
                returnHeader = headers.getValue();
            }
        }

        if(returnHeader.isEmpty())
        {
            throw new RuntimeException("Did not find the haeder:" + server);
        }

        return returnHeader;


    }

    public String getHeaderJava8Way(CloseableHttpResponse response, final String headerName)
    {
        List<Header>  httpHeaders = Arrays.asList(response.getAllHeaders());

        Header matchedHeader = httpHeaders.stream().
                filter(header -> headerName.equalsIgnoreCase(header.getName())).
                findFirst().orElseThrow(() -> new RuntimeException("Didn't find the header"));

        return matchedHeader.getValue();
    }

    public boolean headerIsPresent(CloseableHttpResponse response, String headerName)
    {
        List<Header>  httpHeaders = Arrays.asList(response.getAllHeaders());

        return httpHeaders.stream().
                anyMatch(header -> header.getName().equalsIgnoreCase(headerName));
    }




}
