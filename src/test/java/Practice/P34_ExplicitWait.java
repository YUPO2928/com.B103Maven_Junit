package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

            /*
                            - Explicit Wait -
             Selenium’da Explicit Wait, Web Sürücüsüne belirli koşulları (Expected Condition) veya
             “ElementNotVisibleException” exception’ı atmadan önce aşılan maksimum süreyi beklemesini söylemek için kullanılır.
             Akıllı bir bekleme türüdür ancak yalnızca belirli öğeler(elementler) için uygulanabilir.
             Dinamik olarak yüklenen web elementleri beklerken implicit wait’ten daha iyi seçenekler sunar.
             Explicit Wait kullandığımızda, “ExpectedConditions” tanımlamalıyız veya Fluent Wait kullanarak durumu ne
             sıklıkla kontrol etmek istediğimizi yapılandırmalıyız.
             Syntax:
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
             WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(element locator));

             */

public class P34_ExplicitWait extends TestBase {


    // ***********1.YOL visibilityOfElementLocated() METHOD'U KULLANILDI********************
   @Test
    public void ExplicitWaitTest1(){

       //1- https://automationfc.github.io/dynamic-loading/ sayfasına gidelim.
       driver.get("https://automationfc.github.io/dynamic-loading/");

       //2- Start button'nuna basalım.
       WebElement startButton = driver.findElement(By.xpath("//*[text()='Start']"));
       startButton.click();

       //3- Hello World! yazısının çıktığını doğrulayalım.
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       // START BUTONUNA BASTIKDAN SONRA "Hello World!" YAZISI ÇIKANA KADAR BEKLEDIK.
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World!']")));

       assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();


   }

    // ***********2.YOL invisibilityOfElementLocated() METHOD'U KULLANILDI.***********************
    @Test
    public void ExplicitWaitTest2(){

        //1- https://automationfc.github.io/dynamic-loading/ sayfasına gidelim.
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //2- Start button'nuna basalım.
        WebElement startButton = driver.findElement(By.xpath("//*[text()='Start']"));
        startButton.click();

        //3- Hello World! yazısının çıktığını doğrulayalım.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // START BUTONUNA BASTIKDAN SONRA "Loading..." WEB ELEMENTİ KAYBOLANA KADAR BEKLEDİK.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Loading...']")));

        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();


    }




}
