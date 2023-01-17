package Practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

   /*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.

    */

public class P33_Faker extends TestBase {

    @Test
    public void FakerTest(){

    //"https://demoqa.com/automation-practice-form"  Adresine gidin.
        driver.get("https://demoqa.com/automation-practice-form");

    // Formu doldurunuz.
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,Keys.SPACE,Keys.TAB,faker.phoneNumber().phoneNumber(),Keys.TAB," 20 Jul 1980", Keys.ENTER,
                Keys.TAB,faker.shakespeare().romeoAndJulietQuote(), Keys.TAB,
                Keys.SPACE);

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        //String dosyaYolu = "C:\\Users\\Yunus\\Desktop\\aaa.txt";

        String anaYol = System.getProperty("user.home"); // C:\Users\Yunus\\
        String ortakYol = "\\Desktop\\aaa.txt"; // \\Desktop\\aaa.txt
        String dosyaYolu = anaYol+ortakYol;
        dosyaSec.sendKeys(dosyaYolu);

        WebElement adres = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        adres.sendKeys(faker.address().fullAddress(), Keys.TAB, "NCR", Keys.TAB, Keys.ENTER, "Delhi");


        // Sayfayi kapatin.


    }

}
