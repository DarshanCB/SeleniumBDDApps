package REST_API;

import BaseClass.BaseClassFactory;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LegendaryGETRequest extends BaseClassFactory {


    CloseableHttpClient client;
    CloseableHttpResponse response;



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
