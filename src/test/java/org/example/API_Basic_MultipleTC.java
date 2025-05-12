package org.example;

import io.restassured.RestAssured;

public class API_Basic_MultipleTC {
    public static void main(String[] args) {

        String pincode="177042";
        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);


        pincode="@";
        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);


        pincode="4324324";
        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

        pincode=" ";
        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }
}
