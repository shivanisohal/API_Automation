package org.example;

import io.restassured.RestAssured;

public class API_Basic {
    public static void main(String[] args) {

        //builder pattern 
        RestAssured.
                given()
                    .baseUri("https://api.postalpincode.in/pincode/110001")
                .when()
                   .get()
                .then()
                   .log()
                   .all()
                   .statusCode(200);
    }
}
