package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P17_windowHandle03 extends TestBase {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/iframe adresine gidiniz.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();
        textbox.sendKeys("Techproeducation");

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin.
        driver.switchTo().defaultContent();
        WebElement elementSeleniumLinki = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(elementSeleniumLinki.isDisplayed());


        // Elemental Selenium linkine tıklayın.
        elementSeleniumLinki.click();
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHandles);
        driver.switchTo().window(windowHandles.get(1));

        // Açılan sayfada sayfa başlığını yazdırınız.
        System.out.println("sayfaBaslıgı : " +driver.getTitle());

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin.
        WebElement SauceLabsLink = driver.findElement(By.xpath("//*[@class='link']"));
        Assert.assertTrue(SauceLabsLink.isDisplayed());

        // Source labs linkine tıklayın.
        SauceLabsLink.click();

        // Açılan sayfada sayfa başlığını yazdırınız.
        List<String> windowHandles2 = new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHandles2);
        driver.switchTo().window(windowHandles2.get(2));
        System.out.println("sayfa Baslıgı :" +driver.getTitle());

        // ilk sekmeye geri dönelim ve url'ini yazdıralım.
        driver.switchTo().window(windowHandles.get(0));

        // ilk sekmeyi kapatalım
        driver.close();

    }




}
