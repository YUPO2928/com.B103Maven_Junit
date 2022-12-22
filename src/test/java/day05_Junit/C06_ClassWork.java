package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ClassWork {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
//
//    @After
//    public void teardown(){
//        driver.close();
//
//    }

    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidin.
        driver.get("https://www.facebook.com");

        //2- Cookies’i kabul edin.

        //3- “Create an Account” button’una basin.
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        //4- “radio butto"ns” elementlerini locate edin.
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement Ozel = driver.findElement(By.xpath("//input[@value='-1']"));


        //5- Secili degilse cinsiyet butonundan size uygun olani secin
        if(!male.isSelected()){
            male.click();
        }
        Thread.sleep(3000);
        female.click();
        Thread.sleep(3000);
        Ozel.click();
    }

}