package BasicTestNG;

import org.testng.annotations.Test;

public class Demo03_TestNG_Dependencies {
		

	    @Test(dependsOnMethods = { "login" })
	    public void dashboard()
	    {
	        System.out.println("Dashboard Page");
	        System.out.println("hi");
	    }
	    
	    @Test
	    public void login() 
	    {
	        System.out.println("Code to login into the AUT");
	    }

	   @Test(dependsOnMethods = { "dashboard" })
	    public void logout() 
	    {
	        System.out.println("Logout from the application");
	    }
}
