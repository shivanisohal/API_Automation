package POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDD_Example {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vs;

    @Test
    public void Test_NonBDD_Post()
    {
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

//Part 1 - GIVEN
        rs=RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");

        rs.contentType(ContentType.JSON);
        rs.log().all().body(payload);

//Part 2 - When
        response=rs.when().log().all().post();

//Part 3 - Then

        vs=response.then().log().all();
        vs.statusCode(200);



    }

}
