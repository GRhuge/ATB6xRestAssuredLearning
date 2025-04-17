package ex_25Jun2024;

import org.testng.annotations.Test;

public class Lab223_dependsOnMethods {
	@Test
	public void getToken() {
		System.out.println("I will run first");
	}
	
	@Test
	public void getBookingId() {
		System.out.println("I will run first");
	}
	
	@Test(dependsOnMethods= {"getToken","getBookingId"})
	public void getPUTMethod() {
		System.out.println("testPUT");
	}
	
	@Test(dependsOnMethods= {"getToken","getBookingId"})
	public void testDeleteRequest() {
		System.out.println("testPUT");
	}
}
