package day06_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {

    /*
    1-https://books-pwakit.appspot.com/ adresine gidin.
    2-"BOOKS" başlığının görünür olduğunu doğrulayın
    3-Arama çubuğunda "Selenium" u aratın.
    4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
*/


    WebDriver driver;

    @Before
            public void setup(){


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
        public void Test01(){
            //1-https://books-pwakit.appspot.com/ adresine gidin.
            driver.get("https://books-pwakit.appspot.com");

            //2-"BOOKS" başlığının görünür olduğunu doğrulayın
            driver.findElement(By.xpath("//*[@.='BOOKS']"));

        }




}
