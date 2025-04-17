package ex_25Jun2024_Listeners;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class Lab227 {
	
	@Test(groups="sanity")
	public void test1() {
		System.out.println("test1");
		Assert.assertTrue(true);
	}
	
	@Test(groups="sanity")
	public void test2() {
		System.out.println("test2");
		Assert.assertTrue(true);
	}
	
	@AfterSuite
	public void emailToQALead() {
		System.out.println("After Suite Executing....\n");
		System.out.println("Sending Email\n");
	}
}
