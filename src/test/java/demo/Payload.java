package demo;

import io.restassured.RestAssured;

public class Payload {
    public static String AddDetail() {
      //  RestAssured.baseURI = "https://zoom-kubernetes.stg.rivigo.com";

        return "{\n" +
                "    \"id\": null,\n" +
                "    \"client\": {\n" +
                "        \"id\": 1519\n" +
                "    },\n" +
                "    \"addressType\": \"PICKUPANDDROP\",\n" +
                "    \"address\": {\n" +
                "        \"id\": null,\n" +
                "        \"detailedAddress\": \"test test test3333395798\",\n" +
                "        \"pincode\": \"122001\",\n" +
                "        \"state\": \"Delhi\",\n" +
                "        \"landmark\": null\n" +
                "    },\n" +
                "    \"name\": \"test\",\n" +
                "    \"phoneNumber\": \"9971639104\",\n" +
                "    \"isAppoinmentDelivery\": false,\n" +
                "    \"contactPerson\": \"test\",\n" +
                "    \"status\": \"ACTIVE\",\n" +
                "    \"organizationId\": null\n" +
                "}";
    }
    public static String VehicleNo(){
        int alpha1 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        int alpha2 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        int alpha3 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        int digit1 = (int)(Math.random() * 10);
        int digit2 = (int)(Math.random() * 10);
        int digit3 = (int)(Math.random() * 10);
        int digit4 = (int)(Math.random() * 10);
        String vehicleNo = (""+(char)(alpha1) + ((char)(alpha2)) +digit1+digit4+
                ((char)(alpha3)) +(char)(alpha1)+ digit1 + digit2 + digit3 + digit4);
        return vehicleNo;
    }
}
