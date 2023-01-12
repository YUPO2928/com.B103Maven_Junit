package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P28_windowHandle extends TestBase {

    @Test
    public void test(){


    // ...Exercise 2...
    // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String ilkWindow = driver.getWindowHandle();

    // 2- url'in 'amazon' icerdigini test edelim.
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciWindow = driver.getWindowHandle();

    // 4- title'in 'Best Buy' icerdigini test edelim.
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

    // 5- ilk sayfaya(amazon) donup sayfada java aratalım.
        driver.switchTo().window(ilkWindow);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);


    // 6- arama sonuclarının 'Java' icerdigini test edelim.
        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramaSonucuStr=aramaSonucu.getText();
        Assert.assertTrue(aramaSonucuStr.contains("java"));

    // 7- ikinci sayfaya(bestbuy) donelim.
        driver.switchTo().window(ikinciWindow);


    // 8- logonun gorundugunu test edelim
       Assert.assertTrue(driver.findElement(By.xpath("//*[@class='logo']")).isDisplayed());

    }
}
