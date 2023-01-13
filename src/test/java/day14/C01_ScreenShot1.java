package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot1 extends TestBase {

    @Test
    public void fullPageScreenShotPage() throws IOException {

        //Class : screenShot1
        //Techpro education a git ve Sayfanin goruntusunu al.
        driver.get("https://www.techproeducation.com");

            //1- Ekran görüntüsünü getScreenshotsAs metot u ile alıp File olarak olusturalım.
        File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //2- Almıs oldugum ekran goruntusunu belirlediğim bir PATH e kaydet.dir=directory = dosya
            //Note: kayıt ismini dinamik yapmak için date objesi kullandım. (zaman ekledik)
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+ currentDate +"image.png";
        File hedef = new File(path);

            //3- görüntüm ile dosyamı birleştir kaydet.
        FileUtils.copyFile(goruntu,hedef);

            //Alternatıf olarak tum bu adımları tek seferde degişken kullanmadan yapabilirim.
            //FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), //goruntu
            //                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path


        //-“QA” aramasi yap.
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA", Keys.ENTER);
        waitFor(3);

        //Acilen sayfanin metnini test et ve ekran goruntnputusu al: “Search Results for: qa

        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();

        //Reusable metod yardı ile ekran görüntüsü alalım.
        takeScreenShotOfPage();


    }
}
