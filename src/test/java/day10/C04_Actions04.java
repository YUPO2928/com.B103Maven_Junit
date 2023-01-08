package day10;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {

             /*

            Class: Action4
            Method: dragAndDropTest
            Given user is on https://jqueryui.com/droppable/
            And user moves the target element(Drag me to my target) in to  destination(Drop here)

             */

    @Test
    public void dragAndDropTest(){

        driver.get("https://jqueryui.com/droppable/");
        //KAYNAK VE HEDEF ELEMENTLERİ IFRAME ICINDE
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);
        actions.dragAndDrop(kaynak,hedef).perform();
        waitFor(4);
    }

    @Test
    public void clickAndHold(){

        driver.get("https://jqueryui.com/droppable/");
        //KAYNAK VE HEDEF ELEMENTLERİ IFRAME ICINDE
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);
        actions.dragAndDrop(kaynak,hedef).perform();
        waitFor(4);

        actions.clickAndHold(kaynak) //kaynagı tut.
                .moveToElement(hedef) // hedefe koy.
                .build() // onceki methodların ilişkisini kur / guclendir.
                .perform(); // islemi gerceklestir.
    }

    @Test
    public void movebyOffsetTest(){

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(kaynak).moveByOffset(430,30).build().perform();


    }



}
