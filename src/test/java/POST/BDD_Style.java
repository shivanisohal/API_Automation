package POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDD_Style {

    //https://restful-booker.herokuapp.com/auth


    @Test
    public void BDD_PostTest()
    {

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")

                     .contentType(ContentType.JSON)
                .log().all()
                     .body(payload)

                .when().log().all()
                     .post()

                .then().log().all()
                     .statusCode(200);


    }


}
