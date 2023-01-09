package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cookies_ClassWork_1 extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone13 512" + Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//*[@class='a-size-medium-plus a-color-base a-text-normal']"));
        Assert.assertTrue(result.isDisplayed());
        WebElement model = driver.findElement(By.xpath("//*[text()='iPhone 13 Mini, 512GB, Starlight - Unlocked (Renewed Premium)']"));
        String kelimeler = model.getText();
        List<String> kelimelerList = new ArrayList<>(Arrays.asList(kelimeler.split("")));

        for (String w:kelimelerList) {

            System.out.println(w);
        }


    }

}
