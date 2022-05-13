package demo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class BulkCn extends BaseClass {
        @Test(dataProvider = "BooksData")
        public void addBook(String Id) {
            String bearertoken = "Bearer " + accessToken;
            RestAssured.baseURI = "https://zoom-kubernetes.stg.rivigo.com/snow";
            Response resp = given().queryParam("id", Id).
                    header("appUuid", "e3eede03-84e0-497e-a18f-668f7c09263e").header("Authorization", bearertoken)
                    .header("Accept","*/*").header("Accept-Encoding","gzip, deflate, br")
                    .when().
                    post("/client-integration/bulk-upload/processCnCreation").
                    then().assertThat().log().all().statusCode(200).
                    extract().response();
        }
        @DataProvider(name = "BooksData")
        public Object[][] getData() {
            return new Object[][]{{"201"}};
        }
    }

