package ex_25Jun2024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab221 {
	@Test(groups= {"sanity"})
	public void sanityRun() {
		System.out.println("Sanity");
		System.out.println("QA");
	}
	
	@Test(groups={"Reg"})
	public void regRun() {
		System.out.println("Reg");
	}
	
	@Test(groups= {"smoke"})
	public void SmokeRun() {
		System.out.println("Smoke");
		Assert.assertTrue(true);
	}
	
	@Test(groups= {"qa","prod"})
	public void QARun() {
		System.out.println("Smoke");
		Assert.assertTrue(true);
	}
	
	@Test(groups= {"prod"})
	public void ProdRun() {
		System.out.println("Smoke");
		Assert.assertTrue(true);
	}
}