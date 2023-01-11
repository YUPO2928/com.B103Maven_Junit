package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.sql.Driver;

public class P25_Exercises extends TestBase {

    @Test
    public void test01(){

    // ...Exercise 1...
    // https://html.com/tags/iframe sayfasına gidiniz.
        driver.get("https://html.com/tags/iframe");

    // Videoyu görecek kadar asagiya ininiz.
        WebElement videoIframe = driver.findElement(By.xpath("//*[@class='render']/iframe"));
        driver.switchTo().frame(videoIframe);
        WebElement playBox = driver.findElement(By.cssSelector("button[aria-label='Oynat']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(playBox).perform();
        // Videoyu izlemek icin Play tusuna basiniz.
        playBox.click();

    // Videoyu calistirdiginizi test ediniz.
      Assert.assertTrue(driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).isDisplayed());


    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz.
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='Powerful, but easy to misuse']"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Powerful, but easy to misuse']")).isDisplayed());
    }
}