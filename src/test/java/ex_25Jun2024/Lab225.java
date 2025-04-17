package ex_25Jun2024;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab225 {
	// from line 8 to 15 we don't use this code in real life,
	// instead we use Apache POI code in real life - Apache POI read the excel file which contain data
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {
			new Object[] {"admin","admin"},
			new Object[] {"admin","password"},
			new Object[] {"admin","password123"}
		};
	}
	@Test(dataProvider="getData")
	public void testAuthToGetToken(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}
}
