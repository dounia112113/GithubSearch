package utils;

import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.ResponseSpecification;

import static com.jayway.restassured.RestAssured.given;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * The GitHubUtilityMethods class that stores helpers methods.
 *
 * @author  Dounia Mdarhri Alaoui
 * @version 1.0
 * @since   2018-06-12
 */
public class GitHubUtilityMethods {
    /*
    Verify the http response status returned. Check Status Code is 200?
    We can use Rest Assured library's response's getStatusCode method
    */
    public static void checkStatusIs200 (Response res) {
        assertEquals("Status Check Failed!", 200, res.getStatusCode());
    }

    /*
     * Verifying the status code
     * Verifying the content type
     */
    public static ResponseSpecification checkStatusCodeAndContentType()
    {
        ResponseSpecification respSpec =
                new ResponseSpecBuilder().
                        expectStatusCode(200).
                        expectContentType(ContentType.JSON).
                        build();
        return respSpec;
    }

    public static void printSearchGitHubQuery(String query) {
        Header acceptHeader = new Header("Accept", "application/vnd.github.mercy-preview+json");
        Response resp = given().header(acceptHeader).
                when().
                get(query);
        ResponseBody body = resp.getBody();
        //Print the JSON message using the prettyPrint method
        System.out.println("Response Body is: " + body.prettyPrint());

    }


    //Checking the size of all queries

    public static void verifyResponseSize(String query){
        Header acceptHeader = new Header("Accept", "application/vnd.github.mercy-preview+json");
        Map response = given().header(acceptHeader).when().get(query).as(Map.class);
        // verify key is available the response is not empty
        assert response.containsKey("items");
        assert response.size() > 0;

    }
}

