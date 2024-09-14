package ex_22Jun2024_CRUD_Operations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Lab211_Post_BDDStyle_Request {
	
	@Test
	void testBDDStylePOSTPositive() { 
		//what required for POST request:-
		//URL
		//Body
		//Headers
		
		String BASE_URL = "https://restful-booker.herokuapp.com";
		String BASE_PATH = "/booking";
		String payload = "{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		RestAssured
		 .given()
		  .baseUri(BASE_URL)
		  .basePath(BASE_PATH)
		  .contentType(ContentType.JSON)
		  .log().all().body(payload)
		  
		 .when()
		  .post()
		  
		 .then()
		  .log()
		  .all()
		  .statusCode(200);
	}
}