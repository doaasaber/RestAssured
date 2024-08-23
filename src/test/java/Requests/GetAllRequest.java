package Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashSet;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllRequest {
    @Test
    public void GetAllUsers(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        Response createResponse=given().when().get("/posts").then().statusCode(200).extract().response();
        List<?> posts = createResponse.jsonPath().getList("$");
        System.out.println(posts);
        int expectedSize=100;
        given().get("/posts").then()
                .statusCode(200)
                .assertThat()
                .body("size()", equalTo(expectedSize));
    }
}
