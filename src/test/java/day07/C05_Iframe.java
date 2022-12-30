package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_Iframe extends TestBase {

     /*
        Iframe nedir?
           https://testcenter.techproeducation.com/index.php?page=iframe

        1- Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim.
        2- Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim.
        3- Son olarak footer daki ‘Powered By’ yazisini varligini test edin.

        */

    @Test
    public void iframeTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //1- Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim.
        //tag[.='metin']; Bana bu tagli metni ver.
        //tag[text()='metin'];

        //p[.='An iframe with a thin black border:']==> bana html sayfasında "An iframe with a thin black border:" text'li path'i ver.
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //2- Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim.
        //Applications lists elementi iframe içinde Iframe switch yapmam şart.
        driver.switchTo().frame(0); //index 0 dan baslar. ilk iframe switch yapıyoruz.
        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText01 = "Applications lists";
        Assert.assertEquals(expectedText01,icMetin);
        //Assert.assertTrue(expectedText01.contains(icMetin)); ==> Alternatif çözüm.

        //3- Son olarak footer daki ‘Powered By’ yazisini varligini test edin.
        //Iframe'in dışına çıkmamız gerekiyor.
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'])[1]//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));

        /*
        ******************************************************** INTERVIEW QUESTIONS *****************************************************
        How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
        ***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
        ***driver.findElements(By.tagName(“iframe”));
        ***driver.findElements(By.xpath(“//iframe”));
        ————————————
        Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
        ***2 farkli yol vardır.
        ***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
        ———————————-
        What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
        *** Oncelikle her ikiside framein misina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
        —————————————
        What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
        Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
        Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
        Iframe. Cozum : switch to iframe
        Alert. Cozum : switch to alert
        New window(Yeni pencere) : switch to window
         */


    }

}
