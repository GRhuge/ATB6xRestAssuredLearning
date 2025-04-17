package ex_27Jun2024_PayLoad_File;

import java.io.File;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab234 {
	RequestSpecification r = RestAssured.given();
	Response res;
	ValidatableResponse validResp;
	
	@Description("TC#1 - Verify that create booking is working with valid payload")
	@Test
	public void testNonBDDStylePOSTPositive() {
		String BASE_URL = "https://restful-booker.herokuapp.com";
		String BASE_PATH = "/booking";
		
		File file = new File("E:\\ABTB6x\\ATB6xRestAssured\\src\\test\\java\\ex_27Jun2024_PayLoad_File\\postReq.json");
		
		r.baseUri(BASE_URL);
		r.basePath(BASE_PATH);
		r.contentType(ContentType.JSON);
		r.log().all().body(file);
		  
		res=r.when().post();
		String responseString = res.asString();
		System.out.println(responseString);
		  
		validResp=res.then();
		validResp.statusCode(200);
	}
	
	@Description("TC#2 - verify that create booking is not working, with 500 Error")
	@Test
	public void testNonBDDStylePOSTNegative() {
		String BASE_URL = "https://restful-booker.herokuapp.com";
		String BASE_PATH = "/booking";
		String payload = "";
		
		r.baseUri(BASE_URL);
		r.basePath(BASE_PATH);
		r.contentType(ContentType.JSON);
		r.log().all().body(payload);
		  
		res = r.when().post();
		String responseString = res.asString();
		System.out.println(responseString);
		  
		validResp = res.then();
		validResp.statusCode(500);
	}
}
