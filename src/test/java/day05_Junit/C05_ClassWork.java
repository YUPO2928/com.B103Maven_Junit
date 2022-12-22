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

public class C05_ClassWork {

    /*
    1- Verilen web sayfasına gidin.
    2- https://the-internet.herokuapp.com/checkboxes
    3- Checkbox1 ve checkbox2 elementlerini locate edin.
    4- Checkbox1 seçili değilse onay kutusunu tıklayın
    5- Checkbox2 seçili değilse onay kutusunu tıklayın
     */


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){
        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {
        //1- Verilen web sayfasına gidin.
        //2- https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //3- Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //4- Checkbox1 seçili değilse onay kutusunu tıklayın.
        Thread.sleep(3000);
        if(!checkbox1.isSelected()){
            checkbox1.click();

        }

        //5- Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if(checkbox2.isSelected()){
            checkbox2.click();

        }


    }




}
