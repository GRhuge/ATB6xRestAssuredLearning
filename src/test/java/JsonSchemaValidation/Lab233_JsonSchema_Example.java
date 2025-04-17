package JsonSchemaValidation;

import org.testng.annotations.Test;
import java.io.File;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class Lab233_JsonSchema_Example {
	@Test
	public void JSValidation() {
		RestAssured.given()
		 .baseUri("https://jsonplaceholder.typicode.com/posts/2")
		 .when().get().then().assertThat()
		 .body(JsonSchemaValidator.matchesJsonSchema(new File("E:\\ABTB6x\\ATB6xRestAssured\\src\\test\\java\\JsonSchemaValidation\\schema.json")));
	}
}
