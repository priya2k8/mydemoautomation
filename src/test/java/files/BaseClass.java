package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BaseClass {

    public static String placeId = null;

    public void intilalize() {
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.AddPlace()).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
        System.out.println(response);//to print response in a string
        JsonPath js = new JsonPath(response); //for parsing JSON
        placeId = js.getString("place_id");
        System.out.println(placeId);
    }

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        intilalize();
    }
}