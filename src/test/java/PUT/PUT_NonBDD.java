package PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PUT_NonBDD {


RequestSpecification r;
Response rs;
ValidatableResponse vr;

    @Test
    public void Test_Put_NonBDD()
    {
        String Bookingid="2547";
        String token="9bfee6b92eb2f30";
        String Payload="{\n" +
                "    \"firstname\" : \"shivani\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

      r= RestAssured.given();
      r.baseUri("https://restful-booker.herokuapp.com");
      r.basePath("/booking/"+Bookingid);
      r.contentType(ContentType.JSON);
     //r.auth().basic("basic","YWRtaW46cGFzc3dvcmQxMjM=");
      r.cookie("token",token);
      r.body(Payload).log().all();

      rs=r.when().log().all().put();

      vr=rs.then().log().all().statusCode(200);

    }


}
