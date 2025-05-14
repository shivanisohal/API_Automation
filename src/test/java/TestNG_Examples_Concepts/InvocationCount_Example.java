package TestNG_Examples_Concepts;

import org.testng.annotations.Test;

public class InvocationCount_Example {


    @Test(invocationCount = 2)
    public void Test1()
    {
        System.out.println("Test1");
    }

    @Test
    public void Test2()
    {
        System.out.println("Test2");
    }
}
