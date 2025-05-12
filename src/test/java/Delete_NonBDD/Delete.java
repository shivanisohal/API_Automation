package Delete_NonBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Delete {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void DeleteTest()
    {
        String Bookingid="1979";
        String token="0d48d09fa3b839f";

        rs=RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+Bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.log().all();

        r=rs.when().log().all().delete();

        vr=r.then().log().all().statusCode(201);

    }
}
