package TestNG_20Jun2024;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;

public class Lab205 {
	
	@Description("TC#1 - Verify GET Request")
	@Test
	void getRequest() {
		RestAssured
		 .given()
		   .baseUri("https://restful-booker.herokuapp.com")
		   .basePath("/ping")
		 
		 .when() 
		   .get().then().statusCode(201);
	}
	
	@Description("TC#2 - Verify GET Request2")
	@Test
	void getRequest2() {
		RestAssured
		 .given()
		   .baseUri("https://restful-booker.herokuapp.com")
		   .basePath("/ping")
		 
		 .when() 
		   .get().then().statusCode(201);
	}
}
