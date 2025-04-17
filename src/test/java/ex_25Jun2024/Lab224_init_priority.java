package ex_25Jun2024;

import org.testng.annotations.Test;

public class Lab224_init_priority {
	@Test(groups= {"init"},priority=1)
	public void getToken() {
		System.out.println("serverStartedOk");
	}
	
	@Test(groups= {"init"},priority=2)
	public void getBookingId() {
		System.out.println("initEnvironment");
	}
	
	@Test(dependsOnGroups= {"init.*"})
	public void testPutReq() {
		System.out.println("Now i will run");
	}
}
