package ex_22Jun2024_CRUD_Operations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab216_FullCrud_Operation {
	
	@BeforeTest
	public void getToken() {
		System.out.println("1");
	}
	@BeforeTest
	public void getBookingId() {
		System.out.println("2");
	}
	@Test
	public void t3() {
		//token and bookingId
		System.out.println("3");
	}
}
