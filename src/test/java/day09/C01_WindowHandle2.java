package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    @Test
    public void windowHandleTest() throws InterruptedException {

        //1-  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows ");
        String window1Handle = driver.getWindowHandle();

        //2- Sayfadaki text'in "Opening a new window" olduğunu doğrulayın. ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        String expected = "Opening a new window";
        Assert.assertEquals(expected,window1Text );

        //3- Sayfa başlığının(title) "The Internet" olduğunu doğrulayın. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet",window1Title);

        //4- Click Here butonuna basın. --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.linkText("Click Here")).click();
        waitFor(3);

        //IKINCI PENCERE ACILIR VE IKINCI PENCEREYE SWITCH-GECIS YAPMALIYIZ.
        //5- Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.---------------------------------------------------------------------------------------------------------------------------------------------------------------
        switchToWindow(1);  //2. windowa gecis yapdik. driver artik 2. window da

        //6-  Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.---------------------------------------------------------------------------------------------------------------------------------------------------------------
        String actualWindowTitle = driver.getTitle();
        String expectedWindowTitle = "New Window";
        Assert.assertEquals(expectedWindowTitle, actualWindowTitle);


    }


}
