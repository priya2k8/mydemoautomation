import files.BaseClass;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

//this is an example of POST request not for put.
public class PutAutomation extends BaseClass {
    @Test
    public void addPlace(){
        //validate if Add Place API is working as expected
        //given - all input details
        //when - Submit the API
        //Then - validate the response
       //
//        //Update Place
//        String newaddress = "70 winter walk, USA";
//        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
//                .body("{\n" +
//                        "\"place_id\":\""+placeId+"\",\n" +
//                        "\"address\":\""+newaddress+"\",\n" +
//                        "\"key\":\"qaclick123\"\n" +
//                        "}").when().put("/maps/api/place/update/json")
//                .then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
  //Get Place
//       String getPlaceResponse= given().log().all().queryParam("key", "qaclick123")
//                .queryParam("place_id",placeId)
//                .when().get("/maps/api/place/get/json")
//                .then().assertThat().log().all().statusCode(200).extract().response().asString();
//        JsonPath js1 = new JsonPath(getPlaceResponse); //for parsing JSON
//        String actualAddress= js1.getString("address");
//        System.out.println(actualAddress);
//        Assert.assertEquals(actualAddress, newaddress);
    }
}
