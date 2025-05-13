package TestBG_Examples_Concepts;

import org.testng.annotations.Test;

public class Grouping_Example {

    @Test(groups = {"sanity","reg"},priority = 1)
    public void sanity_run()
    {
        System.out.println("sanity");
    }
    @Test(groups = {"reg"},priority = 2)
    public void Regression_run()
    {
        System.out.println("Regression");
    }
    @Test(groups = {"smoke","reg"},priority = 3)
    public void smoke_run()
    {
        System.out.println("smoke");
    }
}
