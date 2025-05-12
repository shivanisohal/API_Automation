package GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDD_Example {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void Test_get_NonBDD_positive()
    {
        //given
        String pincode="177042";
        r= RestAssured.given();
        r.baseUri("http://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //when
        response=r.when().log().all().get();
        System.out.println(response.asString());

        //then
        vr=response.then().log().all().statusCode(200);
    }

    @Test
    public void Test_get_NonBDD_Negative()
    {
        //given
        String pincode="1770222242";
        r= RestAssured.given();
        r.baseUri("http://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //when
        response=r.when().log().all().get();
        System.out.println(response.asString());

        //then
        vr=response.then().log().all().statusCode(404);
    }
}
