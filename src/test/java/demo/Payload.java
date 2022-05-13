package demo;

import io.restassured.RestAssured;

import static demo.CnCreation.fromAddressId;
import static demo.CnCreation.toAddressId;
import static java.lang.System.currentTimeMillis;

public class Payload extends BaseClass {
    public static String cnote;
    public static String cnotebarcode;
    public static String time;
    public static String AddInsert() {
        cnote = "" + (long) (Math.random() * 100000 + 3333300000L);
        return cnote;
    }
    public static String InsertCNote() {
        cnotebarcode = "" + (long) (Math.random() * 100000 + 3333300000L);
        return cnotebarcode;
    }
    public static String InsertTime() {
        time = String.valueOf(currentTimeMillis());
        return time;

    }
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
    public static String CorporateCN(){
        return "{\n" +
                "    \"id\": null,\n" +
                "    \"cnoteType\": \"NORMAL\",\n" +
                "    \"cnote\": \"" + AddInsert() + "\",\n" +
                "    \"clientCode\": \"" + client_code + "\",\n" +
                "    \"serviceType\": \"ZOOM\",\n" +
                "    \"gstNumber\": null,\n" +
                "    \"fromPinCode\": \"" + FromPin + "\",\n" +
                "    \"toPinCode\": \"" + ToPin + "\",\n" +
                "    \"totalBoxes\": \"" + numberOfBoxes + "\",\n" +
                "    \"weight\": \"1\",\n" +
                "    \"volume\": null,\n" +
                "    \"value\": null,\n" +
                "    \"bookingDateTime\": " + InsertTime() + " ,\n" +
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
                "        " + InsertCNote() + "\n" +
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
                "}";
    }
    //Retail Normal CN
    public static String RetailNormalCN(){
        return"{\"id\": null,\n" +
                "    \"cnoteType\": \"RETAIL\",\n" +
                "    \"cnote\": \"" + AddInsert()+"\",\n" +
                "    \"clientCode\": \"ZRETL\",\n" +
                "    \"serviceType\": \"EXPRESS\",\n" +
                "    \"gstNumber\": \"07AABCU9603R1ZP\",\n" +
                "    \"fromPinCode\": \"" + FromPin + "\",\n" +
                "    \"toPinCode\": \"" + ToPin + "\",\n" +
                "    \"totalBoxes\": \"1\",\n" +
                "    \"weight\": \"20\",\n" +
                "    \"volume\": null,\n" +
                "    \"value\": null,\n" +
                "    \"bookingDateTime\": \"" + InsertTime() + "\",\n" +
                "    \"consignorAddress\": \"mnv hgfd hgfd\",\n" +
                "    \"consignorAddressId\": \"" + fromAddressId + "\",\n" +
                "    \"consignorEmail\": null,\n" +
                "    \"consignorPhone\": \"987654345678\",\n" +
                "    \"consigneeAddress\": \"shwh shshs hejsj aiajajsjs jsjsjej\",\n" +
                "    \"consigneeAddressId\": \"" + toAddressId + "\",\n" +
                "    \"consigneeEmail\": null,\n" +
                "    \"consigneePhone\": \"8215100646\",\n" +
                "    \"contents\": \"Auto parts\",\n" +
                "    \"consignorName\": \"jhgfd\",\n" +
                "    \"consigneeName\": \"dhdhd\",\n" +
                "    \"retailBillToAddressId\": 2804345,\n" +
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
                "        \"" + InsertCNote() + "\"\n" +
                "    ],\n" +
                "    \"isDacc\": false,\n" +
                "    \"invoices\": [\n" +
                "        {\n" +
                "            \"invoiceId\": null,\n" +
                "            \"invoiceNo\": \"1\",\n" +
                "            \"invoiceValue\": \"10\",\n" +
                "            \"hsnCodes\": null,\n" +
                "            \"invoiceFiles\": []\n" +
                "        }\n" +
                "    ],\n" +
                "    \"invoiceFiles\": [],\n" +
                "    \"volumeDetails\": [\n" +
                "        {\n" +
                "            \"unit\": \"IN\",\n" +
                "            \"length\": \"20\",\n" +
                "            \"breadth\": \"20\",\n" +
                "            \"height\": \"20\",\n" +
                "            \"numberOfBoxes\": \"1\",\n" +
                "            \"volume\": 4.6296\n" +
                "        }\n" +
                "    ],\n" +
                "    \"valueAddedServicesDTO\": null,\n" +
                "    \"paymentDetailsDTO\": {\n" +
                "        \"chargeBasis\": \"CFT\",\n" +
                "        \"cft\": 10,\n" +
                "        \"ratePerKg\": 18,\n" +
                "        \"basicFreight\": 900,\n" +
                "        \"fovChargeType\": \"VALUE\",\n" +
                "        \"amountPayable\": 0,\n" +
                "        \"totalRoundOffAmount\": 1860,\n" +
                "        \"paymentMode\": \"PAID\",\n" +
                "        \"ifscCode\": null,\n" +
                "        \"chequeOrDraftNumber\": null,\n" +
                "        \"codDod\": 0,\n" +
                "        \"discountAmount\": 0,\n" +
                "        \"wayBillCharge\": 200,\n" +
                "        \"handlingCharges\": 0,\n" +
                "        \"odaCharge\": 0,\n" +
                "        \"otherCharges\": 0,\n" +
                "        \"consignmentLiability\": \"RIVIGO_LIABILITY\",\n" +
                "        \"billingWeight\": null,\n" +
                "        \"billingVolume\": null,\n" +
                "        \"fuelSurchargePercent\": 40,\n" +
                "        \"fovPercent\": 1,\n" +
                "        \"premiumCharges\": null,\n" +
                "        \"isShortPayment\": false,\n" +
                "        \"shortPaymentReasonId\": null,\n" +
                "        \"shortPaymentAmount\": 0,\n" +
                "        \"id\": null,\n" +
                "        \"consignmentId\": null,\n" +
                "        \"isActive\": null,\n" +
                "        \"microMarketCode\": \"DL_Kar_10\",\n" +
                "        \"retailType\": \"NORMAL\",\n" +
                "        \"chargedWeight\": 50,\n" +
                "        \"fuelSurcharge\": 360,\n" +
                "        \"fov\": 200,\n" +
                "        \"hardCopyPodCharges\": 0,\n" +
                "        \"fod\": 0,\n" +
                "        \"sundayDeliveryCharges\": 0,\n" +
                "        \"mallDeliveryCharges\": 0,\n" +
                "        \"greenTax\": 0,\n" +
                "        \"hardRegionVayuCharges\": 0,\n" +
                "        \"specialZoneCharges\": 0,\n" +
                "        \"infrastructureDevelopmentCharges\": 0,\n" +
                "        \"totalAmountWithoutDiscount\": 1660,\n" +
                "        \"discountCode\": null,\n" +
                "        \"discountCriteria\": null,\n" +
                "        \"discountType\": null,\n" +
                "        \"discountRemarks\": null,\n" +
                "        \"discountValue\": null,\n" +
                "        \"discountFloorAmount\": null,\n" +
                "        \"totalAmountWithDiscount\": 1660,\n" +
                "        \"clientGstIn\": \"07AABCU9603R1ZP\",\n" +
                "        \"clientPan\": null,\n" +
                "        \"sgstPercent\": 6,\n" +
                "        \"sgst\": 99.6,\n" +
                "        \"cgstPercent\": 6,\n" +
                "        \"cgst\": 99.6,\n" +
                "        \"igstPercent\": 0,\n" +
                "        \"igst\": 0,\n" +
                "        \"ugstPercent\": 0,\n" +
                "        \"ugst\": 0,\n" +
                "        \"totalAmountWithoutTds\": 1859.2,\n" +
                "        \"tan\": null,\n" +
                "        \"shortPaymentTan\": null,\n" +
                "        \"tdsPercent\": 0,\n" +
                "        \"tdsAmount\": 0,\n" +
                "        \"tdsRoundOffAmount\": 0,\n" +
                "        \"totalAmount\": 1859.2,\n" +
                "        \"bdSurcharge\": 0,\n" +
                "        \"bankName\": null,\n" +
                "        \"chequeNumber\": null,\n" +
                "        \"ocrChequeNumber\": null,\n" +
                "        \"userInputOnOCR\": false,\n" +
                "        \"transferredAmount\": null,\n" +
                "        \"bankAccountReference\": null,\n" +
                "        \"paymentType\": \"CASH\",\n" +
                "        \"handoverStatus\": \"PENDING\",\n" +
                "        \"createdById\": null,\n" +
                "        \"lastUpdatedById\": null,\n" +
                "        \"createdAt\": null,\n" +
                "        \"lastUpdatedAt\": null,\n" +
                "        \"paymentDetailsStatus\": \"COMPLETE\",\n" +
                "        \"onlineTransactionRecordId\": null,\n" +
                "        \"cnBillingVersion2\": true,\n" +
                "        \"zoomConsignorCode\": null,\n" +
                "        \"consignmentCessDetails\": null,\n" +
                "        \"cessWarnings\": [],\n" +
                "        \"totalCess\": null,\n" +
                "        \"metroCongestion\": 0,\n" +
                "        \"liquidHandling\": 0,\n" +
                "        \"hazardousHandling\": 0,\n" +
                "        \"sezDeliveryCharges\": 0,\n" +
                "        \"railwayDeliveryCharges\": 0,\n" +
                "        \"governmentCompoundDeliveryCharges\": 0,\n" +
                "        \"higherFloorCharges\": 0,\n" +
                "        \"deliveryReattemptCharges\": 0,\n" +
                "        \"canteenDeliveryCharges\": 0,\n" +
                "        \"appointmentDeliveryCharges\": 0,\n" +
                "        \"roundOffVasCharge\": null,\n" +
                "        \"isFinalInvoiceCreated\": null,\n" +
                "        \"fromPcCode\": \"DELT2\",\n" +
                "        \"toPcCode\": \"BLRT1\",\n" +
                "        \"fromBranchCode\": \"DELBD\",\n" +
                "        \"toBranchCode\": \"BLRBC\",\n" +
                "        \"contractMetadata\": {\n" +
                "            \"contractCode\": \"CON-ZRETL-Z9998\",\n" +
                "            \"zoomRetailType\": \"NORMAL\",\n" +
                "            \"consignorCode\": \"\",\n" +
                "            \"zoomMmCode\": \"DL_Kar_10\"\n" +
                "        },\n" +
                "        \"adjustmentCharges\": 0,\n" +
                "        \"cnote\": \"" + AddInsert() + "\",\n" +
                "        \"shortPaymentReason\": null\n" +
                "    },\n" +
                "    \"gstDetailsDTO\": {},\n" +
                "    \"taxId\": \"07AABCU9603R1ZP\",\n" +
                "    \"taxIdType\": \"GSTIN\",\n" +
                "    \"trackerDTO\": {\n" +
                "        \"deviceIdType\": \"IP\",\n" +
                "        \"deviceType\": \"ZOOM_OPS\"\n" +
                "    },\n" +
                "    \"openPopupTime\": 1652339812417,\n" +
                "    \"allIssuesResolved\": true,\n" +
                "    \"billingEntity\": \"Zoom-Retail\",\n" +
                "    \"vehicleNumber\": \"" + Payload.VehicleNo() + "\",\n" +
                "    \"consignmentCodDodDTO\": null,\n" +
                "    \"deliveryType\": \"NORMAL\",\n" +
                "    \"isRivigoAir\": false,\n" +
                "    \"consignmentCustomFieldsDTO\": {\n" +
                "        \"consignmentToggleVasDTO\": {},\n" +
                "        \"consignmentAddressVasDTO\": {\n" +
                "            \"pickupFloorNumber\": null,\n" +
                "            \"deliveryFloorNumber\": null\n" +
                "        }\n" +
                "    },\n" +
                "    \"completionStatus\": \"COMPLETE\"\n" +
                "}";}
    //Retail Bike CN
    public static String BikeCN(){
      return  "{\n" +
                "    \"id\": null,\n" +
                "    \"cnoteType\": \"RETAIL\",\n" +
                "    \"cnote\": \"" +AddInsert()+ "\",\n" +
                "    \"clientCode\": \"ZRETL\",\n" +
                "    \"serviceType\": \"ZOOM\",\n" +
                "    \"gstNumber\": \"07AABCU9603R1ZP\",\n" +
                "    \"fromPinCode\": \""+FromPin+"\",\n" +
                "    \"toPinCode\": \""+ToPin+"\",\n" +
                "    \"totalBoxes\": 1,\n" +
                "    \"weight\": 200,\n" +
                "    \"volume\": null,\n" +
                "    \"value\": null,\n" +
                "    \"bookingDateTime\": "+InsertTime()+",\n" +
                "    \"consignorAddress\": \"mnv hgfd hgfd\",\n" +
                "    \"consignorAddressId\": "+fromAddressId+",\n" +
                "    \"consignorEmail\": null,\n" +
                "    \"consignorPhone\": \"987654345678\",\n" +
                "    \"consigneeAddress\": \"shwh shshs hejsj aiajajsjs jsjsjej\",\n" +
                "    \"consigneeAddressId\": "+toAddressId+",\n" +
                "    \"consigneeEmail\": null,\n" +
                "    \"consigneePhone\": \"8215100646\",\n" +
                "    \"contents\": \"BIKE\",\n" +
                "    \"consignorName\": \"jhgfd\",\n" +
                "    \"consigneeName\": \"dhdhd\",\n" +
                "    \"retailBillToAddressId\": 2804345,\n" +
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
                "    \"packing\": \"Carton\",\n" +
                "    \"barcodeType\": \"PRE_PRINTED\",\n" +
                "    \"barcodes\": [\n" +
                "        \" "+InsertCNote()+"\"\n" +
                "    ],\n" +
                "    \"isDacc\": false,\n" +
                "    \"invoices\": [\n" +
                "        {\n" +
                "            \"invoiceId\": null,\n" +
                "            \"invoiceNo\": \"1\",\n" +
                "            \"invoiceValue\": \"10\",\n" +
                "            \"hsnCodes\": null,\n" +
                "            \"rcData\": [\n" +
                "                \"https://rivigo-zoom-dev.s3.ap-southeast-1.amazonaws.com/CONSIGNMENT/8764321998/BIKE_RC_FRONT/1652438392546/null\",\n" +
                "                \"https://rivigo-zoom-dev.s3.ap-southeast-1.amazonaws.com/CONSIGNMENT/8764321998/BIKE_RC_BACK/1652438394110/null\"\n" +
                "            ],\n" +
                "            \"invoiceFiles\": []\n" +
                "        }\n" +
                "    ],\n" +
                "    \"invoiceFiles\": [],\n" +
                "    \"volumeDetails\": [\n" +
                "        {\n" +
                "            \"numberOfBoxes\": 1,\n" +
                "            \"unit\": \"IN\",\n" +
                "            \"volume\": 0,\n" +
                "            \"height\": 0,\n" +
                "            \"breadth\": 0,\n" +
                "            \"length\": 0,\n" +
                "            \"metadata\": {\n" +
                "                \"CC\": \"200\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"valueAddedServicesDTO\": null,\n" +
                "    \"paymentDetailsDTO\": {\n" +
                "        \"chargeBasis\": \"CFT\",\n" +
                "        \"cft\": 5,\n" +
                "        \"ratePerKg\": 10,\n" +
                "        \"basicFreight\": 10,\n" +
                "        \"fovChargeType\": \"VALUE\",\n" +
                "        \"amountPayable\": 0,\n" +
                "        \"totalRoundOffAmount\": 1514,\n" +
                "        \"paymentMode\": \"PAID\",\n" +
                "        \"ifscCode\": null,\n" +
                "        \"chequeOrDraftNumber\": null,\n" +
                "        \"codDod\": 0,\n" +
                "        \"discountAmount\": 0,\n" +
                "        \"wayBillCharge\": 0,\n" +
                "        \"handlingCharges\": 1340,\n" +
                "        \"odaCharge\": 0,\n" +
                "        \"otherCharges\": 0,\n" +
                "        \"consignmentLiability\": \"CLIENT_LIABILITY\",\n" +
                "        \"isShortPayment\": false,\n" +
                "        \"shortPaymentReasonId\": null,\n" +
                "        \"shortPaymentAmount\": 0,\n" +
                "        \"id\": null,\n" +
                "        \"consignmentId\": null,\n" +
                "        \"isActive\": null,\n" +
                "        \"microMarketCode\": \"BX_DL_Kar_10\",\n" +
                "        \"retailType\": \"BIKE\",\n" +
                "        \"chargedWeight\": 335,\n" +
                "        \"fuelSurchargePercent\": null,\n" +
                "        \"fuelSurcharge\": 0,\n" +
                "        \"fovPercent\": null,\n" +
                "        \"fov\": 1,\n" +
                "        \"hardCopyPodCharges\": 0,\n" +
                "        \"fod\": 0,\n" +
                "        \"sundayDeliveryCharges\": 0,\n" +
                "        \"mallDeliveryCharges\": 0,\n" +
                "        \"greenTax\": 0,\n" +
                "        \"hardRegionVayuCharges\": 0,\n" +
                "        \"specialZoneCharges\": 0,\n" +
                "        \"infrastructureDevelopmentCharges\": 0,\n" +
                "        \"totalAmountWithoutDiscount\": 1351,\n" +
                "        \"premiumCharges\": 0,\n" +
                "        \"discountCode\": null,\n" +
                "        \"discountCriteria\": null,\n" +
                "        \"discountType\": null,\n" +
                "        \"discountRemarks\": null,\n" +
                "        \"discountValue\": null,\n" +
                "        \"discountFloorAmount\": null,\n" +
                "        \"totalAmountWithDiscount\": 1351,\n" +
                "        \"clientGstIn\": \"07AABCU9603R1ZP\",\n" +
                "        \"clientPan\": null,\n" +
                "        \"sgstPercent\": 6,\n" +
                "        \"sgst\": 81.06,\n" +
                "        \"cgstPercent\": 6,\n" +
                "        \"cgst\": 81.06,\n" +
                "        \"igstPercent\": 0,\n" +
                "        \"igst\": 0,\n" +
                "        \"ugstPercent\": 0,\n" +
                "        \"ugst\": 0,\n" +
                "        \"totalAmountWithoutTds\": 1513.12,\n" +
                "        \"tan\": null,\n" +
                "        \"shortPaymentTan\": null,\n" +
                "        \"tdsPercent\": 0,\n" +
                "        \"tdsAmount\": 0,\n" +
                "        \"tdsRoundOffAmount\": 0,\n" +
                "        \"totalAmount\": 1513.12,\n" +
                "        \"bdSurcharge\": 0,\n" +
                "        \"bankName\": null,\n" +
                "        \"chequeNumber\": null,\n" +
                "        \"ocrChequeNumber\": null,\n" +
                "        \"userInputOnOCR\": false,\n" +
                "        \"transferredAmount\": null,\n" +
                "        \"bankAccountReference\": null,\n" +
                "        \"paymentType\": \"CASH\",\n" +
                "        \"handoverStatus\": \"PENDING\",\n" +
                "        \"createdById\": null,\n" +
                "        \"lastUpdatedById\": null,\n" +
                "        \"createdAt\": null,\n" +
                "        \"lastUpdatedAt\": null,\n" +
                "        \"paymentDetailsStatus\": \"COMPLETE\",\n" +
                "        \"onlineTransactionRecordId\": null,\n" +
                "        \"cnBillingVersion2\": true,\n" +
                "        \"zoomConsignorCode\": null,\n" +
                "        \"consignmentCessDetails\": null,\n" +
                "        \"cessWarnings\": [],\n" +
                "        \"totalCess\": null,\n" +
                "        \"metroCongestion\": 0,\n" +
                "        \"liquidHandling\": 0,\n" +
                "        \"hazardousHandling\": 0,\n" +
                "        \"sezDeliveryCharges\": 0,\n" +
                "        \"railwayDeliveryCharges\": 0,\n" +
                "        \"governmentCompoundDeliveryCharges\": 0,\n" +
                "        \"higherFloorCharges\": 0,\n" +
                "        \"deliveryReattemptCharges\": 0,\n" +
                "        \"canteenDeliveryCharges\": 0,\n" +
                "        \"appointmentDeliveryCharges\": 0,\n" +
                "        \"roundOffVasCharge\": null,\n" +
                "        \"billingWeight\": null,\n" +
                "        \"billingVolume\": null,\n" +
                "        \"isFinalInvoiceCreated\": null,\n" +
                "        \"fromPcCode\": \"DELT2\",\n" +
                "        \"toPcCode\": \"BLRT1\",\n" +
                "        \"fromBranchCode\": \"DELBD\",\n" +
                "        \"toBranchCode\": \"BLRBC\",\n" +
                "        \"contractMetadata\": {\n" +
                "            \"contractCode\": \"CON-ZRETL-Z10004\",\n" +
                "            \"zoomRetailType\": \"BIKE\",\n" +
                "            \"consignorCode\": \"\",\n" +
                "            \"zoomMmCode\": \"BX_DL_Kar_10\"\n" +
                "        },\n" +
                "        \"adjustmentCharges\": 0,\n" +
                "        \"cnote\": \" "+AddInsert()+"\",\n" +
                "        \"shortPaymentReason\": null\n" +
                "    },\n" +
                "    \"gstDetailsDTO\": {},\n" +
                "    \"taxId\": \"07AABCU9603R1ZP\",\n" +
                "    \"taxIdType\": \"GSTIN\",\n" +
                "    \"trackerDTO\": {\n" +
                "        \"deviceIdType\": \"IP\",\n" +
                "        \"deviceType\": \"ZOOM_OPS\"\n" +
                "    },\n" +
                "    \"openPopupTime\": 1652438336786,\n" +
                "    \"allIssuesResolved\": true,\n" +
                "    \"billingEntity\": \"Zoom-Retail\",\n" +
                "    \"vehicleNumber\": \" "+VehicleNo()+"\",\n" +
                "    \"consignmentCodDodDTO\": null,\n" +
                "    \"deliveryType\": \"NORMAL\",\n" +
                "    \"isRivigoAir\": false,\n" +
                "    \"consignmentCustomFieldsDTO\": {\n" +
                "        \"consignmentToggleVasDTO\": {},\n" +
                "        \"consignmentAddressVasDTO\": {\n" +
                "            \"pickupFloorNumber\": null,\n" +
                "            \"deliveryFloorNumber\": null\n" +
                "        }\n" +
                "    },\n" +
                "    \"completionStatus\": \"COMPLETE\"\n" +
                "}";}
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
