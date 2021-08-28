package BaseClass;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClassFactory {

    protected static final String BASE_ENDPOINT = "https://github.com/";
    protected static final String GOOGLE_ENDPOINT = "https://google.com/";
    protected static final String MY_GITHUB = "https://github.com/DarshanCB/";
    protected static final String LOCAL_APP = "https://reqres.in/api/users?page=2";
    protected static final String NODE_JS = "http://localhost:3000";
    protected static final String USERS = "https://reqres.in/api/users";




}

