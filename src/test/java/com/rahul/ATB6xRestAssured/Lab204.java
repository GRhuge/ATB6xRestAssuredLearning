package com.rahul.ATB6xRestAssured;

import io.restassured.RestAssured;

public class Lab204 {

	public static void main(String[] args) {
		RestAssured
		 .given()
		   .baseUri("https://restful-booker.herokuapp.com")
		   .basePath("/ping")
		 
		 .when() 
		   .get()
		   
		 .then().statusCode(201);
	}

}
