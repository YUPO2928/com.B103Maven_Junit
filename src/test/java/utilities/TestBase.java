package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestBase {

    //TestBase i abstract yapmamızın sebebi bu sınıfın objesini olusturmak istemiyorum.
    //TestBase testBase = new TestBase(); -> YAPILMAZ
    //Amacım bu sınıfı extend edip içindeki method'ları kullanmak

    //driver objesini olusturduk. Driver ya "public" ya da "protected" olmalı. Sebebi child class larda gorulmesi
    protected static WebDriver driver;

    //--------------------------EXTEND REPORTS OBJELERİ--------------------------------------------------------------------------------------------------------------------
    protected ExtentReports extentReports;//Raporlamayı başlatırız
    protected ExtentHtmlReporter extentHtmlReporter;//Raporumu HTLM formatında düzenler
    protected ExtentTest extentTest; //Test aşamalarına extentTest objesi ile bilgi ekleriz
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    //setup
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Thread.sleep(15); ==> HARD WAIT (NE OLURSA OLSUN TAM 15 SN BEKLE), JAVA DAN GELIR
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // 15 SN KADAR GEREKTIGINDE BEKLE (SELENIUM DAN GELIR)

//--------------------------EXTEND REPORTS--------------------------------------------------------------------------------------------------------------------

            /*
            1- <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports --> pom.xml'e yüklemek
            2- Eğer extentReport almak istersek ilk yapmamız gereken ExtentReport class'ından bir obje oluşturmak
            3- HTLM formatında düzenleneceği için ExtentHtmlReporter class'ından obje oluşturmak
             */


            extentReports = new ExtentReports();
            String tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
            String dosyaYolu = "target/ExtentReports/htmlreport"+tarih+".html";
            extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
            extentReports.attachReporter(extentHtmlReporter);

            //Raporda gözükmesini istediğimiz bilgiler için
            extentReports.setSystemInfo("Browser","Chrome");
            extentReports.setSystemInfo("Tester","Erol");
            extentHtmlReporter.config().setDocumentTitle("Extent Report");
            extentHtmlReporter.config().setReportName("Test Sonucu");

        }

    @After
    public void tearDown() {
        //driver.quit();
        extentReports.flush(); //Raporlamayı bitirir.
    }

//------------------------------MULTIPLE WINDOW--------------------------------------------------------------------------------------------------------------------------------------------------
//
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


    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
//        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//----------------------------------------------------------------------------------------------------------------------------------------------
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
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //   SCREENSHOTS
    public void takeScreenShotOfPage() throws IOException, IOException {
//        1. Take screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//       2. Save screenshot
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

//       3. Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //    SCREENSHOT
//    @params: WebElement
//    takes screenshot
    public void takeScreenshotOfElement(WebElement element) throws IOException {

//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);

//        2. save screenshot path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//****************************************** JAVA-SCRIPT-EXECUTOR **************************************************************************************************************


    // input elementindeki degerleri al.
    // input elementindeki degerleri(value) al
    // Belirli bir WebElement'in id değerini String olarak alır ve value attribute değerini String olarak döndürür
    // return
    // document HTML'E GIT
    // .getElementById('" + idOfElement + "') ID'si VERILEN ELEMENTI BUL
    // .value")
    // .toString();
    public void getValueByJS(String idofElement){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String text = js.executeScript("return document.getElementById('"+idofElement+"').value" ).toString(); // belirli bir webelement'in value attribute un değerini dönderecek
        System.out.println("kutudaki deger = " + text);

    }
}

 /*
--------------------------------------------------------------INTERVIEWS QUESTIONS ---------------------------------------------------------

    1) Javascript Executor nedir?
    2) Ne zaman ve nasil kullanilir?
    3) Sayfayi asagi veya yukari kaydirma islemi seleniumda nasil yapilir
    4) Bir kutucuktaki yani inputtaki elemanin metni nasil alinabilir?
    5) Seleniumda click yaparken problem yasadigin oldu mu? (ya da soyle sorulabilir) Selenium outomasyonunda ne tur problemler yasadin?


 */







