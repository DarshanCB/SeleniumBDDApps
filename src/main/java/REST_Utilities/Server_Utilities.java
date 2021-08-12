package REST_Utilities;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.Arrays;
import java.util.List;



public class Server_Utilities {

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
}
