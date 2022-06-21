package UI_Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CnCreation extends BaseClass {

    public static void main(String[] args) throws InterruptedException {
    // TODO Auto-generated method stub
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    String title = driver.getTitle();
    driver.get("https://zoom-kubernetes.stg.rivigo.com/throne/ops");
    Thread.sleep(3000);
    System.out.println(title);
    driver.findElement(By.xpath("//input[@id=\"login-username\"]")).sendKeys("smoke_oadelt1@rivigo.com");
    driver.findElement(By.xpath("//input[@id=\"login-password\"]")).sendKeys("Smoketest@zoom5");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@id=\"login\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//label[@id=\"toggle-nav-label\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[text()='Create CN']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[text()='I ACCEPT']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@ng-model='cnote']")).sendKeys(cnote);
    Thread.sleep(3000);
    WebElement client = driver.findElement(By.xpath("//*[@id=\"input-12\"]"));
    Thread.sleep(3000);
    client.sendKeys("UNIBIC");
    Thread.sleep(3000);
    client.sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(3000);
    client.sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//input[@placeholder='No. of packages']")).sendKeys("1");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@placeholder='Actual Weight (in kgs)']")).sendKeys("10") ;
    driver.findElement(By.xpath("//*[@placeholder=\"Content\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[text()='Auto parts']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@placeholder=\"Packing Type\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[text()='Carton']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@placeholder=\"Invoice #\"]")).sendKeys("1");
    driver.findElement(By.xpath("//*[@ng-model=\"invoice.invoiceValue\"]")).sendKeys("1");
    WebElement consignee = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/md-content/div[2]/div[2]/div[3]/client-address-list/div/div/div[2]/button"));
    consignee.click();
    driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/md-content/div[2]/div[2]/div[3]/client-address-list/div/div/form/div/div[2]/button[1]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@ng-model=\"addressDto.pincode\"]")).sendKeys("110021");
    driver.findElement(By.xpath("//*[@ng-model='addressDto.detailedAddress']")).sendKeys("Rivigo Pvt. Ltd.");
    driver.findElement(By.xpath("//*[@ng-model='address.name']")).sendKeys("Rivigo");
    driver.findElement(By.xpath("//*[@ng-model='address.phoneNumber']")).sendKeys("9336236257");
    driver.findElement(By.xpath("//*[@ng-model='address.contactPerson']")).sendKeys("Priya");
    driver.findElement(By.xpath("//*[text()=' SAVE ADDRESS ']")).click();
    Thread.sleep(3000);
    //Consignee Address
    driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/md-content/div[2]/div[2]/div[5]/client-address-list/div/div/div[2]/button")).click();
    driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/md-content/div[2]/div[2]/div[5]/client-address-list/div/div/form/div/div[2]/button[1]")).click();
    driver.findElement(By.xpath("//*[@ng-change=\"fillPincodeDetails()\"]")).sendKeys("110033");
    driver.findElement(By.xpath("//*[@ng-model='addressDto.detailedAddress']")).sendKeys("Rivigo Pvt Ltd.");
    driver.findElement(By.xpath("//*[@ng-model='address.name']")).sendKeys("Rivigo Gurgaon");
    driver.findElement(By.xpath("//*[@ng-model='address.phoneNumber']")).sendKeys("9336236275");
    driver.findElement(By.xpath("//*[@ng-model='address.contactPerson']")).sendKeys("Priya");
    driver.findElement(By.xpath("//*[text()=' SAVE ADDRESS ']")).click();
    Thread.sleep(3000);
    //Volume
    driver.findElement(By.xpath("//*[@placeholder=\"Unit\"]")).click();
    driver.findElement(By.xpath("//*[text()=\"INCH\"]")).click();
    driver.findElement(By.xpath("//*[@placeholder=\"Length\"]")).sendKeys("10");
    driver.findElement(By.xpath("//*[@placeholder=\"Breadth\"]")).sendKeys("10");
    driver.findElement(By.xpath("//*[@placeholder=\"Height\"]")).sendKeys("10");
    driver.findElement(By.xpath("//*[@placeholder=\"# Pkgs\"]")).sendKeys("1");
    Thread.sleep(3000);
    //Barcode
    driver.findElement(By.xpath("//*[text()= 'Pre Printed']")).click();
    WebElement barcode= driver.findElement(By.xpath("//*[@placeholder=\"Scan barcode here\"]"));
    barcode.click();
    barcode.sendKeys(cnotebarcode);
    barcode.sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    //pickup Vehicle
    WebElement pickup= driver.findElement(By.xpath("//*[@placeholder=\"Add vehicle\"]"));
    pickup.click();
    pickup.sendKeys(VehicleNo());
    pickup.sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/md-content/div[2]/div[4]/div[2]/button[2]")).click();

}
}
