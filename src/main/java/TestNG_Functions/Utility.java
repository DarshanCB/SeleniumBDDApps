package TestNG_Functions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import static io.restassured.RestAssured.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static io.restassured.RestAssured.*;

public class Utility {

    private static void compareFile(List<String> list_file1, List<String> list_file2)
    {
        for(String content1:list_file1){
            for(String content2:list_file2){
                if(content1.equals(content2)){
                    System.out.println(content1 + "  equals  " + content2);
                }
                else
                {
                    System.out.println(content1 + "   not equals  " + content2);
                }
            }
        }
    }



    public void InputFilePath(String file1, String file2) throws IOException {
        BufferedReader b1 = null;
        BufferedReader b2 = null;

        List<String> list_file1 = null;
        List<String> list_file2 = null;



        String lineText = null;

        FileInputStream inputStream = null;
        Scanner sc1 = null;
        Scanner sc2 = null;
        try {


            FileInputStream inputStream1 = new FileInputStream(file1);
            sc1 = new Scanner(inputStream1, StandardCharsets.UTF_8);
            FileInputStream inputStream2 = new FileInputStream(file2);
            sc2 = new Scanner(inputStream2, StandardCharsets.UTF_8);
            while (sc1.hasNextLine() && sc2.hasNextLine())
            {
                compare_response(sc1.nextLine(), sc2.nextLine());
            }
            // note that Scanner suppresses exceptions
            if (sc1.ioException() != null) {
                throw sc1.ioException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            if (sc1 != null) {
                sc1.close();
            }
            if (sc2 != null) {
                sc2.close();
            }
        }



    }

    public void compare_response(String resp1, String resp2) throws JsonProcessingException {

        Response response1 = given().contentType(ContentType.JSON).get(resp1);
        Response response2 = given().contentType(ContentType.JSON).get(resp2);

        final ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode1 = objectMapper.readTree(response1.getBody().asString());
        JsonNode jsonNode2 = objectMapper.readTree(response2.getBody().asString());

        if(jsonNode1.equals(jsonNode2))
        {
            System.out.println(resp1 + "  equals  " + resp2);
        }
        else
        {
            System.out.println(resp1 + "  not equals  " + resp2);
        }
    }



}
