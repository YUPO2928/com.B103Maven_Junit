package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P15_WindowHandle extends TestBase {

    @Test
    public void test01(){
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin.
        String amazonWindow = driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin.
        String actualTitle = driver.getTitle();
        String arananKelime = "Amazon";
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin.
        driver.switchTo().newWindow(WindowType.TAB); // Yeni bir sekme açmış olduk
        driver.get("https://techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin.
        String actualTechproTitle = driver.getTitle();
        String istenenKelime = "TECHPROEDUCATION";
        Assert.assertFalse(actualTechproTitle.contains(istenenKelime)); //içermediği için assertFalse kullandık.

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://walmart.com");

        //Sayfa title’nin “Walmart” icerdigini test edin.
        String walmartTitle = driver.getTitle();
        String istenenKelime2 = "Walmart";
        Assert.assertTrue(walmartTitle.contains(istenenKelime2));



        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin.
        driver.switchTo().window(amazonWindow);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertEquals(expectedUrl,actualUrl);



    }

}
