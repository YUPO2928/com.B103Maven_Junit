package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions02 extends TestBase {

    /*

    Class: Actions2
    Method : hoverOver() and test the following scenario:

    1- Amazon a gidelim https://www.amazon.com/
    2- Sag ust bolumde bulunan “Account & Lists” menüsüne git
    3- “Account” secenegine tikka
    4- Acilan sayfanin Title in “Your Account” icerdigini dogrula

     */

    @Test
    public void hoverOverTest(){

        driver.get("https://www.amazon.com");

        //1- ACTION OBJESİ OLUSTUR.
        Actions actions = new Actions(driver);
        waitFor(2);

        //2- ELEMANI BUL.
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
        waitFor(3);

        //3- “Account” secenegine tikka
        driver.findElement(By.linkText("Account")).click();

        //4- Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));



    }
}
