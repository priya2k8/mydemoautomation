package demo;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jdk.nashorn.internal.ir.CaseNode;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.PropertyUtils;
import java.io.IOException;
import java.sql.*;

import static com.mongodb.QueryOperators.WHERE;
import static demo.CnCreation.task;
import static java.lang.System.currentTimeMillis;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static files.BaseClass.placeId;
public class BaseClass {
    public static String accessToken = "";
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public static String projectdir = System.getProperty("user.dir");
    protected static PropertyUtils prop = null;
    public static String baseURL = null;
    public static String db_Url =null;
    public static String tokenURL = null;
    public static String ToPin = null;
    public static String FromPin = null;
    public static String numberOfBoxes = null;
    public static String client_code = null;
    public static String usr = "";
    private CaseNode ExtentTestManager;

    public static void initialiseProperties_Zoom() throws Exception {
        prop = new PropertyUtils();
        prop.setPropertyFile(projectdir + "/src/test/java/resources/application.properties");
        baseURL = prop.gettingValueOfProperty("ZoomBaseUrl");
        tokenURL = prop.gettingValueOfProperty("login.stg.url");
        //  ClientId=prop.gettingValueOfProperty("ClientId");
        ToPin = prop.gettingValueOfProperty("ToPin");
        FromPin = prop.gettingValueOfProperty("FromPin");
        numberOfBoxes = prop.gettingValueOfProperty("NumberOfBoxes");
        client_code = prop.gettingValueOfProperty("client_code");
        db_Url = prop.gettingValueOfProperty("db_url");
    }

    public static void generateToken() {
        String pwd = "Smoketest@zoom5";
        String user = "smoke_oadelt1@rivigo.com";
        String response = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("client_id", "sso")
                .formParam("grant_type", "password")
                .formParam("username", user)
                .formParam("password", pwd)
                .when().post(tokenURL)
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response); //for parsing JSON
        accessToken = js.getString("response.access_token");
        JsonPath js5 = new JsonPath(response); //for parsing JSON
        usr = js5.getString("response.username");
        String cnote = "" + (long) (Math.random() * 100000 + 3333300000L);
        String cnotebarcode = "" + (long) (Math.random() * 100000 + 3333300000L);
        String time = String.valueOf(currentTimeMillis());
    }

    @BeforeClass
    public void setup() throws Exception {
        initialiseProperties_Zoom();
        generateToken();
        setExtent();
    }

    public void setExtent() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
        htmlReporter.config().setDocumentTitle("Automation Report");//Title of the report
        htmlReporter.config().setReportName("Functional Report"); //Report Name
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "Linux");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Author", "Priya");
    }

    @AfterClass
    public void endReport() {
        extent.flush();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
            test.info("Message: " + result.getName());
            Reporter.log(result.getName());// to add name in extent report
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
            test.info("Message: " + result.getName());
            Reporter.log(result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
            test.info("Message: " + result.getName());
            Reporter.log(result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
            test.info("Message: " + result.getName());
            Reporter.log(result.getName());
        }

    }

}