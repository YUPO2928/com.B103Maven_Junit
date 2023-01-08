package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestBase {

    //TestBase i abstract yapmamızın sebebi bu sınıfın objesini olusturmak istemiyorum.
    //TestBase testBase = new TestBase(); -> YAPILMAZ
    //Amacım bu sınıfı extend edip içindeki method'ları kullanmak

    //driver objesini olusturduk. Driver ya "public" ya da "protected" olmalı. Sebebi child class larda gorulmesi
    protected static WebDriver driver;

    //setup
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Thread.sleep(15); ==> HARD WAIT (NE OLURSA OLSUN TAM 15 SN BEKLE), JAVA DAN GELIR
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // 15 SN KADAR GEREKTIGINDE BEKLE (SELENIUM DAN GELIR)
    }

    @After
    public void tearDown(){
//        waitFor(5);
//        driver.close();
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//         MULTIPLE WINDOW
//         1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//         ORNEK:
//         driver.get("https://the-internet.herokuapp.com/windows");
//         switchToWindow("New Window");
//         switchToWindow("The Internet")
     public static void switchToWindow(String targetTitle) {
         String origin = driver.getWindowHandle();
         for (String handle : driver.getWindowHandles()) {
             driver.switchTo().window(handle);
             if (driver.getTitle().equals(targetTitle)) {
                 return;
             }
         }
         driver.switchTo().window(origin);
     }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     //windowNumber sıfır (0)'dan baslıyor.
    //index numarasını parametere olarak alır.
    //ve o indexli pencereye geciş yapar.
        public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
     }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Yukardaki iki method ismide aynı fakat parametreler farklı oldugu için hata vermez. (OVERLOADING)
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*
        HARD WAIT:
        @param : second
     */
     public static void waitFor(int seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    /*
       * Alertleri nasil automate edersin? How to handle alerts in selenium?
       * Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
    */


    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//-----------------------------------------------------------------------------------------------------------------------------
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    //cok kullanılmaz.
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }
}
