package TestNG_Examples_Concepts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter_Example {


    @Parameters("browser")
    @Test
    public void test1(String value)
    {
        System.out.println("Test 1");
        if(value.equalsIgnoreCase("chrome"))
        {
            System.out.println("Start Chrome");
        }
        else
            System.out.println("Start firefox");

    }



}
