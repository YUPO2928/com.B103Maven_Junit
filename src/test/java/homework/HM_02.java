package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.PublicKey;
import java.util.Set;

public class HM_02 extends TestBase {

    /*
    https://testcenter.techproeducation.com/index.php?page=multiple-windows
    Title in ‘Windows’ oldugunu test edin
    Click here a tiklayin
    Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin

     */

    @Test
    public void test01(){

        //1- https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //2- Title in ‘Windows’ oldugunu test edin
        String firstWindowTitle = driver.getTitle();
        String expectedFirstWindowTitle = "Windows";
        Assert.assertEquals(expectedFirstWindowTitle,firstWindowTitle);

        //3- Click here a tiklayin
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        Set<String> allWindowHandles = driver.getWindowHandles(); // bütün pencerelerin id'sini aldık.
        System.out.println(allWindowHandles);
        String window1Handle = driver.getWindowHandle();

        for (String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)){ //Eger listedeki id window1'e esit degilse, otomatik olarak birsonrakine esittir.
                driver.switchTo().window(eachHandle); //burdaki eachHandle window2Handle'a esittir.
                break; // birden fazla sayfa olma ihtimali karsı break ekledik.
            }

        }

        ////4-  Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        String secondWindowTitle = driver.getTitle();
        String expectedSecondWindowTitle = "New Window";
        Assert.assertEquals(expectedSecondWindowTitle,secondWindowTitle);

    }


}
