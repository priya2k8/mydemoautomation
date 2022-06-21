package UI_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Thread.sleep(3000);

        driver.manage().window().maximize();
        String title = driver.getTitle();
        driver.get("https://zoom-kubernetes.stg.rivigo.com/arrow/ops");
        Thread.sleep(3000);
        System.out.println(title);
        driver.findElement(By.xpath("//input[@id=\"login-username\"]")).sendKeys("smoke_oadelt1@rivigo.com");
        driver.findElement(By.xpath("//input[@id=\"login-password\"]")).sendKeys("Smoketest@zoom5");
        Thread.sleep(3000);
        Boolean ForgetPassword = driver.findElement(By.xpath("//p[@id=\"forgot-password-link\"]")).isDisplayed();
        Boolean FPassword = driver.findElement(By.xpath("//p[@id=\"forgot-password-link\"]")).isEnabled();
        Boolean Logins = driver.findElement(By.xpath("//button[@id=\"login\"]")).isDisplayed();
        Boolean Login = driver.findElement(By.xpath("//button[@id=\"login\"]")).isEnabled();
        Boolean Loggin = driver.findElement(By.xpath("//button[@id=\"login\"]")).isSelected();
        WebElement loginbutton = driver.findElement(By.xpath("//button[@id=\"login\"]"));
        loginbutton.click();
        driver.quit();
    }
}
