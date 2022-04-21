package dummy;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumOfAmount {
    @Test
    public void sumOfAmount()
    {
        JsonPath js = new JsonPath(BaseClass.CoursePrice());
        int sum =0;
        int count = js.getInt("courses.size()");
        for(int i=0;i<count;i++) {
            int coursePrice = js.getInt ("courses[" + i + "].price");
            int courseCopies = js.getInt("courses[" + i + "].copies");
            int amount = coursePrice * courseCopies;
            sum = sum + amount;
        }
        System.out.println("Sum of all Course prices is : " +sum);
        int actualAmount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum,actualAmount);
        }
    }

