package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    @Test
    public  void explicitWaitTest(){

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! Yazının sitede oldugunu test et.
        //WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        //Assert.assertEquals("Hello World!", helloWorldElement.getText());
        // IMPLICITWAIT ILE CALISMADI
        //COZUM EXPLICIT WAIT

        //1. ADIM :  WebDriverWait objesini olusturalım.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //2. ADIM : wait objesini kullanarak bekleme problemini cozmeye calıs.
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);







    }

}
