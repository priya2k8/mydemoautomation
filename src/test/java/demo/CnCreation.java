package demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static files.BaseClass.placeId;
import static io.restassured.RestAssured.given;
import static java.lang.System.currentTimeMillis;
public class CnCreation extends BaseClass {
    public static String fromAddressId = "";
    public static String toAddressId = "";
    public static String CNOte = "";
    public static String barcodes1 = "";
    public static String prsID = "";
    public static String vehicleNO = "";
    private String cnote;
    private String cnotebarcode;

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
    }

    @Test(priority = 2)
    public void cnCreation() {
        test = extent.createTest("cnCreation");
        RestAssured.baseURI = baseURL;
        //   System.out.println(accessToken);
        String bearertoken = "Bearer " + accessToken;
        String cnote = "" + (long) (Math.random() * 100000 + 3333300000L);
        String cnotebarcode = "" + (long) (Math.random() * 100000 + 3333300000L);
        String time = String.valueOf(currentTimeMillis());
        String fromAddress = given().log().all().header("Authorization", bearertoken)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": null,\n" +
                        "    \"cnoteType\": \"NORMAL\",\n" +
                        "    \"cnote\": \"" + cnote + "\",\n" +
                        "    \"clientCode\": \"" + client_code + "\",\n" +
                        "    \"serviceType\": \"ZOOM\",\n" +
                        "    \"gstNumber\": null,\n" +
                        "    \"fromPinCode\": \"" + FromPin + "\",\n" +
                        "    \"toPinCode\": \"" + ToPin + "\",\n" +
                        "    \"totalBoxes\": \"" + numberOfBoxes + "\",\n" +
                        "    \"weight\": \"1\",\n" +
                        "    \"volume\": null,\n" +
                        "    \"value\": null,\n" +
                        "    \"bookingDateTime\": " + time + " ,\n" +
                        "    \"consignorAddress\": \"test\",\n" +
                        "    \"consignorAddressId\":\"" + fromAddressId + "\",\n" +
                        "    \"consignorEmail\": \"testunibic@gmail.com\",\n" +
                        "    \"consignorPhone\": \"9971639104\",\n" +
                        "    \"consigneeAddress\": \"sdfv dvervev sc\",\n" +
                        "    \"consigneeAddressId\":\"" + toAddressId + "\",\n" +
                        "    \"consigneeEmail\": null,\n" +
                        "    \"consigneePhone\": \"12313131313\",\n" +
                        "    \"contents\": \"Chemicals\",\n" +
                        "    \"consignorName\": \"test\",\n" +
                        "    \"consigneeName\": \"Rivigo costumer\",\n" +
                        "    \"consignmentDocumentDtoList\": [\n" +
                        "        {\n" +
                        "            \"document\": \"GST Invoice / Delivery Challan\",\n" +
                        "            \"status\": \"NOT_PICKED_UP\",\n" +
                        "            \"minInvoiceValue\": null,\n" +
                        "            \"documentType\": \"GSTIN number\",\n" +
                        "            \"order\": 99\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"document\": \"CN consignee copy\",\n" +
                        "            \"status\": \"NOT_PICKED_UP\",\n" +
                        "            \"minInvoiceValue\": null,\n" +
                        "            \"order\": 2\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"document\": \"CN POD copy\",\n" +
                        "            \"status\": \"NOT_PICKED_UP\",\n" +
                        "            \"minInvoiceValue\": null,\n" +
                        "            \"order\": 1\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"packing\": \"Bundle\",\n" +
                        "    \"barcodeType\": \"PRE_PRINTED\",\n" +
                        "    \"barcodes\": [\n" +
                        "        " + cnotebarcode + "\n" +
                        "    ],\n" +
                        "    \"isDacc\": null,\n" +
                        "    \"invoices\": [\n" +
                        "        {\n" +
                        "            \"invoiceId\": null,\n" +
                        "            \"invoiceNo\": \"1\",\n" +
                        "            \"invoiceValue\": \"1\",\n" +
                        "            \"eWaybillNumber\": \"\",\n" +
                        "            \"hsnCodes\": null\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"volumeDetails\": [\n" +
                        "        {\n" +
                        "            \"unit\": \"IN\",\n" +
                        "            \"breadth\": \"1\",\n" +
                        "            \"height\": \"1\",\n" +
                        "            \"numberOfBoxes\": \"1\",\n" +
                        "            \"length\": \"1\",\n" +
                        "            \"volume\": 0.0006\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"valueAddedServicesDTO\": null,\n" +
                        "    \"paymentDetailsDTO\": null,\n" +
                        "    \"gstDetailsDTO\": null,\n" +
                        "    \"taxId\": null,\n" +
                        "    \"taxIdType\": null,\n" +
                        "    \"trackerDTO\": {\n" +
                        "        \"deviceIdType\": \"IP\",\n" +
                        "        \"deviceType\": \"ZOOM_OPS\"\n" +
                        "    },\n" +
                        "    \"openPopupTime\": 1573037386291,\n" +
                        "    \"allIssuesResolved\": true,\n" +
                        "    \"billingEntity\": \"UNIBIC FOODS INDIA PVT LTD.\",\n" +
                        "    \"vehicleNumber\": \"" + Payload.VehicleNo() + "\",\n" +
                        "    \"consignmentCodDodDTO\": null,\n" +
                        "    \"deliveryType\": \"NORMAL\",\n" +
                        "    \"completionStatus\": \"COMPLETE\"\n" +
                        "}")
                .when().post("/backend/operations/consignments")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath js4 = new JsonPath(fromAddress);
//   System.out.println(js3.getString("payload"));
//    System.out.println("Json file ::::----- ");
        CNOte = js4.getString("payload.cnote");
        System.out.println("CNOte is :- \"" + CNOte + "\"");
//        barcodes1 = js4.getString("payload.barcodes[0]");
//        System.out.println("Barcode is :-\"" + barcodes1 + "\"");
        prsID = js4.getString("payload.prsId");
        System.out.println("PRS is :- \"" + prsID + "\"");
        vehicleNO = js4.getString("payload.vehicleNumber");
        System.out.println("Vehicle Number is :-\"" + vehicleNO + "\"");
        //  Assert.assertEquals(cnote, CNOte);
    }

//    @Test(priority = 3)
//    public void markedReached() {
//        //Marked CN's reached on OU
//        test = extent.createTest("markedReached");
//        String bearertoken = "Bearer " + accessToken;
//        RestAssured.baseURI = baseURL;
//        given().queryParam("prsId", prsID).header("Authorization", bearertoken)
//                .when().put("/backend/operations/pickupRunSheet/markReached")
//                .then().log().all().assertThat().statusCode(200).body("status", equalTo("SUCCESS"));
//
//
//    }
//    @Test(priority = 4)
    public void prsUnloading(){
        //Unloading of CN (Assign to PA/OA)
        test = extent.createTest("prsUnloading");
        String bearertoken = "Bearer " + accessToken;
        RestAssured.baseURI = baseURL;
        given().log().all().queryParam("prsId", prsID).header("Authorization", bearertoken)
                .header("Content-Type","application/json")
                .header("Accept","*/*")
                .header("User-Agent","PostmanRuntime/7.28.4")
                .header("accept-encoding","gzip, deflate, br")
                .body("{\n" +
                        "    \"vehicleNumber\": \""+vehicleNO+"\",\n" +
                        "    \"prsId\": "+prsID+",\n" +
                        "    \"taskUserEmailMap\": {\n" +
                        "        \"PA\": [\n" +
                        "            \"smoke_oadelt1@rivigo.com\"\n" +
                        "        ],\n" +
                        "        \"OA\": []\n" +
                        "    },\n" +
                        "    \"dockNumber\": \"1\"\n" +
                        "}")
                .when().put("/backend/operations/pickupRunSheet/assignUnloading")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
    }
//    @Test(priority = 5)
//    public void prsSheet(){
//        //Unloading of CN (Assign to PA/OA)
//        test = extent.createTest("prsSheet");
//        String bearertoken = "Bearer " + accessToken;
//        RestAssured.baseURI = baseURL;
//        given().log().all().queryParam("prsId", prsID).header("Authorization", bearertoken)
//                .header("Content-Type","text/plain")
//
//                .when().get("/backend/operations/lite/pickupRunSheet")
//                .then().log().all().assertThat().statusCode(200).extract().response().asString();
//   }
}