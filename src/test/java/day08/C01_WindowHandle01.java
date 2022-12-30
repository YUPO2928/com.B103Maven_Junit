package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle01 extends TestBase {

    //Tests package'inda yeni bir class olusturun: WindowHandle
    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
    //Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
    //Sayfadaki textin "New Window" olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.

    @Test
    public void handleWindowTest() throws InterruptedException {

        //1- https://the-internet.herokuapp.com/windows adresine gidin. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        driver.get("https://the-internet.herokuapp.com/windows");
        //ILK PENCERENIN ID'SINI ALALIM.
        String window1Handle = driver.getWindowHandle();

        //2- Sayfadaki text'in "Opening a new window" olduğunu doğrulayın. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        String expected = "Opening a new window";
        Assert.assertEquals(expected,window1Text );

        //3- Sayfa başlığının(title) "The Internet" olduğunu doğrulayın. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet",window1Title);

        //4- Click Here butonuna basın. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        //5- Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECİS YAPMAK ISTIYORUM.
        //BUNUN ICIN driver.getWindowHandle() ILE TUM PENCERELERIN ID'LERINI ALALIM.
        Set<String> allWindowHandles = driver.getWindowHandles(); // {window1handle, window2handle}
        System.out.println(allWindowHandles);

        for (String eachHandle : allWindowHandles){

            if(!eachHandle.equals(window1Handle)){ //Eger listedeki id window1'e esit degilse, otomatik olarak birsonrakine esittir.
                driver.switchTo().window(eachHandle); //burdaki eachHandle window2Handle'a esittir.
                break; // birden fazla sayfa olma ihtimali karsı break ekledik.
            }
        // BU NOKTADA DRIVER 2. PENCEREDE
        }
        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window", window2Title);

        //6- Sayfadaki textin "New Window" olduğunu doğrulayın. ------------------------------------------------------------------------------------------------------------------------------------------------------------
         window2Title = driver.getTitle();
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());


        //7- Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
         String window2Handle = driver.getWindowHandle(); //2. pencerenin ID sini aldık.
         Thread.sleep(3000);
         driver.switchTo().window(window1Handle); //1. window'a geçiş yapıyoruz.
        Assert.assertEquals("The Internet", driver.getTitle());






    }



}
