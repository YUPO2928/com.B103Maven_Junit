package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P11 {
    /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin.
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */

        static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        //https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //cookies uyarisini kabul ederek kapatin.

        //Sayfa basliginin “Google” ifadesi icerdigini test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        String[] sonucSayısı = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonuc = sonucSayısı[1];
        System.out.println("Sonuc Sayısı : " + sonuc);

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin.
        sonuc=sonuc.replaceAll("\\D", ""); //replaceAll() method'u ile "\\D" kullanarak bütün "noktalama işaretlerini", "hiçlik" ile değiştir.
        int istenenSayı = 10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayı);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
