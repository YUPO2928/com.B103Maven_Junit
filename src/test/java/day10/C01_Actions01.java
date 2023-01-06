package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_Actions01 extends TestBase {

    /*
    Class: Actions1
    https://the-internet.herokuapp.com/context_menu  sitesine gidin
    Kutuya sag tıklayın
    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    Tamam diyerek alert’i kapatın
     */

    @Test
    public void rightClick(){

        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //1- ACTIONS OBJESI OLUSTUR.
        Actions actions = new Actions(driver);

        //2- ELEMENT'I LOCATE EDELİM.
        WebElement kutu = driver.findElement(By.id("hot-spot"));

        //3- KUTUYA SAG TIKLAYALIM.
        actions.contextClick(kutu).perform();
        //NOTE : Tüm ACTIONS'lar actions objesi ile baslar ve perform() ile biter.

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //5- Tamam diyerek alert’i kapatın.
        driver.switchTo().alert().accept();




    }



}
