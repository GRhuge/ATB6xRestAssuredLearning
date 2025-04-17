package ex_22Jun2024_CRUD_Operations;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab215_Delete_NonBDDStyle_Req {
	RequestSpecification r = RestAssured.given();
	Response res;
	ValidatableResponse vr;
	
	
	String token = "d17e887569a3470";
	String bookingId = "225";
	
	String BASE_URL = "https://restful-booker.herokuapp.com";
	String BASE_PATH = "/booking";
	
	@Test
	public void testDeleteRequestNonBDD() {
		String BASE_PATH_UPDATED = BASE_PATH+"/"+bookingId;
		System.out.println(BASE_PATH_UPDATED);
		
		String payload = "{\r\n"
				+ "    \"firstname\" : \"Krishna\"\r\n"
				+ "}";
		
		r.baseUri(BASE_URL);
		r.basePath("BASE_PATH_UPDATED");
     	r.contentType(ContentType.JSON);
		r.cookie("token",token);
		r.log().all();
		
		res = r.when().log().all().delete();
		
		vr = res.then().log().all();
		
	}
}
