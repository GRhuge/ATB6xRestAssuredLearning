package ex_22Jun2024_CRUD_Operations;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Lab208_Get_BDD_Style {
	
	@Test
	public void getRequestBDDStyle() {
		given()
		 .baseUri("https://api.zippopotam.us")
		 .basePath("/IN/560037")
		
		.when()
		 .log().all()
		 .get()
		
		.then()
		 .log().all()
		 .statusCode(200);
	}
}
