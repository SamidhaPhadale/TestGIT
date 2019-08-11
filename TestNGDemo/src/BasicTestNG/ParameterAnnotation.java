package BasicTestNG;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;


import org.testng.annotations.Parameters;

public class ParameterAnnotation {
	
		
	@BeforeClass
	  @Parameters({"browser","URL"})
	  public void Setup(@Optional("Chrome")String browser1,String url) {
	      System.out.println("Browser:"+browser1);
	      System.out.println("AUT Link: "+url);  
		  }
		  
	  @Test
	  public void test()  {
	     //business logic 
	  }  
		
		 
}
