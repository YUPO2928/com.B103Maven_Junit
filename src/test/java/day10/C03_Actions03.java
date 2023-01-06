package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
    @Test
    public void scrollUpDown(){

        /*
        Class: ActionClass3
        Method : scrollUpDown()

        https://techproeducation.com a git
        Sayfanin altına doğru gidelim
        Sonra sayfanın üstüne doğru gidelim

         */

        //1- https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //2- Sayfanin altına doğru gidelim.
        Actions actions = new Actions(driver);

        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        actions
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        actions.sendKeys(Keys.ARROW_DOWN).perform(); // PAGE_DOWN'a göre daha az mesafe alır.
        actions.sendKeys(Keys.ARROW_UP).perform();

        actions.sendKeys(Keys.PAGE_UP).perform(); // YUKARI CIK.


    }
}
