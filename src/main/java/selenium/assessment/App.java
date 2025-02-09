package selenium.assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.get("https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("FromMain@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.name("login")).click();
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("facebook.com");
        driver.quit();
        
    }
}
