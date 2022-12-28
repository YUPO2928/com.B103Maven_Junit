package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P10 {

    /*
    - ebay sayfasina gidiniz
    - electronics bolumune tiklayiniz
    - genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
    - her sayfanin basligini yazdiralim
    - sayfayi kapatalim
    */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {

        //- ebay sayfasina gidiniz
        driver.get("https://www.ebay.com");

        //- electronics bolumune tiklayiniz
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();



        //- genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim.
        for(int i =1; i<24; i++){

            List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            Thread.sleep(1000);
            System.out.println(i+". baslık : " +driver.getTitle());
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
        }

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }

}
