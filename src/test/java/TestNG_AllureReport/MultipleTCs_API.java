package TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;


//Add TESTNG Dependency also in Pom.xml file, where we added ResrAssured dependency as well
//Check dependency in External liabrary section > then Use Annotation @Test for Each Testcase
//No main method required

public class MultipleTCs_API {
    String pincode = "177042";

    @Test
    public void Testcase1_Positive() {
        String pincode = "177042";
        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }


    @Test
    public void Testcase2_Negative() {
        pincode = "@";
        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    public void Testcase3_Negative() {
        pincode = "4324324";
        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    public void Testcase4_Neagtive() {

        pincode = " ";
        RestAssured.given().baseUri("http://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}

