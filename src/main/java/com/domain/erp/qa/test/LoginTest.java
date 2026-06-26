package com.domain.erp.qa.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;



import com.domain.erp.qa.pojo.LoginResponseData;
import com.domain.erp.qa.pojo.LoginResponseDatapojo;
import com.domain.erp.qa.pojo.request.LoginRequestpojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class LoginTest {

    static String token;
    static int userId;
    static String firstName;
static RequestSpecification requestspec;
static ResponseSpecification responsespec;
    @BeforeClass
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://www.shoppersstack.com/shopping";
    }

    @Test(priority=1)
    public void loginTest() {

        LoginRequestpojo request = new LoginRequestpojo(
                "baithulfarahh@gmail.com",
                "Nahlahali@25",
                "SHOPPER"
        );

        LoginResponseData response =
                given()
                        .contentType(ContentType.JSON)
                        .body(request)
                        .post("/users/login")
                .then()
                        .statusCode(200)
                        .body("message", equalTo("OK"))
                        .extract()
                        .as(LoginResponseData.class);

        token = response.getData().getJwtToken();
        userId = response.getData().getUserId();
       requestspec=new RequestSpecBuilder().addHeader("Authorization","Bearer "+token).setContentType(ContentType.JSON)
       .build();
       responsespec=new ResponseSpecBuilder().expectStatusCode(200)
    		   .expectResponseTime(lessThan(5000L)).build();

        System.out.println("Token     : " + token);
        System.out.println("User ID   : " + userId);}
        
        @Test(dependsOnMethods = {"loginTest"})
        public void getUserInfo() {
        	given(requestspec).pathParam("userId", userId).when().get("/shoppers/{userId}").then().spec(responsespec)
        	.body("data.userId",notNullValue());
        }
        @Test(dependsOnMethods = {"getUserInfo"})
        public void getproducts() {
        	given(requestspec)
        	.queryParam("zoneId", "Asia/Bahrain").when().get("/products").then().spec(responsespec).body("data", notNullValue());
        }
        @Test(dependsOnMethods = {"loginTest"})
        public void schemaValidation() {
            given(requestspec)
                .pathParam("userId", userId)
            .when()
                .get("/shoppers/{userId}")
            .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("Login_schema.json"));
        }}