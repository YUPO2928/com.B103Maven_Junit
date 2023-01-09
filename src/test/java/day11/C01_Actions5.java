package day11;
import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class C01_Actions5 extends TestBase {
    @Test
    public void keyboardActionsTest(){

        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK) (SHIFT ==> KUCUK HARFLERI BUYUTUYOR, BUYUK HARFLERI KUCULTUR.)
        // ‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        // Ve ENTER tusuna bas
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        //aramaKutusu.sendKeys("IPHONE X FIYATLARI" + Keys.ENTER);
        Actions actions = new Actions(driver);
        actions
                .keyDown(aramaKutusu,Keys.SHIFT)//arama kutusunun ustunde Shist tusuna bas
                .sendKeys("iPhone X fiyatlari")//shifte basiliyken yazi yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shift de artik basma
                .sendKeys("  cok pahali!"+Keys.ENTER)//normal halde yaz ve Enter tusuna bas
                .build()// birden fazla actions methodu kullanildiginda build() kullanilmasi onerilir
                .perform();
    }
}

        /*
            1- Actions nedir?
            *Actions selenium dan gelen bir kütüphanedir. Mouse ve Keyboard
            işlemlerini gerçekleştirmek icin kullandigimiz hazır bir
            selenium kütüphanesidir. Ornegin, sag tiklqmqk(contextClick) ,
            çift tıklamak(doub1eClick), elementin uzerine
            gitmek(moveToElement) gibi mouse işlemlerini
            gerçekleştirebiliriz. Ayni zamanda, shift, control, delete,
            enter gibi keyboard tuşlar.inada actions yardımıyla basabiliriz.
            Bu tur işlemlerde sendKeys metodu kullanilir.

            2- Ne tur Methodlar kullandın?
            Action metodlar önemlidir. ve tekrar tekrar kullanmam gerektiğinden,
            Action methodlarını içeren Reusable methodlar oluştursum. ve gerektiğinde
            bu reusable methhodları kullanıyorum.

            3-Hangi methodları kullandın ne ise yarıyor?
            Ornegin, sag tiklqmqk(contextClick) ,
            çift tıklamak(doub1eClick), elementin uzerine
            gitmek(moveToElement) gibi mouse işlemlerini
            gerçekleştirebiliriz. Ayni zamanda, shift, control, delete,
            enter gibi keyboard tuşlar.inada actions yardımıyla basabiliriz.
            Bu tur işlemlerde sendKeys metodu kullanilir.
        */