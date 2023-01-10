package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


    /*
                                            Actions
        Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
        Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
    */

public class P20_Actions extends TestBase {

    @Test
    public void actionsTest01() throws InterruptedException {


        // http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        // Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim.
        WebElement blueBox = driver.findElement(By.xpath("//*[@id='div2']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(blueBox).perform();
        Thread.sleep(3000);

        // Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim.
        WebElement doubleClicked = driver.findElement(By.xpath("//*[@name='dblClick']"));
        actions.doubleClick(doubleClicked).perform();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("Double Clicked !!", alertText);

        // Accept ile alert'ü kapatalım.
        driver.switchTo().alert().accept();

        // Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin.
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag,drop).perform();
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//p[.='Dropped!']")).getText());







    }

}
