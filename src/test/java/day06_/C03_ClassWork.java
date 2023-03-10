package day06_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ClassWork {

    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
     */

    WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

    }


    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("(//*[.='Phones & PDAs'])[1]")).click();
        List<WebElement> phoneList = driver.findElements(By.xpath("//h4"));
        for (WebElement w : phoneList) {
            System.out.println(w.getText());
        }

        List<WebElement> addToCartList = driver.findElements(By.xpath("//*[.='Add to Cart']"));
        for (WebElement w : addToCartList) {
            w.click();
        }
        driver.findElement(By.xpath("//*[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
        List<WebElement> shopCartList = driver.findElements(By.xpath("//*[@class='text-left']"));
        for (WebElement w : addToCartList) {
            System.out.println(w.getText());
        }

        for (WebElement w : phoneList) {
            for (WebElement t: shopCartList) {
                Assert.assertEquals(w.getText(),t.getText());
            }
        }




    }
}