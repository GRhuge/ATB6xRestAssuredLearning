package ex_22Jun2024_CRUD_Operations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Lab209_Get_NonBDDSytle {

	@Test
	public void getRequestNonBDDStyle() {
		
		RequestSpecification rs = RestAssured.given();
		rs.baseUri("https://api.zippopotam.us");
		rs.basePath("/IN/560037");
		rs.when().get();
		rs.then().log().all().statusCode(200);
	}
}