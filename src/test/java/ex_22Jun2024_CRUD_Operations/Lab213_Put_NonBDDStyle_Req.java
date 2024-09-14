package ex_22Jun2024_CRUD_Operations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

public class Lab213_Put_NonBDDStyle_Req {
	
	RequestSpecification r = RestAssured.given();
	Response res;
	ValidatableResponse vr;
	
	String token = "af928576706eb9e";
	String bookingId = "2987";
	
	String BASE_URL = "https://restful-booker.herokuapp.com";
	String BASE_PATH = "/booking";
	
	@Test
	void testPutRequestNonBDD() {
		String BASE_PATH_UPDATED = BASE_PATH+"/"+bookingId;
		System.out.println(BASE_PATH_UPDATED);
		
		String payload = "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 108,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2024-01-01\",\r\n"
				+ "        \"checkout\" : \"2024-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast,Brunch\"\r\n"
				+ "}";
		
		r.baseUri(BASE_URL);
		r.basePath("BASE_PATH_UPDATED");
		r.contentType(ContentType.JSON);
		r.cookie("token",token);
		r.body(payload).log().all();
		
		res = r.when().put();
		
		vr = res.then().log().all();
		vr.statusCode(200);
		vr.body("firstname", Matchers.equalTo("James"));
		vr.body("lastname", Matchers.equalTo("Brown"));
	}
}
