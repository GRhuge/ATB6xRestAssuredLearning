package ex_27Jun2024_WaysToCreatePayloadBody;
import java.util.LinkedHashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab229 {
	// PayloadUsingHashMap
	// POST Request - Payload - String
	
	//Below is the payload we want to send from line 8 to 18
	//"{\r\n"
	//+ "    \"firstname\" : \"Jim\",\r\n"
	//+ "    \"lastname\" : \"Brown\",\r\n"
	//+ "    \"totalprice\" : 111,\r\n"
	//+ "    \"depositpaid\" : true,\r\n"
	//+ "    \"bookingdates\" : {\r\n"
	//+ "        \"checkin\" : \"2018-01-01\",\r\n"
	//+ "        \"checkout\" : \"2019-01-01\"\r\n"
	//+ "    },\r\n"
	//+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
	//+ "}";
	
	@Test
	public void testPOSTReq() {
		Map<String,Object> jsonBodyUsingMap = new LinkedHashMap();
		Faker f = new Faker();
		String firstname = f.name().firstName();
		String lastname = f.name().lastName();
		
		jsonBodyUsingMap.put("firstname", firstname);
		jsonBodyUsingMap.put("lastname", lastname);
		jsonBodyUsingMap.put("totalprice", f.random().nextInt(1000));
		jsonBodyUsingMap.put("depositpaid", f.random().nextBoolean());
		
		Map<String,Object> bookingDatesMap = new LinkedHashMap();
		bookingDatesMap.put("checkin", "2018-01-01");
		bookingDatesMap.put("checkout", "2019-01-05");
		jsonBodyUsingMap.put("additionalneeds", "Breakfast");
		
		jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
		
		System.out.println(jsonBodyUsingMap);
		
		RequestSpecification r = RestAssured.given();
		Response res;
		ValidatableResponse validResp;
		
		String BASE_URL = "https://restful-booker.herokuapp.com";
		String BASE_PATH = "/booking";
		
		r.baseUri(BASE_URL);
		r.basePath(BASE_PATH);
		r.contentType(ContentType.JSON).log().all();
		r.log().all().body(jsonBodyUsingMap);
		
		res=r.when().log().all().post();
		String responseString = res.asString();
		System.out.println(responseString);
		
		validResp=res.then();
		validResp.statusCode(200);
	}
}
