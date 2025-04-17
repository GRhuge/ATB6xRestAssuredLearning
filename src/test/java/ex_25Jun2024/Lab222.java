package ex_25Jun2024;

import org.testng.annotations.Test;

public class Lab222 {
	@Test
	public void serverStartedOk() {
		System.out.println("I will run first");
	}
	
	@Test(dependsOnMethods="serverStartedOk")
	public void method1() {
		System.out.println("method1");
	}
}
