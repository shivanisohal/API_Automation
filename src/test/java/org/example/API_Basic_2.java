package org.example;

import io.restassured.RestAssured;

import java.util.Scanner;
import java.util.SortedSet;

public class API_Basic_2 {
    public static void main(String[] args) {

        System.out.println("Enter any Pincode=");
        Scanner sc=new Scanner(System.in);
        String pincode=sc.next();

        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}
