package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P30_amazon extends TestBase {

    @Test
    public void testAmazon(){

//        Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

//        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın.
        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownMenu);
        List<WebElement> dropDownMenuList = new ArrayList<>(select.getOptions());
        dropDownMenuList.stream().forEach(t-> System.out.println(t.getText()));

//        dropdown menude 28 eleman olduğunu doğrulayın.
        Assert.assertTrue(dropDownMenuList.size()==28);

//                Test02
//        dropdown menuden elektronik bölümü seçin.
        select.selectByVisibleText("Electronics");

//        arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String[] resultList = result.getText().split(" ");
        System.out.println("Sonuc = " + resultList[2]);

//        sonuc sayisi bildiren yazinin iphone icerdigini test edin.
        Assert.assertTrue(result.getText().contains("iphone"));

//        ikinci ürüne relative locater kullanarak tıklayin.
        WebElement title = driver.findElement(By.xpath("//*[text()='[3+3 Pack] Compatible with iPhone 14 Pro Max [6.7 inch] Screen Protector with Camera Lens Protector, Sensor Protection, Dynamic Island Compatible, Case Friendly Tempered Glass [9H Hardness] - HD']"));
        String baslık = title.getText();
        title.click();


//        ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim.
        String fiyat = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        System.out.println("fiyat = " + fiyat);
        System.out.println("baslık = " + baslık);



//        Test03
//        yeni bir sekme açarak amazon anasayfaya gidin.
//        dropdown’dan bebek bölümüne secin
//        bebek puset aratıp bulundan sonuç sayısını yazdırın
//        sonuç yazsının puset içerdiğini test edin
//        5-üçüncü ürüne relative locater kullanarak tıklayin
//        6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
//        1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın.






    }
}
