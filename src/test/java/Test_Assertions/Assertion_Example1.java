package Test_Assertions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Assertion_Example1 {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String payload="{\n" +
            "    \"firstname\" : \"Shivani\",\n" +
            "    \"lastname\" : \"sohal\",\n" +
            "    \"totalprice\" : 1113,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Shivani")
    @Description("TC#1--Verify Create booking")
    @Test
    public void CreateBooking()
    {
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.log().all().body(payload);

        response=r.when().log().all().post();

        vr=response.then()
                .statusCode(200);
        vr.body("booking.firstname", Matchers.equalTo("Shivani"));
        vr.body("booking.additionalneeds",Matchers.equalTo("Breakfast"));



    }
}
