package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    /*
    -"amazon.com" adresine gidelim
    -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
    -title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim
    -Ardindan "trendyol.com" adresine gidelim
    -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
    -Bi onceki web sayfamiza geri donelim
    -sayfayi yenileyelim
    -Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String  actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Sayfa Baslığı :" + actualTitle);
        System.out.println("Sayfa Url'si :" + actualUrl);

        //-title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("Spend")&&actualUrl.contains("Spend")); // "ve" dediği için ve ikiside içermediği için false kullandık, çünkü beklenen içermemesi

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com");

        //bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolTitle = driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Sitesi"));

        //-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        Thread.sleep(3000);

        //-sayfayi yenileyelim.
        driver.navigate().refresh();
        Thread.sleep(3000);

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.quit();

    }


}
