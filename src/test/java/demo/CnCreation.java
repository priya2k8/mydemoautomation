package demo;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class CnCreation extends BaseClass {
    public static String fromAddressId = "";
    public static String toAddressId = "";
    public static String CNOte = "";
    public static String barcodes1 = "";
    public static String prsID = "";
    public static String task = "";
    public static String vehicleNO = "";
    @Test(priority = 0)
    public void getToAddress() {
        test = extent.createTest("getToAddress");
        RestAssured.baseURI = baseURL;
        //   System.out.println(accessToken);
        String bearertoken = "Bearer " + accessToken;
        String toaddress = given().header("Authorization", bearertoken)
                .header("Content-Type", "application/json")
                .body(Payload.AddDetail())
                .when().post("/backend/master/client_address")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath js2 = new JsonPath(toaddress); //for parsing JSON
        toAddressId = js2.getString("payload.id");
        test.log(Status.INFO, "ToAddress ID fetch");
    }
    @Test(priority = 1)
    public void fromToAddress() {
        test = extent.createTest("fromToAddress");
        RestAssured.baseURI = baseURL;
        //   System.out.println(accessToken);
        String bearertoken = "Bearer " + accessToken;
        String fromAddress = given().header("Authorization", bearertoken)
                .header("Content-Type", "application/json")
                .body(Payload.AddDetail())
                .when().post("/backend/master/client_address")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath js1 = new JsonPath(fromAddress); //for parsing JSON
        fromAddressId = js1.getString("payload.id");
        test.log(Status.INFO, "FromAddress ID fetch");
    }
    @Test(priority = 2)
    public void cnCreation() {
        test = extent.createTest("cnCreation");
        RestAssured.baseURI = baseURL;
        //   System.out.println(accessToken);
        String bearertoken = "Bearer " + accessToken;
        String fromAddress = given().log().all().header("Authorization", bearertoken)
                .header("Content-Type", "application/json")
                .body(Payload.BikeCN())
               // .body(Payload.RetailNormalCN())
               // .body(Payload.CorporateCN())
                .when().post("/backend/operations/consignments")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath js4 = new JsonPath(fromAddress);
//   System.out.println(js3.getString("payload"));
//    System.out.println("Json file ::::----- ");
        CNOte = js4.getString("payload.cnote");
        System.out.println("CNOte is :- \"" + CNOte + "\"");
        barcodes1 = js4.getString("payload.barcodes[0]");
        System.out.println("Barcode is :-\"" + barcodes1 + "\"");
        prsID = js4.getString("payload.prsId");
        System.out.println("PRS is :- \"" + prsID + "\"");
        vehicleNO = js4.getString("payload.vehicleNumber");
        System.out.println("Vehicle Number is :-\"" + vehicleNO + "\"");
        //  Assert.assertEquals(cnote, CNOte);
        test.log(Status.INFO, "Creating Trip");
    }
    //    @Test(priority = 3)
//    public void markedReached() {
//        //Marked CN's reached on OU
//        test = extent.createTest("markedReached");
//        String bearertoken = "Bearer " + accessToken;
//        RestAssured.baseURI = baseURL;
//        given().queryParam("prsId", prsID).header("Authorization", bearertoken)
//                .when().put("backend/operations/pickupRunSheet/markReached")
//                .then().log().all().assertThat().statusCode(200).extract().response().asString();
//    }
//    @Test(priority = 4)
//    public void prsUnloading() {
//        //Unloading of CN (Assign to PA/OA)
//        test = extent.createTest("prsUnloading");
//        String bearertoken = "Bearer " + accessToken;
//        RestAssured.baseURI = baseURL;
//        given().log().all().queryParam("prsId", prsID).header("Authorization", bearertoken)
//                .header("Content-Type", "application/json")
//                .header("Accept", "*/*")
//                .header("User-Agent", "PostmanRuntime/7.28.4")
//                .header("accept-encoding", "gzip, deflate, br")
//                .body("{\n" +
//                        "    \"vehicleNumber\": \"" + vehicleNO + "\",\n" +
//                        "    \"prsId\": " + prsID + ",\n" +
//                        "    \"taskUserEmailMap\": {\n" +
//                        "        \"PA\": [\n" +
//                        "            \"smoke_oadelt1@rivigo.com\"\n" +
//                        "        ],\n" +
//                        "        \"OA\": []\n" +
//                        "    },\n" +
//                        "    \"dockNumber\": \"1\"\n" +
//                        "}")
//                .when().put("/backend/operations/pickupRunSheet/assignUnloading")
//                .then().log().all().assertThat().statusCode(200).extract().response().asString();
//    }
    }
