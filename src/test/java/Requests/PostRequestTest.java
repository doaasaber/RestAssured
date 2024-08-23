package Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class PostRequestTest {
    @Test
    public void PostTest(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        JSONObject request = new JSONObject();
        request.put("title","foo");
        request.put("body","bar");
        request.put("userId",1);
        System.out.println(request.toJSONString());
        Response createResponse=given().body(request.toJSONString()).when().post("/posts").then().statusCode(201).extract().response();

        int ID = createResponse.path("id");
        given()
        .get("/posts/" + ID)
         .then()
         .statusCode(200)
         .body("title", equalTo("foo"))
         .body("body", equalTo("bar"));



    }
}
