package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class windowHandle_ClassWork_02 extends TestBase {

    //https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    //New Tab butonunun görünür olduğunu doğrula.

    @Test
    public void test01(){

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com");

        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();

        //"Please select an item from left to start practice." yazısının görünür olduğunu doğrula
         driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']")).isDisplayed();

         //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
         driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula.
        driver.findElement(By.id("tabButton")).isDisplayed();

        //New Tab butonuna click yap
        driver.findElement(By.id("tabButton")).click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String ilkPencereId = driver.getWindowHandle();
        Set<String> sekmeler = driver.getWindowHandles();
        for (String w: sekmeler) {
            if(!w.equalsIgnoreCase(ilkPencereId)){
                driver.switchTo().window(w);
                break;
            }

        }

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        driver.findElement(By.xpath("//*[text()='This is a sample page']")).isDisplayed();

        //İlk Tab'a geri dön
        driver.switchTo().window(ilkPencereId);

        //New Tab butonunun görünür olduğunu doğrula.
        driver.findElement(By.id("tabButton")).isDisplayed();



    }




}
