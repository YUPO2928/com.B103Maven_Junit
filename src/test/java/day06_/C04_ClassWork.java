package day06_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ClassWork {
    WebDriver driver;
    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");

    }

        /*  Given kullanici "https://editor.datatables.net/" sayfasina gider
            Then new butonuna basar
            And editor firstname kutusuna "<firstName>" bilgileri girer
            And editor lastname kutusuna "<lastName>" bilgileri girer
            And editor position kutusuna "<position>" bilgileri girer
            And editor office kutusuna "<office>" bilgileri girer
            And editor extension kutusuna "<extension>" bilgileri girer
            And editor startdate kutusuna "<startDate>" bilgileri girer
            And editor salary kutusuna "<salary>" bilgileri girer
            When Create tusuna basar
            Then Kullanıcının eklendiğini doğrular.
            And Eklediği kullanıcı kaydını siler
            Then Kullanıcinin silindiğini doğrular.
    */

    @Test

    public void test01(){

        //Then new butonuna basar
        WebElement newButton = driver.findElement(By.xpath("//span[.='New']"));
        newButton.click();

        //And editor firstname kutusuna "<firstName>" bilgileri girer.









    }

}
