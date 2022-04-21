//package demo;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import org.testng.annotations.*;
//
//public class BaseClas {
//    public static String accessToken = "";
//
//    public static String tokenURL = "https://login.stg.rivigo.com/sso/token";
//    public static String usr = "";
//    public static void generateTokens() {
//        String pwd = "Smoketest@zoom5";
//        String user = "smoke_oadelt1@rivigo.com";
//        String response = RestAssured
//                .given()
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("client_id", "sso")
//                .formParam("grant_type", "password")
//                .formParam("username", user)
//                .formParam("password", pwd)
//                .when().post(tokenURL)
//                .then().assertThat().log().all().statusCode(200).extract().response().asString();
//        JsonPath js = new JsonPath(response); //for parsing JSON
//        accessToken = js.getString("response.access_token");
//        JsonPath js5 = new JsonPath(response); //for parsing JSON
//        usr = js5.getString("response.username");}
//    @BeforeClass
//    public void setup() throws Exception {
//        generateTokens();
//    }
//
//
//}
