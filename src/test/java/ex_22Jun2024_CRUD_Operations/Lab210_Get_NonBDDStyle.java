package ex_22Jun2024_CRUD_Operations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Lab210_Get_NonBDDStyle {	
//	@Test
//	void getRequestPositive() {
//		RequestSpecification r = RestAssured.given();
//		r.baseUri("https://restful-booker.herokuapp.com");
//		r.basePath("/booking/2002").log().all();
//		r.when().get();
//		r.then().log().all().statusCode(200);
//	}
	
	@Test
	void getRequestNegative() {
		RequestSpecification r = RestAssured.given();
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/-1").log().all(); //here -1 is negative test case
		r.when().get();
		r.then().log().all().statusCode(404);
	}
}
