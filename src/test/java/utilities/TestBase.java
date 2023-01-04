package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

 public class TestBase {

    //TestBase i abstract yapmamızın sebebi bu sınıfın objesini olusturmak istemiyorum.
    //TestBase testBase = new TestBase(); -> YAPILMAZ
    //Amacım bu sınıfı extend edip içindeki method'ları kullanmak

    //driver objesini olusturduk. Driver ya "public" ya da "protected" olmalı. Sebebi child class larda gorulmesi
    protected static WebDriver driver;

    //setup
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

     //    MULTIPLE WINDOW
     //    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
     //    ORNEK:
     //    driver.get("https://the-internet.herokuapp.com/windows");
     //    switchToWindow("New Window");
     //    switchToWindow("The Internet")
//     public static void switchToWindow(String targetTitle) {
//         String origin = driver.getWindowHandle();
//         for (String handle : driver.getWindowHandles()) {
//             driver.switchTo().window(handle);
//             if (driver.getTitle().equals(targetTitle)) {
//                 return;
//             }
//         }
//         driver.switchTo().window(origin);
//     }

    /*
       * Alertleri nasil automate edersin? How to handle alerts in selenium?
       * Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
    */

}
