package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P16_windowHandle02 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //    - https://html.com/tags/iframe/ adresine gidiniz.
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow = driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız,
        WebElement iframe = driver.findElement(By.xpath("//*[@class='render']/iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        String amazonWindow = driver.getWindowHandle();

        //    - iphone aratınız.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız.
        String[] iphoneResultList = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
        System.out.println("iphone sonuc sayısı :" + iphoneResultList[2]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım.
        driver.switchTo().window(ilkWindow);
        String ilkWindowUrl = driver.getCurrentUrl();
        System.out.println("ilk window url'si : + " + ilkWindowUrl);

        //    - ilk sekmeyi kapatalım.
        driver.switchTo().window(amazonWindow);
        driver.close();

        //    - Sonra diğer sekmeyide kapatalım.





    }

}
