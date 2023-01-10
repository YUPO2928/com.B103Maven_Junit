package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P21_BuyukKucukHarf extends TestBase {

    @Test
    public void name(){
        //google sayfasına gidelim.
        driver.get("https://www.google.com");

        //buyuk kucuk harf olacak sekilde Hello yazdıralım.
        WebElement searchbox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchbox.sendKeys(Keys.SHIFT, "h", Keys.SHIFT, "e", Keys.SHIFT, "l", Keys.SHIFT, "L",Keys.SHIFT, "o");





    }

}
