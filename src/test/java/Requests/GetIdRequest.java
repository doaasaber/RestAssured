package Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetIdRequest {
    @Test
    public void GetId(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        Response createResponse=given().when().get("/posts/20").then().statusCode(200).extract().response();
        String expectedTitle="doloribus ad provident suscipit at";
        String expectedBody = "qui consequuntur ducimus possimus quisquam amet similique\nsuscipit porro ipsam amet\neos veritatis officiis exercitationem vel fugit aut necessitatibus totam\nomnis rerum consequatur expedita quidem cumque explicabo";
        int expectedUserId=2;
        given()
                .get("/posts/20")
                .then()
                .statusCode(200)
                .body("title", equalTo(expectedTitle))
                .body("body", equalTo(expectedBody))
                 .body("userId", equalTo(expectedUserId));

    }
}
