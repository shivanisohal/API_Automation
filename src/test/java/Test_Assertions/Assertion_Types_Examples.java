package Test_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_Types_Examples {

    @Test(enabled = false)
    public void HardAssertion_Test()
    {
        System.out.println("Start of Program");
        Assert.assertEquals("shivani","Shivani");
        System.out.println("End of Program");
    }

    @Test
    public void softAssert_Test()
    {

        System.out.println("Start of Program");
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals("shivani","SHIVANI");
        System.out.println("End of Program");


    }
}
