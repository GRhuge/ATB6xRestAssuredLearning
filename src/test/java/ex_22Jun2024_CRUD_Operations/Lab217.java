package ex_22Jun2024_CRUD_Operations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;

public class Lab217 {
	
	RequestSpecification requestSpecification = RestAssured.given();
	Response response;
	ValidatableResponse validatableResponse;
	
	String token;
	String bookingId;
	
	@BeforeTest
	public void getAToken() {
		
		String payload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("auth");
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(payload);
		
		response = requestSpecification.post();
		
		validatableResponse = response.then();
		validatableResponse.statusCode(200);
		
		//Extract the Token
		token = response.then().log().all().extract().path("token");
		Assert.assertNotNull(token);
	}
	
	@BeforeTest
	public void getBookingId() {
		String payload = "{\r\n"
				+ "    \"firstname\": \"Krishna\",\r\n"
				+ "    \"lastname\": \"Brown\",\r\n"
				+ "    \"totalprice\": 108,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2024-01-01\",\r\n"
				+ "        \"checkout\": \"2024-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast,Brunch\"\r\n"
				+ "}";
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("/booking");
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(payload);
		
		response = requestSpecification.when().post();
		
		ValidatableResponse validatableResponse = response.then();
		String resString = response.asString();
		System.out.println(resString);
		
		validatableResponse.statusCode(200);
		
		//Extract bookingId
		bookingId = response.then().log().all().extract().path("bookingid");
		Assert.assertNotNull(bookingId);
	}
	
	@Test
	public void testPutRequestPositive() {
		//token and bookingId
		System.out.println("- Test case Put Request");
		
		String payload = "{\r\n"
				+ "    \"firstname\": \"Ram\",\r\n"
				+ "    \"lastname\": \"Brown\",\r\n"
				+ "    \"totalprice\": 108,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2024-01-01\",\r\n"
				+ "        \"checkout\": \"2024-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast,Brunch\"\r\n"
				+ "}";
		
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking/"+bookingId);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.cookie("token",token);
		requestSpecification.auth().oauth2("token");
		requestSpecification.body(payload).log().all();
		
		response = requestSpecification.when().put();
		String fullResponseJSONString = response.asString();
		System.out.println(fullResponseJSONString);
		
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
		
		String firstName = response.then().log().all().extract().path("firstname");
		Assert.assertEquals(firstName, "Ram");
		
		// verify all the value and key	pairs in response
		//i.e. firstname,lastname,deposit,checkin
		
		//4 ways we can verify the response
		
		//1.RestAssured - Matchers
		 validatableResponse.body("firstname",Matchers.equalTo("Ram"));
		
		//2.TestNG Asserts -
		// String firstName = response.then().log().all().extract().path("firstname");
		// Assert.assertEquals(firstName, "Ram");
		
		//3. TestNG Assertion with JSON Path library
		 JsonPath jp = new JsonPath(fullResponseJSONString);
		 String firstNameJSONPathExtracted = jp.getString("firstname");
		 String lastNameJSONPathExtracted = jp.getString("lastname");
		 String checkinDate = jp.getString("bookingdates.checkin");
		 Integer totalPriceJSONPathExtracted = jp.getInt("totalprice");
		 
		 Assert.assertEquals(firstNameJSONPathExtracted, "Ram");
		 Assert.assertEquals(lastNameJSONPathExtracted, "Brown");
		 Assert.assertEquals(totalPriceJSONPathExtracted, "108");
		 Assert.assertEquals(checkinDate, "2024-01-01");
		 
		 //4. AssertJ Matching
		 
		 assertThat(firstNameJSONPathExtracted).isEqualTo("Ram")
		 .isNotBlank().isNotEmpty();
		 
		 assertThat(totalPriceJSONPathExtracted).isNotZero()
		 .isNotNegative();
	}
}
