package TestNG_Examples_Concepts;

import org.testng.annotations.Test;

public class Dependsupon_Example {

    @Test
    public void serverTestOk()
    {
        System.out.println("I will run first");
    }

    @Test(dependsOnMethods = "serverTestOk")
    public void Test1()
    {
        System.out.println("Testcase 1");
    }
}
