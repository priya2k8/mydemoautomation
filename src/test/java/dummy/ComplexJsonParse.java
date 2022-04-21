package dummy;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class ComplexJsonParse {
    @Test
    public void complexJsonParse() {
        JsonPath js = new JsonPath(BaseClass.CoursePrice());
        //Print No. of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println("Total no. of courses is :" + count);
        //Print purchase amount
        int totalamount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Total Purchase Amount is :" + totalamount);
        //  Print Title of the first course
        String firstcourse = js.getString("courses[0].title");
        System.out.println("First Course Name is:" + firstcourse);
        //Print All course titles and their respective Prices
        for (int i = 0; i < count; i++) {
            String courseTitle = js.getString("courses[" + i + "].title");
            String coursePrice = js.getString("courses[" + i + "].price");
            System.out.println(courseTitle + " Price is:" + coursePrice);
        }
        //Print no of copies sold by RPA Course
        int courseCopies = js.getInt("courses[2].copies");
        System.out.println("RPA's total sold copies are: " + courseCopies);
        //Print no. of copies sold by RPA Course when we don't know the array address of that course
        boolean found = false;
        for (int y = 0; y< count; y++) {
            String courseTitles = js.getString("courses["+y+"].title");
          //  System.out.println("course Titles is "+courseTitles);
            if (courseTitles.equalsIgnoreCase("JAVA")) {
                int soldCopies = js.get("courses[" + y + "].copies");
                System.out.println(" total sold copies were : " + soldCopies);
                System.out.println("course found");
                found = true;
             break;
            }

            }
        if(!found){
            System.out.println("course not found");
        }
        }
    }

