package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class DropDown_ClassWork_2 {

    // ...Exercise 1...
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin


     WebDriver driver;

        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @Test
    public void test01(){

            // https://www.amazon.com/ sayfasina gidin
            driver.get("https://www.amazon.com/");

            // dropdown'dan "Books" secenegini secin
            WebElement menu = driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
            Select dropDownMenu = new Select(menu);
            dropDownMenu.selectByVisibleText("Books");

            // arama cubuguna "Java" aratın
            driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
            List<WebElement> javaBooksList = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));

            for (WebElement w : javaBooksList) {

                Assert.assertTrue(w.getText().toUpperCase().contains("JAVA"));
            }



        }

}
