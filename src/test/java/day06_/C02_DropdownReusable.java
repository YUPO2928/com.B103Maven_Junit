package day06_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReusable {

    //   RE-USABLE METHOD: Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim.
    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }
    public void selectFromDropDown(WebElement dropdown, String secenek){
        // ornek ==> selectFromDropDown(driver.findElement(By.xpath("//select[@id='year']"), "2005"));
        //           selectFromDropDown(driver.findElement(By.xpath("//*[@id='month']"), "January");
        //           selectFromDropDown(driver.findElement(By.xpath("//select[@id='day']"), "12");

        List<WebElement> options = dropdown.findElements(By.tagName("option")); // Tum option tag'li elementleri alıyorum.

        for(WebElement eachOption : options){

            if(eachOption.getText().equals(secenek)){
                eachOption.click();
                break;
            }

        }


    }

}
