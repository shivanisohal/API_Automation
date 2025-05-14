package TestNG_Examples_Concepts;

import org.testng.annotations.Test;

public class Priority_Example {

    @Test(priority =2)
    public void T1()
    {
        System.out.println("T2");
    }
    @Test(priority = 1)
    public void T2()
    {
        System.out.println("T1");
    }
    @Test(priority =3)
    public void T3()
    {
        System.out.println("T3");
    }
}
