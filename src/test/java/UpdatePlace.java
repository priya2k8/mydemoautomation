import files.BaseClass;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePlace extends BaseClass {
    public String updatedAddress = "";
    public static String newaddress = "70 winter walk, USA";
    public static String actualAddress = null;
    @Test(priority=0)
    public void updatePlace() throws InterruptedException {
        // RestAssured.baseURI = "https://rahulshettyacademy.com";

        String updatePlaceResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + newaddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").when().put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(updatePlaceResponse);
    }

    @Test(priority=1)
    public void getPlace() {
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        System.out.println();
        JsonPath js1 = new JsonPath(getPlaceResponse); //for parsing JSON
        actualAddress = js1.getString("address");
        System.out.println("actual address is "+actualAddress);
       Assert.assertEquals(actualAddress, newaddress);
    }
}

