package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P29_moveToElement extends TestBase {

    @Test
    public void test01(){

        // https://amazon.com adresine gidiniz.
        driver.get("https://amazon.com");

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim.
        WebElement dilSecenegi= driver.findElement(By.xpath("//*[@class='icp-nav-link-inner']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dilSecenegi).perform();

        // Change country/region butonuna basiniz.
        driver.findElement(By.xpath("(//*[text()='Change country/region.'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz.
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(countryDropDown);
        select.selectByVisibleText("Turkey (Türkiye)" );

        // Go to website butonuna tiklayiniz.
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz.
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));



    }

}
