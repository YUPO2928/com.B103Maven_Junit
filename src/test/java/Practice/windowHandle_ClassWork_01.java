package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class windowHandle_ClassWork_01 extends TestBase {

    /*
       url'ye git: http://demo.guru99.com/popup.php
       ilk pencereyi al
       "Click Here" butonuna tıklayın
       setteki tüm pencereyi al
       diğer pencereye geç
       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       Gönder düğmesine tıklayarak
       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       Tekrar ilk pencereye geç
       İlk pencerede olduğunu doğrula
      */

    @Test
    public void test01(){
        //1- url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //2-  ilk pencereyi al
        String firstWindowId = driver.getWindowHandle();

        //3- "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[@style='text-align:center']")).click();

        //4- setteki tüm pencereyi al
        Set<String> ids = driver.getWindowHandles();

        //5- diğer pencereye geç.
        for (String w : ids) {
            if(!w.equalsIgnoreCase(firstWindowId)){
                driver.switchTo().window(w);
                break;
            }
        }

        //6- e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın.
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("somepne@gmail.com", Keys.ENTER);

        String sonucYazısı = driver.findElement(By.xpath("//*[text()='This access is valid only for 20 days.']")).getText();
        String expectedsonucYazısı = "This access is valid only for 20 days.";
        Assert.assertEquals(expectedsonucYazısı,sonucYazısı);

        //7- Tekrar ilk pencereye geç
        driver.switchTo().window(firstWindowId);

        //8- İlk pencerede olduğunu doğrula
        String yeniIlkPencere = driver.getWindowHandle();
        Assert.assertEquals(yeniIlkPencere, firstWindowId);






    }



}
