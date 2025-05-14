package TestNG_Examples_Concepts;

import org.testng.annotations.Test;

public class Enabled_Example {


    @Test(enabled = false)
    public void Test1()
    {
        System.out.println("Test 1 ");
    }
    @Test
    public void Test2()
    {
        System.out.println("Test 2");
    }
    @Test
    public void Test3()
    {
        System.out.println("Test3");
    }
}
