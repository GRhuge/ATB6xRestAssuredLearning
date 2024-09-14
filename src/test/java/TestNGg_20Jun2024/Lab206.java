package TestNGg_20Jun2024;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;

public class Lab206 {
	
	@Description("TC#1")
	@Test
	public void testCase() {
		
//		SoftAssert s = new SoftAssert();
//		s.assertEquals("hari", "Hari","not equal");
//		System.out.println("end of program");
//		s.assertAll();
		
		Assert.assertEquals("hari", "Ram");
		System.out.println("end of the program");
	}
}
