package BasicTestNG;

import org.testng.annotations.Test;

public class Demo06_TestNG_Grouping {
	@Test(groups = { "car", "ecar" })            
    public void car() {
        System.out.println("Car");
    }
   @Test(groups = { "car", "sedan" })
    public void car1() {
        System.out.println("Car1");
    }
   @Test(groups = { "car" })
    public void car2() {
        System.out.println("Car2");
    }
	@Test(groups = { "bike", "ebike" })
	public void bike() {
	        System.out.println("Bike");
	}
	@Test(groups = { "bike" })
	public void bike1() {
		System.out.println("Bike1");
	}
	@Test(groups = { "bike" })
	public void bike2() {
		System.out.println("Bike2");
	}

}
