package TestNG_Examples_Concepts;

import org.testng.annotations.Test;

public class AlwaysRun_Example {

    @Test(enabled = false,priority = 1)
    public void test_Registration_1()
    {
        System.out.println("Registration done,thank you");
    }
@Test(priority = 2,alwaysRun = true,dependsOnMethods = "test_Registration_1")
    public void Login()
    {
        System.out.println("Login successfull");
    }

    @Test(priority = 3)
    public void Logout()
    {
        System.out.println("Logout");
    }
}
