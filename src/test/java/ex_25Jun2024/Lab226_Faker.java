package ex_25Jun2024;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Lab226_Faker {
	
	@Test
	public void testDemo1() {
		Faker f = new Faker();
		String username = f.name().username();
		String phoneNumber = f.phoneNumber().phoneNumber();
		System.out.println(username);
		System.out.println(phoneNumber);
	}
}
