package ex_25Jun2024;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab220 {
	@Test(groups= {"sanity"})
	public void sanityRun() {
		System.out.println("Sanity");
		System.out.println("QA");
	}
	
	@Test(groups={"Reg"})
	public void regRun() {
		System.out.println("Reg");
	}
	
	@Test
	public void SmokeRun() {
		System.out.println("Smoke");
		Assert.assertTrue(true);
	}
}
