package Payload_Managment.hashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Example1 {


    int bookingID;
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test
    public void Test1() {
//    {
//        "firstname" : "SIM",
//            "lastname" : "BrownNN",
//            "totalprice" : 1113,
//            "depositpaid" : true,
//            "bookingdates" : {
//        "checkin" : "2018-01-01",
//                "checkout" : "2019-01-01"
//    },
//        "additionalneeds" : "Breakfast"
//    }

        //---HasMap is a Key - Value pair
        Map<String, Object> jsonbodyUsingMAP = new LinkedHashMap<>();
        jsonbodyUsingMAP.put("firstname","Shivani");
        jsonbodyUsingMAP.put("lastname","sohal");
        jsonbodyUsingMAP.put("totalprice","1113");
        jsonbodyUsingMAP.put("depositpaid","true");


        Map<String, Object> bookingDateMAP =new LinkedHashMap<>();
        bookingDateMAP.put("checkin","2018-01-01");
        bookingDateMAP.put("checkout","2019-01-01");

        jsonbodyUsingMAP.put("bookingdates",bookingDateMAP);

        jsonbodyUsingMAP.put("additionalneeds","Breakfast");
        System.out.println(jsonbodyUsingMAP);


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.log().all().body(jsonbodyUsingMAP);

        response = r.when().log().all().post();
        System.out.println(response.prettyPrint());

        vr = response.then()
                .statusCode(200);
        vr.body("booking.firstname", Matchers.equalTo("Shivani"));
        vr.body("booking.additionalneeds", Matchers.equalTo("Breakfast"));
    }


}
