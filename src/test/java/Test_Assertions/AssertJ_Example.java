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
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class AssertJ_Example {


    int bookingID;
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String payload = "{\n" +
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
    public void CreateBooking() {
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.log().all().body(payload);

        response = r.when().log().all().post();

        // ✅ Print actual response
        String responseBody = response.prettyPrint(); // prints and stores
        //System.out.println("Stored Response: " + responseBody);

        vr = response.then()
                .statusCode(200);
        vr.body("booking.firstname", Matchers.equalTo("Shivani"));
        vr.body("booking.additionalneeds", Matchers.equalTo("Breakfast"));

// Extraction and Validation using TestNG

        bookingID=response.then().extract().path("bookingid");
        String firstname=response.then().extract().path("booking.firstname");
        String lastname=response.then().extract().path("booking.lastname");

        Assert.assertEquals(firstname,"Shivani");
        Assert.assertEquals(lastname,"sohal");
        Assert.assertNotNull(bookingID);


        //Assertj(3rd party Lib) - extraction
        // assertThat(bookingID).isNotZero().isNotNull().isNotPositive();
        assertThat(firstname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Shivani");


    }
}