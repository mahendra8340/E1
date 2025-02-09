package selenium.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
    
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
    }

    @Test
    public void testFacebookLogin() {

        driver.get("https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("FromTest@example.com");
        driver.findElement(By.id("pass")).sendKeys("your-password");
        driver.findElement(By.name("login")).click();

        try {
            Thread.sleep(5000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
